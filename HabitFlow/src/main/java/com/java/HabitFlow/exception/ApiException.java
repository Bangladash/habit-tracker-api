package com.java.HabitFlow.exception;


public class ApiException extends RuntimeException {

    public ApiException(String message) {
        super(message);
    }
}