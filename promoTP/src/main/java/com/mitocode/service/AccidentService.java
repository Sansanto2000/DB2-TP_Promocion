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
	
	/*public Accident conditionsMostCommons() {
		//Implementar una clase Accidente con las condiciones mas comunes en cada campo
	}
	
	public Slice<Accident> accidentsNearAPointAndARadius(Double[] point, int radius, int pageNumber, int pageSize) {
		Pageable page = PageRequest.of(pageNumber, pageSize);
		repoM.addLocationToAccidents();
		return repoM.accidentsNearAPointInARadius(point, radius, page);
	}
	
	public Float averageDistanceOfAccidentsFromBeginningToEnd() {
		//Avg del campo distance
	}
	
	public List<String> fiveMostDangerousPoints(Double[] point, int radius){
		//Las 5 locations mas peligrosos(que mas se repiten) dentro del area recibida por parametro
	}
	
	public Float averageDistanceFromEveryAccidentToTheNearestTen(int page) {
		//Sacar promedio de distancias entre un accidente y los 10 mas cercanos, para luego
		//hacer un promedio de todos los promedios calculados anteriormente
	}*/
}
