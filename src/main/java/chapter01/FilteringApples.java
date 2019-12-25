package chapter01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringApples {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
            new Apple(80, "green"),
            new Apple(110, "green"),
            new Apple(120, "red")
        );

        List<Apple> greenApples = filterGreenApples(inventory);
        System.out.println(greenApples);

        List<Apple> heavyApples = filterHeavyApples(inventory);
        System.out.println(heavyApples);

        List<Apple> greenApples2 = filterApples(inventory, FilteringApples::isGreenApple);
        System.out.println(greenApples2);

        List<Apple> heavyApples2 = filterApples(inventory, FilteringApples::isHeavyApple);
        System.out.println(heavyApples2);

        List<Apple> redApples = filterApples(inventory, apple -> "red".equals(apple.getColor()));
        System.out.println(redApples);

    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 100;
    }

    public interface Predicate<T>{
        boolean test(T t);
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList<Apple>();

        for(Apple apple: inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

    // old style, bad practice
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<Apple>();

        for(Apple apple: inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }

        return result;
    }

    // old style, bad practice
    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<Apple>();

        for(Apple apple: inventory) {
            if (apple.getWeight() > 100) {
                result.add(apple);
            }
        }

        return result;
    }

    public static class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "Apple{" +
                   "weight=" + weight +
                   ", color='" + color + '\'' +
                   '}';
        }
    }
}


