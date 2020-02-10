package chapter05;

import java.util.Objects;

public class Trader {
    private String name;
    private String city;

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Trader))
            return false;

        Trader trader = (Trader) o;
        return Objects.equals(name, trader.name) &&
               Objects.equals(city, trader.city);
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = hash * 31 + (name == null ? 0 : name.hashCode());
        hash = hash * 31 + (city == null ? 0 : city.hashCode());

        return hash;
    }

    @Override
    public String toString() {
        return "Trader{" +
               "name='" + name + '\'' +
               " in city='" + city + '\'' +
               '}';
    }
}
