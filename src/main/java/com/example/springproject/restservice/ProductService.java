package com.example.springproject.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public ResponseEntity<List<Product>> listAll() {
        return ResponseEntity.ok(repo.findAll());
    }

    public ResponseEntity<Boolean> save(Product product) {
        repo.save(product);
        return ResponseEntity.ok(true);
    }

    public ResponseEntity<Product> get(Integer id) {
        return ResponseEntity.ok(repo.findById(id).get());
    }

    public ResponseEntity<Boolean> delete(Integer id) {
        repo.deleteById(id);
        return ResponseEntity.ok(true);
    }
}