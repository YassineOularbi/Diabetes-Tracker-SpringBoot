package com.diabetestracker.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@ToString
@Entity
public class Exercice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long sugarEffect;
    private Long levelMax;
    private Long levelMin;
    private String note;
    private String picture;
    @ManyToOne
    private Report report;
    @ManyToOne
    @JoinColumn(name = "diabetic_id")
    private Diabetic diabetic;
}
