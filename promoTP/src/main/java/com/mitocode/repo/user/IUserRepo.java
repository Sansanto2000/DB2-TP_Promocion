package com.mitocode.repo.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mitocode.model.user.User;

@Repository
public interface IUserRepo extends MongoRepository<User, Integer> {

}
