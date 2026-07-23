
package com.lpu.library.controller;
import com.lpu.library.entity.Book;
import com.lpu.library.repository.BookRepository;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/books")
public class BookController{
private final BookRepository repo;
public BookController(BookRepository repo){this.repo=repo;}
@GetMapping public List<Book> all(){return repo.findAll();}
@PostMapping public Book add(@RequestBody Book b){return repo.save(b);}
@GetMapping("/{id}") public Book one(@PathVariable Long id){return repo.findById(id).orElse(null);}
@PutMapping("/{id}") public Book update(@PathVariable Long id,@RequestBody Book b){b.setId(id);return repo.save(b);}
@DeleteMapping("/{id}") public String delete(@PathVariable Long id){repo.deleteById(id);return "Deleted";}
}
