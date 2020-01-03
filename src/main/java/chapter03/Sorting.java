package chapter03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import chapter02.Apple;
import chapter02.Color;

import static java.util.Comparator.comparing;

public class Sorting {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
            new Apple(80, Color.GREEN),
            new Apple(155, Color.GREEN),
            new Apple(120, Color.RED));

        // 1
        inventory.sort(new AppleComparator());
        System.out.println(inventory);

        inventory.set(1, new Apple(30, Color.GREEN));

        // 2
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight() - a2.getWeight();
            }
        });
        System.out.println(inventory);

        inventory.set(1, new Apple(20, Color.GREEN));

        // 3
        inventory.sort((a1, a2) -> a1.getWeight() - a2.getWeight());
        System.out.println(inventory);

        inventory.set(1, new Apple(10, Color.GREEN));

        // 4
        inventory.sort(comparing(Apple::getWeight));
        System.out.println(inventory);
    }
}
