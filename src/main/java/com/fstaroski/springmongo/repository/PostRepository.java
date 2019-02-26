package com.fstaroski.springmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.fstaroski.springmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
