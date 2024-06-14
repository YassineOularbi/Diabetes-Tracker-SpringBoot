package com.diabetestracker.controller;

import com.diabetestracker.model.Diabetic;
import com.diabetestracker.model.Exercice;
import com.diabetestracker.model.Glycemie;
import com.diabetestracker.model.Program;
import com.diabetestracker.service.DiabeticService;
import com.diabetestracker.service.ExerciceService;
import com.diabetestracker.service.GlycemieService;
import com.diabetestracker.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/programs")
public class ProgramController {

    @Autowired
    private ProgramService programService;

    @Autowired
    private ExerciceService exerciceService;

    @Autowired
    private GlycemieService glycemieService;

    @Autowired
    private DiabeticService diabeticService;

    @GetMapping("/all/{diabeticId}")
    public String getAllPrograms(@PathVariable Long diabeticId,Model model) {
        model.addAttribute("programs", programService.getAllPrograms(diabeticId));
        return "program";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Program> getProgramById(@PathVariable Long id) {
        Optional<Program> program = programService.getProgramById(id);
        return program.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/addnew/{diabeticId}")
    public String addNewProgram(@PathVariable Long diabeticId, Model model) {
        Program program = new Program();

        Diabetic diabetic = diabeticService.getById(diabeticId);
        Glycemie glycemie = glycemieService.getLatestGlycemie();
        List<Exercice> exercices = exerciceService.getAllExercices();

        program.setGlycemie(glycemie);
        program.setDiabetic(diabetic);

        model.addAttribute("exercices", exercices);
        model.addAttribute("program", program);

        return "add-program";
    }



    @PostMapping("/save")
    public String saveProgram(@ModelAttribute("program") Program program) {
        programService.saveProgram(program);
        return "redirect:/programs";
    }

    @PutMapping("/{id}")
    public ResponseEntity<Program> updateProgram(@PathVariable Long id, @RequestBody Program updatedProgram) {
        Optional<Program> program = programService.getProgramById(id);
        if (program.isPresent()) {
            updatedProgram.setId(id);
            return ResponseEntity.ok(programService.saveProgram(updatedProgram));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgram(@PathVariable Long id) {
        if (programService.getProgramById(id).isPresent()) {
            programService.deleteProgram(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
