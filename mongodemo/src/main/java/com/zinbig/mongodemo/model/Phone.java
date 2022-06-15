/**
 * Este paquete contiene las clases que representan las entidades del dominio.
 */
package com.zinbig.mongodemo.model;

import org.springframework.data.annotation.Id;

/**
 * Clase que representa un teléfono.<br>
 * 
 *
 * @author Javier Bazzocco
 *
 */

public class Phone {

	/**
	 * Es el identificador de cada instancia.
	 */
	@Id
	private String id;

	/**
	 * Es el número del teléfono.
	 */
	private String number;

	/**
	 * Constructor. No utilizar.
	 */
	public Phone() {

	}

	/**
	 * Constructor.
	 * 
	 * @param aNumber es el número de teléfono.
	 */
	public Phone(String aNumber) {
		this.setNumber(aNumber);
	}

	/**
	 * Getter.
	 * 
	 * @return el identificador de esta instancia.
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Setter.
	 * 
	 * @param anId es el identificador de esta instancia.
	 */
	public void setId(String anId) {
		this.id = anId;
	}

	/**
	 * Getter.
	 * 
	 * @return el número de este teléfono.
	 */
	public String getNumber() {
		return this.number;
	}

	/**
	 * Setter.
	 * 
	 * @param aNumber es el número de este teléfono.
	 */
	public void setNumber(String aNumber) {
		this.number = aNumber;
	}

}
