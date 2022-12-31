package com.mitocode.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.data.domain.Page;

import com.mitocode.model.persistence.Accident;
import com.mitocode.model.schema.AccidentWithDistanceSchema;
import com.mitocode.model.schema.ConditionsSchema;
import com.mitocode.model.schema.LocationAndAmountSchema;
import com.mitocode.repo.mongo.IMongoAccidentRepo;
import com.mitocode.repo.postgre.IPostgreAccidentRepo;
import com.mitocode.service.interf.AccidentService;
import com.mitocode.repo.elastic.IElasticAccidentRepo;

import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

@Service
public class AccidentServiceImpl implements AccidentService{

	@Autowired
	private IMongoAccidentRepo repoM;
	@Autowired
	private IPostgreAccidentRepo repoP;
	@Autowired
	private IElasticAccidentRepo repoE;

	public Page<Accident> findByCountry(String country, int pageNumber, int pageSize) {
		Pageable page = PageRequest.of(pageNumber, pageSize);
		return repoE.findByCountry(country, page);
	}

	public Page<Accident> test(int pageNumber, int pageSize) {
		Pageable page = PageRequest.of(pageNumber, pageSize);
		return repoE.test(page);
	}

	public void registrar(Accident t) {
		repoM.save(t);
		repoP.save(t);
	}

	public Slice<Accident> accidentsBetweenTwoDates(Date startDate, Date endDate, int pageNumber, int pageSize) {
		Pageable page = PageRequest.of(pageNumber, pageSize);
		//return repoP.accidentsBetweenTwoDates(startDate, endDate, page);
		return repoP.findByStartTimeBetween(startDate, endDate, page);
	}

	public ConditionsSchema mostCommonConditions() {
		ConditionsSchema mostCommonConditions = new ConditionsSchema();
		mostCommonConditions.setAmenity(this.repoP.mostCommonConditionAmenity());
		mostCommonConditions.setAstronomicalTwilight(this.repoP.mostCommonConditionAstronomicalTwilight());
		mostCommonConditions.setBump(this.repoP.mostCommonConditionBump());
		mostCommonConditions.setCity(this.repoP.mostCommonConditionCity());
		mostCommonConditions.setCivilTwilight(this.repoP.mostCommonConditionCivilTwilight());
		mostCommonConditions.setCounty(this.repoP.mostCommonConditionCounty());
		mostCommonConditions.setCrossing(this.repoP.mostCommonConditionCrossing());
		mostCommonConditions.setDistanceMi(this.repoP.mostCommonConditionDistanceMi());
		mostCommonConditions.setEndTime(this.repoP.mostCommonConditionEndTime());
		mostCommonConditions.setStartLat(this.repoP.mostCommonConditionStartLat());
		mostCommonConditions.setStartLng(this.repoP.mostCommonConditionStartLng());
		mostCommonConditions.setEndLat(this.repoP.mostCommonConditionEndLat());
		mostCommonConditions.setEndLng(this.repoP.mostCommonConditionEndLng());
		mostCommonConditions.setGiveWay(this.repoP.mostCommonConditionGiveWay());
		mostCommonConditions.setHumidity(this.repoP.mostCommonConditionHumidity());
		mostCommonConditions.setJunction(this.repoP.mostCommonConditionJunction());
		mostCommonConditions.setNoExit(this.repoP.mostCommonConditionNoExit());
		mostCommonConditions.setNauticalTwilight(this.repoP.mostCommonConditionNuaticalTwilight());
		mostCommonConditions.setNumber(this.repoP.mostCommonConditionNumber());
		mostCommonConditions.setPrecipitationIn(this.repoP.mostCommonConditionPrecipitation());
		mostCommonConditions.setPressureIn(this.repoP.mostCommonConditionPressureIn());
		mostCommonConditions.setRailway(this.repoP.mostCommonConditionRailway());
		mostCommonConditions.setRoundabout(this.repoP.mostCommonConditionRoundabout());
		mostCommonConditions.setSeverity(this.repoP.mostCommonConditionSeverity());
		mostCommonConditions.setSide(this.repoP.mostCommonConditionSide());
		mostCommonConditions.setStartTime(this.repoP.mostCommonConditionStartTime());
		mostCommonConditions.setState(this.repoP.mostCommonConditionState());
		mostCommonConditions.setStation(this.repoP.mostCommonConditionStation());
		mostCommonConditions.setStop(this.repoP.mostCommonConditionStop());
		mostCommonConditions.setStreet(this.repoP.mostCommonConditionStreet());
		mostCommonConditions.setSunriseSunset(this.repoP.mostCommonConditionSunriseSunset());
		mostCommonConditions.setTemperatureF(this.repoP.mostCommonConditionTemperatureF());
		mostCommonConditions.setTmc(this.repoP.mostCommonConditionTmc());
		mostCommonConditions.setTrafficCalming(this.repoP.mostCommonConditionTrafficCalming());
		mostCommonConditions.setTrafficSignal(this.repoP.mostCommonConditionTrafficSignal());
		mostCommonConditions.setTurningLoop(this.repoP.mostCommonConditionTurningLoop());
		mostCommonConditions.setVisibilityMi(this.repoP.mostCommonConditionVisibilityMi());
		mostCommonConditions.setWeatherCondition(this.repoP.mostCommonConditionWeatherCondition());
		mostCommonConditions.setWindChillF(this.repoP.mostCommonConditionWindChillF());
		mostCommonConditions.setWindDirection(this.repoP.mostCommonConditionWindDirection());
		mostCommonConditions.setWindSpeedMph(this.repoP.mostCommonConditionWindSpeedMph());
		mostCommonConditions.setZipcode(this.repoP.mostCommonConditionZipcode());
		mostCommonConditions.setCountry(this.repoP.mostCommonConditionCountry());
		mostCommonConditions.setTimezone(this.repoP.mostCommonConditionTimezone());
		mostCommonConditions.setAirportCode(this.repoP.mostCommonConditionAirportCode());
		mostCommonConditions.setWeatherTimestamp(this.repoP.mostCommonConditionWeatherTimestamp());

		return mostCommonConditions;
	}
	
	public Slice<Accident> accidentsNearAPointAndARadius(Double[] point, int radius, int pageNumber, int pageSize) {
		Pageable page = PageRequest.of(pageNumber, pageSize);
		return repoM.accidentsNearAPointInARadius(point, radius, page);
	}
	
	public Float averageDistanceOfAccidentsFromBeginningToEnd() {
		return repoP.averageDistanceOfAccidentsFromBeginningToEnd();
	}
	
	public List<LocationAndAmountSchema> fiveMostDangerousPoints(Double[] point, int radius){
		return repoM.fiveMostDangerousPoints(point, radius);
	}
	
	public Slice<AccidentWithDistanceSchema> allAvgDistanceBetweenTop10NearestAccidents(int pageNumber, int pageSize){
		Pageable page = PageRequest.of(pageNumber, pageSize);
		List<AccidentWithDistanceSchema> list = new ArrayList<AccidentWithDistanceSchema>(); 
		Slice<Accident> accidents = repoM.findAll(page);
		for (Accident a: accidents) {
			Double[] l = {Double.parseDouble(a.getStartLat().toString()), Double.parseDouble(a.getStartLng().toString())};
			list.add(repoM.allAvgDistanceBetweenTop10NearestAccidents(a.getId(), l).get(0));
		}
		return new SliceImpl<AccidentWithDistanceSchema>(list, page, accidents.hasNext());	
	}
	
	public List<String> fiveStreetsWithMoreAccidents() {
		return repoP.streetsWithMoreAccidents();
	}
	
}
