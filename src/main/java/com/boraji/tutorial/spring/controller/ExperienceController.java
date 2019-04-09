package com.boraji.tutorial.spring.controller;

import com.boraji.tutorial.spring.model.Experience;
import com.boraji.tutorial.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class ExperienceController {

    @Resource(name = "exper")
    private BookService<Experience> bookService;

    @PostMapping("/experience")
    public ResponseEntity<?> save(@RequestBody Experience experience) {
        long id = bookService.save(experience);
        return ResponseEntity.ok().body("New experience has been saved with ID:" + id);
    }

    @GetMapping("/experience/{id}")
    public ResponseEntity<Experience> get(@PathVariable("id") long id) {
        Experience experience = bookService.get(id);
        return ResponseEntity.ok().body(experience);
    }

    /*---get all books---*/
    @GetMapping("/experience")
    public ResponseEntity<List<Experience>> list() {
        List<Experience> experiences = bookService.list();
        return ResponseEntity.ok().body(experiences);
    }

    /*---Update a person by id---*/
    @PutMapping("/experience/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Experience experience) {
        bookService.update(id, experience);
        return ResponseEntity.ok().body("Experience has been updated successfully.");
    }

    /*---Delete a book by id---*/
    @DeleteMapping("/experience/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        bookService.delete(id);
        return ResponseEntity.ok().body("Experience has been deleted successfully.");
    }
}
