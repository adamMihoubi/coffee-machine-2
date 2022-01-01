package dtos;

public record Order(String drink, Integer sugars, Double amount, boolean isExtraHot) {
    public Order(String drink, Integer sugars, Double amount) {
        this(drink, sugars, amount, false);
    }
}
