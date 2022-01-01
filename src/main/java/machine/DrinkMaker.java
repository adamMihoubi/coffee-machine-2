package machine;

import dtos.Order;
import exceptions.DrinkNotFoundException;
import exceptions.NotEnoughMoneyToGetTheDrink;

import java.util.function.IntPredicate;

public class DrinkMaker {
    public static final String DELIMITER = ":";
    private static final String STICK = "0";
    private static final IntPredicate isThereAnySugar = value -> value > 0;

    public String make(Order order) {
        try {
            return makeTheDrink(order);
        } catch (DrinkNotFoundException | NotEnoughMoneyToGetTheDrink e) {
            return String.join(DELIMITER, "M", e.getMessage());
        }
    }

    private String makeTheDrink(Order order) throws DrinkNotFoundException, NotEnoughMoneyToGetTheDrink {
        var drink = DrinkType.getFrom(order.drink());
        MoneyVerifier.verifyIfThereIsEnoughMoney(drink, order.amount());
        var drinkInitial = computeIfHot(drink.getInitial(), order.isExtraHot());
        return drinkWithSugarOrRegular(order, drinkInitial);
    }

    private String computeIfHot(String initial, boolean extraHot) {
        return extraHot ? initial.concat("h") : initial;
    }

    private String drinkWithSugarOrRegular(Order order, String drinkInitial) {
        return isThereAnySugar.test(order.sugars()) ?
                       String.join(DELIMITER, drinkInitial, String.valueOf(order.sugars()), STICK) :
                       String.join(DELIMITER, drinkInitial, DELIMITER);
    }
}
