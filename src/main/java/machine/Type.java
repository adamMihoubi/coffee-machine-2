package machine;

import exceptions.DrinkNotFoundException;

import java.util.Arrays;

public enum Type {
    TEA("T", "Tea", 0.4), COFFEE("C", "Coffee", 0.6), CHOCOLATE("H", "Chocolate", 0.5);

    private final String initial;
    private final String orderName;
    private final Double price;

    Type(String initial, String orderName, Double price) {
        this.initial = initial;
        this.orderName = orderName;
        this.price = price;
    }

    public static Type getFrom(String orderName) throws DrinkNotFoundException {
        return Arrays.stream(values()).filter(type -> type.orderName.equals(orderName)).findAny().orElseThrow(DrinkNotFoundException::new);
    }

    public String getInitial() {
        return initial;
    }

    public boolean cantGetIt(Double amount) {
        return amount < price;
    }
}
