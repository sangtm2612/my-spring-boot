package com.example.springbootsample.elasticsearch.repositories;

import com.example.springbootsample.elasticsearch.responses.ProductDto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepository extends ElasticsearchRepository<ProductDto, String> {
}
