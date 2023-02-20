package com.example.zoo_resources.domain.norm;

import com.example.zoo_resources.domain.animal.Animal;
import com.example.zoo_resources.domain.animal.AnimalService;
import com.example.zoo_resources.domain.norm.dto.AnimalDto;
import com.example.zoo_resources.domain.norm.dto.ProductDto;
import com.example.zoo_resources.domain.product.Product;
import com.example.zoo_resources.domain.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;


@Component
@Primary
@RequiredArgsConstructor
public class NormServiceImpl implements NormService {

    private final NormRepository normRepository;
    private final AnimalService animalService;
    private final ProductService productService;

    @Override
    public List<ProductDto> productsBySevenDays() {
        Map<String, ProductDto> productDtoMap = new HashMap<>();
        List<Norm> norms = normRepository.findAll();
        Set<UUID> animals = norms.stream().map(Norm::getAnimalId).collect(Collectors.toSet());
        for (UUID animalId : animals) {
            List<ProductDto> products = productsByAnimalForDay(norms, animalId, 7);
            for (ProductDto product : products) {
                if (!productDtoMap.containsKey(product.getName())) {
                    productDtoMap.put(product.getName(), product);
                } else {
                    ProductDto productDto = productDtoMap.get(product.getName());

                    productDtoMap.put(product.getName(), new ProductDto(product.getName(), productDto.getSizeForSevenDays() + product.getSizeForSevenDays(),
                            productDto.getTotalSize(), productDto.getTotalSize() - (productDto.getSizeForSevenDays() + product.getSizeForSevenDays()) > 0 ? null :
                            Math.abs(productDto.getSizeForSevenDays() + product.getSizeForSevenDays()), productDto.getUnit()));
                }
            }
        }
        return new ArrayList<>(productDtoMap.values());
    }

    private List<ProductDto> productsByAnimalForDay(List<Norm> norms, UUID animalId, int day) {
        return norms.stream()
                .filter(i -> i.getAnimalId().equals(animalId))
                .map(i -> {
                    Product product = productService.product(i.getProductId());
                    return new ProductDto(product.getName(), i.getSize() * day, product.getCount(),
                            (product.getCount() - (i.getSize() * day)) > 0 ? null : Math.abs(product.getCount() - (i.getSize() * 7)),
                            product.getUnit());
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<AnimalDto> animalAndProducts(String typeAnimal, String typeProducts, Boolean isPredator) {
        List<AnimalDto> resultList = new ArrayList<>();
        List<Norm> norms = normRepository.findAll();
        Set<UUID> allAnimals = norms.stream().map(Norm::getAnimalId).collect(Collectors.toSet());

        if (typeAnimal == null && typeProducts == null && isPredator == null) {
            resultList = animalsAndProducts(new ArrayList<>(allAnimals), null);

        } else if (typeAnimal != null && typeProducts == null && isPredator == null) {
            List<UUID> animals = animalService.animalsByType(typeAnimal).stream().map(Animal::getId).collect(Collectors.toList());
            resultList = animalsAndProducts(animals, null);

        } else if (isPredator != null && typeAnimal == null && typeProducts == null) {
            List<UUID> animals = animalService.findAllByPredatorIs(isPredator).stream().map(Animal::getId).collect(Collectors.toList());
            resultList = animalsAndProducts(animals, null);

        } else if (typeAnimal != null && isPredator != null && typeProducts == null) {
            List<UUID> animals = animalService.findAllByIsPredatorIsAndType(isPredator, typeAnimal).stream().map(Animal::getId).collect(Collectors.toList());
            resultList = animalsAndProducts(animals, null);

        } else if (typeAnimal != null && isPredator != null) {
            List<UUID> animals = animalService.findAllByIsPredatorIsAndType(isPredator, typeAnimal).stream().map(Animal::getId).collect(Collectors.toList());
            resultList = animalsAndProducts(animals, typeProducts);
        } else {
            resultList = animalsAndProducts(new ArrayList<>(allAnimals), typeProducts);
        }
        return resultList;
    }

    @Override
    @Transactional
    public void updateNormProductByAnimal(UUID animalId, UUID productId, Double newSize) {
        normRepository.updateSizeByAnimalIdAndProductId(animalId, productId, newSize);
    }

    private List<AnimalDto> animalsAndProducts(List<UUID> animals, String typeProducts) {
        List<AnimalDto> resultNorm = new ArrayList<>();
        List<Norm> norms = normRepository.findAll();
        for (UUID animalId : animals) {
            Animal animal = animalService.animal(animalId);
            List<ProductDto> products = typeProducts == null ? productsByAnimalForDay(norms, animalId, 1) :
                    productsByTypeByAnimalForDay(norms, animalId, 1, typeProducts);
            if (!products.isEmpty()) {
                resultNorm.add(new AnimalDto(animal.getName(), products));
            }
        }
        return resultNorm;
    }

    private List<ProductDto> productsByTypeByAnimalForDay(List<Norm> norms, UUID animalId, int day, String type) {
        return norms.stream()
                .filter(i -> i.getAnimalId().equals(animalId))
                .map(i -> {
                    Product product = productService.product(i.getProductId());
                    return new ProductDto(product.getName(), product.getType(), i.getSize() * day, product.getUnit());
                })
                .filter(i -> i.getType().equals(type))
                .collect(Collectors.toList());
    }
}