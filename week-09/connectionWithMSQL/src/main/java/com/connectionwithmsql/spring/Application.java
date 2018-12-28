package com.connectionwithmsql.spring;

import com.connectionwithmsql.spring.model.Todo;
import com.connectionwithmsql.spring.repository.Repository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  private Repository repository;

  public Application(Repository repository) {
    this.repository = repository;
  }

  public void run(String[] titles) {
    repository.save(new Todo("Learn Object Relational Mapping"));
    repository.save(new Todo("Check difference between GetMapping and PostMapping"));
    repository.save(new Todo("Check out Levi's code review"));
    repository.save(new Todo("Book time for code review"));
    repository.save(new Todo("Catch up with last week's projects"));
    repository.save(new Todo("Prepare for the exam"));
  }
}