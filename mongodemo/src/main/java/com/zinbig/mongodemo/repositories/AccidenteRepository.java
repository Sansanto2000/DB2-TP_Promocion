/**
 * Este paquete contiene todas las implementaciones de los repositorios.
 */
package com.zinbig.mongodemo.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.zinbig.mongodemo.model.Accidente;

/**
 * Clase que representa el repositorio de accidentes.
 *
 * @author Javier Bazzocco
 *
 */
@Repository
public interface AccidenteRepository extends MongoRepository<Accidente, String>, CustomAccidenteRepository {

	/**
	 * ACA IRIAN LAS CONSULTAS
	 * Recupera un usuario por su nombre.
	 * 
	 * @param aName es el nombre del usuario.
	 * @return el usuario hallado o null.
	 */
	public Optional<Accidente> findById(String aId);


}