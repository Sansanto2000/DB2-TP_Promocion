package com.mitocode.service.implementation;

import org.elasticsearch.search.aggregations.InternalOrder.Aggregation;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;

import com.mitocode.model.persistence.Accident;
import com.mitocode.model.schema.AccidentWithDistanceSchema;
import com.mitocode.model.schema.ConditionsSchema;
import com.mitocode.model.schema.LocationAndAmountSchema;
import com.mitocode.repo.mongo.MongodbAccidentRepository;
import com.mitocode.repo.postgre.PostgreAccidentRepository;
import com.mitocode.service.interf.AccidentService;
import com.mitocode.repo.elastic.ElasticsearchAccidentRepository;

import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.text.SimpleDateFormat;

@Service
public class AccidentServiceImpl implements AccidentService{

	@Autowired
	private MongodbAccidentRepository repoM;
	@Autowired
	private PostgreAccidentRepository repoP;
	@Autowired
	private ElasticsearchAccidentRepository repoE;

	public void registrar(Accident t) {
		repoE.save(t);
		repoM.save(t);
		repoP.save(t);
	}

	public Page<Accident> accidentsBetweenTwoDates(Date startDate, Date endDate, int pageNumber, int pageSize) {
		Pageable page = PageRequest.of(pageNumber, pageSize);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return repoM.findByStartTimeBetween(format.format(startDate), format.format(endDate), page);
	}
	
	public Page<Accident> accidentsBetweenTwoDatesElasticVersion(Date startDate, Date endDate, int pageNumber, int pageSize) {
		Pageable page = PageRequest.of(pageNumber, pageSize);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return repoE.findByStartTimeBetween(format.format(startDate), format.format(endDate), page);
	}

	public ConditionsSchema mostCommonConditions() {
		ConditionsSchema mostCommonConditions = new ConditionsSchema();
		mostCommonConditions.setStartTime(this.repoP.mostCommonConditionStartTime());
		mostCommonConditions.setEndTime(this.repoP.mostCommonConditionEndTime());
		mostCommonConditions.setAmenity(this.repoP.mostCommonConditionAmenity());
		mostCommonConditions.setAstronomicalTwilight(this.repoP.mostCommonConditionAstronomicalTwilight());
		mostCommonConditions.setBump(this.repoP.mostCommonConditionBump());
		mostCommonConditions.setCivilTwilight(this.repoP.mostCommonConditionCivilTwilight());
		mostCommonConditions.setCrossing(this.repoP.mostCommonConditionCrossing());
		mostCommonConditions.setGiveWay(this.repoP.mostCommonConditionGiveWay());
		mostCommonConditions.setHumidity(this.repoP.mostCommonConditionHumidity());
		mostCommonConditions.setJunction(this.repoP.mostCommonConditionJunction());
		mostCommonConditions.setNoExit(this.repoP.mostCommonConditionNoExit());
		mostCommonConditions.setNauticalTwilight(this.repoP.mostCommonConditionNuaticalTwilight());
		mostCommonConditions.setPrecipitationIn(this.repoP.mostCommonConditionPrecipitation());
		mostCommonConditions.setPressureIn(this.repoP.mostCommonConditionPressureIn());
		mostCommonConditions.setRailway(this.repoP.mostCommonConditionRailway());
		mostCommonConditions.setRoundabout(this.repoP.mostCommonConditionRoundabout());
		mostCommonConditions.setStation(this.repoP.mostCommonConditionStation());
		mostCommonConditions.setStop(this.repoP.mostCommonConditionStop());
		mostCommonConditions.setSunriseSunset(this.repoP.mostCommonConditionSunriseSunset());
		mostCommonConditions.setTemperatureF(this.repoP.mostCommonConditionTemperatureF());
		mostCommonConditions.setTrafficCalming(this.repoP.mostCommonConditionTrafficCalming());
		mostCommonConditions.setTrafficSignal(this.repoP.mostCommonConditionTrafficSignal());
		mostCommonConditions.setTurningLoop(this.repoP.mostCommonConditionTurningLoop());
		mostCommonConditions.setVisibilityMi(this.repoP.mostCommonConditionVisibilityMi());
		mostCommonConditions.setWeatherCondition(this.repoP.mostCommonConditionWeatherCondition());
		mostCommonConditions.setWindChillF(this.repoP.mostCommonConditionWindChillF());
		mostCommonConditions.setWindDirection(this.repoP.mostCommonConditionWindDirection());
		mostCommonConditions.setWindSpeedMph(this.repoP.mostCommonConditionWindSpeedMph());

		return mostCommonConditions;
	}
	
	public Slice<Accident> accidentsNearAPointAndARadius(Double lat, Double lng, int radius, int pageNumber, int pageSize) {
		Pageable page = PageRequest.of(pageNumber, pageSize);
		return repoM.accidentsNearAPointInARadius(lat, lng, radius*1000, page); // El "*1000" es para que el radio sea tomado como kilometros
	}
	
	public Page<Accident> accidentsNearAPointAndARadiusElasticVersion(Double lat, Double lng, int radius, int pageNumber, int pageSize) {
		Pageable page = PageRequest.of(pageNumber, pageSize);
		return repoE.accidentsNearAPointInARadius(lat, lng, radius, page);
	}
	
	public Float averageDistanceOfAccidentsFromBeginningToEnd() {
		return repoP.averageDistanceOfAccidentsFromBeginningToEnd();
	}
	
	public List<LocationAndAmountSchema> fiveMostDangerousPoints(Double lat, Double lng, int radius){
		return repoM.fiveMostDangerousPoints(lat, lng, radius * 1000); // El "*1000" es para que el radio sea tomado como kilometros
	}
	
	public Page<AccidentWithDistanceSchema> allAvgDistanceBetweenTop10NearestAccidents(int pageNumber, int pageSize){
		Pageable page = PageRequest.of(pageNumber, pageSize);
		List<AccidentWithDistanceSchema> list = new ArrayList<AccidentWithDistanceSchema>(); 
		Page<Accident> accidents = repoM.findAll(page);
		for (Accident a: accidents) {
			Double[] l = {Double.parseDouble(a.getStartLat().toString()), Double.parseDouble(a.getStartLng().toString())};
			list.add(repoM.allAvgDistanceBetweenTop10NearestAccidents(a.getId(), l).get(0));
		}
		return new PageImpl<AccidentWithDistanceSchema>(list, page, accidents.getTotalPages());	
	}
	
	public List<String> fiveStreetsWithMoreAccidents() {
		return repoP.streetsWithMoreAccidents();
	}
	
}
