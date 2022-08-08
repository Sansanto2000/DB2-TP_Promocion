package com.zinbig.mongodemo.services;

import java.util.Date;
import java.util.List;

import com.zinbig.mongodemo.model.Accident;
import com.zinbig.mongodemo.model.AccidentWithDistance;
import com.zinbig.mongodemo.model.LocationWithAmount;

public interface AccidentService {

    /**
     * @param beginDate fecha de inicio
     * @param endDate   fecha de fin
     * @param page      número página
     * @return los accidentes ocurridos entre 2 fechas
     */
    public List<Accident> accidentsBetweenDates(Date beginDate, Date endDate, int page);

    /**
     * @return las condiciones más comunes de los accidentes
     */
    public Accident mostCommonConditions();

    /**
     * @param point  punto
     * @param radius radio
     * @param page   número de página
     * @return los accidentes ocurridos dentro de un radio
     */
    public List<Accident> accidentsNearAPointInARadius(Double[] point, int radius, int page);

    /**
     * @return la distancia promedio desde el inicio al fin del accidente
     */
    public Float averageDistanceOfAccidentsFromBeginningToEnd();

    /**
     * @param point  punto
     * @param radius radio
     * @return los 5 puntos más peligrosos
     */
    public List<LocationWithAmount> fiveMostDangerousPoints(Double[] point, int radius);

    /**
     * @param page número de página
     * @return la distancia promedio que existe entre cada accidente y los 10 más cercanos
     */
    public List<AccidentWithDistance> averageDistanceFromEveryAccidentToTheNearestTen(int page);

    /**
     * @return el nombre de las 5 calles con más accidentes
     */
    public List<String> findByStreetsWithMoreAccidents();
}
