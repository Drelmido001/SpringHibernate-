package com.example.springhibernate.Exceptions;

public class ApiRequestException extends RuntimeException {

    public ApiRequestException() {
        super("enter A valid CIN most be greater than 0 ");
    }

    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
