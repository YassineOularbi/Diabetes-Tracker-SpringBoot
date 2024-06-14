package com.diabetestracker.repository;

import com.diabetestracker.model.Program;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgramRepository extends JpaRepository<Program, Long> {
    List<Program> getAllProgramsById(Long id);
}
