package com.example.zoo_resources.domain.norm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto {

    private String name;
    private String type;
    private Double sizeForSevenDays;
    private Double totalSize;
    private Double sizeToLack;
    private String unit;


    public ProductDto(String name, Double sizeForSevenDays, Double totalSize, Double sizeToLack, String unit) {
        this.name = name;
        this.sizeForSevenDays = sizeForSevenDays;
        this.totalSize = totalSize;
        this.sizeToLack = sizeToLack;
        this.unit = unit;
    }

    public ProductDto(String name, String type, Double sizeForSevenDays, String unit) {
        this.name = name;
        this.type = type;
        this.sizeForSevenDays = sizeForSevenDays;
        this.unit = unit;
    }
}
