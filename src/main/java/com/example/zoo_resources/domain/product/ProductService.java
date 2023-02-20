package com.example.zoo_resources.domain.product;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ProductService {

    List<Product> products();

    Product product(UUID id);

    List<Product> findAllByType(String type);
}
