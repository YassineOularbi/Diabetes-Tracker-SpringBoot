package com.diabetestracker.service;

//import com.diabetestracker.dto.ProgramDTO;
import com.diabetestracker.model.Program;
import com.diabetestracker.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramService {

    @Autowired
    private ProgramRepository programRepository;

    public List<Program> getAllPrograms(Long id) {
        return programRepository.getAllProgramsById(id);
    }

    public Program getProgramById(Long id) {
        return programRepository.findById(id).orElse(null);
    }

    public Program saveProgram(Program program) {
        return programRepository.save(program);
    }

    public void deleteProgram(Long id) {
        programRepository.deleteById(id);
    }
}
