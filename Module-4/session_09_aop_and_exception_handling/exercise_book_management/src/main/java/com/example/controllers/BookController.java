package com.example.controllers;

import com.example.exceptions.OutOfRemainQuantityException;
import com.example.exceptions.WrongBookIdException;
import com.example.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("")
    public ModelAndView listBooks() {
        return new ModelAndView("list", "books", bookService.findAll());
    }

    @GetMapping("/detail")
    public ModelAndView viewDetail(@RequestParam String id) {
        return new ModelAndView("detail", "book", bookService.findById(id));
    }

    @GetMapping("/borrow")
    public String borrowBook(@RequestParam String id, Model model) throws OutOfRemainQuantityException {
        bookService.borrowBook(id);
        model.addAttribute("message", "Borrowed successfully!");
        model.addAttribute("books", bookService.findAll());
        return "list";
    }

    @GetMapping("/return")
    public String returnBook(@RequestParam String id, Model model) throws WrongBookIdException {
        bookService.returnBook(id);
        model.addAttribute("message", "Returned successfully!");
        model.addAttribute("books", bookService.findAll());
        return "list";
    }

    @ExceptionHandler({OutOfRemainQuantityException.class, WrongBookIdException.class})
    public ModelAndView catchBorrowException(Exception e) {
        return new ModelAndView("error", "message", e.getMessage());
    }
}
