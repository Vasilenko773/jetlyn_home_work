package com.example.zoo_resources.domain.norm;

import com.example.zoo_resources.domain.norm.dto.AnimalDto;
import com.example.zoo_resources.domain.norm.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface NormService {

    List<ProductDto> productsBySevenDays();
    List<AnimalDto> animalAndProducts(String typeAnimal, String typeProducts, Boolean isPredator);

    void updateNormProductByAnimal(UUID animalId, UUID productId, Double newSize);

}
