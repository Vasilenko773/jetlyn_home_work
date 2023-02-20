package com.example.zoo_resources.domain.animal;

import liquibase.pro.packaged.A;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, UUID> {

    List<Animal> findAll();

    Animal findAnimalById(UUID id);

    List<Animal> findAllByType(String type);

    @Query(value = "select * from animals  where is_predator = ?1", nativeQuery = true)
    List<Animal> findAllByPredator(Boolean isPredator);

    @Query(value = "select * from animals where is_predator = ?1 and type = ?2", nativeQuery = true)
    List<Animal> findAllByPredatorIsAndType(Boolean isPredator, String type);

    void deleteAll();
    void deleteById(UUID id);

}
