package com.org.homework.secondtask;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Integer> integerList = getIntegerList();
        System.out.println("Generated list of values:" + integerList);

        Long result = getSumOfDoubleEvenNumbers(integerList);

        System.out.println("The sum of the doubled even values of the list: " + result);

    }

    private static Long getSumOfDoubleEvenNumbers(List<Integer> integerList) {
        return integerList.stream()
                .filter(v -> v % 2 == 0 && v != 0)
                .map(v -> v * 2)
                .collect(Collectors.summarizingInt(v -> v))
                .getSum();
    }

    private static List<Integer> getIntegerList() {
        List<Integer> integerList = new ArrayList<>();

        for (int i = 0; i < (Math.random() * 20) + 10; i++) {
            integerList.add((int) (Math.random() * 20));
        }
        return integerList;
    }

}
