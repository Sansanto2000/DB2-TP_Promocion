package com.zinbig.mongodemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.zinbig.mongodemo.model.Accident;
public interface AccidentPostgreRepository extends JpaRepository<Accident, String> {

}