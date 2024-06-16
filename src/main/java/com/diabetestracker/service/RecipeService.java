package com.diabetestracker.service;

import com.diabetestracker.model.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.diabetestracker.exception.RecipeNotFoundException;
import com.diabetestracker.model.Recipe;
import com.diabetestracker.repository.RecipeRepository;

import java.util.List;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public List<Program> getAllRecipes(Long id) {
        return recipeRepository.getAllRecipesById(id);
    }

    @Transactional
    public List<Recipe> getAll(){
        return recipeRepository.findAll();
    }

    @Transactional
    public Recipe save(Recipe recipe){
        return recipeRepository.save(recipe);
    }

    @Transactional
    public Recipe getById(Long id){
        return recipeRepository.findById(id).orElseThrow(RecipeNotFoundException::new);
    }

    @Transactional
    public void delete(Long id){
        recipeRepository.findById(id).orElseThrow(RecipeNotFoundException::new);
        recipeRepository.deleteById(id);
    }
}
