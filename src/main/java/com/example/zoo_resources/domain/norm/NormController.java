package com.example.zoo_resources.domain.norm;

import com.example.zoo_resources.domain.norm.dto.AnimalDto;
import com.example.zoo_resources.domain.norm.dto.ProductDto;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class NormController {
    private final NormService normService;

    @GetMapping("/food-seven-days")
    @ApiOperation("Получение перечня продуктов за неделю")
    public List<ProductDto> productsBySevenDays() {
        return normService.productsBySevenDays();
    }

    @GetMapping("/animal-and-products")
    @ApiOperation("Получение списка животных с продуктами")
    public List<AnimalDto> animalsByProducts(@RequestParam(required = false) String typeAnimal,
                                             @RequestParam(required = false) String typeProducts,
                                             @RequestParam(required = false) Boolean isPredator) {

        return normService.animalAndProducts(typeAnimal, typeProducts, isPredator);
    }

    @PutMapping("/norm")
    @ApiOperation("Изменение нормы продукты для животного ")
    public void updateNorm(@RequestParam UUID animalId, @RequestParam UUID productId, @RequestParam Double newSize) {
        normService.updateNormProductByAnimal(animalId, productId, newSize);
    }
}
