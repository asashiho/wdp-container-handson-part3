package com.example.back;

public class RetryException extends RuntimeException {

    RetryException(int id) {
        super("Retry error.... " + id);
    }
}