# Trabajo de promoción Base de Datos 2 - 2022

#### Integrantes:

Andy Levy, legajo: 12929/1

Santiago Cristobal, legajo: 14413/4

Alejo Pugliese, legajo: 14414/5

## IMPORTANTE

Se necesita copiar el dataset US_Accidents_Dec19.csv en la carpeta docker antes de levantar los containers

## Levantar los containers
Primero debemos pararnos en la carpeta docker
```
cd docker
```
Para iniciar la aplicación se deberá buildear el container con el tag mongodemo
```
docker build --tag mongodemo  . 
```
Una vez creado el container se podrá levantar la aplicación con las bases de datos

utilizando docker compose
```
docker-compose up
```
### Disclaimer:

#### _Levantar los containers, importar las bases de datos y crear el índice 2dSphere puede tardar varios minutos, por favor se paciente._

#### _Si las consultas de localización fallan se puede deber a que el índice aún no se terminó de crear. Fin del disclaimer._


En el archivo de docker-compose podemos ver la creación de los distintos containers.

Las bases de datos cuentan con un script inicial de importación, que se ejecuta la primera vez que se crean.
Estos son ejecutados automáticamente por el docker-entrypoint-initdb.

Una vez levantada la aplicación e importadas las bases de datos, podemos acceder a la misma a través del puerto 8080.

## Consumo de las APIs
La aplicación cuenta con las siguientes APIs:

#### Beetween Dates

    /api/accidents/betweenDates

Esta api devuelve todos los accidentes ocurridos entre 2 fechas dadas. Se
envían una fecha de inicio y una fecha de fin y se obtienen los accidentes
correspondientes a ese rango de fechas de manera paginada.

Ejemplo:
    
    http://localhost:8080/api/accidents/betweenDates?start=2016-01-01&end=2016-02-01&page=0

#### Most Common Conditions

    /api/accidents/mostCommonConditions    

Permite obtener las condiciones más comunes al momento que ocurre un accidente.

#### Accidents near

    /api/accidents/accidentsNear    
    
Permite, dado un punto geográfico y un radio, devolver los accidentes ocurridos
allí de manera paginada. Se envian la latitud y longitud como datos para poder realizar dicha consulta.

Ejemplo:

    http://localhost:8080/api/accidents/accidentsNear?longitude=-84&latitude=39&radius=10000&page=0

#### Average distance

    /api/accidents/averageDistance

Se obtiene una distancia promedio entre el punto de inicio y el punto de fin
de todos los accidentes.

#### Five Most Dangerous Points

    /api/accidents/fiveMostDangerousPoints    

Esta api nos permite ver los 5 puntos con más accidentes.

#### Average Distance From Every Accident To The Nearest Ten 

    /api/accidents/averageDistanceFromEveryAccidentToTheNearestTen?page=0

Api que nos permite devolver la distancia promedio que existe entre cada 
accidente y los 10 más cercanos. De manera paginada.

#### Streets With More Accidents 

    /api/accidents/fiveStreetsWithMoreAccidents

Devuelve las 5 calles en donde hubo más accidentes.
    
    

