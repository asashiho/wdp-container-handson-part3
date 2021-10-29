package com.example.back;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Product {

    private @Id @GeneratedValue Long id;
    private String name;
    private String detail;
    private int price;

    public Product() {
    }

    public Product(String name, String detail, int price) {

        this.name = name;
        this.detail = detail;
        this.price = price;
    }

}