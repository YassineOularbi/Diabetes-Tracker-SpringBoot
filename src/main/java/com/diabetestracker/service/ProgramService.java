package com.diabetestracker.service;

//import com.diabetestracker.dto.ProgramDTO;
import com.diabetestracker.dto.ProgramDTO;
import com.diabetestracker.model.Program;
import com.diabetestracker.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProgramService {

    @Autowired
    private ProgramRepository programRepository;

    public List<Program> getAllPrograms(Long id) {
        return programRepository.getAllProgramsById(id);
    }

    public Optional<Program> getProgramById(Long id) {
        return programRepository.findById(id);
    }

    public Program saveProgram(Program program) {
        return programRepository.save(program);
    }

    public void deleteProgram(Long id) {
        programRepository.deleteById(id);
    }

    public List<ProgramDTO> getAllProgramsByDId(Long id) {
        return programRepository.getAllProgramsById(id).stream().map(program -> {
            ProgramDTO dto = new ProgramDTO();
            dto.setProgramId(program.getId());
            dto.setExerciceName(program.getExercice().getName());
            dto.setSugarEffect(program.getExercice().getSugarEffect());
            dto.setLevelMax(program.getExercice().getLevelMax());
            dto.setLevelMin(program.getExercice().getLevelMin());
            dto.setNote(program.getExercice().getNote());
            dto.setPicture(program.getExercice().getPicture());
            dto.setUserId(program.getDiabetic().getId());
            dto.setDuration(program.getDuration());
            dto.setBloodSugarBefore(program.getBloodSugarBefore());
            dto.setBloodSugarBefore(program.getBloodSugarAfter());
            dto.setGlycemieValue(program.getGlycemie().getValue());
            dto.setGlycemieDate(program.getGlycemie().getDate());
            dto.setGlycemieUnit(program.getGlycemie().getUnit());
            return dto;
        }).collect(Collectors.toList());
    }
}
