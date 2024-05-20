package com.example.springbootsample.elasticsearch.service;

import com.example.springbootsample.elasticsearch.responses.ProductDto;

public interface ProductService {

    void createProduct(ProductDto productDto);
}
