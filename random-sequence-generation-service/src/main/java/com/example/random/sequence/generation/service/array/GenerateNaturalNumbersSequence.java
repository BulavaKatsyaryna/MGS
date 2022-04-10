package com.example.random.sequence.generation.service.array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.stream.IntStream;

public class GenerateNaturalNumbersSequence {
    private static final Logger log = LoggerFactory.getLogger(GenerateNaturalNumbersSequence.class);

//    String arrayLength = "${length}";

    @GetMapping
    public String naturalNumbersSequenceGeneration(@RequestParam(required = false) String length, Model model) {

        int[] naturalNumbersArray = IntStream.iterate(2, i -> i + 1)
                .filter(j -> IntStream.range(2, j).noneMatch(e -> j % e == 0))
                .limit(Integer.parseInt(length))
                .toArray();
//        model.addAttribute("array", naturalNumbersArray);
        log.info(String.valueOf(naturalNumbersArray));
        return "auto_page";
    }
}
