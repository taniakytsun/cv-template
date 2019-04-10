package com.boraji.tutorial.spring.controller;

import java.util.List;

import com.boraji.tutorial.spring.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boraji.tutorial.spring.service.BookService;

import javax.annotation.Resource;

@RestController
public class PersonController {

   @Resource(name = "personService")
   private BookService<Person> bookService;

   @PostMapping("/person")
   public ResponseEntity<?> save(@RequestBody Person person) {
      long id = bookService.save(person);
      return ResponseEntity.ok().body("New Person has been saved with ID:" + id);
   }

   @GetMapping("/person/{id}")
   public ResponseEntity<Person> get(@PathVariable("id") long id) {
      Person person = bookService.get(id);
      return ResponseEntity.ok().body(person);
   }

   /*---get all books---*/
   @GetMapping("/person")
   public ResponseEntity<List<Person>> list() {
      List<Person> people = bookService.list();
      return ResponseEntity.ok().body(people);
   }

   /*---Update a person by id---*/
   @PutMapping("/person/{id}")
   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Person person) {
      bookService.update(id, person);
      return ResponseEntity.ok().body("Person has been updated successfully.");
   }

   /*---Delete a book by id---*/
   @DeleteMapping("/person/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") long id) {
      bookService.delete(id);
      return ResponseEntity.ok().body("Person has been deleted successfully.");
   }
}