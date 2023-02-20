package com.example.zoo_resources.domain.product;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    @ApiOperation("Получение списка продуктов")
    public List<Product> products() {
        return productService.products();
    }

    @GetMapping("/product")
    @ApiOperation("Получение продукта по uuid")
    public Product product(UUID id) {
        return productService.product(id);
    }
}
