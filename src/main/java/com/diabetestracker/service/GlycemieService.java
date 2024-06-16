package com.diabetestracker.service;

import com.diabetestracker.model.Diabetic;
import com.diabetestracker.model.Glycemie;
import com.diabetestracker.repository.DiabeticRepository;
import com.diabetestracker.repository.GlycemieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GlycemieService {

    @Autowired
    private GlycemieRepository glycemieRepository;

    @Autowired
    private DiabeticRepository diabeticRepository;

    public List<Glycemie> getAllGlycemies() {
        return glycemieRepository.findAll();
    }

    public void saveGlycemie(Glycemie glycemie) {
        glycemieRepository.save(glycemie);
    }

    public Diabetic deleteGlycemieById(Long id) {
        var glycemie = glycemieRepository.findById(id);
        var diabetic = diabeticRepository.findById(glycemie.get().getDiabetic().getId());
        glycemieRepository.deleteById(id);
        return diabetic.get();
    }

    public List<Glycemie> findHourlyGlycemiaData(LocalDateTime startDate, LocalDateTime endDate) {
        return glycemieRepository.findHourlyGlycemiaData(startDate, endDate);
    }

    public List<Glycemie> findAllByDate(LocalDateTime date) {
        return glycemieRepository.findAllByDate(date);
    }

    public Glycemie getLatestGlycemie() {
        return glycemieRepository.findTopByOrderByDateDesc();
    }

    public List<Glycemie> getAllGroupedByWeek() {
        return GlycemieRepository.findAllGroupedByWeek();
    }

    public List<Glycemie> getAllGroupedByMonth() {
        return GlycemieRepository.findAllGroupedByMonth();
    }

    public List<Glycemie> getAllGroupedByYear() {
        return GlycemieRepository.findAllGroupedByYear();
    }

    public List<Glycemie> getByYearAndWeek(int year, int week) {
        return GlycemieRepository.findByYearAndWeek(year, week);
    }

    public List<Glycemie> getByYearAndMonth(int year, int month) {
        return GlycemieRepository.findByYearAndMonth(year, month);
    }

    public Glycemie getById(Long glycemieId) {
        return glycemieRepository.findById(glycemieId).orElse(null);
    }
}
