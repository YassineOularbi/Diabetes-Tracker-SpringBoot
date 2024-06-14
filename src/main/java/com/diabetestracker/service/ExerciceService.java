package com.diabetestracker.service;

import com.diabetestracker.exception.ExerciceNotFoundException;
import com.diabetestracker.model.Exercice;
import com.diabetestracker.repository.ExerciceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciceService {

    @Autowired
    private ExerciceRepository exerciceRepository;

    public List<Exercice> getAllExercices() {
        return exerciceRepository.findAll();
    }

    public Optional<Exercice> getExerciceById(Long id) {
        return exerciceRepository.findById(id);
    }

    public Exercice saveExercice(Exercice exercice) {
        return exerciceRepository.save(exercice);
    }

    public void deleteExercice(Long id) {
        exerciceRepository.findById(id).orElseThrow(ExerciceNotFoundException::new);
        exerciceRepository.deleteById(id);
    }
}
