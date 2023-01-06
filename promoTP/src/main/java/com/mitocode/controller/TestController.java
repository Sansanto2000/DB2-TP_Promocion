package com.mitocode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.model.persistence.Accident;
import com.mitocode.model.schema.AccidentWithDistanceSchema;
import com.mitocode.model.schema.ConditionsSchema;
import com.mitocode.model.schema.LocationAndAmountSchema;
import com.mitocode.service.interf.AccidentService;
import com.mitocode.util.MongodbVsElasticSearchTimeComparer;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Slice;

import java.util.List;
import java.sql.Date;
import java.text.ParseException;


@RestController
@RequestMapping("/databases")
public class TestController {
	
	@Autowired
	private AccidentService accidentService;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/accident")
	public void registrarAccident(@RequestBody Accident accident) {
		accidentService.registrar(accident);
	}

	// Devolver todos los accidentes ocurridos entre 2 fechas dadas (sin incluir las de esta ultima)
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/accidentsBetweenTwoDates")
	public Slice<Accident> accidentsBetweenTwoDates(
			@RequestParam(value = "startDate", required=true) Date startDate,
			@RequestParam(value = "endDate", required=true) Date endDate,
			@RequestParam(value = "pageNumber", required=true) int pageNumber,
			@RequestParam(value = "pageSize", required=true) int pageSize) throws ParseException {
		Slice<Accident> accidents = accidentService.accidentsBetweenTwoDates(startDate, endDate, pageNumber, pageSize);
		return accidents;
	}
	
	// El anterior otra vez pero usando la implementacion de ELASTIC SEARCH
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/accidentsBetweenTwoDatesElasticVersion")
	public Slice<Accident> accidentsBetweenTwoDatesElasticVersion(
			@RequestParam(value = "startDate", required=true) Date startDate,
			@RequestParam(value = "endDate", required=true) Date endDate,
			@RequestParam(value = "pageNumber", required=true) int pageNumber,
			@RequestParam(value = "pageSize", required=true) int pageSize) throws ParseException {
		Slice<Accident> accidents = accidentService.accidentsBetweenTwoDatesElasticVersion(startDate, endDate, pageNumber, pageSize);
		return accidents;
	}

	// Determinar las condiciones más comunes en los accidentes (hora del día, condiciones climáticas, etc)
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/mostCommonConditions")
	public ConditionsSchema mostCommonConditions() {
		return accidentService.mostCommonConditions();
	}

	// Dado un punto geográfico y un radio (expresado en kilómetros) devolver todos los accidentes ocurridos dentro del radio.
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/accidentsNearAPointInARadius")
	public Slice<Accident> accidentsNearAPointInARadius(
			@RequestParam(value = "longitude", required = true) Double longitude,
			@RequestParam(value = "latitude", required = true) Double latitude,
			@RequestParam(value = "radius", required=true) int radius,
			@RequestParam(value = "pageNumber", required=true) int pageNumber,
			@RequestParam(value = "pageSize", required=true) int pageSize) throws ParseException {
		return accidentService.accidentsNearAPointAndARadius(latitude, longitude, radius, pageNumber, pageSize); 
	}
	
	// El anterior otra vez pero usando la implementacion de ELASTIC SEARCH
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/accidentsNearAPointInARadiusElasticVersion")
	public Slice<Accident> accidentsNearAPointInARadiusElasticVersion(
			@RequestParam(value = "longitude", required = true) Double longitude,
			@RequestParam(value = "latitude", required = true) Double latitude,
			@RequestParam(value = "radius", required=true) int radius,
			@RequestParam(value = "pageNumber", required=true) int pageNumber,
			@RequestParam(value = "pageSize", required=true) int pageSize) throws ParseException {
		return accidentService.accidentsNearAPointAndARadiusElasticVersion(latitude, longitude, radius, pageNumber, pageSize); 
	}

	// Obtener la distancia promedio desde el inicio al fin del accidente
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/averageDistanceOfAccidentsFromBeginningToEnd")
	public Float averageDistanceOfAccidentsFromBeginningToEnd() {
		return accidentService.averageDistanceOfAccidentsFromBeginningToEnd();
	}

	// Devolver los 5 puntos más peligrosos (definiendo un determinado radio y utilizando los datos de los accidentes registrados).
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/fiveMostDangerousPoints")
    public List<LocationAndAmountSchema> fiveMostDangerousPoints(
            @RequestParam(required = true) Double longitude,
            @RequestParam(required = true) Double latitude,
            @RequestParam(required = true) int radius) throws ParseException {
        List<LocationAndAmountSchema> points = this.accidentService.fiveMostDangerousPoints(latitude, longitude, radius); 
        return points;
	}
	
	// Devolver la distancia promedio que existe entre cada accidente y los 10 más cercanos.
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/allAvgDistanceBetweenTop10NearestAccidents")
	public Slice<AccidentWithDistanceSchema> avgDistanceBetweenTop10NearestAccidents(
			@RequestParam(value = "pageNumber", required=true) int pageNumber,
			@RequestParam(value = "pageSize", required=true) int pageSize) {
		Slice<AccidentWithDistanceSchema> average = this.accidentService.allAvgDistanceBetweenTop10NearestAccidents(pageNumber, pageSize);
		return average;
	}


	// Devolver el nombre de las 5 calles con más accidentes.
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/fiveStreetsWithMoreAccidents")
	public List<String> fiveStreetsWithMoreAccidents() {
		List<String> topFive = accidentService.fiveStreetsWithMoreAccidents();
		return topFive;
	}
	
	
	// ENDPOINT EXTRA: Añadido para comparar el tiempo que tardan las consultas de MongoDb
	// respecto a sus homonimas en ElasticSearch, los resultados se muestran en la consola.
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/mongoVsElasticTimeCompare")
	public void mongoVsElasticTimeCompare(
			@RequestParam(value = "N", required=true) int N) {
		MongodbVsElasticSearchTimeComparer.timeCompare(accidentService, N);
	}
		
}
