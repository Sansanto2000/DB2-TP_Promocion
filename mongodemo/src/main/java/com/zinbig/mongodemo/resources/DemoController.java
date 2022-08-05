/**
 * Este paquete contiene las clases que definen la api rest de la aplicación.
 */
package com.zinbig.mongodemo.resources;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zinbig.mongodemo.services.IAccidentService;

/**
 * Esta clase presenta los diferentes "endpoints" de la api rest.
 * 
 * @author Javier Bazzocco
 *
 */
@RestController
public class DemoController {

	/**
	 * Es el servicio relacionado con los accidentes.
	 */
	@Inject
	private IAccidentService accidentService;

	@GetMapping("/api/HelloWorld")
	public String HelloWorld() {
		return "Hello World";
	}

	@GetMapping("/api/accidents/SourceMapQuest")
	public String getAccidentWhitSourceMapQuest() {
		return this.getAccidentService().findBySource("MapQuest").toString();
	}

	/**
	 * Getter.
	 *
	 * @return el servicio relacionado con los accidentes.
	 */
	public IAccidentService getAccidentService() {
		return this.accidentService;
	}
}
