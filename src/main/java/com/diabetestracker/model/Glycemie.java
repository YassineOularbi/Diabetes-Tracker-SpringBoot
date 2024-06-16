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
public class Glycemie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double value;

    @Enumerated(EnumType.STRING)
    @Column(name = "level", nullable = false, length = 225)
    private Level level;

    private String unit;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime date;

    @ManyToOne
    private Diabetic diabetic;

    @OneToMany(mappedBy = "glycemie")
    @ToString.Exclude
    private List<Program> program;

    public Glycemie(Double value, LocalDateTime date, Level level, String unit) {
        this.value = value;
        this.date = date;
        this.level = level;
        this.unit = unit;
    }

    public Object getDateAndTime() {
        return null;
    }
}
