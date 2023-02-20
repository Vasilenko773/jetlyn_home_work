package com.example.zoo_resources.domain.animal;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
@Primary
public class AnimalServiceImpl implements AnimalService {
    private final AnimalRepository animalRepository;

    @Override
    public List<Animal> animals() {
        return animalRepository.findAll();
    }

    @Override
    public Animal animal(UUID id) {
        return animalRepository.findAnimalById(id);
    }

    @Override
    public List<Animal> animalsByType(String type) {
        return animalRepository.findAllByType(type);
    }

    @Override
    public List<Animal> findAllByPredatorIs(Boolean isPredator) {
        return animalRepository.findAllByPredator(isPredator);
    }

    @Override
    public List<Animal> findAllByIsPredatorIsAndType(Boolean isPredator, String type) {
        return animalRepository.findAllByPredatorIsAndType(isPredator, type);
    }

    @Override
    public void save(Animal animal) {
        animalRepository.save(animal);
    }

    @Override
    public void delete(UUID id, Boolean isAll) {
        if (isAll != null && isAll) {
            animalRepository.deleteAll();
        } else {
            animalRepository.deleteById(id);
        }
    }
}
