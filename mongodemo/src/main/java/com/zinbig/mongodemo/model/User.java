/**
 * Este paquete contiene las clases que representan las entidades del dominio.
 */
package com.zinbig.mongodemo.model;

import org.springframework.data.annotation.Id;

/**
 * Clase que representa a la entidad del usuario.<br>
 * 
 *
 * @author Javier Bazzocco
 *
 */
public class User {

	/**
	 * Es el identificador de cada instancia.
	 */
	@Id
	private String id;

	/**
	 * Es el nombre de usuario (en general es un email).
	 */
	private String username;

	/**
	 * Es la clave del usuario.
	 */
	private String password;

	/**
	 * Es el nombre del usuario.
	 */
	private String name;

	/**
	 * Es el teléfono del usuario.
	 */
	private Phone phone;

	/**
	 * Es la versión del usuario.
	 * 
	 */
	public int version;

	/**
	 * Constructor. No utilizar.
	 */
	public User() {

	}

	/**
	 * Constructor.
	 * 
	 * @param anUsername es el username del nuevo usuario.
	 * @param aPassword  es la clave del usuario.
	 * @param aName      es el nombre del usuario.
	 */
	public User(String anUsername, String aPassword, String aName) {
		this.setUsername(anUsername);
		this.setName(aName);
		this.setPassword(aPassword);
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
	 * @return el username de este usuario.
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * Setter.
	 * 
	 * @param anUsername es el username de este usuario.
	 */
	public void setUsername(String anUsername) {
		this.username = anUsername;
	}

	/**
	 * Getter.
	 * 
	 * @return la clave del usuario.
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Setter.
	 * 
	 * @param aPassword es la clave del usuario.
	 */
	public void setPassword(String aPassword) {
		this.password = aPassword;
	}

	/**
	 * Getter.
	 * 
	 * @return el nombre del usuario.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Setter.
	 * 
	 * @param aName es el nombre del usuario.
	 */
	public void setName(String aName) {
		this.name = aName;
	}

	/**
	 * Getter.
	 * 
	 * @return la versión del usuario.
	 */
	public int getVersion() {
		return this.version;
	}

	/**
	 * Setter.
	 * 
	 * @param version es la versión del usuario.
	 */
	public void setVersion(int version) {
		this.version = version;
	}

	/**
	 * Getter.
	 * 
	 * @return el teléfono del usuario.
	 */
	public Phone getPhone() {
		return this.phone;
	}

	/**
	 * Setter.
	 * 
	 * @param aPhone es el teléfono del usuario.
	 */
	public void setPhone(Phone aPhone) {
		this.phone = aPhone;
	}

}
