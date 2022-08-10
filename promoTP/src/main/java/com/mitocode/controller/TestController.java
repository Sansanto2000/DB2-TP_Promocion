package com.mitocode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.model.Accident;
import com.mitocode.service.AccidentService;

import java.util.List;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;


@RestController
@RequestMapping("/databases")
public class TestController {
	
	@Autowired
	private AccidentService accidentService;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/accident")
	public void registrarUser(@RequestBody Accident accident) {
		accidentService.registrar(accident);
	}

	//(postgre) Devolver todos los accidentes ocurridos entre 2 fechas dadas
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/query1")
	public List<Accident> accidentsBetweenTwoDates(String startDate, String endDate) {
		//Comprobaciones de formato y tipo de date1 y date2
		Date date1 = new GregorianCalendar(2000, Calendar.FEBRUARY, 11).getTime();
		Date date2 = new GregorianCalendar(2020, Calendar.FEBRUARY, 20).getTime();
		List<Accident> accidents = accidentService.accidentsBetweenTwoDates(date1, date2);
		System.out.println("Hubo " + accidents.size() + " accidentes entre " + startDate +" y "+ endDate);
		return accidents; //falta agregar paginado
		//Tambien falta hacer que las fechas que usa sean las recibidas por parametro y no las que harcodeamos
	}

	//(postgre) Determinar las condiciones más comunes en los accidentes (hora del día, condiciones climáticas, etc)
	//(mongodb) Dado un punto geográfico y un radio (expresado en kilómetros) devolver todos los accidentes ocurridos dentro del radio.
	//(mongodb) Obtener la distancia promedio desde el inicio al fin del accidente
	//(mongodb) Devolver los 5 puntos más peligrosos (definiendo un determinado radio y utilizando los datos de los accidentes registrados).
	//(mongodb) Devolver la distancia promedio que existe entre cada accidente y los 10 más cercanos.

	//(postgre) Devolver el nombre de las 5 calles con más accidentes.
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/query7")
	public List<String> fiveStreetsWithMoreAccidents() {
		List<String> topFive = accidentService.fiveStreetsWithMoreAccidents();
		return topFive; //falta agregar paginado
	}
}
