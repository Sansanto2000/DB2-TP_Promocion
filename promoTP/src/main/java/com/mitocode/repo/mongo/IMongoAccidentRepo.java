package com.mitocode.repo.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mitocode.model.Accident;

@Repository
public interface IMongoAccidentRepo extends MongoRepository<Accident, String> {

}
