package com.henrybooks.henrybooks.controller;

import com.henrybooks.henrybooks.model.Book;
import com.henrybooks.henrybooks.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    BookRepository bookRepo;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value = "id") String bookCode){
        Book book = bookRepo.findOne(bookCode);
        if (book == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(book);
    }

}
