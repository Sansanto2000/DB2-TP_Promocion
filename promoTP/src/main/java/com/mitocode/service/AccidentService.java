package com.mitocode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;

import com.mitocode.model.Accident;
import com.mitocode.repo.mongo.IMongoAccidentRepo;
import com.mitocode.repo.postgre.IPostgreAccidentRepo;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Date;
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
	
	/*public Accident mostCommonCondition() {
		//Implementar una clase Accidente con las condiciones mas comunes en cada campo
		Accident mostCommonConditionsAccident = new Accident();
		System.out.println("-----------------------------------------------");
		System.out.println(repoP.mostCommonConditionDistanceMi());
		System.out.println("-----------------------------------------------");
		mostCommonConditionsAccident.setAmenity(Boolean.parseBoolean(repoP.mostCommonCondition("Amenity")));
		mostCommonConditionsAccident.setAstronomicalTwilight(repoP.mostCommonCondition("Astronomical_Twilight"));
		mostCommonConditionsAccident.setBump(Boolean.parseBoolean(repoP.mostCommonCondition("Bump")));
		mostCommonConditionsAccident.setCity(repoP.mostCommonCondition("City"));
		mostCommonConditionsAccident.setCivilTwilight(repoP.mostCommonCondition("Civil_Twilight"));
		mostCommonConditionsAccident.setCounty(repoP.mostCommonCondition("County"));
		mostCommonConditionsAccident.setCrossing(Boolean.parseBoolean(repoP.mostCommonCondition("Crossing")));
		mostCommonConditionsAccident.setDistanceMi(Float.parseFloat(repoP.mostCommonCondition("distanceMi")));
		mostCommonConditionsAccident.setEndTime(repoP.mostCommonCondition("End_Time"));
		mostCommonConditionsAccident.setGiveWay(Boolean.parseBoolean(repoP.mostCommonCondition("Give_Way")));
		mostCommonConditionsAccident.setHumidity(repoP.mostCommonCondition("Humidity(%)"));
		mostCommonConditionsAccident.setJunction(Boolean.parseBoolean(repoP.mostCommonCondition("Junction")));
		mostCommonConditionsAccident.setNoExit(Boolean.parseBoolean(repoP.mostCommonCondition("No_Exit")));
		mostCommonConditionsAccident.setNauticalTwilight(repoP.mostCommonCondition("Nautical_Twilight"));
		mostCommonConditionsAccident.setNumber(Float.parseFloat(repoP.mostCommonCondition("number")));
		mostCommonConditionsAccident.setPrecipitationIn(Float.parseFloat(repoP.mostCommonCondition("Precipitation(In)")));
		mostCommonConditionsAccident.setPressureIn(repoP.mostCommonCondition("Pressure(In)"));
		mostCommonConditionsAccident.setRailway(Boolean.parseBoolean(repoP.mostCommonCondition("Railway")));
		mostCommonConditionsAccident.setRoundabout(Boolean.parseBoolean(repoP.mostCommonCondition("Roundabout")));
		mostCommonConditionsAccident.setSeverity(Integer.valueOf(repoP.mostCommonCondition("Severity")));
		mostCommonConditionsAccident.setSide(repoP.mostCommonCondition("Side").charAt(0));
		mostCommonConditionsAccident.setStartTime(repoP.mostCommonCondition("Start_Time"));
		mostCommonConditionsAccident.setState(repoP.mostCommonCondition("State"));
		mostCommonConditionsAccident.setStation(Boolean.parseBoolean(repoP.mostCommonCondition("Station")));
		mostCommonConditionsAccident.setStop(Boolean.parseBoolean(repoP.mostCommonCondition("Stop")));
		mostCommonConditionsAccident.setStreet(repoP.mostCommonCondition("Street"));
		mostCommonConditionsAccident.setSunriseSunset(repoP.mostCommonCondition("Sunrise_Sunset"));
		mostCommonConditionsAccident.setTemperatureF(Float.parseFloat(repoP.mostCommonCondition("Temperature(F)")));
		mostCommonConditionsAccident.setTmc(Float.parseFloat(repoP.mostCommonCondition("TMC")));
		mostCommonConditionsAccident.setTrafficCalming(Boolean.parseBoolean(repoP.mostCommonCondition("Traffic_Calming")));
		mostCommonConditionsAccident.setTrafficSignal(Boolean.parseBoolean(repoP.mostCommonCondition("Traffic_Signal")));
		mostCommonConditionsAccident.setTurningLoop(Boolean.parseBoolean(repoP.mostCommonCondition("Turning_Loop")));
		mostCommonConditionsAccident.setVisibilityMi(Float.parseFloat(repoP.mostCommonCondition("Visibility(Mi)")));
		mostCommonConditionsAccident.setWeatherCondition(repoP.mostCommonCondition("Weather_Condition"));
		mostCommonConditionsAccident.setWindChillF(repoP.mostCommonCondition("Wind_Chill(F)"));
		mostCommonConditionsAccident.setWindDirection(repoP.mostCommonCondition("Wind_Direction"));
		mostCommonConditionsAccident.setWindSpeedMph(Float.parseFloat(repoP.mostCommonCondition("Wind_Speed(mph)")));
		mostCommonConditionsAccident.setZipcode(repoP.mostCommonCondition("Zipcode"));
		return mostCommonConditionsAccident;
	}*/

	@Transactional
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
