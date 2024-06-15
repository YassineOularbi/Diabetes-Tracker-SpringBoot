package com.diabetestracker.controller;

import com.diabetestracker.model.Exercice;
import com.diabetestracker.service.ExerciceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/exercices")
public class ExerciceController {

    @Autowired
    private ExerciceService exerciceService;

    @GetMapping
    public List<Exercice> getAllExercices() {
        return exerciceService.getAllExercices();
    }
}
