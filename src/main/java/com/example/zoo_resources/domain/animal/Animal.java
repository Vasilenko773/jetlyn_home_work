package com.example.zoo_resources.domain.animal;

//import jakarta.persistence.*;
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
@Table(name = "animals")
@Getter
@Setter
public class Animal {

    @Id
    @GeneratedValue(generator = "uuidData")
    @GenericGenerator(name = "uuidData", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private String name;
    private String type;
    @Column(name = "is_predator")
    private boolean isPredator;

}
