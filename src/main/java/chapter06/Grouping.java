package chapter06;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.flatMapping;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.List;
import java.util.Map;

import static chapter06.Dish.menu;

public class Grouping {

    enum CaloricLevel {DIET, NORMAL, FAT};

    public static void main(String[] args) {

    }

    private static Map<Dish.Type, List<Dish>> groupDishesByType() {
        return menu.stream()
            .collect(groupingBy(Dish::getType));
    }

    private static Map<Dish.Type, List<String>> groupDishNamesByType() {
        return menu.stream()
            .collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));
    }
}
