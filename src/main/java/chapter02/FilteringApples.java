package chapter02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringApples {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
            new Apple(80, Color.GREEN),
            new Apple(155, Color.GREEN),
            new Apple(120, Color.RED));

        List<Apple> greenApples = filterApplesByColor(inventory, Color.GREEN);
        System.out.println(greenApples);

        List<Apple> redApples = filterApplesByColor(inventory, Color.RED);
        System.out.println(redApples);

        List<Apple> greenApples2 = filter(inventory, new AppleColorPredicate());
        System.out.println(greenApples2);

        List<Apple> heavyApples = filter(inventory, new AppleWeightPredicate());
        System.out.println(heavyApples);

        List<Apple> redAndHeavyApples = filter(inventory, new AppleRedAndHeavyPredicate());
        System.out.println(redAndHeavyApples);

        List<Apple> redApples2 = filter(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple a) {
                return a.getColor() == Color.RED;
            }
        });
        System.out.println(redApples2);
    }

    public static List<chapter01.FilteringApples.Apple> filterApples(List<chapter01.FilteringApples.Apple> inventory, chapter01.FilteringApples.Predicate<chapter01.FilteringApples.Apple> predicate) {
        List<chapter01.FilteringApples.Apple> result = new ArrayList<chapter01.FilteringApples.Apple>();

        for(chapter01.FilteringApples.Apple apple: inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();

        for(Apple apple: inventory) {
            if (apple.getColor() == Color.GREEN) {
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();

        for(Apple apple: inventory) {
            if (apple.getColor() == color) {
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();

        for(Apple apple: inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> filter(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();

        for(Apple apple: inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

    static class AppleWeightPredicate implements ApplePredicate {

        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }
    }

    static class AppleColorPredicate implements ApplePredicate {

        @Override
        public boolean test(Apple apple) {
            return apple.getColor() == Color.GREEN;
        }
    }

    static class AppleRedAndHeavyPredicate implements ApplePredicate {

        @Override
        public boolean test(Apple apple) {
            return apple.getColor() == Color.RED && apple.getWeight() > 150;
        }
    }
}
