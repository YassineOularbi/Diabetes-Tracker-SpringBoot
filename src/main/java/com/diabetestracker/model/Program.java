package com.diabetestracker.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;

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

    @OneToOne
    private Exercice exercice;

    @ManyToOne
    private Glycemie glycemie;

    private Time duration;
    private Long bloodSugarBefore;
    private Long bloodSugarAfter;

}
