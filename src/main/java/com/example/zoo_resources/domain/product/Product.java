package com.example.zoo_resources.domain.product;

//import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(generator = "uuidData")
    @GenericGenerator(name = "uuidData", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private String name;
    private Double count;
    private String unit;
    private String type;
}