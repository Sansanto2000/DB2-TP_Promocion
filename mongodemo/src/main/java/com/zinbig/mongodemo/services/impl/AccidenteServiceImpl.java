/**
 * Este paquete contiene las implementaciones de los servicios.
 */
package com.zinbig.mongodemo.services.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zinbig.mongodemo.dtos.DTOFactory;
import com.zinbig.mongodemo.model.Accidente;
import com.zinbig.mongodemo.repositories.AccidenteRepository;
import com.zinbig.mongodemo.services.AccidenteService;


/**
 * Esta clase contiene la implementación de los servicios relacionados con los
 * accidentes.
 * 
 * @author Javier Bazzocco
 *
 */
@Service
@Transactional
public class AccidenteServiceImpl implements AccidenteService {

	/**
	 * Es el repositorio ligado a los accidentes.
	 */
	@Inject
	private AccidenteRepository accidenteRepository;

	/**
	 * Es el objeto encargado de crear los DTOs.
	 */
	@Inject
	private DTOFactory dtoFactory;

	/**
	 * Getter.
	 * 
	 * @return el repositorio de accidentes.
	 */
	public AccidenteRepository getAccidenteRepository() {
		return this.accidenteRepository;
	}

	/**
	 * Getter.
	 * 
	 * @return el objeto que debe utilizarse para crear los DTOs.
	 */
	public DTOFactory getDtoFactory() {
		return this.dtoFactory;
	}

}
