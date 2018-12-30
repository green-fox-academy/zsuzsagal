package com.listingtodosfrommysql.spring.repository;

import com.listingtodosfrommysql.spring.model.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoRepository extends CrudRepository<Todo,Long> {
   List <Todo> findAllByDone(boolean isDone);
}
