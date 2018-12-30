package com.reddit.spring.repository;

import com.reddit.spring.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}