package com.example.springbootsample.elasticsearch.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "product")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ProductDto {

    @Id
    private String id;
    private String name;
    private String description;
    private long price;
}
