package chapter02;

import java.util.Arrays;
import java.util.List;

public class PrettyPrint {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
            new Apple(80, "green"),
            new Apple(110, "green"),
            new Apple(120, "red")
        );

        prettyPrintApple(inventory, new AppleFancyFormatter());
        prettyPrintApple(inventory, new AppleSimpleFormatter());
    }

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for(Apple apple: inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }
}

interface AppleFormatter {
    String accept(Apple apple);
}

class AppleFancyFormatter implements AppleFormatter {

    @Override
    public String accept(Apple apple) {
        String characteristic = apple.getWeight() > 150 ? "heavy" : "light";

        return "A " + characteristic + " " + apple.getColor() + " apple";
    }
}

class AppleSimpleFormatter implements AppleFormatter {

    @Override
    public String accept(Apple apple) {
        return "An apple of " + apple.getWeight() + "g";
    }
}