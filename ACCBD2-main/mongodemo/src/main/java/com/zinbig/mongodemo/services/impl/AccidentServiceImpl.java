/**
 * Este paquete contiene las implementaciones de los servicios.
 */
package com.zinbig.mongodemo.services.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import com.zinbig.mongodemo.model.AccidentWithDistance;
import com.zinbig.mongodemo.model.LocationWithAmount;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zinbig.mongodemo.model.Accident;
import com.zinbig.mongodemo.repositories.AccidentRepositoryMongo;
import com.zinbig.mongodemo.repositories.JpaRepository.AccidentRepositoryPostgres;
import com.zinbig.mongodemo.services.AccidentService;

import org.springframework.data.domain.Pageable;

@Service
@Transactional
public class AccidentServiceImpl implements AccidentService {

    @Inject
    private AccidentRepositoryPostgres accidentRepository;
    @Inject
    private AccidentRepositoryMongo accidentRepositoryMongo;

    /**
     * @param beginDate fecha de inicio
     * @param endDate   fecha de fin
     * @param page      número de página
     * @return los accidentes ocurridos entre 2 fechas
     */
    @Override
    public List<Accident> accidentsBetweenDates(Date beginDate, Date endDate, int page) {
        Pageable pageWithFiveElements = PageRequest.of(page, 5);
        return this.accidentRepository.findByStartTimeBetween(beginDate, endDate, pageWithFiveElements);
    }

    /**
     * @return las condiciones más comunes de los accidentes
     */
    @Override
    public Accident mostCommonConditions() {
        Accident mostCommonConditionsAccident = new Accident();
        mostCommonConditionsAccident.setAmenity(this.accidentRepository.mostCommonConditionAmenity());
        mostCommonConditionsAccident
                .setAstronomicalTwilight(this.accidentRepository.mostCommonConditionAstronomicalTwilight());
        mostCommonConditionsAccident.setBump(this.accidentRepository.mostCommonConditionBump());
        mostCommonConditionsAccident.setCity(this.accidentRepository.mostCommonConditionCity());
        mostCommonConditionsAccident.setCivilTwilight(this.accidentRepository.mostCommonConditionCivilTwilight());
        mostCommonConditionsAccident.setCounty(this.accidentRepository.mostCommonConditionCounty());
        mostCommonConditionsAccident.setCrossing(this.accidentRepository.mostCommonConditionCrossing());
        mostCommonConditionsAccident.setDistanceMi(this.accidentRepository.mostCommonConditionDistanceMi());
        mostCommonConditionsAccident.setEndTime(this.accidentRepository.mostCommonConditionEndTime());
        mostCommonConditionsAccident.setGiveWay(this.accidentRepository.mostCommonConditionGiveWay());
        mostCommonConditionsAccident.setHumidity(this.accidentRepository.mostCommonConditionHumidity());
        mostCommonConditionsAccident.setJunction(this.accidentRepository.mostCommonConditionJunction());
        mostCommonConditionsAccident.setNoExit(this.accidentRepository.mostCommonConditionNoExit());
        mostCommonConditionsAccident.setNauticalTwilight(this.accidentRepository.mostCommonConditionNuaticalTwilight());
        mostCommonConditionsAccident.setNumber(this.accidentRepository.mostCommonConditionNumber());
        mostCommonConditionsAccident.setPrecipitationIn(this.accidentRepository.mostCommonConditionPrecipitation());
        mostCommonConditionsAccident.setPressureIn(this.accidentRepository.mostCommonConditionPressureIn());
        mostCommonConditionsAccident.setRailway(this.accidentRepository.mostCommonConditionRailway());
        mostCommonConditionsAccident.setRoundabout(this.accidentRepository.mostCommonConditionRoundabout());
        mostCommonConditionsAccident.setSeverity(this.accidentRepository.mostCommonConditionSeverity());
        mostCommonConditionsAccident.setSide(this.accidentRepository.mostCommonConditionSide());
        mostCommonConditionsAccident.setStartTime(this.accidentRepository.mostCommonConditionStartTime());
        mostCommonConditionsAccident.setState(this.accidentRepository.mostCommonConditionState());
        mostCommonConditionsAccident.setStation(this.accidentRepository.mostCommonConditionStation());
        mostCommonConditionsAccident.setStop(this.accidentRepository.mostCommonConditionStop());
        mostCommonConditionsAccident.setStreet(this.accidentRepository.mostCommonConditionStreet());
        mostCommonConditionsAccident.setSunriseSunset(this.accidentRepository.mostCommonConditionSunriseSunset());
        mostCommonConditionsAccident.setTemperatureF(this.accidentRepository.mostCommonConditionTemperatureF());
        mostCommonConditionsAccident.setTmc(this.accidentRepository.mostCommonConditionTmc());
        mostCommonConditionsAccident.setTrafficCalming(this.accidentRepository.mostCommonConditionTrafficCalming());
        mostCommonConditionsAccident.setTrafficSignal(this.accidentRepository.mostCommonConditionTrafficSignal());
        mostCommonConditionsAccident.setTurningLoop(this.accidentRepository.mostCommonConditionTurningLoop());
        mostCommonConditionsAccident.setVisibilityMi(this.accidentRepository.mostCommonConditionVisibilityMi());
        mostCommonConditionsAccident.setWeatherCondition(this.accidentRepository.mostCommonConditionWeatherCondition());
        mostCommonConditionsAccident.setWindChillF(this.accidentRepository.mostCommonConditionWindChillF());
        mostCommonConditionsAccident.setWindDirection(this.accidentRepository.mostCommonConditionWindDirection());
        mostCommonConditionsAccident.setWindSpeedMph(this.accidentRepository.mostCommonConditionWindSpeedMph());
        mostCommonConditionsAccident.setZipcode(this.accidentRepository.mostCommonConditionZipcode());
        return mostCommonConditionsAccident;
    }

    /**
     * @param point  punto
     * @param radius radio
     * @param page   número de página
     * @return los accidentes ocurridos dentro de un radio
     */
    @Override
    public List<Accident> accidentsNearAPointInARadius(Double[] point, int radius, int page) {
        Pageable pageWithFiveElements = PageRequest.of(page, 5);
        return accidentRepositoryMongo.accidentsNearAPointInARadius(point, radius, pageWithFiveElements);
    }

    /**
     * @return la distancia promedio desde el inicio al fin del accidente
     */
    @Override
    public Float averageDistanceOfAccidentsFromBeginningToEnd() {
        return this.accidentRepositoryMongo.averageDistanceOfAccidentsFromBeginningToEnd();
    }

    /**
     * @param point  punto
     * @param radius radio
     * @return los 5 puntos más peligrosos
     */
    @Override
    public List<LocationWithAmount> fiveMostDangerousPoints(Double[] point, int radius) {
        return this.accidentRepositoryMongo.fiveMostDangerousPoints(point, radius);
    }

    /**
     * @param page número de página
     * @return la distancia promedio que existe entre cada accidente y los 10 más
     *         cercanos
     */
    @Override
    public List<AccidentWithDistance> averageDistanceFromEveryAccidentToTheNearestTen(int page) {
        Pageable pageWithFiveElements = PageRequest.of(page, 5);
        return this.accidentRepositoryMongo.averageDistanceFromEveryAccidentToTheNearestTen(pageWithFiveElements);
    }

    /**
     * @return el nombre de las 5 calles con más accidentes
     */
    @Override
    public List<String> findByStreetsWithMoreAccidents() {
        return this.accidentRepository.findByStreetsWithMoreAccidents();
    }

}
