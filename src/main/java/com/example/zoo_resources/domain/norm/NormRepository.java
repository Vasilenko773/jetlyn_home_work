package com.example.zoo_resources.domain.norm;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NormRepository extends CrudRepository<Norm, UUID> {

    List<Norm> findAll();

    @Modifying
    @Query(value = "update Norm set size =?3  where animalId = ?1 and productId = ?2")
    void updateSizeByAnimalIdAndProductId(UUID animalId, UUID productId, Double newSize);
}
