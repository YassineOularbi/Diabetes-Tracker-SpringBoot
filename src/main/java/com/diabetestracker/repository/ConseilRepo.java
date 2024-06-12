package com.diabetestracker.repository;

import com.diabetestracker.enums.Level;
import com.diabetestracker.model.Conseil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConseilRepo extends JpaRepository<Conseil, Long> {
    Optional<Conseil> findByLevel(Level level);
}
