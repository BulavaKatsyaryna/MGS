package com.example.random.sequence.generation.service.controller;

import com.example.random.sequence.generation.service.array.IterationNaturalNumbers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutoPageController extends IterationNaturalNumbers {

    Random random = new SecureRandom();
    public final List<Object> randomArrayCertainLength = new ArrayList<>();
    private Object randomArrayCertainLengthResult;

    public void auto(@RequestParam(required = false) int length) {

        naturalNumberSelection();

        randomArrayCertainLength.clear();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(naturalNumbersSequence.size());
            var randomElement = naturalNumbersSequence.get(randomIndex);
            log.info("RANDOM ARRAY OF SELECTED LENGTH: " + randomElement);
            randomArrayCertainLength.add(randomElement);
        }

        randomArrayCertainLengthResult = randomArrayCertainLength.stream()
                .map(String::valueOf)
                .collect(Collectors.joining("-", "{", "}"));
    }

    public void request(HttpServletRequest request) {
        request.setAttribute("randomArrayCertainLength", randomArrayCertainLengthResult);
    }
}
