package com.diabetestracker.controller;

import com.diabetestracker.service.GlycemieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GlycemiaController {
    @Autowired
    private GlycemieService service;

    @GetMapping("/glycemia")
    public String getGlycemiaForm(Model model) {
        model.addAttribute("reading", new GlycemieReading());
        return "glycemiaForm";
    }

    @PostMapping("/glycemia")
    public String submitGlycemiaForm(@ModelAttribute GlycemiaReading reading) {
        service.save(reading);
        return "redirect:/glycemia";
    }

    @GetMapping("/glycemia/readings")
    public String getReadings(Model model) {
        LocalDateTime start = LocalDateTime.now().minusDays(7); // example for last week
        LocalDateTime end = LocalDateTime.now();
        model.addAttribute("readings", service.getReadings(start, end));
        return "glycemiaReadings";
    }
}
