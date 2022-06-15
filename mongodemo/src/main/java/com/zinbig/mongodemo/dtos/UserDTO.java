/**
 * Este paquete contiene las clases que se utilizan para transferir información de las 
 * distintas instancias entre capas.
 */
package com.zinbig.mongodemo.dtos;

/**
 * Las instancias de esta clase se utilizan para transferir información de los
 * usuarios.
 * 
 * @author Javier Bazzocco
 *
 */
public class UserDTO {

	/**
	 * Identificador de cada una de las instancias.
	 */
	private String id;

	/**
	 * Es el nombre del usuario.
	 */
	private String name;

	/**
	 * Es el username del usuario.
	 */
	private String username;

	/**
	 * Es la versión del usuario.
	 */
	private int version;

	/**
	 * Constructor.
	 * 
	 * @param anId       es el identificador del usuario.
	 * @param anUsername es el username del usuario.
	 * @param aName      es el nombre del usuario.
	 * @param aVersion   es la versión del usuario.
	 */
	public UserDTO(String anId, String anUsername, String aName, int aVersion) {
		this.setId(anId);
		this.setName(aName);
		this.setUsername(anUsername);
		this.setVersion(aVersion);
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
	private void setVersion(int version) {
		this.version = version;
	}

}
