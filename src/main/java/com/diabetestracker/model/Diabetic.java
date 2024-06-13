package com.diabetestracker.model;
import com.diabetestracker.enums.DiabeticType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Diabetic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private DiabeticType type;
    private Integer age;
    private String picture;


//    @OneToMany(mappedBy = "diabetic")
//    private List<Glycemie> glycemies;
    @OneToMany(mappedBy = "diabetic", cascade = CascadeType.REMOVE)
    private List<Glycemie> glycemies;


    public List<Glycemie> getAllGlycemies() {
        return this.glycemies;
    }


}



