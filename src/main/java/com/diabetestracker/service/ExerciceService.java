package com.diabetestracker.service;

import com.diabetestracker.exception.ExerciceNotFoundException;
import com.diabetestracker.model.Exercice;
import com.diabetestracker.repository.ExerciceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciceService {

    @Autowired
    private ExerciceRepository exerciceRepository;

    public List<Exercice> getAll(){
        return exerciceRepository.findAll();
    }

    public Exercice save(Exercice exercice) {
        return exerciceRepository.save(exercice);
    }

    public Exercice getById(Long id) {
        return exerciceRepository.findById(id).orElseThrow(ExerciceNotFoundException::new);
    }

    public void delete(Long id) {
        exerciceRepository.findById(id).orElseThrow(ExerciceNotFoundException::new);
        exerciceRepository.deleteById(id);
    }
}
