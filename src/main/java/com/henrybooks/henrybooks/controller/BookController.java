package com.henrybooks.henrybooks.controller;

import com.henrybooks.henrybooks.model.Book;
import com.henrybooks.henrybooks.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    BookRepository bookRepo;

    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        /*uses an EntityManager to persist the book entity to the database
        see https://github.com/spring-projects/spring-data-jpa/blob/master/
        src/main/java/org/springframework/data/jpa/repository/support/
        SimpleJpaRepository.java for the implementation*/
        if (bookRepo.findOne(book.getBookCode()) == null){
            bookRepo.save(book);
            return ResponseEntity.ok(book);
        }
        //book already exists
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable(value = "id") String bookCode) {
        Book book = bookRepo.findOne(bookCode);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(book);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook (@PathVariable(value = "id") String bookCode, @RequestBody Book bookDetails) {
        Book book = bookRepo.findOne(bookCode);
        if (book == null){
            return ResponseEntity.notFound().build();
        }

        book.setTitle(bookDetails.getTitle());
        book.setPublisherCode(bookDetails.getPublisherCode());
        book.setType(bookDetails.getType());
        book.setPaperback(bookDetails.getPaperback());
        bookRepo.save(book);

        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable(value = "id") String bookCode) {
        if (bookRepo.findOne(bookCode) == null){
            return ResponseEntity.notFound().build();
        }

        bookRepo.deleteOne(bookCode);
        return ResponseEntity.ok().build();
    }

}
