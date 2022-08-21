package com.mitocode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Slice;

import com.mitocode.model.Accident;
import com.mitocode.service.AccidentService;

import java.util.List;
import java.util.Date;
//import java.sql.Date;
import java.text.SimpleDateFormat;
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

	//(postgre) Devolver todos los accidentes ocurridos entre 2 fechas dadas
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/query1") //Revisar que startDate siempre es retornado como null
	public Slice<Accident> accidentsBetweenTwoDates(
			@RequestParam(value = "startDate", required=true) String startDate,
			@RequestParam(value = "endDate", required=true) String endDate,
			@RequestParam(value = "pageNumber", required=true) int pageNumber,
			@RequestParam(value = "pageSize", required=true) int pageSize) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = dateFormat.parse(startDate + "T00:00:00");
		Date date2 = dateFormat.parse(endDate + "T00:00:00");
		Slice<Accident> accidents = accidentService.accidentsBetweenTwoDates(date1, date2, pageNumber, pageSize);
		return accidents;
	}

	//(postgre) Determinar las condiciones más comunes en los accidentes (hora del día, condiciones climáticas, etc)
	/*@ResponseStatus(HttpStatus.OK)
	@GetMapping("/query2") //Reparar parseos
	public Accident mostCommonCondition() {
		return accidentService.mostCommonCondition();
	}*/

	//(mongodb) dado un punto geográfico y un radio (expresado en kilómetros) devolver todos los accidentes ocurridos dentro del radio.
	/*@ResponseStatus(HttpStatus.OK)
	@GetMapping("/query3") //Resolver por que no anda la query
	public Slice<Accident> accidentsNearAPointInARadius(
			@RequestParam(value = "longitude", required = true) String longitude,
			@RequestParam(value = "latitude", required = true) String latitude,
			@RequestParam(value = "radius", required=true) int radius,
			@RequestParam(value = "pageNumber", required=true) int pageNumber,
			@RequestParam(value = "pageSize", required=true) int pageSize) throws ParseException {
		Double[] point = { Double.parseDouble(longitude), Double.parseDouble(latitude) };
		Slice<Accident> accidents = accidentService.accidentsNearAPointAndARadius(point, radius, pageNumber, pageSize);
		return accidents;
	}*/

	//(postgre) Obtener la distancia promedio desde el inicio al fin del accidente
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/query4")
	public Float averageDistanceOfAccidentsFromBeginningToEnd() {
		return accidentService.averageDistanceOfAccidentsFromBeginningToEnd();
	}

	//(mongodb) Devolver los 5 puntos más peligrosos (definiendo un determinado radio y utilizando los datos de los accidentes registrados).
	//(mongodb) Devolver la distancia promedio que existe entre cada accidente y los 10 más cercanos.

	//(postgre) Devolver el nombre de las 5 calles con más accidentes.
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/query7")
	public List<String> fiveStreetsWithMoreAccidents() {
		List<String> topFive = accidentService.fiveStreetsWithMoreAccidents();
		return topFive;
	}
	
}
