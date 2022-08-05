/**
 * Este paquete contiene las clases que se utilizan para transferir información de las
 * distintas instancias entre capas.
 */
package com.zinbig.mongodemo.dtos;

/**
 * Las instancias de esta clase se utilizan para transferir información de los
 * accidentes.
 *
 * @author Javier Bazzocco
 *
 */
public class AccidentDTO {

    private String id;
    private String source;

    public AccidentDTO(String anId, String aSource) {
        this.setId(anId);
        this.setSource(aSource);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String anId) {
        this.id = anId;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String anSource) {
        this.source = anSource;
    }
}