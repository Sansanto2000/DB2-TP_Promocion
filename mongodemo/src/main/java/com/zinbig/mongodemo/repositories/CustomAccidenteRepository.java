/**
 * Este paquete contiene todas las implementaciones de los repositorios.
 */
package com.zinbig.mongodemo.repositories;

/**
 * Esta interface define el comportamiento extra que debe cumplir un repositorio
 * de accidentes.
 * 
 * @author Javier Bazzocco
 *
 */
public interface CustomAccidenteRepository {

	/**
	 * Obtiene la cantidad de accidentes en una misma calle.
	 * 
	 * @return el número de accidentes.
	 */
	public int getNumberOfAccidentesThatHasTheSameStreet();
}
