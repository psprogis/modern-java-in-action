package chapter05;

import java.util.Arrays;
import java.util.List;

import chapter04.Dish;
import chapter04.DishType;

import static chapter04.Dish.menu;
import static java.util.stream.Collectors.toList;

public class Filtering {
    public static void main(String[] args) {

        System.out.println("filtering with predicate");
        List<Dish> vegetarianMenu = menu.stream()
            .filter(Dish::isVegetarian)
            .collect(toList());
        vegetarianMenu.forEach(System.out::println);

        System.out.println("\nfiltering unique even elements");
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
               .filter(i -> i % 2 == 0)
               .distinct()
               .forEach(System.out::println);

        List<Dish> specialMenu = Arrays.asList(
            new Dish("season fruit", true, 120, DishType.OTHER),
            new Dish("prawns", false, 300, DishType.FISH),
            new Dish("rice", true, 350, DishType.OTHER),
            new Dish("chicken", false, 400, DishType.MEAT),
            new Dish("french fries", true, 530, DishType.OTHER));

        System.out.println("\nfiltered sorted menu");
        List<Dish> filteredMenu = specialMenu.stream()
            .filter(dish -> dish.getCalories() < 320)
            .collect(toList());
        filteredMenu.forEach(System.out::println);

        System.out.println("\nsorted menu sliced with takeWhile()");
        List<Dish> sliceMenu1 = specialMenu.stream()
            .takeWhile(dish -> dish.getCalories() < 320)
            .collect(toList());
        sliceMenu1.forEach(System.out::println);

        System.out.println("\nsorted menu sliced with dropWhile()");
        List<Dish> sliceMenu2 = specialMenu.stream()
            .dropWhile(dish -> dish.getCalories() < 320)
            .collect(toList());
        sliceMenu2.forEach(System.out::println);

        System.out.println("\ntruncating a stream");
        List<Dish> dishesLimit3 = menu.stream()
            .filter(d -> d.getCalories() > 300)
            .limit(3)
            .collect(toList());
        dishesLimit3.forEach(System.out::println);

        System.out.println("\nskipping elements");
        List<Dish> dishesSkip2 = menu.stream()
            .filter(d -> d.getCalories() > 300)
            .skip(2)
            .collect(toList());
        dishesSkip2.forEach(System.out::println);
    }
}
