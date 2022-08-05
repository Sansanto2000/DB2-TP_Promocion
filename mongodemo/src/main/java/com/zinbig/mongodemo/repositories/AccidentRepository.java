package com.zinbig.mongodemo.repositories;

//import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zinbig.mongodemo.model.Accident;

@Repository
public interface AccidentRepository extends MongoRepository<Accident, String> {

    public Accident findBySource(String aSource);

    /*
    @Query("{name: ?1, username:?0}")
    public User findUserX(String anUsername, String aName);

    List<Accident> findByPressure(@Param("Pressure") double pressure);
     */
}