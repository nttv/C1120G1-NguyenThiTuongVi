package com.example.exceptions;

public class WrongBookIdException extends Exception {
    public WrongBookIdException() {
    }

    @Override
    public String getMessage() {
        return "The book id is incorrect. Please check again.";
    }
}
