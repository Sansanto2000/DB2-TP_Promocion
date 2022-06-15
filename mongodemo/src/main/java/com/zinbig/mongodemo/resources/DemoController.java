/**
 * Este paquete contiene las clases que definen la api rest de la aplicación.
 */
package com.zinbig.mongodemo.resources;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zinbig.mongodemo.dtos.UserRequestDTO;
import com.zinbig.mongodemo.services.IUserService;

/**
 * Esta clase presenta los diferentes "endpoints" de la api rest.
 * 
 * @author Javier Bazzocco
 *
 */
@RestController
public class DemoController {

	/**
	 * Es el servicio relacionado con los usuarios.
	 */
	@Inject
	private IUserService usersService;

	/**
	 * Endpoint para crear usuarios.
	 * 
	 * @param anUserRequestDTO dto que contiene la información del usuario a crear.
	 * 
	 */
	@PostMapping("/api/users")
	public void createUser(@RequestBody UserRequestDTO anUserRequestDTO) {
		this.getUsersService().addUser(anUserRequestDTO.name, anUserRequestDTO.username, anUserRequestDTO.password);
	}

	/**
	 * Endpoint para agregar un nuevo número de teléfono.
	 * 
	 * @param anId    es el identificador del usuario.
	 * @param aNumber es el número del teléfono.
	 */
	@PostMapping("/api/users/{id}/{number}")
	public void addPhone(@PathVariable("id") String anId, @PathVariable("number") String aNumber) {
		this.getUsersService().addPhone(anId, aNumber);
	}

	/**
	 * Getter.
	 * 
	 * @return el servicio relacionado con los usuarios.
	 */
	public IUserService getUsersService() {
		return this.usersService;
	}

}
