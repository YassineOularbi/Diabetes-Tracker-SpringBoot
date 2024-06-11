package com.diabetestracker.service;

import com.diabetestracker.exception.DiabeticNotFoundException;
import com.diabetestracker.model.Diabetic;
import com.diabetestracker.repository.DiabeticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiabeticService {

    @Autowired
    private DiabeticRepository diabeticRepository;

    public List<Diabetic> getAll(){
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
}
