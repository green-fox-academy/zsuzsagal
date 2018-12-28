package com.connectionwithmsql.spring.repository;

import com.connectionwithmsql.spring.model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface Repository extends CrudRepository<Todo,Long> {

}

