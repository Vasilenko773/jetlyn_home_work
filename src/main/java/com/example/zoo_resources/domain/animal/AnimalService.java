package com.example.zoo_resources.domain.animal;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface AnimalService {

    List<Animal> animals();

    Animal animal(UUID id);

    List<Animal> animalsByType(String type);

    List<Animal> findAllByPredatorIs(Boolean isPredator);

    List<Animal> findAllByIsPredatorIsAndType(Boolean isPredator, String type);

    void save(Animal animal);

    void delete(UUID id, Boolean isAll);

}
