/**
 * Este paquete contiene todas las clases e interfaces que componen la capa de servicios.
 */
package com.zinbig.mongodemo.services;

import com.zinbig.mongodemo.dtos.AccidentDTO;

/**
 * Esta interface define el comportamiento esperado por los servicios
 * relacionados con los usuarios.
 *
 * @author Javier Bazzocco
 *
 */
public interface IAccidentService {
    /**
     * Encuentra el primer accidente con un "Source" especifico
     *
     * @param aSource es el source del accidente
     * @return un DTO que representa al accidente hallado.
     */
    public AccidentDTO findBySource(String aSource);
}
