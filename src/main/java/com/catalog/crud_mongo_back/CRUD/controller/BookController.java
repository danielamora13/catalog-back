package com.catalog.crud_mongo_back.CRUD.controller;

import com.catalog.crud_mongo_back.CRUD.dto.BookDto;
import com.catalog.crud_mongo_back.CRUD.entity.Book;
import com.catalog.crud_mongo_back.CRUD.service.BookService;
import com.catalog.crud_mongo_back.global.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAll() {
        return ResponseEntity.ok(bookService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable("id") int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(bookService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Book> save(@RequestBody BookDto dto) {
        return ResponseEntity.ok(bookService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable("id") int id, @RequestBody BookDto dto) throws ResourceNotFoundException {
        return ResponseEntity.ok(bookService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) throws ResourceNotFoundException {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
