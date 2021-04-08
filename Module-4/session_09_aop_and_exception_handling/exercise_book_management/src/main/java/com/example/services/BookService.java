package com.example.services;

import com.example.exceptions.OutOfRemainQuantityException;
import com.example.exceptions.WrongBookIdException;
import com.example.models.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();

    Book findById(String id);

    void borrowBook(String id) throws OutOfRemainQuantityException;

    boolean isAvailable(Book book);

    void returnBook(String id) throws WrongBookIdException;
}
