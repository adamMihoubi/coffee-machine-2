package exceptions;

public class NotEnoughMoneyToGetTheDrink extends Exception {
    public NotEnoughMoneyToGetTheDrink() {
        super("Not enough money given");
    }
}
