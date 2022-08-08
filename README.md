
# Guia inicio

*PREREQUISITO: Tener Docker Desktop corriendo*

*Poner el archivo "US_Accidents_Dec19.csv" en la carpeta "/csv/"*

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
  - (postgre) devolver todos los accidentes ocurridos entre 2 fechas dadas  
  - (postgre) determinar las condiciones más comunes en los accidentes (hora del día, condiciones climáticas, etc) 
  - (mongodb) dado un punto geográfico y un radio (expresado en kilómetros) devolver todos los accidentes ocurridos dentro del radio. 
  - (mongodb) obtener la distancia promedio desde el inicio al fin del accidente

Consultas para equipos de 3 personas: 
  - (mongodb) devolver los 5 puntos más peligrosos (definiendo un determinado radio y utilizando los datos de los accidentes registrados). 
  - (mongodb) devolver la distancia promedio que existe entre cada accidente y los 10 más cercanos. 
  - (postgre) devolver el nombre de las 5 calles con más accidentes.

# Documento de resolucion

https://docs.google.com/document/d/1W5dwerkj80ql5_9XjbZUjylkwJr832pej2Q4ZWeIWWU/edit?usp=sharing
