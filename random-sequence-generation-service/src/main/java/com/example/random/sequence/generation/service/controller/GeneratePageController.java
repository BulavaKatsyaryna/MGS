package com.example.random.sequence.generation.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GeneratePageController {
    private static final Logger log = LoggerFactory.getLogger(AutoPageController.class);

    @GetMapping("/generate")
    public String generate(@RequestParam(required = false) String length, Model model) {
        log.info("ENTERED ARRAY LENGTH: " + length);
        model.addAttribute("length", length);
        return "generate_page";
    }
}
