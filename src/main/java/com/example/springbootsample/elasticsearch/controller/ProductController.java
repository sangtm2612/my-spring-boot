package com.example.springbootsample.elasticsearch.controller;

import com.example.springbootsample.elasticsearch.responses.ProductDto;
import com.example.springbootsample.elasticsearch.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/es/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody ProductDto request) {
        productService.createProduct(request);
        return ResponseEntity.ok(1);
    }
}
