package com.diabetestracker.service;

import com.diabetestracker.exception.DiabeticNotFoundException;
import com.diabetestracker.model.Diabetic;
import com.diabetestracker.model.Glycemie;
import com.diabetestracker.repository.DiabeticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DiabeticService {

    @Autowired
    private DiabeticRepository diabeticRepository;

    public List<Diabetic> getAll() {
        return diabeticRepository.findAll();
    }

    public Diabetic save(Diabetic diabetic) {
        return diabeticRepository.save(diabetic);
    }

    public Diabetic getById(Long id) {
        return diabeticRepository.findById(id).orElseThrow(DiabeticNotFoundException::new);
    }

    public void delete(Long id) {
        diabeticRepository.findById(id).orElseThrow(DiabeticNotFoundException::new);
        diabeticRepository.deleteById(id);
    }

    public Diabetic getDiabeticById(Long id) {
        return diabeticRepository.findById(id).orElse(null);
    }

    public List<Glycemie> getAllGlycemiesByDiabeticId(Long diabeticId) {
        Diabetic diabetic = diabeticRepository.findById(diabeticId).orElse(null);
        if (diabetic != null) {
            return diabetic.getAllGlycemies();
        } else {
            return new ArrayList<>();
        }


    }
}