package com.mitocode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Accident;
import com.mitocode.repo.mongo.IMongoAccidentRepo;
import com.mitocode.repo.postgre.IPostgreAccidentRepo;

@Service
public class AccidentService{

	@Autowired
	private IMongoAccidentRepo repoM;
	@Autowired
	private IPostgreAccidentRepo repoP;

	public void registrar(Accident t) {
		repoM.save(t);
		repoP.save(t);
	}
}
