package chapter05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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
    }
}
