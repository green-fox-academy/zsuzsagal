package com.listingtodosfrommysql.spring.repository;

import com.listingtodosfrommysql.spring.model.Assignee;
import org.springframework.data.repository.CrudRepository;

public interface AssigneeRepository extends CrudRepository<Assignee,Long> {
}
