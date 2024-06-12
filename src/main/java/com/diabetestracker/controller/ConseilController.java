package com.diabetestracker.controller;

import com.diabetestracker.enums.Level;
import com.diabetestracker.model.Conseil;
import com.diabetestracker.service.ConseilService;
import com.diabetestracker.service.GlycemieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/conseil")
public class ConseilController {

    @Autowired
    private ConseilService conseilService;

    @Autowired

    private GlycemieService glycemieService ;

    @GetMapping
    public String listConseils(Model model) {
        model.addAttribute("listConseils", conseilService.getAllConseils());
        return "conseil_list";
    }

    @GetMapping("/new")
    public String showNewConseilForm(Model model) {
        model.addAttribute("conseil", new Conseil());
        return "conseil_form";
    }

    @PostMapping("/new")
    public String saveConseil(@RequestParam("level") Level level,
                              @RequestParam("message") String message) {
        Conseil conseil = new Conseil(level, message);
        conseilService.saveConseil(conseil);
        return "redirect:/conseil";
    }

    @GetMapping("/delete/{id}")
    public String deleteConseil(@PathVariable Long id) {
        conseilService.deleteConseilById(id);
        return "redirect:/conseil";
    }

    @GetMapping("/{level}")
    public String getConseilByLevel(@PathVariable Level level, Model model) {
        Optional<Conseil> conseil = conseilService.getConseilByLevel(level);
        if (conseil.isEmpty()) {
            conseil = Optional.of(new Conseil(level, level.getDefaultConseil()));
        }
        model.addAttribute("conseil", conseil.get()); // Unwrapping the Optional
        return "conseil_detail";
    }

}
