package com.diabetestracker.model;

import com.diabetestracker.enums.DiabeticType;
import com.fasterxml.jackson.databind.deser.UnresolvedId;
import lombok.*;

import jakarta.persistence.*;

import java.util.List;

@Getter
@Setter
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

    public UnresolvedId getDiabetic() {
        return null;
    }
}
