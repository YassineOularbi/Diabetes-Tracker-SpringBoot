package com.diabetestracker.model;

import com.diabetestracker.enums.IngredientType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double amount;
    private String picture;
    @Enumerated(EnumType.STRING)
    private IngredientType type;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Recipe> recipes;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "nutrient_id")
    private Nutrient nutrient;
}
