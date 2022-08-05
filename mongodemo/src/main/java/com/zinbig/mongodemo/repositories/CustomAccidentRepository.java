package com.zinbig.mongodemo.repositories;

/**
 * Esta interface define el comportamiento extra que debe cumplir un repositorio
 * de accidentes.
 *
 * @author Javier Bazzocco
 *
 */
public interface CustomAccidentRepository {

    /**
     * Obtiene la cantidad de accidentes que tienen el mismo "Source".
     *
     * @return el número de usuarios.
     */
    public int getNumberOfAccidentsThatHasTheSameSource();
}
