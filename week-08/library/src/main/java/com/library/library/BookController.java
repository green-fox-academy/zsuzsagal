package com.library.library;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BookController {

  private List<Book> books = new ArrayList<>();

  public BookController() {
    books.add(new Book("Cat's Cradle", "Kurt Vonnegut", 1963));
    books.add(new Book("Do Androids Dream of Electric Sheep?", "Philip K. Dick", 1968));
    books.add(new Book("Do Androids Dream of ice cream?", "Philip K. Dick", 1969));
    books.add(new Book("Nice gardens", "Philip K. Dick", 2000));
  }

  @GetMapping("/books")
  public String queryBooks(Model model, @RequestParam(name = "author", required = false) String author) {
    List<Book> queriedBooks;
    if (author != null) {
      queriedBooks = filterBooksByAuthor(author);
    } else {
      queriedBooks = books;
    }
    model.addAttribute("books", queriedBooks);
    return "index";
  }


  private List<Book> filterBooksByAuthor(String author) {
    return books.stream()
            .filter(book -> book.getAuthor().equals(author))
            .collect(Collectors.toList());
  }

  @GetMapping("/books/{id}/details")
  // search for the id in the path, and put it into the bookId variable:
  public String getBookById(Model model, @PathVariable(name="id") Integer bookId) {
    Book bookById = null;
    for(Book book : books) {
      if (book.getId() == bookId) {
        bookById = book;
      }
    }
    if (bookById != null) {
      model.addAttribute("book", bookById);
    } else {
      model.addAttribute("error", "No book found");
    }
    return "details";
  }

  @GetMapping("/books/add")
  public String addBookForm(Model model, @ModelAttribute(name="book") Book book) {
    model.addAttribute("book", book);
    return "create";
  }

  @PostMapping("/books/add")
  public String addBook(@ModelAttribute(name="book") Book book) {
    books.add(book);
    return "redirect:/books";
  }
}


