package com.example.springbootsample.elasticsearch.service.impl;

import com.example.springbootsample.elasticsearch.repositories.ProductRepository;
import com.example.springbootsample.elasticsearch.responses.ProductDto;
import com.example.springbootsample.elasticsearch.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    @Operation(summary = "create product elastic search")
    public void createProduct(ProductDto productDto) {
        productRepository.save(productDto);
    }
}
