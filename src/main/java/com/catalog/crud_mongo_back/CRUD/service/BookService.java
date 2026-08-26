package com.catalog.crud_mongo_back.CRUD.service;

import com.catalog.crud_mongo_back.CRUD.dto.BookDto;
import com.catalog.crud_mongo_back.CRUD.entity.Book;
import com.catalog.crud_mongo_back.CRUD.repository.BookRepository;
import com.catalog.crud_mongo_back.global.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Book getById(int id) throws ResourceNotFoundException {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
    }

    public Book save(BookDto dto) {
        int id = autoIncrement();
        return bookRepository.save(BookMapper.fromDto(dto, id));
    }

    public Book update(int id, BookDto dto) throws ResourceNotFoundException {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
        return bookRepository.save(BookMapper.update(dto, book));
    }

    public void delete(int id) throws ResourceNotFoundException {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + id));
        bookRepository.delete(book);
    }

    private int autoIncrement() {
        List<Book> books = bookRepository.findAll();
        return books.isEmpty() ? 1
                : books.stream().max(Comparator.comparing(Book::getId)).get().getId() + 1;
    }
}
