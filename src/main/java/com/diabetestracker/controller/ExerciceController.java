package com.diabetestracker.controller;

import com.diabetestracker.model.Diabetic;
import com.diabetestracker.model.Exercice;
import com.diabetestracker.service.DiabeticService;
import com.diabetestracker.service.ExerciceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/exercice")
public class ExerciceController {

    @Autowired
    private ExerciceService exerciceService;

    @GetMapping("/addnew")
    public String addNewEmployee(Model model) {
        model.addAttribute("exercice", new Exercice());
        return "add";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("exercice") Exercice exercice) {
        exerciceService.save(exercice);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("exercice", exerciceService.getById(id));
        return "update";
    }

    @GetMapping("/deleteDiabetic/{id}")
    public String deleteThroughId(@PathVariable(value = "id") Long id) {
        exerciceService.delete(id);
        return "redirect:/";

    }
}
