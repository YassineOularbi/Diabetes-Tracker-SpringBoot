package com.diabetestracker.controller;

import com.diabetestracker.model.*;
import com.diabetestracker.service.DiabeticService;
import com.diabetestracker.service.GlycemieService;
import com.diabetestracker.service.IngredientService;
import com.diabetestracker.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    public DiabeticService diabeticService;

    @Autowired
    public GlycemieService glycemieService;

    @Autowired
    public IngredientService ingredientService;

    @Autowired
    public RecipeService recipeService;

    @GetMapping("/all/{diabeticId}")
    public String getAllRecipe(@PathVariable Long diabeticId,Model model) {
        model.addAttribute("programs", recipeService.getAllRecipes(diabeticId));
        return "recipes";
    }

    @GetMapping("/add/{diabeticId}")
    public String addNewRecipe(@PathVariable Long diabeticId, Model model) {
        Diabetic diabetic = diabeticService.getById(diabeticId);
        Glycemie glycemie = glycemieService.getLatestGlycemie(diabeticId);
        List<Ingredient> ingredients = ingredientService.getAll();

        model.addAttribute("diabetic", diabetic);
        model.addAttribute("glycemie", glycemie);
        model.addAttribute("ingredients", ingredients);
        model.addAttribute("recipe", new Recipe());

        return "add-recipe";
    }

    @PostMapping("/save")
    public String saveRecipe(@RequestParam("diabeticId") Long diabeticId,
                             @RequestParam("glycemieId") Long glycemieId,
                             @RequestParam("ingredientIds") List<Long> ingredientIds,
                             @RequestParam("name") String name,
                             @RequestParam("description") String description,
                             @RequestParam("image") String image) {

        Recipe recipe = new Recipe();
        Diabetic diabetic = diabeticService.getById(diabeticId);
        Glycemie glycemie = glycemieService.getLatestGlycemie(glycemieId);
        List<Ingredient> ingredients = ingredientService.getByIds(ingredientIds);

        recipe.setDiabetic(diabetic);
        recipe.setGlycemie(glycemie);
        recipe.setIngredients(ingredients);
        recipe.setName(name);
        recipe.setDescription(description);
        recipe.setImage(image);

        double total = ingredients.stream()
                .mapToDouble(ingredient -> ingredient.getNutrient().getGlucose())
                .average()
                .orElse(0.0);

        recipe.setTotale(total);

        recipeService.save(recipe);
        return "redirect:/";
    }
}
