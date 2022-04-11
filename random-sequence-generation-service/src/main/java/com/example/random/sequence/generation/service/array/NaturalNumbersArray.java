//package com.example.random.sequence.generation.service.array;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//
//import java.util.LinkedList;
//import java.util.List;
//
//@Data
//@AllArgsConstructor
//public class NaturalNumbersArray {
//
//    private static List<Object> naturalNumbersSequence = new LinkedList<>();
//
//    static {
//
//        for (int i = 2; i < 543; i++) {
//            boolean bool = true;
//            int x = (int) Math.sqrt(i);
//            for (int j = 2; j <= x; j++) {
//                if ((i % j) == 0) {
//                    bool = false;
//                    break;
//                }
//            }
//            if (bool) naturalNumbersSequence.add(i);
//        }
//    }
//
//
//}
