package com.example.springproject.restservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/api/products")
public interface IProductController {

    @PostMapping
    ResponseEntity<Boolean> add(@RequestBody Product product);

    @GetMapping
    public ResponseEntity<List<Product>> list();

}
