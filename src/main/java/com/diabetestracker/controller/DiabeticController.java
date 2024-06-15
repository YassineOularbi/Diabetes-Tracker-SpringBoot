package com.diabetestracker.controller;

import com.diabetestracker.model.Diabetic;
import com.diabetestracker.service.DiabeticService;
import com.diabetestracker.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/")
public class DiabeticController {

    @Autowired
    private DiabeticService diabeticService;

    @GetMapping("/")
    public String show(Model model){
        model.addAttribute("diabetics", diabeticService.getAll());
        return "index";
    }

    @GetMapping("/addnew")
    public String addNewEmployee(Model model) {
        model.addAttribute("diabetic", new Diabetic());
        return "add";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute Diabetic diabetic, @RequestParam("picture") MultipartFile file) {
        try {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            String uploadDir = "user-photos/";

            FileUploadUtil.saveFile(uploadDir, fileName, file);

            diabetic.setPicture(uploadDir + fileName);

            diabeticService.save(diabetic);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }

//    @PostMapping("/save")
//    public <MultipartFile> String saveEmployee(@ModelAttribute("diabetic") Diabetic diabetic,
//                                               @RequestParam("picture") MultipartFile picture) {
//        diabetic.setPicture((String) picture);
//        diabeticService.save(diabetic);
//        return "redirect:/";
//    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("diabetic", diabeticService.getById(id));
        return "update";
    }

    @GetMapping("/deleteDiabetic/{id}")
    public String deleteThroughId(@PathVariable(value = "id") Long id) {
        diabeticService.delete(id);
        return "redirect:/";

    }

}
