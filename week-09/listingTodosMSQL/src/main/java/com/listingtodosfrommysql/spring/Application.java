package com.listingtodosfrommysql.spring;

import com.listingtodosfrommysql.spring.model.Assignee;
import com.listingtodosfrommysql.spring.model.Todo;
import com.listingtodosfrommysql.spring.repository.AssigneeRepository;
import com.listingtodosfrommysql.spring.repository.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  private TodoRepository todoRepository;
  private AssigneeRepository assigneeRepository;

  public Application(TodoRepository todoRepository, AssigneeRepository assigneeRepository) {
    this.todoRepository = todoRepository;
    this.assigneeRepository = assigneeRepository;
  }

  public void run(String[] titles) {
    Assignee Dave = new Assignee("Dave", "dave@gmail.com");
    Assignee Emily = new Assignee("Emily", "emily12@hotmail.com");
    Assignee Emma = new Assignee("Emma", "esmith@yahoo.com");
    Assignee Chris = new Assignee("Chris", "dragon23@gmail.com");
    Assignee Pablo = new Assignee("Pablo", "pablo_nazarro@yahoo.com");

    List<Assignee> users = Arrays.asList(Dave, Emily,Emma, Chris,Dave,Pablo );
    assigneeRepository.saveAll(users);

    todoRepository.save(new Todo("Learn Object Relational Mapping", true, false, Dave));
    todoRepository.save(new Todo("Check difference between GetMapping and PostMapping", true, false, Dave));
    todoRepository.save(new Todo("Check out Levi's code review", false, false, Emma));
    todoRepository.save(new Todo("Book time for code review", true, true, Chris));
    todoRepository.save(new Todo("Catch up with last week's projects", true, true, Pablo));
    todoRepository.save(new Todo("Prepare for the exam", false, false, Emily));
  }
}
