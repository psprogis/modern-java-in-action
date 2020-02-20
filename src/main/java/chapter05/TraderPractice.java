package chapter05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class TraderPractice {
    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );

        // Find all transactions in the year 2011 and sort them by value (small to high)
        List<Transaction> query1 = transactions.stream()
                    .filter(transaction -> transaction.getYear() == 2011)
                    .sorted(comparing(Transaction::getValue))
                    .collect(Collectors.toList());

        System.out.println(query1);

        // What are all the unique cities where the traders work?
        List<String> cities = transactions.stream()
            .map(transaction -> transaction.getTrader().getCity())
         // .collect(toSet())
            .distinct()
            .collect(Collectors.toList());

        System.out.println(cities);

        // Find all traders from Cambridge and sort them by name.
        List<Trader> tradersFromCambridge = transactions.stream()
            .map(transaction -> transaction.getTrader())
            .filter(trader -> trader.getCity().equals("Cambridge"))
            .distinct()
            .sorted(comparing(Trader::getName))
            .collect(Collectors.toList());

        System.out.println(tradersFromCambridge);

        // Return a string of all traders’ names sorted alphabetically.
        String traderNames = transactions.stream()
            .map(transaction -> transaction.getTrader().getName())
            .distinct()
            .sorted()
            .collect(Collectors.joining());
         // .reduce("", (n1, n2) -> n1 + n2);

        System.out.println(traderNames);

        // Are any traders based in Milan?
        boolean areAnyTradersFromMilan = transactions.stream()
            .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));

        System.out.println(areAnyTradersFromMilan);

        // Print the values of all transactions from the traders living in Cambridge.
        transactions.stream()
                    .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                    .map(Transaction::getValue)
                    .forEach(System.out::println);
                 // .forEach(transaction -> System.out.println(transaction.getValue()));

        // What’s the highest value of all the transactions?
        int highestValue = transactions.stream()
                    .map(Transaction::getValue)
                    .reduce(0, Integer::max);

        System.out.println(highestValue);

        // Find the transaction with the smallest value.
        Optional<Transaction> smallestTransaction = transactions.stream()
            .min(comparing(Transaction::getValue));

        System.out.println(smallestTransaction.map(String::valueOf).orElse("no transactions found."));
    }
}
