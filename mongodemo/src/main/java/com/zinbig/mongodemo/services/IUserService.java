/**
 * Este paquete contiene todas las clases e interfaces que componen la capa de servicios.
 */
package com.zinbig.mongodemo.services;

import com.zinbig.mongodemo.dtos.UserDTO;

/**
 * Esta interface define el comportamiento esperado por los servicios
 * relacionados con los usuarios.
 * 
 * @author Javier Bazzocco
 *
 */
public interface IUserService {

	/**
	 * Agrega un nuevo usuario.
	 * 
	 * @param aName      es el nombre del usuario.
	 * @param anUsername es el nombre de usuario del nuevo usuario.
	 * @param aPassword  es la contraseña del usuario.
	 * @return un DTO que representa al usuario recientemete creado.
	 */
	public UserDTO addUser(String aName, String anUsername, String aPassword);

	/**
	 * Agrega un teléfono a un usuario.
	 * 
	 * @param anId    es el identificador del usuario.
	 * @param aNumber es el número del teléfono.
	 */
	public void addPhone(String anId, String aNumber);

}
