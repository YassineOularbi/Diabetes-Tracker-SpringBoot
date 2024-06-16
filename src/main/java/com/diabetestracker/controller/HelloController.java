package com.diabetestracker.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class HelloController {
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String printHelloWorld(ModelMap modelMap){
//        modelMap.addAttribute("message",
//                "Hello World and Welcome to Spring MVC!");

        return "Home"; // Renommez la vue 'Home' si nécessaire.
    }
    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String print(ModelMap modelMap){
//        modelMap.addAttribute("message",
//                "Hello World and Welcome to Spring MVC!");

        return "Contact";
    }
}
