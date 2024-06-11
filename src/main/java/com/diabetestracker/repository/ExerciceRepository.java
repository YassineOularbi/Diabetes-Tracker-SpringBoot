package com.diabetestracker.repository;

import com.diabetestracker.model.Diabetic;
import com.diabetestracker.model.Exercice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciceRepository extends JpaRepository<Exercice, Long> {
}
