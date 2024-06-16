package com.diabetestracker.service;

import com.diabetestracker.model.Diabetic;
import com.diabetestracker.model.Exercice;
import com.diabetestracker.model.Glycemie;
import com.diabetestracker.model.Repas;
import com.diabetestracker.model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private DiabeticService diabeticService;

    @Autowired
    private GlycemieService glycemieService;

    @Autowired
    private RepasService repasService;

    @Autowired
    private ExerciceService exerciceService;
    @Autowired
    private ConseilService conseilService;

    public Report generateCustomReport(Long diabeticId) {
        Report report = new Report();
        Diabetic diabetic = diabeticService.getById(diabeticId);
        report.setDiabetic(diabetic);
        return report;
    }
}
