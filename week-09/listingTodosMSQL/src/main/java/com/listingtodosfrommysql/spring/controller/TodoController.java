package com.listingtodosfrommysql.spring.controller;

import com.listingtodosfrommysql.spring.model.Assignee;
import com.listingtodosfrommysql.spring.model.Todo;
import com.listingtodosfrommysql.spring.repository.AssigneeRepository;
import com.listingtodosfrommysql.spring.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/todo")
public class TodoController {

  private TodoRepository todoRepository;
  private AssigneeRepository assigneeRepository;

  @Autowired
  public TodoController(TodoRepository todoRepository, AssigneeRepository assigneeRepository) {
    this.todoRepository = todoRepository;
    this.assigneeRepository = assigneeRepository;
  }

  @GetMapping({"/", "/list"})
  public String listByDone(Model model, @RequestParam(value = "done", required = false) Boolean done,
                           @RequestParam(value = "title", required = false) String title) {
    if(done!=null) {
      model.addAttribute("todos", todoRepository.findAllByDone(done));
    }
    else {
      if (title !=null) {
        model.addAttribute("todos",  filterTodosByTitle(title));
      }
      else
        model.addAttribute("todos", todoRepository.findAll());
    }
    return "todolist";
  }

  @GetMapping("/add")
  public String addNew(Model model) {
    model.addAttribute("todo", new Todo());
    return "addTodo";
  }

  @PostMapping("/add")
  public String showUpdatedList(@ModelAttribute Todo todo) {
    Assignee assignee = assigneeRepository.findById(1L).get();
    todo.setAssignee(assignee);
    todoRepository.save(todo);
    return "redirect:list";
  }

  @GetMapping("/{id}/edit")
  public String editTodo(Model model, @PathVariable Long id) {
    if(id!=null) {
      Optional<Todo> todo = todoRepository.findById(id);
      model.addAttribute("todo", todo);
    }
    return "/editTodo";
    }

  @PostMapping("/{id}/edit")
  public String showUpdatedTodo(@PathVariable Long id,@ModelAttribute Todo todo) {
   Todo currentTodo = todoRepository.findById(id).get();
   currentTodo.setTitle(todo.getTitle());
   currentTodo.setDone(todo.getDone());
   currentTodo.setUrgent(todo.getUrgent());
   todoRepository.save(currentTodo);
   return "redirect:/todo/list";
  }

  @GetMapping("/{id}/delete")
  public String delete(@PathVariable Long id){
    if(id!=null){
      todoRepository.deleteById(id);
    }
    return "redirect:/todo/list";
  }

  public List<Todo> filterTodosByTitle(String title) {
    List<Todo> todos = new ArrayList<>();
    todoRepository.findAll().forEach(todos::add);
    return  todos.stream().filter(e->e.getTitle().contains(title))
            .collect(Collectors.toList());
  }

  @GetMapping("/assignee")
  public String listAssignees(Model model) {
        model.addAttribute("assignees", assigneeRepository.findAll());
    return "assigneelist";
  }

  @GetMapping("/assignee/{id}/edit")
  public String editAssignee(Model model, @PathVariable Long id) {
    if(id!=null) {
      Optional<Assignee> assignee = assigneeRepository.findById(id);
      model.addAttribute("assignee", assignee);
    }
    return "editAssignee";
  }

  @PostMapping("/assignee/{id}/edit")
  public String showUpdatedAssignee(@PathVariable Long id,@ModelAttribute Assignee assignee) {
    Assignee currentAssignee = assigneeRepository.findById(id).get();
    currentAssignee.setName(assignee.getName());
    currentAssignee.setEmail(assignee.getEmail());
    assigneeRepository.save(currentAssignee);
    return "redirect:/todo/assignee";
  }

  @GetMapping("/assignee/{id}/delete")
  public String deleteAssignee(@PathVariable Long id){
    if(id!=null){
      assigneeRepository.deleteById(id);
    }
    return "redirect:/todo/assignee";
  }

  @GetMapping("/assignee/add")
  public String addNewAssignee(Model model) {
    model.addAttribute("assignee", new Assignee());
    return "addAssignee";
  }

  @PostMapping("/assignee/add")
  public String showUpdatedAssigneeList(@ModelAttribute Assignee assignee) {
    assigneeRepository.save(assignee);
    return "redirect:/todo/assignee";
  }
}







