package com.diabetestracker.service;

import com.diabetestracker.model.*;
import com.diabetestracker.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private DiabeticRepository diabeticRepository;

    @Autowired
    private GlycemieRepository glycemieRepository;

    @Autowired
    private RepasRepository repasRepository;

    @Autowired
    private ExerciceRepository exerciceRepository;

    public Report generateCustomReport(Long diabeticId) {
        Diabetic diabetic = diabeticRepository.findById(diabeticId).orElse(null);
        List<Glycemie> glycemiaReadings = glycemieRepository.findByDiabetic_Id(diabeticId);
        List<Repas> meals = repasRepository.findByDiabetic_Id(diabeticId);
        List<Exercice> exercises = exerciceRepository.findByDiabetic_Id(diabeticId);

        return Report.builder()
                .diabetic(diabetic)
                .glycemiaReadings(glycemiaReadings)
                .meals(meals)
                .exercises(exercises)
                .build();
    }
}
