package com.example.back;

public class ProductNotFoundException extends RuntimeException {

    ProductNotFoundException(Long id) {
        super("Could not find item " + id);
    }
}