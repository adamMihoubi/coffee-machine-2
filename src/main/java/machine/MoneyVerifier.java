package machine;

import exceptions.NotEnoughMoneyToGetTheDrink;

public interface MoneyVerifier {
    static void verifyIfThereIsEnoughMoney(DrinkType drink, Double amount) throws NotEnoughMoneyToGetTheDrink {
        if (drink.cantGetIt(amount)) {
            throw new NotEnoughMoneyToGetTheDrink();
        }
    }
}
