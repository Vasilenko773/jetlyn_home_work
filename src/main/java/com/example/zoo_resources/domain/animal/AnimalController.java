package com.example.zoo_resources.domain.animal;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AnimalController {
    private final AnimalService animalService;

    @GetMapping("/animals")
    @ApiOperation("Получение списка животных")
    public List<Animal> animals() {
        log.info("AnimalController.animals started");
        List<Animal> animals = animalService.animals();
        log.info("AnimalController.animals completed: size = {}", animals.size());
        return animals;
    }

    @GetMapping("/animal")
    @ApiOperation("Получение животного по uuid")
    public Animal animals(@RequestParam UUID id) {
        return animalService.animal(id);
    }


    @PostMapping("/animal")
    @ApiOperation("Сохранение животного")
    public void save(@RequestBody Animal animal) {
        animalService.save(animal);
    }

    @DeleteMapping("/animal")
    @ApiOperation("Удаление животного по id или всех")
    public void delete(@RequestBody(required = false) UUID id, @RequestParam(required = false) Boolean isAll) {
        animalService.delete(id, isAll);
    }
}
