package com.diabetestracker.repository;

import com.diabetestracker.model.Program;
import com.diabetestracker.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    @Query("SELECT r FROM Recipe  r WHERE r.diabetic.id = :diabeticId")
    List<Program> getAllRecipesById(Long diabeticId);
}
