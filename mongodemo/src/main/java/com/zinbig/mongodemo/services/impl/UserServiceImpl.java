/**
 * Este paquete contiene las implementaciones de los servicios.
 */
package com.zinbig.mongodemo.services.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zinbig.mongodemo.dtos.DTOFactory;
import com.zinbig.mongodemo.dtos.UserDTO;
import com.zinbig.mongodemo.model.Phone;
import com.zinbig.mongodemo.model.User;
import com.zinbig.mongodemo.repositories.UserRepository;
import com.zinbig.mongodemo.services.IUserService;

/**
 * Esta clase contiene la implementación de los servicios relacionados con los
 * usuarios.
 * 
 * @author Javier Bazzocco
 *
 */
@Service
@Transactional
public class UserServiceImpl implements IUserService {

	/**
	 * Es el repositorio ligado a los usuarios.
	 */
	@Inject
	private UserRepository userRepository;

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

	public UserDTO addUser(String aName, String anUsername, String aPassword) {

		User newUser = new User(anUsername, aPassword, aName);

		this.getUserRepository().save(newUser);

		return this.getDtoFactory().createUserDTO(newUser);
	}

	/**
	 * Getter.
	 * 
	 * @return el repositorio de usuarios.
	 */
	public UserRepository getUserRepository() {
		return this.userRepository;
	}

	/**
	 * Getter.
	 * 
	 * @return el objeto que debe utilizarse para crear los DTOs.
	 */
	public DTOFactory getDtoFactory() {
		return this.dtoFactory;
	}

	/**
	 * Agrega un teléfono a un usuario.
	 * 
	 * @param anId    es el identificador del usuario.
	 * @param aNumber es el número del teléfono.
	 */
	@Override
	public void addPhone(String anId, String aNumber) {
		User anUser = this.getUserRepository().findById(anId).get();
		anUser.setPhone(new Phone(aNumber));
		this.getUserRepository().save(anUser);

	}
}
