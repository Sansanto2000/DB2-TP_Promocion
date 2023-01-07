# Trabajo práctico Final de la materia Base de Datos 2

## Requisitos

- Tener instalado Docker.

### Opcional

- Tener instalado MongoDBCompass (Conveniente en caso de que se quieran visualizar los datos que contiene la base de datos MongoDB).

## Recomendaciones

- La primera mitad del proyecto la desarrollamos utilizando el idle "Intellij Idea" pero hubo constantes problemas debido a que las importaciones no se hacian de forma automática y el Idle no verificaba los errores del código, por lo que en un determinado punto nos pasamos a "Eclipse-JavaEnterpriseEdition" con el cual si bien tuvimos ciertas complicaciones iniciales logramos que funcione satisfactoriamente para el desarrollo del proyecto. Es de descarga gratuita desde la página de eclipse, se descarga el instalador genérico y al ejecutarlo se le ofrece entre varias versiones, entre las que está "Java EE IDE" la cual es la que interesa, el mismo tiene un icono similar a un engranaje. Los pasos a seguir en este documento se escribieron teniendo en cuenta a este último.

## Puesta a punto

1. En una primera instancia lo primero que se debe hacer es importar el presente repositorio en una carpeta local.
2. Vaya a /docker, cree una carpeta llamada "csv" y pege en ella el archivo donde tiene los accidentes a cargar en las DBs. Es importante que se llame “US_Accidents_Dec19.csv” si no tiene ese nombre debe asignarcelo.
3. Una vez hecho esto debe abrir un símbolo del sistema (cmd), posicionarse sobre la carpeta donde importo el repositorio y avance a la carpeta "docker".
```
cd (Path de la carpeta donde importo el repositorio)/docker
```
4. Notará la existencia de un archivo llamado "docker-compose.yml", en este se halla la especificación de los contenedores que representan las BDs que se usarán. Interesa levantar 5 de los 6 servicios que en este se especifican, ya que el servicio identificado como Logstash se corresponde con un cargador de datos para la DB ElasticSearch que se usará mas adelante. 
Para efectivamente levantar los contenedores de interés valla al símbolo del sistema del paso anterior y ejecute la siguiente secuencia de comandos.
```
docker-compose up -d
docker-compose stop Logstash
cd .
```
> IMPORTANTE: Deben ejecutarse lo mas seguidas posibles, cada una ni bien termine de ejecutarse la anterior (si uno tiene varias líneas copiadas en el portapapeles al pegarlas en una consola estas se suelen ejecutar automáticamente de forma seguida). En caso de que en un intento no logre ejecutarlo de forma seguida (pasaron por lo menos 5 segundos entre que termino un comando y comenzo el que sigue) entonces es importante de que antes de intentarlo otra vez borre los contenedores y volúmenes docker que se crearon, en caso de no hacerlo es probable que la aplicación cargue mal los datos en las DBs.
3. Pasados varios segundos (30s-60s) para que los contenedores tengan tiempo de inicializarse correctamente, hay que configurar algunos ciertos aspectos en ElasticSearch, para ello puede usar Kibana. Desde el navegador ingrese a http://localhost:5601/app/dev_tools#/console y en la consola emergente ejecute las siguientes líneas:
```
PUT /accident
{
  "mappings": {
    "properties": {
      "location": { "type":"geo_point" },
      "start_time": {
        "type": "date",
        "format": "yyyy-MM-dd HH:mm:ss"
      }
    }
  }
}
```
4. Con esto configurado hay que cargar los datos en ElasticSearch, esto ya se configuró por medio del contenedor Logstash, por lo que solo hay que iniciarlo mediante el comando:
```
docker-compose start Logstash
```
5. Ahora toca ESPERAR a que los datos se carguen en los contenedores, esto varía según las especificaciones del equipo pero en general es un proceso bastante tardío, tenga en cuenta que tenemos 3 bases de datos que están cargando datos al mismo tiempo, PostgreSQL y MongoDB habran iniciado su carga de datos de forma automática cuando los finalizo el paso 2, ElasticSearch por otro lado recién habra iniciado su carga cuando ejecuto el contenedor Logstash en el paso 4. Es probable que las 2 primeras termine la carga de datos en alrededor de 30-40 minutos, ElasticSearch por otro lado destaca en lo lento que es para insertar nuevos archivos, por lo que en un caso malo podría llegar a tardar hasta 1:30hs en finalizar la carga. Personalmente recomendamos ejecutar hasta el paso 4 e irse a hacer otra cosa durante alrededor de 1:00-1:30 horas. 
> NOTA: Puede comprobar que finalizó la carga en cada contenedor haciendo uso de los visores de cada DB, corroborando que el total de filas en cada DB sea de 2974335.
> 
> Para visualizar mongoDB puede usar MongoDBCompass creando una nueva conexión a "mongodb://root:root@localhost:27017/?authMechanism=DEFAULT"
> ![image](https://user-images.githubusercontent.com/64858429/211129278-9b7e6b64-1499-4001-a7d7-29b40d81d1a1.png)
> Para visualizar PostgreSQL puede usar el pgAdmin que está andando en docker, para acceder al mismo puede ir desde al navegador a http://localhost/browser/, los credenciales para iniciar sesión y para efectivamente establecer la conexión los puede encontrar en el archivo "docker-compose.yml".
> ![image](https://user-images.githubusercontent.com/64858429/211129286-23992c50-233c-4823-b112-69d09c096357.png)
> Para visualizar ElasticSearch puede usar kibana que está andando en docker, para acceder al mismo puede ir desde al navegador a http://localhost:5601/app/discover#, la primera vez tendrá que crear un index pattern, para ello solo presione el botón "create index" que se le muestra escriba "accident" en el label y presione aceptar (si le pide una referencia temporal seleccione @timestamp). Hecho esto reingrese a la url y podrá ver un listado de los accidentes de la DB (asegúrese que el rango temporal de la vista se encuentre en un tiempo razonable según el tiempo que pasó desde que cargo los datos, ya que por defecto solo muestra los accidentes de los últimos 15 minutos). Aun así, probablemente los datos importantes son los siguientes: "puerto: 5432", "db: root", "username: root", "password: root".
> ![image](https://user-images.githubusercontent.com/64858429/211129447-3ca4948d-f490-4e27-9140-90f03190232d.png)
>> EXTRA: En caso de que no desee mirar los datos puede detener los contenedores pgadmin-1 y kibana, realmente no son necesarios para el funcionamiento íntegro de la aplicación. También puede detenerlos y activarlos solo cuando necesite consultar los datos, estos pueden reiniciarse las veces que vea conveniente. El contenedor logstash por otro lado, no se recomienda que sea detenido hasta que la totalidad de los datos hayan sido cargados en ElasticSearch, una vez esto ocurra puede detenerlo a su discreción, pero si lo hace NO lo vuelva a activar ya que esto provocará que se carguen otra vez todos los datos de la DB, independientemente de si ya se habían cargado o no. 
>> 
>> A continuación se muestra los contenedores mínimos requeridos para el funcionamiento de la aplicación una vez todos los datos estén cargados:
>> ![image](https://user-images.githubusercontent.com/64858429/211129693-6ddfd2a8-1dd5-4c5d-9ec5-a82634c43a05.png)

6. Una vez finalizada la espera y con todos los datos cargados en la DB ya está totalmente configurado todo lo relacionado a las DBs y a docker, por lo que puede configurar lo relacionado a la aplicación como tal. En una primera instancia debe ir a su idle de confianza (En nuestro caso "Eclipse-JavaEnterpriseEdition") e importar la carpeta llamada "promoTP" como un proyecto maven.
7. Por último, en Eclipse debe ir a la ventana de "ProyectExplorer" (usualmente está del lado izquierdo) y haga click derecho sobre el proyecto en cuestión, allí seleccione "Maven/update Proyect" se abrirá una ventana, no toque nada de ahi y presione "Ok". Una vez el updateo termine, vuelva a hacer click derecho sobre la raíz del proyecto pero ahora seleccione "Run As/maven clean". Una vez se termina de ejecutar, haga click derecho otra vez sobre la raíz del proyecto, pero ahora seleccionando "Run As/maven Install". Con eso el proyecto ya estará listo para su ejecución.

## Ejecución

Realizados todos los pasos anteriores, para ejecutar el software basta con ir al Eclipse, ir a la carpeta correspondiente al proyecto, desde ahí avanzar a la carpeta "/src/main/java", seleccionar el paquete "com.mitocode", hacer click derecho en el archivo "DemoDataBaseAplication.java" y clickear la opción "Run As > Java Aplication".
![image](https://user-images.githubusercontent.com/64858429/211130091-3f64deed-677a-4ee6-bd89-dde08adf1b6d.png)

Hecho esto los endpoins de la aplicacion estaran disponibles para su acceso en "http://localhost:8080/databases/(el endpoint al que quiera acceder)". A continacion se deja el link a una carpeta compartida de postman, donde se pueden ver todos los endpoints del servicio: https://solar-spaceship-105447.postman.co/workspace/DB2~c5105de8-5948-433a-8dc2-da24f2424e47/collection/18209837-64523b34-5a9c-40af-b5d9-04e587dcd2a0?action=share&creator=18209837. Tendra que solicitar permiso para poder editarlo, pero cuando lo haga le llegara una notificaccion a nuestros equipos por lo que cuando ocurra lo habilitaremos a la brevedad.
