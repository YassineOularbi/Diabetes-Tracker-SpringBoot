package com.diabetestracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.diabetestracker.exception.IngredientNotFoundException;
import com.diabetestracker.model.Ingredient;
import com.diabetestracker.repository.IngredientRepository;

import java.util.List;

@Service
public class IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Transactional
    public List<Ingredient> getAll() {
        return ingredientRepository.findAll();
    }

    @Transactional
    public Ingredient save(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Transactional
    public Ingredient getById(Long id) {
        return ingredientRepository.findById(id).orElseThrow(IngredientNotFoundException::new);
    }

    @Transactional
    public List<Ingredient> getByIds(List<Long> ids) {
        return ingredientRepository.findAllById(ids);
    }

    @Transactional
    public void delete(Long id) {
        ingredientRepository.findById(id).orElseThrow(IngredientNotFoundException::new);
        ingredientRepository.deleteById(id);
    }
}
