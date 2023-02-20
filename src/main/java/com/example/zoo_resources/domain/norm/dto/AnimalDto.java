package com.example.zoo_resources.domain.norm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AnimalDto {

    private String animalName;
    private List<ProductDto> products = new ArrayList<>();

}
