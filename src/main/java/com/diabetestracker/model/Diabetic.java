package com.diabetestracker.model;
import com.diabetestracker.enums.DiabeticType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Diabetic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private DiabeticType type;
    private Integer age;
    private float weight;
    private float height;
    private String picture;

    @OneToMany(mappedBy = "diabetic")
    @ToString.Exclude
    private List<Program> program;

    @OneToMany(mappedBy = "diabetic", cascade = CascadeType.REMOVE)
    private List<Glycemie> glycemies;
    public List<Glycemie> getAllGlycemies() {

        return this.glycemies;
    }

}



