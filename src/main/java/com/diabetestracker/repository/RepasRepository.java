package com.diabetestracker.repository;

import com.diabetestracker.model.Repas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepasRepository extends JpaRepository<Repas, Long> {
}
