package com.example.services.impl;

import com.example.exceptions.OutOfRemainQuantityException;
import com.example.exceptions.WrongBookIdException;
import com.example.models.Book;
import com.example.repositories.BookRepository;
import com.example.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(String id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public boolean isAvailable(Book book) {
        return book.getQuantity() > 0;
    }

    @Override
    public void borrowBook(String id) throws OutOfRemainQuantityException {
        Book book = bookRepository.getOne(id);
        if (isAvailable(book)) {
            book.setQuantity(book.getQuantity() - 1);
            bookRepository.save(book);
        } else {
            throw new OutOfRemainQuantityException();
        }
    }

    @Override
    public void returnBook(String id) throws WrongBookIdException {
        Book book = findById(id);
        if (book != null) {
            book.setQuantity(book.getQuantity() + 1);
            bookRepository.save(book);
        } else {
            throw new WrongBookIdException();
        }
    }
}