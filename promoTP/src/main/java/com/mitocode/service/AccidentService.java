package com.mitocode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Accident;
import com.mitocode.repo.mongo.IMongoAccidentRepo;
import com.mitocode.repo.postgre.IPostgreAccidentRepo;
import java.util.List;
import java.util.Date;

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

	public List<Accident> accidentsBetweenTwoDates(Date startDate, Date endDate) {
		return repoP.accidentsBetweenTwoDates(startDate, endDate);
	}
}
