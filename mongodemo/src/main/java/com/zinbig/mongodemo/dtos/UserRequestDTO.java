/**
 * Este paquete contiene todos los objetos que se utilizan para representar los pedidos enviados
 * como parte del cuerpo (body).
 */
package com.zinbig.mongodemo.dtos;

/**
 * Las instancias de esta clase se utilizan para representar los datos
 * requeridos para el alta de un usuario.
 * 
 * @author Javier Bazzocco
 *
 */

public class UserRequestDTO {

	/**
	 * Es el id del usuario.
	 */
	public String id;

	/**
	 * Es el nombre del usuario.
	 */
	public String name;

	/**
	 * Es el username del nuevo usuario.
	 */
	public String username;

	/**
	 * Es la clave del usuario.
	 */
	public String password;

	/**
	 * Constructor.
	 * 
	 * @param id       es el identificador del usuario.
	 * 
	 * @param name     es el nombre del usuario.
	 * @param username es el username del nuevo usuario.
	 * @param password es la clave del usuario.
	 */
	public UserRequestDTO(String id, String name, String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
	}

}
