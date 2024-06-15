package com.diabetestracker.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"diabetic", "exercice", "glycemie"})
@Entity
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Diabetic diabetic;

    @ManyToOne
    private Exercice exercice;

    @ManyToOne
    private Glycemie glycemie;

    private Time duration;
    private Float bloodSugarBefore;
    private Float bloodSugarAfter;

}
