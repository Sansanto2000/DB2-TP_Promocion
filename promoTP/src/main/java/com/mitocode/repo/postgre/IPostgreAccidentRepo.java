package com.mitocode.repo.postgre;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Accident;

public interface IPostgreAccidentRepo extends JpaRepository<Accident, String>{

}
