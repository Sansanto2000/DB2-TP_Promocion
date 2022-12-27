package com.mitocode.service.interf;

import java.sql.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import com.mitocode.model.persistence.Accident;
import com.mitocode.model.schema.AccidentWithDistanceSchema;
import com.mitocode.model.schema.ConditionsSchema;
import com.mitocode.model.schema.LocationAndAmountSchema;

public interface AccidentService {
	
	public Slice<Accident> accidentsBetweenTwoDates(Date startDate, Date endDate, int pageNumber, int pageSize);

	public ConditionsSchema mostCommonConditions();
	
	public Slice<Accident> accidentsNearAPointAndARadius(Double[] point, int radius, int pageNumber, int pageSize);
	
	public Float averageDistanceOfAccidentsFromBeginningToEnd();
	
	public List<LocationAndAmountSchema> fiveMostDangerousPoints(Double[] point, int radius);
	
	public List<AccidentWithDistanceSchema> avgDistanceBetweenTop10NearestAccidents();
	
	public List<String> fiveStreetsWithMoreAccidents();
	
	
	
	// Luego Borrar
	public void registrar(Accident t);
	public Page<Accident> test(int pageNumber, int pageSize);
	public Page<Accident> findByCountry(String country, int pageNumber, int pageSize);

}
