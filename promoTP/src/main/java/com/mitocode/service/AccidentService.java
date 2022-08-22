package com.mitocode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;

import com.mitocode.model.Accident;
import com.mitocode.model.LocationAndAmount;
import com.mitocode.repo.mongo.IMongoAccidentRepo;
import com.mitocode.repo.postgre.IPostgreAccidentRepo;
import java.util.List;
import java.sql.Date;
//import java.sql.Date;
import java.text.SimpleDateFormat;

@Service
public class AccidentService{

	@Autowired
	private IMongoAccidentRepo repoM;
	@Autowired
	private IPostgreAccidentRepo repoP;

	public void registrar(Accident t) {
		repoM.save(t);
		repoP.save(t);
	}

	public Slice<Accident> accidentsBetweenTwoDates(Date startDate, Date endDate, int pageNumber, int pageSize) {
		Pageable page = PageRequest.of(pageNumber, pageSize);
		//return repoP.accidentsBetweenTwoDates(startDate, endDate, page);
		return repoP.findByStartTimeBetween(startDate, endDate, page);
	}

	public List<String> fiveStreetsWithMoreAccidents() {
		return repoP.streetsWithMoreAccidents().subList(0, 5);
	}

	@Override
	public Accident mostCommonConditions() {
		Accident mostCommonConditionsAccident = new Accident();
		mostCommonConditionsAccident.setAmenity(this.accidentRepository.mostCommonConditionAmenity());
		mostCommonConditionsAccident.setAstronomicalTwilight(this.accidentRepository.mostCommonConditionAstronomicalTwilight());
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

	public Slice<Accident> accidentsNearAPointAndARadius(Double[] point, int radius, int pageNumber, int pageSize) {
		Pageable page = PageRequest.of(pageNumber, pageSize);
		return repoM.accidentsNearAPointInARadius(point, radius, page);
	}
	
	public Float averageDistanceOfAccidentsFromBeginningToEnd() {
		//Avg del campo distance
		return repoP.averageDistanceOfAccidentsFromBeginningToEnd();
	}
	
	public List<LocationAndAmount> fiveMostDangerousPoints(Double[] point, int radius){
		return repoM.fiveMostDangerousPoints(point, radius);
	}
	/*
	public Float averageDistanceFromEveryAccidentToTheNearestTen(int page) {
		//Sacar promedio de distancias entre un accidente y los 10 mas cercanos, para luego
		//hacer un promedio de todos los promedios calculados anteriormente
	}*/
}
