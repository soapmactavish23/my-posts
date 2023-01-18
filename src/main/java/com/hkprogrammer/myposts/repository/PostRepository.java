package com.hkprogrammer.myposts.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.hkprogrammer.myposts.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
