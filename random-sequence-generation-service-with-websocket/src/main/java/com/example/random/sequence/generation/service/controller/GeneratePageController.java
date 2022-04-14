package com.example.random.sequence.generation.service.controller;

import com.example.random.sequence.generation.service.array.IterationNaturalNumbers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class GeneratePageController {
    IterationNaturalNumbers inn = new IterationNaturalNumbers();


    @GetMapping("/generate")
    public String generate(@RequestParam(required = false) Integer length, Model model) {

        inn.naturalNumberSelection();
        inn.choiceSixNaturalNumbers();

        log.info("ARRAY OUTPUT ON THE GENERATION PAGE: " + inn.getArrayWithSixNumbers());
        log.info("ARRAY OUTPUT ON THE GENERATION PAGE: " + inn.getArrayWithSixNumbers2());
        log.info("ARRAY OUTPUT ON THE GENERATION PAGE: " + inn.getArrayWithSixNumbers3());
        log.info("ARRAY OUTPUT ON THE GENERATION PAGE: " + inn.getArrayWithSixNumbers4());
        log.info("ARRAY OUTPUT ON THE GENERATION PAGE: " + inn.getArrayWithSixNumbers5());

        model.addAttribute("length", length);
        model.addAttribute("arrayWithSixNumbers", inn.getArrayWithSixNumbers());
        model.addAttribute("arrayWithSixNumbers2", inn.getArrayWithSixNumbers2());
        model.addAttribute("arrayWithSixNumbers3", inn.getArrayWithSixNumbers3());
        model.addAttribute("arrayWithSixNumbers4", inn.getArrayWithSixNumbers4());
        model.addAttribute("arrayWithSixNumbers5", inn.getArrayWithSixNumbers5());

        return "generate_page";
    }
}