package com.example.random.sequence.generation.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Controller
public class GeneratePageController {
    private static final Logger log = LoggerFactory.getLogger(GeneratePageController.class);
    private static final List<Object> naturalNumbersSequenceForGeneratePage = new LinkedList<>();

    Random random = new SecureRandom();
    private final List<Object> arrayWithSixNumbers = new ArrayList<>();

    static {

        for (int i = 2; i < 543; i++) {
            boolean bool = true;
            int x = (int) Math.sqrt(i);
            for (int j = 2; j <= x; j++) {
                if ((i % j) == 0) {
                    bool = false;
                    break;
                }
            }
            if (bool) naturalNumbersSequenceForGeneratePage.add(i);
        }
    }

    @GetMapping("/generate")
    public String generate(@RequestParam(required = false) Integer length, Model model) {

        arrayWithSixNumbers.clear();

        for (int i = 0; i < 6; i++) {
            int randomIndex = random.nextInt(naturalNumbersSequenceForGeneratePage.size());
            var randomElement = naturalNumbersSequenceForGeneratePage.get(randomIndex);
            log.info("RANDOM ARRAY 6 DIGIT LONG: " + randomElement);
            arrayWithSixNumbers.add(randomElement);
        }

        log.info("ARRAY OUTPUT ON THE GENERATION PAGE: " + arrayWithSixNumbers);
        model.addAttribute("length", length);
        model.addAttribute("arrayWithSixNumbers", arrayWithSixNumbers);

        return "generate_page";
    }
}
