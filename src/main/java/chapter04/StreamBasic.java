package chapter04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamBasic {
    public static void main(String[] args) {

        // java 7
        getLowCaloricDishesNamesInJava7(Dish.menu).forEach(System.out::println);
        System.out.println("---");

        // java 8
        getLowCaloricDishesNamesInJava8(Dish.menu).forEach(System.out::println);
    }

    private static List<String> getLowCaloricDishesNamesInJava8(List<Dish> menu) {
        return menu.stream()
            .filter(dish -> dish.getCalories() < 400)
            .sorted(Comparator.comparing(Dish::getCalories))
            .map(Dish::getName)
            .collect(Collectors.toList());
    }

    private static List<String> getLowCaloricDishesNamesInJava7(List<Dish> menu) {
        List<Dish> lowCaloriesDishes = new ArrayList<>();

        for (Dish d : menu) {
            if (d.getCalories() < 400) {
                lowCaloriesDishes.add(d);
            }
        }

        Collections.sort(lowCaloriesDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish d1, Dish d2) {
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });

        List<String> lowCaloriesDishesNames = new ArrayList<>();

        for (Dish d : lowCaloriesDishes) {
            lowCaloriesDishesNames.add(d.getName());
        }

        return lowCaloriesDishesNames;
    }
}
