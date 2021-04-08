package com.example.exceptions;

public class OutOfRemainQuantityException extends Exception {
    public OutOfRemainQuantityException() {
        super();
    }

    @Override
    public String getMessage() {
        return "The book is now fully borrowed. Please come back later.";
    }
}
