package com.diabetestracker.model;

import com.fasterxml.jackson.databind.deser.UnresolvedId;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Repas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private double carbohydrates;
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "diabetic_id")
    private Diabetic diabetic;


    public UnresolvedId getDiabetic() {
        return null;
    }

    public void setDiabetic(Diabetic diabetic) {
    }

    public void setDescription(String description) {
    }

    public void setDate(LocalDateTime dateTime) {
    }

    public void setCarbohydrates(double carbohydrates) {
    }
}
