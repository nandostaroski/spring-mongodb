package com.fstaroski.springmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fstaroski.springmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
