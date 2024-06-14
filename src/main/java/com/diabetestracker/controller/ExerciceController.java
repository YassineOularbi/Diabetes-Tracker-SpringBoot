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

    @GetMapping("/{id}")
    public ResponseEntity<Exercice> getExerciceById(@PathVariable Long id) {
        Optional<Exercice> exercice = exerciceService.getExerciceById(id);
        return exercice.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Exercice createExercice(@RequestBody Exercice exercice) {
        return exerciceService.saveExercice(exercice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exercice> updateExercice(@PathVariable Long id, @RequestBody Exercice updatedExercice) {
        Optional<Exercice> exercice = exerciceService.getExerciceById(id);
        if (exercice.isPresent()) {
            updatedExercice.setId(id);
            return ResponseEntity.ok(exerciceService.saveExercice(updatedExercice));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExercice(@PathVariable Long id) {
        if (exerciceService.getExerciceById(id).isPresent()) {
            exerciceService.deleteExercice(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
