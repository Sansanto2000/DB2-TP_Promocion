/**
 * Este paquete contiene las implementaciones de los servicios.
 */
package com.zinbig.mongodemo.services.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zinbig.mongodemo.dtos.DTOFactory;
import com.zinbig.mongodemo.dtos.AccidentDTO;
import com.zinbig.mongodemo.model.Accident;
import com.zinbig.mongodemo.repositories.AccidentRepository;
import com.zinbig.mongodemo.repositories.AccidentPostgreRepository;
import com.zinbig.mongodemo.services.IAccidentService;

/**
 * Esta clase contiene la implementación de los servicios relacionados con los
 * usuarios.
 *
 * @author Javier Bazzocco
 *
 */
@Service
//@Transactional
public class AccidentServiceImpl implements IAccidentService {

    /**
     * Es el repositorio ligado a los accidentes.
     */
    @Inject
    private AccidentRepository accidentRepository;
    @Inject
    private AccidentPostgreRepository accidentpostgreRepository;

    /**
     * Es el objeto encargado de crear los DTOs.
     */
    @Inject
    private DTOFactory dtoFactory;

    /**
     * Agrega un nuevo usuario.
     *
     * @param aName      es el nombre del usuario.
     * @param anUsername es el nombre de usuario del nuevo usuario.
     * @param aPassword  es la contraseña del usuario.
     * @return un DTO que representa al usuario recientemente creado.
     */
    @Override
    public AccidentDTO findBySource(String aSource) {
        Accident anAccident = this.getAccidentRepository().findBySource(aSource);
        return this.getDtoFactory().createAccidentDTO(anAccident);
    }

    /**
     * Getter.
     *
     * @return el repositorio de accidentes.
     */
    public AccidentRepository getAccidentRepository() {
        return this.accidentRepository;
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