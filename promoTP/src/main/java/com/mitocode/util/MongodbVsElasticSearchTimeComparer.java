package com.mitocode.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.mitocode.service.interf.AccidentService;

public class MongodbVsElasticSearchTimeComparer {

	private MongodbVsElasticSearchTimeComparer() {
		// TODO Auto-generated constructor stub
	}

	public static void timeCompare(AccidentService accidentService, int N) {
		double inicio;
		double fin;
		int i;
		Double totalMD;
		Double totalES;
		ArrayList<Double> promediosC1MD = new ArrayList<Double>();
		ArrayList<Double> promediosC1ES = new ArrayList<Double>();
		ArrayList<Double> promediosC2MD = new ArrayList<Double>();
		ArrayList<Double> promediosC2ES = new ArrayList<Double>();
		
		System.out.println("_____________________________________________");
		System.out.println("Comparacion de tiempos de las consulta X a lo largo de N repeticiones, por medio de sus implementaciones en de MongoDB y ElasticSearch Respectivamente");
		int[] arr_m = { 1, 2, 4, 8, 16, 32, 64, 128};
		int[] arr_r = { 1, 4, 16, 64, 256, 1024, 4096, 16384};
		
		
		System.out.println("---------------------------------------------");
		System.out.println("CONSULTA 1 = 'Devolver todos los accidentes ocurridos entre 2 fechas dadas (sin incluir las de esta ultima)'");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date fechaInicio = null;
		Date fechaFin;
		try {
			fechaInicio = new java.sql.Date(format.parse("2016-03-01 00:00:00").getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int pageNumber = 0;
		int pageSize = 1000;
		System.out.println("PARAMETROS:");
		System.out.println("- startDate = 2016-03-01");
		System.out.println("- endDate = VARIA");
		System.out.println("- pageNumber = "+ pageNumber);
		System.out.println("- pageSize = "+ pageSize);
		
		System.out.println("---------------------------------------------");
		System.out.println("CONSULTA 2 = 'Dado un punto geográfico y un radio (expresado en kilómetros) devolver todos los accidentes ocurridos dentro del radio.'");
		double latitude = 39.865147;
		double longitude = 39.865147;
		System.out.println("PARAMETROS:");
		System.out.println("- latitude = "+ latitude);
		System.out.println("- longitude = "+ longitude);
		System.out.println("- radius = VARIA");
		System.out.println("- pageNumber = "+ pageNumber);
		System.out.println("- pageSize = "+ pageSize);
		
		/* Se ejecuta 1 vez cada consulta de la forma mas exigente para que todas las que siguen cuenten con la misma ventaja de cache */
		fechaFin = Date.valueOf(fechaInicio.toLocalDate().plusMonths(arr_m[arr_m.length - 1]));
		accidentService.accidentsBetweenTwoDates(fechaInicio, fechaFin, pageNumber, pageSize);
		accidentService.accidentsBetweenTwoDatesElasticVersion(fechaInicio, fechaFin, pageNumber, pageSize);
		/* Calculo de promedios de la consulta 1 */
		for(int m: arr_m) {
			// Calculos relacionados a Consulta 1
			fechaFin = Date.valueOf(fechaInicio.toLocalDate().plusMonths(m));
			totalMD = 0.0;
			totalES = 0.0;
			for (i = 0; i < N; i++) {
				inicio = System.currentTimeMillis();
				accidentService.accidentsBetweenTwoDates(fechaInicio, fechaFin, pageNumber, pageSize);
		        fin = System.currentTimeMillis();
		        totalMD += ((fin - inicio)/1000);
		        
		        inicio = System.currentTimeMillis();
				accidentService.accidentsBetweenTwoDatesElasticVersion(fechaInicio, fechaFin, pageNumber, pageSize);
		        fin = System.currentTimeMillis();
		        totalES += ((fin - inicio)/1000);
			}
			promediosC1MD.add(totalMD/N);
			promediosC1ES.add(totalES/N);
		}
		
		/* Se ejecuta 1 vez cada consulta de la forma mas exigente para que todas las que siguen cuenten con la misma ventaja de cache */
		int radius = arr_r[arr_r.length - 1];
		accidentService.accidentsNearAPointAndARadius(latitude, longitude, radius, pageNumber, pageSize);
		accidentService.accidentsNearAPointAndARadiusElasticVersion(latitude, longitude, radius, pageNumber, pageSize);
		/* Calculo de promedios de la consulta 2 */
		for(int r: arr_r) {
			// Calculos relacionados a Consulta 2
			totalMD = 0.0;
			totalES = 0.0;
			for (i = 0; i < N; i++) {
				inicio = System.currentTimeMillis();
				accidentService.accidentsNearAPointAndARadius(latitude, longitude, r, pageNumber, pageSize);
		        fin = System.currentTimeMillis();
		        totalMD += ((fin - inicio)/1000);
		        
		        inicio = System.currentTimeMillis();
		        accidentService.accidentsNearAPointAndARadiusElasticVersion(latitude, longitude, r, pageNumber, pageSize);
		        fin = System.currentTimeMillis();
		        totalES += ((fin - inicio)/1000);
			}
			promediosC2MD.add(totalMD/N);
			promediosC2ES.add(totalES/N);
			
		}
		System.out.println("---------------------------------------------");
		System.out.println("TABLA 1 = promedio en segundos que tarda cada DB para la Consulta 1 a lo largo de "+N+" repeticiones, variando la dimencion M de la cantidad de meses que contempla el intervalo");
		System.out.println("|      |    M=1|    M=2|    M=4|    M=8|   M=16|   M=32|   M=64|  M=128|");
		System.out.print("|  MD  |");
		for(i = 0; i< arr_m.length; i++)
			System.out.printf(" %.4f|", promediosC1MD.get(i));
		System.out.println("");
		System.out.print("|  ES  |");
		for(i = 0; i< arr_m.length; i++)
			System.out.printf(" %.4f|", promediosC1ES.get(i));
		System.out.println("");
		
		System.out.println("");
		System.out.println("TABLA 2 = promedio en segundos que tarda cada DB para la Consulta 2 a lo largo de "+N+" repeticiones, variando el radio R a utilizar");
		System.out.println("|      |    R=1|    R=4|   R=16|   R=64|  R=256| R=1024| R=4096|R=16384|");
		System.out.print("|  MD  |");
		for(i = 0; i< arr_r.length; i++)
			System.out.printf(" %.4f|", promediosC2MD.get(i));
		System.out.println("");
		System.out.print("|  ES  |");
		for(i = 0; i< arr_r.length; i++)
			System.out.printf(" %.4f|", promediosC2ES.get(i));
		System.out.println("");
		
		System.out.println("_____________________________________________");
		

	}

}
