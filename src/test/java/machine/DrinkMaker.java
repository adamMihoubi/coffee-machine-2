package machine;

import dtos.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Drink maker should")
class DrinkMakerTest {
    @Test
    void makeACoffeeWithTwoSugarAndAStick() {
        var drinkMaker = new DrinkMaker();
        var coffee = new Order("Coffee", 2, 0.6);

        var drink = drinkMaker.make(coffee);

        assertThat(drink).isEqualTo("C:2:0");
    }

    @Test
    void makeATeaWithOneSugarAndAStick() {
        var drinkMaker = new DrinkMaker();
        var tea = new Order("Tea", 1, 0.4);

        var drink = drinkMaker.make(tea);

        assertThat(drink).isEqualTo("T:1:0");
    }

    @Test
    void makeAHotChocolateWithoutSugarNorStick() {
        var drinkMaker = new DrinkMaker();
        Order chocolate = new Order("Chocolate", 0, 0.5);

        var drink = drinkMaker.make(chocolate);

        assertThat(drink).isEqualTo("H::");
    }

    @Test
    void notMakeCoffeeIfAmountIsNotSufficient() {
        var drinkMaker = new DrinkMaker();
        Order chocolate = new Order("Chocolate", 0, 0.2);

        var drink = drinkMaker.make(chocolate);

        assertThat(drink).isEqualTo("M:Not enough money given");
    }

}
