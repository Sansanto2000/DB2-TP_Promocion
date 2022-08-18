package com.mitocode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;

import com.mitocode.model.Accident;
import com.mitocode.repo.mongo.IMongoAccidentRepo;
import com.mitocode.repo.postgre.IPostgreAccidentRepo;
import java.util.List;
import java.util.Date;

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
		return repoP.accidentsBetweenTwoDates(startDate, endDate, page);
	}

	public List<String> fiveStreetsWithMoreAccidents() {
		return repoP.streetsWithMoreAccidents().subList(0, 5);
	}
	
	public Accident conditionsMostCommons() {
		//Implementar una clase Accidente con las condiciones mas comunes en cada campo
		Accident mostCommonConditionsAccident = new Accident();
		mostCommonConditionsAccident.setAmenity(Boolean.parseBoolean(this.accidentRepository.mostCommonConditionAmenity("Amenity")));
		mostCommonConditionsAccident.setAstronomicalTwilight(this.accidentRepository.mostCommonCondition("Astronomical_Twilight"));
		mostCommonConditionsAccident.setBump(Boolean.parseBoolean(this.accidentRepository.mostCommonCondition("Bump")));
		mostCommonConditionsAccident.setCity(this.accidentRepository.mostCommonCondition("City"));
		mostCommonConditionsAccident.setCivilTwilight(this.accidentRepository.mostCommonCondition("Civil_Twilight"));
		mostCommonConditionsAccident.setCounty(this.accidentRepository.mostCommonCondition("County"));
		mostCommonConditionsAccident.setCrossing(Boolean.parseBoolean(this.accidentRepository.mostCommonCondition("Crossing")));
		mostCommonConditionsAccident.setDistanceMi(Float.parseFloat(this.accidentRepository.mostCommonCondition("Distance(Mi)")));
		mostCommonConditionsAccident.setEndTime(this.accidentRepository.mostCommonCondition("End_Time"));
		mostCommonConditionsAccident.setGiveWay(Boolean.parseBoolean(this.accidentRepository.mostCommonCondition("Give_Way")));
		mostCommonConditionsAccident.setHumidity(this.accidentRepository.mostCommonCondition("Humidity(%)"));
		mostCommonConditionsAccident.setJunction(Boolean.parseBoolean(this.accidentRepository.mostCommonCondition("Junction")));
		mostCommonConditionsAccident.setNoExit(Boolean.parseBoolean(this.accidentRepository.mostCommonCondition("No_Exit")));
		mostCommonConditionsAccident.setNauticalTwilight(this.accidentRepository.mostCommonCondition("Nautical_Twilight"));
		mostCommonConditionsAccident.setNumber(Float.parseFloat(this.accidentRepository.mostCommonCondition("Number")));
		mostCommonConditionsAccident.setPrecipitationIn(Float.parseFloat(this.accidentRepository.mostCommonCondition("Precipitation(In)")));
		mostCommonConditionsAccident.setPressureIn(this.accidentRepository.mostCommonCondition("Pressure(In)"));
		mostCommonConditionsAccident.setRailway(this.accidentRepository.mostCommonCondition("Railway"));
		mostCommonConditionsAccident.setRoundabout(Boolean.parseBoolean(this.accidentRepository.mostCommonCondition("Roundabout")));
		mostCommonConditionsAccident.setSeverity(Integer.valueOf(this.accidentRepository.mostCommonCondition("Severity")));
		mostCommonConditionsAccident.setSide(this.accidentRepository.mostCommonCondition("Side").charAt(0));
		mostCommonConditionsAccident.setStartTime(this.accidentRepository.mostCommonConditionStart("Start_Time"));
		mostCommonConditionsAccident.setState(this.accidentRepository.mostCommonCondition("State"));
		mostCommonConditionsAccident.setStation(Boolean.parseBoolean(this.accidentRepository.mostCommonCondition("Station")));
		mostCommonConditionsAccident.setStop(Boolean.parseBoolean(this.accidentRepository.mostCommonCondition("Stop")));
		mostCommonConditionsAccident.setStreet(this.accidentRepository.mostCommonCondition("Street"));
		mostCommonConditionsAccident.setSunriseSunset(this.accidentRepository.mostCommonCondition("Sunrise_Sunset"));
		mostCommonConditionsAccident.setTemperatureF(Float.parseFloat(this.accidentRepository.mostCommonCondition("Temperature(F)")));
		mostCommonConditionsAccident.setTmc(Float.parseFloat(this.accidentRepository.mostCommonConditionTmc("TMC")));
		mostCommonConditionsAccident.setTrafficCalming(Boolean.parseBoolean(this.accidentRepository.mostCommonCondition("Traffic_Calming")));
		mostCommonConditionsAccident.setTrafficSignal(Boolean.parseBoolean(this.accidentRepository.mostCommonCondition("Traffic_Signal")));
		mostCommonConditionsAccident.setTurningLoop(Boolean.parseBoolean(this.accidentRepository.mostCommonConditionT("Turning_Loop")));
		mostCommonConditionsAccident.setVisibilityMi(Float.parseFloat(this.accidentRepository.mostCommonCondition("Visibility(Mi)")));
		mostCommonConditionsAccident.setWeatherCondition(this.accidentRepository.mostCommonCondition("Weather_Condition"));
		mostCommonConditionsAccident.setWindChillF(this.accidentRepository.mostCommonCondition("Wind_Chill(F)"));
		mostCommonConditionsAccident.setWindDirection(this.accidentRepository.mostCommonCondition("Wind_Direction"));
		mostCommonConditionsAccident.setWindSpeedMph(Float.parseFloat(this.accidentRepository.mostCommonCondition("Wind_Speed(mph)")));
		mostCommonConditionsAccident.setZipcode(this.accidentRepository.mostCommonCondition("Zipcode"));
		return mostCommonConditionsAccident;
	}
	
	public List<Accident> accidentsNearAPointAndARadius(Double[] point, int radius, int page) {
		Pageable page = PageRequest.of(pageNumber, pageSize);
		repoM.addLocationToAccidents();
		return repoM.accidentsNearAPointInARadius(point, radius, page);
	}
	
	public Float averageDistanceOfAccidentsFromBeginningToEnd() {
		//Avg del campo distance
		return repoP.averageDistanceOfAccidentsFromBeginningToEnd();
	}
	
	public List<LocationWithAmount> fiveMostDangerousPoints(Double[] point, int radius){
		//Las 5 locations mas peligrosos(que mas se repiten) dentro del area recibida por parametro
	}
	
	public Float averageDistanceFromEveryAccidentToTheNearestTen(int page) {
		//Sacar promedio de distancias entre un accidente y los 10 mas cercanos, para luego
		//hacer un promedio de todos los promedios calculados anteriormente
	}
}
