package com.example.random.sequence.generation.service.controller;

import com.example.random.sequence.generation.service.array.IterationNaturalNumbers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GeneratePageController {
    private static final Logger log = LoggerFactory.getLogger(GeneratePageController.class);
    IterationNaturalNumbers inn = new IterationNaturalNumbers();


    @GetMapping("/generate")
    public String generate(@RequestParam(required = false) Integer length, Model model) {

        inn.naturalNumberSelection();
        inn.ChoiceSixNaturalNumbers();

        log.info("ARRAY OUTPUT ON THE GENERATION PAGE: " + inn.getArrayWithSixNumbers());
        model.addAttribute("length", length);
        model.addAttribute("arrayWithSixNumbers", inn.getArrayWithSixNumbers());

        return "generate_page";
    }
}
