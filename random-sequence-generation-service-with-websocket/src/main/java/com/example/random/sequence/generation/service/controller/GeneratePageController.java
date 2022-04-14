package com.example.random.sequence.generation.service.controller;

import com.example.random.sequence.generation.service.model.IterationNaturalNumbers;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@NoArgsConstructor

public class GeneratePageController extends IterationNaturalNumbers {

    public void generate(@RequestParam(required = false) Integer length, Model model) {

        naturalNumberSelection();
        choiceSixNaturalNumbers();

        log.info("ARRAY OUTPUT ON THE GENERATION PAGE: " + getArrayWithSixNumbers());
        log.info("ARRAY OUTPUT ON THE GENERATION PAGE: " + getArrayWithSixNumbers2());
        log.info("ARRAY OUTPUT ON THE GENERATION PAGE: " + getArrayWithSixNumbers3());
        log.info("ARRAY OUTPUT ON THE GENERATION PAGE: " + getArrayWithSixNumbers4());
        log.info("ARRAY OUTPUT ON THE GENERATION PAGE: " + getArrayWithSixNumbers5());

        model.addAttribute("length", length);
        model.addAttribute("arrayWithSixNumbers", getArrayWithSixNumbers());
        model.addAttribute("arrayWithSixNumbers2", getArrayWithSixNumbers2());
        model.addAttribute("arrayWithSixNumbers3", getArrayWithSixNumbers3());
        model.addAttribute("arrayWithSixNumbers4", getArrayWithSixNumbers4());
        model.addAttribute("arrayWithSixNumbers5", getArrayWithSixNumbers5());

    }
}