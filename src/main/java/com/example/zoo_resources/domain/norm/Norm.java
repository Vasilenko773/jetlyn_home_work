package com.example.zoo_resources.domain.norm;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "consumption_norm")
@Getter
@Setter
public class Norm {

    @Id
    @GeneratedValue(generator = "uuidData")
    @GenericGenerator(name = "uuidData", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    @Column(name = "animal_id")
    private UUID animalId;
    @Column(name = "product_id")
    private UUID productId;
    private double size;
}