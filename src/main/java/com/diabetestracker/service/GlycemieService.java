package com.diabetestracker.service;

import com.diabetestracker.exception.DiabeticNotFoundException;
import com.diabetestracker.model.Diabetic;
import com.diabetestracker.repository.DiabeticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GlycemieService {

    @Autowired
    private DiabeticRepository GlycemieRepository;

    public List<Diabetic> getAll(){
        return GlycemieRepository.findAll();
    }

    public Diabetic save(Diabetic diabetic) {
        return GlycemieRepository.save(diabetic);
    }

    public Diabetic getById(Long id) {
        return GlycemieRepository.findById(id).orElseThrow(DiabeticNotFoundException::new);
    }

    public void delete(Long id) {
        GlycemieRepository.findById(id).orElseThrow(DiabeticNotFoundException::new);
        GlycemieRepository.deleteById(id);
    }
}