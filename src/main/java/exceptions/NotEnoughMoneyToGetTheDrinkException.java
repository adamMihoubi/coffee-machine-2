package exceptions;

public class NotEnoughMoneyToGetTheDrinkException extends Exception {
    public NotEnoughMoneyToGetTheDrinkException() {
        super("Not enough money given");
    }
}
