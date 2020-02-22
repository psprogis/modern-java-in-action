package chapter05;

import java.util.Arrays;
import java.util.stream.Stream;

public class BuildingStreams {
    public static void main(String[] args) {

        // Stream.of
        Stream<String> stream = Stream.of("java 8", "lambdas", "in", "action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        // Stream.empty
        Stream<String> emptyStream = Stream.empty();

        // Arrays.stream
        int[] numbers= { 2, 3, 5, 7, 11, 13 };
        System.out.println(Arrays.stream((numbers)).sum());

        // Stream.iterate
        Stream.iterate(0, n -> n + 2)
              .limit(10)
              .forEach(System.out::println);
    }
}
