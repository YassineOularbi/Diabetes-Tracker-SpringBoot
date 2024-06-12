package com.diabetestracker.controller;

import com.diabetestracker.model.Glycemie;
import com.diabetestracker.model.Conseil;
import com.diabetestracker.enums.Level;
import com.diabetestracker.service.GlycemieService;
import com.diabetestracker.service.ConseilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Controller
@RequestMapping("/glycemie")
public class GlycemiaController {

    @Autowired
    private GlycemieService glycemieService;

    @Autowired
    private ConseilService conseilService;

    @GetMapping
    public String listGlycemies(ModelMap modelMap) {
        modelMap.addAttribute("listGlycemies", glycemieService.getAllGlycemies());
        return "registrations";
    }

    @GetMapping("/new")
    public String showNewGlycemieForm(Model model) {
        model.addAttribute("glycemie", new Glycemie());
        return "addGlycemie";
    }

    @PostMapping("/new")
    public String saveGlycemie(@RequestParam("value") double value,
                               @RequestParam("date") String date,
                               @RequestParam("unit") String unit,
                               Model model) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        Level level = Level.fromValue(value);
        Glycemie glycemie = new Glycemie(value, dateTime, level, unit);

        glycemieService.saveGlycemie(glycemie);
        Optional<Conseil> conseil = conseilService.getConseilByLevel(level);
        if (conseil.isPresent()) {
            model.addAttribute("conseil", conseil.get());
        } else {
            model.addAttribute("conseil", new Conseil(level, level.getDefaultConseil()));
        }
        return "viewConseil";
    }

    @GetMapping("/delete/{id}")
    public String deleteGlycemie(@PathVariable Long id) {
        glycemieService.deleteGlycemieById(id);
        return "redirect:/glycemie";
    }
}
