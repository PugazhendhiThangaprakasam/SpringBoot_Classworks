package com.example.day4pah.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.day4pah.model.Book;
import com.example.day4pah.service.BookService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class BookController {
    public BookService bookService;
    public BookController(BookService bookService)
    {
        this.bookService=bookService;
    }
    @PostMapping("/api/book")
    public ResponseEntity<Book> postBooks(@RequestBody Book book) {
        if(bookService.saveBook(book)==true)
        {
            return new ResponseEntity<>(book,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/api/book")
    public ResponseEntity<List<Book>> getMethodName() {
        List<Book> list = bookService.getBooks();
        if(list.size() == 0)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/api/book/{bookId}")
    public ResponseEntity<Book> getMethodName(@PathVariable("bookId") int id) {
        Book b = bookService.getBookById(id);
        if(b==null)
        {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(b,HttpStatus.OK);
    }
    
    
    
}
