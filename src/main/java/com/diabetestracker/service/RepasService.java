package com.diabetestracker.service;

import com.diabetestracker.model.Repas;
import com.diabetestracker.repository.RepasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RepasService {
    @Autowired
    private RepasRepository repasRepository;

    public List<Repas> getAllRepas() {
        return repasRepository.findAll();
    }

    public Repas saveRepas(Repas repas) {
        return repasRepository.save(repas);
    }

    public List<Repas> getRepasByDiabeticId(Long diabeticId) {
        return repasRepository.findAll().stream()
                .filter(r -> r.getDiabetic().getId().equals(diabeticId))
                .collect(Collectors.toList());
    }

    public List<Repas> getRepasByGlycemieId(Long glycemieId) {
        return repasRepository.findAll().stream()
                .filter(r -> r.getGlycemie().getId().equals(glycemieId))
                .collect(Collectors.toList());
    }

    public void deleteRepasById(Long id) {
        repasRepository.deleteById(id);
    }
}
