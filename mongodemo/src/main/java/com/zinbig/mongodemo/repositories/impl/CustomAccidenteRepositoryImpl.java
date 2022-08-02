/**
 * Este paquete contiene las implementaciones de los repositorios personalizados.
 */
package com.zinbig.mongodemo.repositories.impl;

import com.zinbig.mongodemo.repositories.CustomAccidenteRepository;

/**
 * Esta clase implementa los mecanismos personalizados de recuperación de
 * información.
 * 
 * @author Javier Bazzocco
 *
 */
public class CustomAccidenteRepositoryImpl implements CustomAccidenteRepository {

	/**
	 * Obtiene la cantidad de accidentes en una misma calle.
	 * 
	 * @return el número de accidentes.
	 */
	@Override
	public int getNumberOfAccidentesThatHasTheSameStreet(){
		return 4;

	}

}