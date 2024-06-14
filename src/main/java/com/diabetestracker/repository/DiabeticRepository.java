package com.diabetestracker.repository;

import com.diabetestracker.model.Diabetic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiabeticRepository extends JpaRepository<Diabetic, Long> {

}
