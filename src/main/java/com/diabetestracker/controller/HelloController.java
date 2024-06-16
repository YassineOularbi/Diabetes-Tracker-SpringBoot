package com.diabetestracker.controller;

import com.diabetestracker.enums.Level;
import com.diabetestracker.model.Conseil;
import com.diabetestracker.service.ConseilService;
import com.diabetestracker.service.GlycemieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/home")
public class HelloController {
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String printHelloWorld(ModelMap modelMap){
//        modelMap.addAttribute("message",
//                "Hello World and Welcome to Spring MVC!");

        return "Home"; // Renommez la vue 'Home' si nécessaire.
    }
}
