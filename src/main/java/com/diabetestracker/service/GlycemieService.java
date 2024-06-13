package com.diabetestracker.service;

import com.diabetestracker.model.Glycemie;
import com.diabetestracker.repository.GlycemieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GlycemieService {
    @Autowired
    private GlycemieRepository glycemieRepository;

    public List<Glycemie> getAllGlycemies() {
        return glycemieRepository.findAll();
    }

    public void saveGlycemie(Glycemie glycemie) {
        glycemieRepository.save(glycemie);
    }

    public void deleteGlycemieById(Long id) {
        glycemieRepository.deleteById(id);
    }

    public List<Glycemie> findHourlyGlycemiaData(LocalDateTime startDate, LocalDateTime endDate) {
        return glycemieRepository.findHourlyGlycemiaData(startDate, endDate);
    }

    public List<Glycemie> findAllByDate(LocalDateTime date) {
        return glycemieRepository.findAllByDate(date);
    }

    public List<Glycemie> getGlycemiesByUser(Long userId) {
        // Implémentation pour récupérer les glycémies par utilisateur
        return glycemieRepository.findByUserId(userId);
    }

    public List<Glycemie> getGlycemiesByUserAndDateRange(Long userId, LocalDateTime startDate, LocalDateTime endDate) {
        // Implémentation pour récupérer les glycémies par utilisateur et plage de dates
        return glycemieRepository.findByUserIdAndDateBetween(userId, startDate, endDate);
    }
}
