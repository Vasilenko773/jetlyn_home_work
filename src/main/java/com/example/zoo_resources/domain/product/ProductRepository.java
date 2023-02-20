package com.example.zoo_resources.domain.product;

import liquibase.pro.packaged.L;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends CrudRepository<Product, UUID> {

    List<Product> findAll();

    Product findProductById(UUID id);

    List<Product> findAllByType(String type);
}
