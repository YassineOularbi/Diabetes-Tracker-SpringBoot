package com.diabetestracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.diabetestracker.model.Nutrient;

public interface NutrientRepository extends JpaRepository<Nutrient, Long> {
}
