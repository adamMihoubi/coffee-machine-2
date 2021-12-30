package exceptions;

public class DrinkNotFoundException extends Exception {
    public DrinkNotFoundException() {
        super("Drink asked is not existing");
    }
}
