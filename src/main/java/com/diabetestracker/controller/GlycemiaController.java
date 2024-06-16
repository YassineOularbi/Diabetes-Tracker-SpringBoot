package com.diabetestracker.controller;

import com.diabetestracker.enums.Level;
import com.diabetestracker.model.Conseil;
import com.diabetestracker.model.Diabetic;
import com.diabetestracker.model.Glycemie;
import com.diabetestracker.service.ConseilService;
import com.diabetestracker.service.DiabeticService;
import com.diabetestracker.service.GlycemieService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/glycemie")
public class GlycemiaController {

    @Autowired
    private GlycemieService glycemieService;

    @Autowired
    private DiabeticService diabeticService;

    @Autowired
    private ConseilService conseilService;

    @GetMapping
    public String listGlycemies(ModelMap modelMap) throws JsonProcessingException {
        List<Glycemie> glycemies = glycemieService.getAllGlycemies();
        modelMap.addAttribute("listGlycemies", glycemies);

        // Convert Glycemie data to JSON for Chart.js
        String glycemiaDataJson = new ObjectMapper().writeValueAsString(glycemies);
        modelMap.addAttribute("glycemiaData", glycemiaDataJson);

        return "registrations";
    }

    @GetMapping("/new/{diabeticId}")
    public String showNewGlycemieForm(@PathVariable Long diabeticId, Model model) {
        Glycemie glycemie = new Glycemie();
        Diabetic diabetic = diabeticService.getById(diabeticId);
        glycemie.setDiabetic(diabetic); // Set diabetic
        model.addAttribute("glycemie", glycemie);
        return "addGlycemie";
    }

    @PostMapping("/new")
    public String saveGlycemie(@RequestParam("value") double value,
                               @RequestParam("date") String date,
                               @RequestParam("unit") String unit,
                               @RequestParam("diabeticId") Long diabeticId,
                               Model model) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        Level level = Level.fromValue(value);
        Glycemie glycemie = new Glycemie(value, dateTime, level, unit);
        Diabetic diabetic = diabeticService.getById(diabeticId);
        glycemie.setDiabetic(diabetic);

        glycemieService.saveGlycemie(glycemie);
        Optional<Conseil> conseil = conseilService.getConseilByLevel(level);
        model.addAttribute("conseil", conseil.orElse(new Conseil(level, level.getDefaultConseil())));
        return "viewConseil";
    }

    @GetMapping("/delete/{id}")
    public String deleteGlycemie(@PathVariable Long id) {
        Diabetic glycemie = glycemieService.deleteGlycemieById(id);
        return "redirect:/glycemie/glycemie/" + glycemie.getDiabetic().getId();
    }

    @GetMapping("/glycemie/{id}")
    public String viewGlycemies(@PathVariable Long id, Model model) {
        Diabetic diabetic = diabeticService.getDiabeticById(id);
        if (diabetic != null) {
            List<Glycemie> glycemies = diabetic.getAllGlycemies();
            model.addAttribute("listGlycemies", glycemies);
            return "registrations";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/conseil/{level}")
    public String getConseilByLevel(@PathVariable Level level, Model model) {
        Optional<Conseil> conseil = conseilService.getConseilByLevel(level);
        model.addAttribute("conseil", conseil.orElse(new Conseil(level, level.getDefaultConseil())));
        return "viewConseil";
    }

    @GetMapping("/chart")
    public String chart(Model model) {
        List<Glycemie> readings = glycemieService.getAllGlycemies();
        List<String> labels = new ArrayList<>();
        List<Integer> data = new ArrayList<>();

        for (Glycemie reading : readings) {
            labels.add(reading.getDate().toString());
            data.add(reading.getLevel().ordinal()); // Assuming Level enum has an ordinal value
        }

        model.addAttribute("labels", labels);
        model.addAttribute("data", data);
        return "chart";
    }

    @GetMapping("/chartDisplay")
    public String getGlucoseReadings(
            @RequestParam(value = "view", required = false, defaultValue = "week") String view,
            @RequestParam(value = "year", required = false) Integer year,
            @RequestParam(value = "month", required = false) Integer month,
            @RequestParam(value = "week", required = false) Integer week,
            Model model) {

        List<Glycemie> readings;

        switch (view) {
            case "month":
                readings = glycemieService.getAllGroupedByMonth();
                break;
            case "year":
                readings = glycemieService.getAllGroupedByYear();
                break;
            case "specificMonth":
                readings = glycemieService.getByYearAndMonth(year, month);
                break;
            case "specificWeek":
                readings = glycemieService.getByYearAndWeek(year, week);
                break;
            default:
                readings = glycemieService.getAllGroupedByWeek();
        }

        List<String> labels = new ArrayList<>();
        List<Integer> data = new ArrayList<>();

        for (Glycemie reading : readings) {
            labels.add(reading.getDate().toString());
            data.add(reading.getLevel().ordinal()); // Assuming Level enum has an ordinal value
        }

        model.addAttribute("labels", labels);
        model.addAttribute("data", data);
        return "index";
    }
}
