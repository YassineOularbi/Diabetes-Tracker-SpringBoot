package com.diabetestracker.repository;

import com.diabetestracker.model.Glycemie;
import com.diabetestracker.model.Repas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepasRepository extends JpaRepository<Repas, Long> {
    List<Repas> findByDiabetic_Id(Long diabeticId);

}

