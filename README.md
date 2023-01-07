
# Trabajo practico Final de la materia Base de Datos 2

## Requsitos

- Tener instalado Docker.

### Opcional

- Tener instalado MongoDBCompass (Conveniente en caso de que se quieran visualizar los datos que contiene la base de datos MongoDB).

## Recomendaciones

- La primera mitad del proyecto la desarrollamos utilizando el Ide "Intellij Idea" pero hubo constantes problemas debido a que las importaciones no se hacian de forma automatica y el Ide no verificaba los errores del codigo, por lo que en un determinado punto nos pasamos a "Eclipse-JavaEnterpriseEdition" con el cual si bien tubimos ciertas complicaciones iniciales logramos que funcione satisfactoriamente para el desarrollo del proyecto. Los pasos a seguir en este documento se escribieron teniendo en cuenta este ultimo Ide.

## Puesta a punto

1. En una primera instancia lo primero que se debe hacer es importar el presente repositorio en una carpeta local.
2. Valla a /docker y cree una carpeta llamada "csv" y copie en ella el archivo "US_Accidents_Dec19.csv" (si no tiene ese nombre debe ponerselo).
3. una vez haya echo esto debe abrir un simbolo del sistema (cmd), posicionarce sobre la carpeta donde importo el repositorio y muevase a la carpeta "docker".
```
cd (Path de la carpeta donde importo el repositorio)/docker
```
4. Notara la existencia de un archivo llamado "docker-compose.yml", en este se halla la especificacion de los contenedores que representan las BDs que se usaran. Interesa levantar 5 del los 6 servicios que en este se especifican, ya que el servicio identificado como Logstash se corresponde con un cargador de datos para la DB ElasticSearch que se usara mas adelante. 
Para efectivamente levantar los contenedores de interes valla al simbolo del sistema del paso anterior y ejecutar la siguiente secuencia de comandos.
> IMPORTANTE: Deben ejecutarse lo mas seguidas posibles, cada una ni bien termine de ejecutarse la anterior (si uno tiene varias lineas copiadas en el portapapeles al pegarlas en una consola estas se suelen ejecutar automaticamente de forma seguida). En caso de que en un intento no logre ejecutarlo de forma seguida (pasaron por lo menos 5 segundos entre que termino un comando y comenzo el que sigue) entonces es importante de que antes de intentarlo denuevo borre los contenedores y volumenes docker que se crearon, en caso de no hacerlo es probable que la applicacion funcione de forma insatisfactoria
```
docker-compose up -d
docker-compose stop Logstash
cd .
```
3. Pasados varios segundos (30s-60s) para que los contenedores tengan tiempo de inicializarce correctamente, hay que configurar algunos ciertos aspectos en ElasticSearch, para ello puede usar Kibana. Desde el navegador ingrese a http://localhost:5601/app/dev_tools#/console y en la consola emergente ejecute las siguientes lineas:
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
4. Con esto configurado hay que cargar los datos en ElasticSearch, esto ya se configuro por medio del contenedor Logstash, por lo que solo hay que iniciarlo mediante el comando:
```
docker-compose start Logstash
```
5. Ahora toca ESPERAR a que los datos se carguen en los contenedores, esto varia segun las especificaciones del equipo pero en general es un proceso bastante tardio, tenga en cuenta que tenemos 3 bases de datosque estan cargando datos al mismo tiempo, PosgreSQL y MongoDB habran iniciado su carga de datos de forma automatica cuando los finalizo el paso 2, ElasticSearch por otro lado recien habra iniciado su carga cuando ejecuto el contenedor Logstash en el paso 4. Es probable que las 2 primeras terminen la carga de datos en alrededor de 30-40 minutos, ElasticSearch por otro lado destaca en lo lento que es para insertar nuevos archivos, por lo que en un caso malo podria llegar a tardar hasta 1:30hs en finalizar la carga. Personalmente recomendamos ejecutar hasta el paso 4 e irse a hacer otra cosa durante alrededor de 1:00-1:30 horas. 
> NOTA: Puede comprobar que finalizo la carga en cada contenedor haciendo uso de los visores de cada DB, corroborando que el total de filas en cada DB sea de 2974335.
> 
> Para visualizar mongoDB puede usar MongoDBCompass creando una nueva conexion a mongodb://root:root@localhost:27017/?authMechanism=DEFAULT
> ![image](https://user-images.githubusercontent.com/64858429/211129278-9b7e6b64-1499-4001-a7d7-29b40d81d1a1.png)
> Para visualizar PostgreSQL puede usar el pgAdmin que esta andando en docker, para acceder al mismo puede ir desde al navegador a http://localhost/browser/, los credenciales para iniciar secion y para efectivamente establecer la conexion los puede encontrar en el archivo "docker-compose.yml".
> ![image](https://user-images.githubusercontent.com/64858429/211129286-23992c50-233c-4823-b112-69d09c096357.png)
> Para visualizar ElasticSearch puede usar kibana que esta andando en docker, para acceder al mismo puede ir desde al navegador a http://localhost:5601/app/discover#, la primera vez tendra que crear un index pattern, para ello solo precione el boton "create index" que se le muestra escriba "accident" en el label y precione aceptar (si le pide una referencia temporal seleccione @timestamp). Hecho esto reingrese a la url y podra ver un listado de los accidentes de la DB (asegurese que el rango temporal de la vista se encuentre en un tiempo razonable segun el tiempo que paso desde que cargo los datos, ya que por defecto solo muestra los accidentes de los ultimos 15 minutos).
> ![image](https://user-images.githubusercontent.com/64858429/211129447-3ca4948d-f490-4e27-9140-90f03190232d.png)
>> EXTRA: En caso de que no desee mirar los datos puede detener los contenedores pgadmin-1 y kibana, realmente no son necesarios para el funcionamiento integro de la aplicacion. Tambien puede detenerlos y activarlos solo cuando necesite consultar los datos, estos pueden reiniciarse las veces que vea conveniente. El contenedor logstash por otro lado, no se recomienda que sea detenido hasta que la totalidad de los datos hallan sido cargados en ElasticSearch, una vez esto ocurra puede detenerlo a su discrecion, pero si lo hace NO lo vuelva a activar ya que esto probocara que se carguen otra vez todos los datos de la DB, independientemente de si ya se habian cargado o no. 
>> 
>> A continuacion se muestra los contenedores minimos requeridos para el funcionamiento de la aplicacion una vez todos los datos estan cargados:
>> ![image](https://user-images.githubusercontent.com/64858429/211129693-6ddfd2a8-1dd5-4c5d-9ec5-a82634c43a05.png)

6. 
7. 
8. 

*PREREQUISITO: Tener Docker Desktop corriendo*

**

*Posicionarse en la raiz del proyecto "/"*

*Levantar las dbs en segundo plano:*
```
docker-compose up -d
```
*La primera vez que se levante se realizara una importacion en el postgre que durara entre 5-7 minutos*

IMPORTANTE: Solo se hace para Postgre, en MongoDB hay que hacer el import manual, del csv desde el MongoDB Compas, para conectarce al mismo luego de ejecutar docker usar `mongodb://root:root@localhost:27017/?authMechanism=DEFAULT`, tambien solo es necesario la primera vez, para las siguiente veces que se levante el contenedor los datos ya van a quedar guardados*

*Levantar la app:*
```
cd promoTP
./mvnw spring-boot:run
```

*Con el POSTMAN se pueden ejecutar las querys*

# DB2-TP_Promocion

Definición trabajo Promición Bases de datos 2 - 2022

Para el trabajo de promoción se deberá: 
- montar un entorno utilizando Docker 
- configurar un motor de bases de datos postgres 
- configurar un motor NoSQL Mongodb (instalación básica) 
- importar el dataset de accidentes de tránsito en cada una de las bases de datos 
- implementar una aplicación utilizando la arquitectura de base presentada en la materia 
- implementar las siguientes consultas apuntando a cada una de las bases de datos según su conveniencia: 
  - RESUELTA: (postgre) devolver todos los accidentes ocurridos entre 2 fechas dadas
  - IÑA: (postgre) determinar las condiciones más comunes en los accidentes (hora del día, condiciones climáticas, etc) 
  - FRAN: (mongodb) dado un punto geográfico y un radio (expresado en kilómetros) devolver todos los accidentes ocurridos dentro del radio. 
  - IÑA: (postgre) obtener la distancia promedio desde el inicio al fin del accidente

Consultas para equipos de 3 personas: 
  - FRAN: (mongodb) devolver los 5 puntos más peligrosos (definiendo un determinado radio y utilizando los datos de los accidentes registrados). 
  - SANTI: (mongodb) devolver la distancia promedio que existe entre cada accidente y los 10 más cercanos. 
  - SANTI(RESUELTA): (postgre) devolver el nombre de las 5 calles con más accidentes.

# Documento de resolucion

https://docs.google.com/document/d/1W5dwerkj80ql5_9XjbZUjylkwJr832pej2Q4ZWeIWWU/edit?usp=sharing
