package com.example.random.sequence.generation.service.controller;

import com.example.random.sequence.generation.service.array.IterationNaturalNumbers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class AutoPageController extends IterationNaturalNumbers {
    private static final Logger log = LoggerFactory.getLogger(AutoPageController.class);

    Random random = new SecureRandom();
    private final List<Object> randomArrayCertainLength = new ArrayList<>();

    @GetMapping("/auto")
    public String auto(@RequestParam(required = false) int length, Model model) {

        naturalNumberSelection();

        randomArrayCertainLength.clear();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(naturalNumbersSequence.size());
            var randomElement = naturalNumbersSequence.get(randomIndex);
            log.info("RANDOM ARRAY OF SELECTED LENGTH: " + randomElement);
            randomArrayCertainLength.add(randomElement);
        }

        log.info("ENTERED ARRAY LENGTH: " + length);
        log.info("ARRAY OUTPUT ON THE AUTO PAGE: " + randomArrayCertainLength);
        model.addAttribute("length", length);
        model.addAttribute("randomArrayCertainLength", randomArrayCertainLength);
        return "auto_page";
    }
}