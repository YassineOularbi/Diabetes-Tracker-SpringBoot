package com.diabetestracker.controller;

import com.diabetestracker.model.Diabetic;
import com.diabetestracker.model.Repas;
import com.diabetestracker.service.DiabeticService;
import com.diabetestracker.service.RepasService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/repas")
public class RepasController {
    @Autowired
    private RepasService repasService;

    @Autowired
    private DiabeticService diabeticService;

    @GetMapping
    public String listRepas(ModelMap modelMap) throws JsonProcessingException {
        List<Repas> repasList = repasService.getAllRepas();
        modelMap.addAttribute("listRepas", repasList);
        String repasDataJson = new ObjectMapper().writeValueAsString(repasList);
        modelMap.addAttribute("repasData", repasDataJson);
        return "registrations";
    }

    @GetMapping("/new/{diabeticId}")
    public String showNewRepasForm(@PathVariable Long diabeticId, Model model) {
        Repas repas = new Repas();
        Diabetic diabetic = diabeticService.getDiabeticById(diabeticId);
        repas.setDiabetic(diabetic);
        model.addAttribute("repas", repas);
        return "addRepas";
    }

    @PostMapping("/new")
    public String saveRepas(@RequestParam("description") String description,
                            @RequestParam("carbohydrates") double carbohydrates,
                            @RequestParam("date") String date,
                            @RequestParam("diabeticId") Long diabeticId,
                            Model model) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        Repas repas = new Repas();
        repas.setDescription(description);
        repas.setCarbohydrates(carbohydrates);
        repas.setDate(dateTime);
        Diabetic diabetic = diabeticService.getDiabeticById(diabeticId);
        repas.setDiabetic(diabetic);
        repasService.saveRepas(repas);
        return "redirect:/repas";
    }

    @GetMapping("/delete/{id}")
    public String deleteRepas(@PathVariable Long id) {
        repasService.deleteRepasById(id);
        return "redirect:/repas";
    }
}
