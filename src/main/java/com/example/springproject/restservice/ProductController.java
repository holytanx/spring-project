package com.example.springproject.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController implements IProductController {

    @Autowired
    private ProductService service;

    @Override
    public ResponseEntity<Boolean> add(Product product) {
        return service.save(product);
    }

    @Override
    public ResponseEntity<List<Product>> list() {
        return service.listAll();
    }

//    @GetMapping("/products/{id}")
//    public ResponseEntity<Product> get(@PathVariable Integer id) {
//        try {
//            Product product = service.get(id);
//            return new ResponseEntity<Product>(product, HttpStatus.OK);
//        } catch (NoSuchElementException e) {
//            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
//        }
//    }

//    @PostMapping("/products")
//    public void add(@RequestBody Product product) {
//        service.save(product);
//    }

//    @PutMapping("/products/{id}")
//    public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Integer id) {
//        try {
//            Product existProduct = service.get(id);
//            service.save(product);
//            return new ResponseEntity<>(HttpStatus.OK);
//        } catch (NoSuchElementException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

//    @DeleteMapping("/products/{id}")
//    public void delete(@PathVariable Integer id) {
//        service.delete(id);
//    }

}
