package com.example.day4pah.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.day4pah.model.Book;
import com.example.day4pah.repository.BookRepo;

@Service
public class BookService {
    public BookRepo bookRepo;
    public BookService(BookRepo bookRepo)
    {
        this.bookRepo = bookRepo;
    }
    public boolean saveBook(Book book)
    {
        try{
            bookRepo.save(book);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<Book> getBooks()
    {
        return bookRepo.findAll();
    }
    public Book getBookById(int id)
    {
        return bookRepo.findById(id).orElse(null);
    }
}
