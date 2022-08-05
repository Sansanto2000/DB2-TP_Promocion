package com.example.demo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "accident", path = "accident")
public interface AccidentRepository extends MongoRepository<Accident, String> {

    List<Accident> findByPressure(@Param("Pressure") double pressure);

}