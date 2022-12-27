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

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Page;

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
		Double[] point = { longitude, latitude };
		Slice<Accident> accidents = accidentService.accidentsNearAPointAndARadius(point, radius*1000, pageNumber, pageSize); // El "*1000" es para que el radio sea tomado como kilometros
		return accidents;
	}

	// Obtener la distancia promedio desde el inicio al fin del accidente
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/averageDistanceOfAccidentsFromBeginningToEnd")
	public Float averageDistanceOfAccidentsFromBeginningToEnd() {
		return accidentService.averageDistanceOfAccidentsFromBeginningToEnd();
	}

	// REARMAR, SOLO RECIBE EL RADIO
	// Devolver los 5 puntos más peligrosos (definiendo un determinado radio y utilizando los datos de los accidentes registrados).
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/fiveMostDangerousPoints")
    public List<LocationAndAmountSchema> fiveMostDangerousPoints(
            @RequestParam(required = true) String longitude,
            @RequestParam(required = true) String latitude,
            @RequestParam(required = true) int radius) throws ParseException {
        Double[] point = { Double.parseDouble(longitude), Double.parseDouble(latitude) };
        List<LocationAndAmountSchema> points = this.accidentService.fiveMostDangerousPoints(point, radius * 1000); // El "*1000" es para que el radio sea tomado como kilometros
        return points;
      }
	
	// REARMAR, La distancia devuelta por cada accidente siempre esta siendo null.
	//(mongodb) Devolver la distancia promedio que existe entre cada accidente y los 10 más cercanos.
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/avgDistanceBetweenTop10NearestAccidents")
	public List<AccidentWithDistanceSchema> avgDistanceBetweenTop10NearestAccidents() {
		List<AccidentWithDistanceSchema> average = this.accidentService.avgDistanceBetweenTop10NearestAccidents();
		return average;
	}


	// Devolver el nombre de las 5 calles con más accidentes.
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/fiveStreetsWithMoreAccidents")
	public List<String> fiveStreetsWithMoreAccidents() {
		List<String> topFive = accidentService.fiveStreetsWithMoreAccidents();
		return topFive;
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/elasticTest")
	public Page<Accident> findAll(
			@RequestParam(required = true) String country,
			@RequestParam(required=true) int pageNumber,
			@RequestParam(required=true) int pageSize) throws ParseException {
		Page<Accident> accidents = accidentService.findByCountry(country, pageNumber, pageSize);
		return accidentService.test(pageNumber, pageSize);
		//return accidentService.findByCountry(country, pageNumber, pageSize);
	}
		
}
