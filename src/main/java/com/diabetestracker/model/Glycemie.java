package com.diabetestracker.model;

import com.diabetestracker.enums.DiabeticType;
import com.diabetestracker.enums.Level;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

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
    private  Double value ;

    @Enumerated(EnumType.STRING)
    private Level level;
    private String Unit;

    @DateTimeFormat(pattern = "YYYY-MM-DD HH:MM")
    private LocalDateTime date;
}
