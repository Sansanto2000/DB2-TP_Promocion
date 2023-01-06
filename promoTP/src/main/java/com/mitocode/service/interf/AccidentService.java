package com.mitocode.service.interf;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;

import com.mitocode.model.persistence.Accident;
import com.mitocode.model.schema.AccidentWithDistanceSchema;
import com.mitocode.model.schema.ConditionsSchema;
import com.mitocode.model.schema.LocationAndAmountSchema;

public interface AccidentService {
	
	public Page<Accident> accidentsBetweenTwoDates(Date startDate, Date endDate, int pageNumber, int pageSize);
	
	public Page<Accident> accidentsBetweenTwoDatesElasticVersion(Date startDate, Date endDate, int pageNumber, int pageSize);

	public ConditionsSchema mostCommonConditions();
	
	public Slice<Accident> accidentsNearAPointAndARadius(Double lat, Double lng, int radius, int pageNumber, int pageSize);
	
	public Page<Accident> accidentsNearAPointAndARadiusElasticVersion(Double lat, Double lng, int radius, int pageNumber, int pageSize);
	
	public Float averageDistanceOfAccidentsFromBeginningToEnd();
	
	public List<LocationAndAmountSchema> fiveMostDangerousPoints(Double lat, Double lng, int radius);
	
	public Page<AccidentWithDistanceSchema> allAvgDistanceBetweenTop10NearestAccidents(int pageNumber, int pageSize);
	
	public List<String> fiveStreetsWithMoreAccidents();
	
	// Extra
	public void registrar(Accident t);

}
