package com.diabetestracker.model;

import com.diabetestracker.enums.Level;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Glycemie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double value;

    @Enumerated(EnumType.STRING)
    @Column(name = "level", nullable = false, length = 25)
    private Level level;

    private String unit;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime date;

    @ManyToOne
    private Diabetic diabetic;

    public Glycemie(Double value, LocalDateTime date, Level level, String unit) {
        this.value = value;
        this.date = date;
        this.level = level;
        this.unit = unit;
    }
}