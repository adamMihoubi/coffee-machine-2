package machine;

import exceptions.DrinkNotFoundException;

import java.util.Arrays;

public enum DrinkType {
    TEA("T", "Tea", 0.4),
    COFFEE("C", "Coffee", 0.6),
    CHOCOLATE("H", "Chocolate", 0.5),
    ORANGE("O", "Orange", 0.6);

    private final String initial;
    private final String orderName;
    private final Double price;

    DrinkType(String initial, String orderName, Double price) {
        this.initial = initial;
        this.orderName = orderName;
        this.price = price;
    }

    public static DrinkType getFrom(String orderName) throws DrinkNotFoundException {
        return Arrays.stream(values())
                .filter(drinkType -> drinkType.orderName.equals(orderName))
                .findAny()
                .orElseThrow(DrinkNotFoundException::new);
    }

    public String getInitial() {
        return initial;
    }

    public boolean cantGetIt(Double amount) {
        return amount < price;
    }
}
