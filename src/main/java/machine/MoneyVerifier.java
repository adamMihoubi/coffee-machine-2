package machine;

import exceptions.NotEnoughMoneyToGetTheDrinkException;

public interface MoneyVerifier {
    static void verifyIfThereIsEnoughMoney(DrinkType drink, Double amount) throws NotEnoughMoneyToGetTheDrinkException {
        if (drink.cantGetIt(amount)) {
            throw new NotEnoughMoneyToGetTheDrinkException();
        }
    }
}
