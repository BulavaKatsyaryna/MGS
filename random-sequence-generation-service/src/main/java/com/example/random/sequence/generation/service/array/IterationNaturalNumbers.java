package com.example.random.sequence.generation.service.array;

import com.example.random.sequence.generation.service.controller.AutoPageController;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IterationNaturalNumbers {
    private static final Logger log = LoggerFactory.getLogger(AutoPageController.class);
    protected static final List<Object> naturalNumbersSequence = new LinkedList<>();
    private final List<Object> arrayWithSixNumbers = new ArrayList<>();
    Random random = new Random();

    public void naturalNumberSelection() {

        for (int i = 2; i < 543; i++) {
            boolean bool = true;
            int x = (int) Math.sqrt(i);
            for (int j = 2; j <= x; j++) {
                if ((i % j) == 0) {
                    bool = false;
                    break;
                }
            }
            if (bool) naturalNumbersSequence.add(i);
        }
    }

    public void ChoiceSixNaturalNumbers() {
        arrayWithSixNumbers.clear();

        for (int i = 0; i < 6; i++) {
            int randomIndex = random.nextInt(naturalNumbersSequence.size());
            var randomElement = naturalNumbersSequence.get(randomIndex);
            log.info("RANDOM ARRAY OF SELECTED LENGTH: " + randomElement);
            arrayWithSixNumbers.add(randomElement);
        }
    }
}
