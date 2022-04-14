package com.example.random.sequence.generation.service.model;

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
    private static final Logger log = LoggerFactory.getLogger(IterationNaturalNumbers.class);
    public static final List<Object> naturalNumbersSequence = new LinkedList<>();
    private final List<Object> arrayWithSixNumbers = new ArrayList<>();
    private final List<Object> arrayWithSixNumbers2 = new ArrayList<>();
    private final List<Object> arrayWithSixNumbers3 = new ArrayList<>();
    private final List<Object> arrayWithSixNumbers4 = new ArrayList<>();
    private final List<Object> arrayWithSixNumbers5 = new ArrayList<>();

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

    public void choiceSixNaturalNumbers() {
        arrayWithSixNumbers.clear();
        arrayWithSixNumbers2.clear();
        arrayWithSixNumbers3.clear();
        arrayWithSixNumbers4.clear();
        arrayWithSixNumbers5.clear();

        for (int i = 0; i < 30; i++) {
            int randomIndex = random.nextInt(naturalNumbersSequence.size());
            var randomElement = naturalNumbersSequence.get(randomIndex);
            if (arrayWithSixNumbers.size() <= 5) {
                arrayWithSixNumbers.add(randomElement);
            } else if (arrayWithSixNumbers2.size() <= 5) {
                arrayWithSixNumbers2.add(randomElement);
            } else if (arrayWithSixNumbers3.size() <= 5) {
                arrayWithSixNumbers3.add(randomElement);
            } else if (arrayWithSixNumbers4.size() <= 5) {
                arrayWithSixNumbers4.add(randomElement);
            } else if (arrayWithSixNumbers5.size() <= 5) {
                arrayWithSixNumbers5.add(randomElement);
            } else {
                log.info("Arrays are full");
            }
        }
    }
}
