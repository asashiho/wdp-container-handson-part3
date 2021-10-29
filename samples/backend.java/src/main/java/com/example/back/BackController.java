package com.example.back;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class BackController {

    private static final Random r = new Random(System.currentTimeMillis());

    @Autowired
    private ProductRepository repository;

    BackController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/items")
    List<Product> all() {

        int i = r.nextInt(10);
        log.info("i = {}", i );
        if (i < 5) {
            log.error("Throws RetryException.");
            throw new RetryException(i);

        } else {
            log.info("Access: OK");
            return repository.findAll();
        }

    }

    @PostMapping("/items")
    Product newProduct(@RequestBody Product newProduct) {
        return repository.save(newProduct);
    }

    @GetMapping("/items/{id}")
    Product one(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    @PutMapping("/items/{id}")
    Product replaceProduct(@RequestBody Product newProduct, @PathVariable Long id) {

        return repository.findById(id).map(item -> {
            item.setName(newProduct.getName());
            item.setDetail(newProduct.getDetail());
            item.setPrice(newProduct.getPrice());
            
            return repository.save(item);
        }).orElseGet(() -> {
            newProduct.setId(id);
            return repository.save(newProduct);
        });
    }

    @DeleteMapping("/items/{id}")
    void deleteProduct(@PathVariable Long id) {
        repository.deleteById(id);
    }
}