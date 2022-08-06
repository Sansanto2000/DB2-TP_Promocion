package com.mitocode.repo.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mitocode.model.mongo.User;

@Repository
public interface IUserRepo extends MongoRepository<User, Integer> {

}
