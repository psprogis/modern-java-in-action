package chapter05;

import java.util.Objects;

public class Transaction {
    private Trader trader;
    private int year;
    private int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Transaction))
            return false;

        Transaction that = (Transaction) o;

        return year == that.getYear() &&
               value == that.getValue() &&
               Objects.equals(trader, that.getTrader());
    }

    @Override
    public int hashCode() {
        return Objects.hash(trader, year, value);
    }

    @Override
    public String toString() {
        return "Transaction{" +
               "trader=" + trader +
               ", year=" + year +
               ", value=" + value +
               '}';
    }
}
