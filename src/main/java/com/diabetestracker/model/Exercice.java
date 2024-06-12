package com.diabetestracker.model;

import com.diabetestracker.enums.DiabeticType;
import com.diabetestracker.enums.ExerciceType;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Exercice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ExerciceType type;
    private Time duration;
    private String picture;
}
