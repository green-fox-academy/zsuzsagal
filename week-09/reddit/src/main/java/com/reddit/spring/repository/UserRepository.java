package com.reddit.spring.repository;

import com.reddit.spring.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
