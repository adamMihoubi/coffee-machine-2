package machine;

import dtos.Order;
import exceptions.DrinkNotFoundException;
import exceptions.NotEnoughMoneyToGetTheDrink;

public class DrinkMaker {
    public static final String DELIMITER = ":";
    private static final String STICK = "0";

    public String make(Order order) {
        try {
            return makeTheDrink(order);
        } catch (DrinkNotFoundException | NotEnoughMoneyToGetTheDrink e) {
            return String.join(DELIMITER, "M", e.getMessage());
        }
    }

    private String makeTheDrink(Order order) throws DrinkNotFoundException, NotEnoughMoneyToGetTheDrink {
        var drink = Type.getFrom(order.drink());
        verifyIfThereIsEnoughMoney(drink, order.amount());
        if (order.sugars() > 0) {
            return String.join(DELIMITER, drink.getInitial(), String.valueOf(order.sugars()), STICK);
        }
        return String.join(DELIMITER, drink.getInitial(), DELIMITER);
    }

    private void verifyIfThereIsEnoughMoney(Type drink, Double amount) throws NotEnoughMoneyToGetTheDrink {
        if (drink.cantGetIt(amount)) {
            throw new NotEnoughMoneyToGetTheDrink();
        }
    }
}
