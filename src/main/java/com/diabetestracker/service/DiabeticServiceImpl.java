package com.diabetestracker.service;

import com.diabetestracker.exception.DiabeticNotFoundException;
import com.diabetestracker.model.Diabetic;
import com.diabetestracker.repository.DiabeticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DiabeticServiceImpl implements DiabeticService{

    @Autowired
    private DiabeticRepository diabeticRepository;

    @Override
    @Transactional
    public List<Diabetic> getAll(){
        return diabeticRepository.findAll();
    }

    @Override
    public Diabetic save(Diabetic diabetic) {
        return diabeticRepository.save(diabetic);
    }

    @Override
    public Diabetic getById(Long id) {
        return diabeticRepository.findById(id).orElseThrow(DiabeticNotFoundException::new);
    }

    @Override
    public void delete(Long id) {
        diabeticRepository.findById(id).orElseThrow(DiabeticNotFoundException::new);
        diabeticRepository.deleteById(id);
    }
}
