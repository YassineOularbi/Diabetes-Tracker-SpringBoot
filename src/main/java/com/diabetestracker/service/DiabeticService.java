package com.diabetestracker.service;

import com.diabetestracker.model.Diabetic;

import java.util.List;

public interface DiabeticService {
    List<Diabetic> getAll();
    Diabetic save(Diabetic diabetic);
    Diabetic getById(Long id);
    void delete(Long id);
}
