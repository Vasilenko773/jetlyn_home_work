package com.example.zoo_resources.domain.product;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@Primary
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public List<Product> products() {
        return productRepository.findAll();
    }

    @Override
    public Product product(UUID id) {
        return productRepository.findProductById(id);
    }

    @Override
    public List<Product> findAllByType(String type) {
        return productRepository.findAllByType(type);
    }
}
