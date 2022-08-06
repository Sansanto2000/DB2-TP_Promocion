package com.mitocode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.model.Accident;
import com.mitocode.service.AccidentService;

@RestController
@RequestMapping("/databases")
public class TestController {
	
	@Autowired
	private AccidentService accidentService;
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/accident")
	public void registrarUser(@RequestBody Accident accident) {
		accidentService.registrar(accident);
	}
}
