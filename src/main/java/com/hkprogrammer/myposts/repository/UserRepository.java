package com.hkprogrammer.myposts.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hkprogrammer.myposts.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
