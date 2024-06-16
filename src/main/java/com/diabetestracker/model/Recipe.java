package com.diabetestracker.model;

import com.diabetestracker.enums.Level;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String image;

    private Double totale;

    @ManyToOne
    private Diabetic diabetic;

    @ManyToOne
    private Glycemie glycemie;

    @ManyToMany(mappedBy = "recipes", fetch = FetchType.EAGER)
    private List<Ingredient> ingredients;
}
