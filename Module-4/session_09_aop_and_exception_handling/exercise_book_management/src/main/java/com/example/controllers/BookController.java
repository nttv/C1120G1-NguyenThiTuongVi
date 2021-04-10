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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String borrowBook(@RequestParam String id, RedirectAttributes redirect) throws OutOfRemainQuantityException {
        bookService.borrowBook(id);
        redirect.addFlashAttribute("message", "Borrowed successfully!");
        return "redirect:/";
    }

    @GetMapping("/return")
    public String returnBook(@RequestParam String id, RedirectAttributes redirect) throws WrongBookIdException {
        bookService.returnBook(id);
        redirect.addFlashAttribute("message", "Returned successfully!");
        return "redirect:/";
    }

    @ExceptionHandler({OutOfRemainQuantityException.class, WrongBookIdException.class})
    public ModelAndView catchBorrowException(Exception e) {
        return new ModelAndView("error", "message", e.getMessage());
    }
}
