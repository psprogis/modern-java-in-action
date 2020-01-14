package chapter05;

import java.util.Arrays;
import java.util.List;

import chapter04.Dish;

import static chapter04.Dish.menu;
import static java.util.stream.Collectors.toList;

public class Mapping {
    public static void main(String[] args) {

        List<String> dishNames = menu.stream()
            .map(Dish::getName)
            .collect(toList());
        System.out.println(dishNames);

        List<String> words = Arrays.asList("Hello", "World");
        List<Integer> wordLengths = words.stream()
            .map(String::length)
            .collect(toList());
        System.out.println(wordLengths);

        words.stream()
             .flatMap(line -> Arrays.stream(line.split("")))
             .distinct()
             .forEach(System.out::println);

        List<Integer> number1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> number2 = Arrays.asList(6, 7, 8);
        List<int[]> pairs = number1.stream()
            .flatMap(i -> number2.stream()
                    .map(j -> new int[]{i, j}))
            .filter(pair -> (pair[0] + pair[1]) % 3 == 0)
            .collect(toList());

        pairs.forEach(pair -> System.out.printf("(%d, %d)", pair[0], pair[1]));
    }
}
