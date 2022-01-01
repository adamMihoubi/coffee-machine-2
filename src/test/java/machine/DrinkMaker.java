package machine;

import dtos.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Drink maker should")
class DrinkMakerTest {
    private final DrinkMaker drinkMaker = new DrinkMaker();

    @Test
    void makeACoffeeWithTwoSugarAndAStick() {
        var coffee = new Order("Coffee", 2, 0.6);

        var drink = drinkMaker.make(coffee);

        assertThat(drink).isEqualTo("C:2:0");
    }

    @Test
    void makeATeaWithOneSugarAndAStick() {
        var tea = new Order("Tea", 1, 0.4);

        var drink = drinkMaker.make(tea);

        assertThat(drink).isEqualTo("T:1:0");
    }

    @Test
    void makeAHotChocolateWithoutSugarNorStick() {
        var chocolate = new Order("Chocolate", 0, 0.5);

        var drink = drinkMaker.make(chocolate);

        assertThat(drink).isEqualTo("H::");
    }

    @Test
    void notMakeCoffeeIfAmountIsNotSufficient() {
        var coffee = new Order("Coffee", 0, 0.2);

        var drink = drinkMaker.make(coffee);

        assertThat(drink).isEqualTo("M:Not enough money given");
    }

    @Test
    void notMakeTeaIfAmountIsNotSufficient() {
        var tea = new Order("Tea", 0, 0.2);

        var drink = drinkMaker.make(tea);

        assertThat(drink).isEqualTo("M:Not enough money given");
    }

    @Test
    void notMakeChocolateIfAmountIsNotSufficient() {
        var chocolate = new Order("Chocolate", 0, 0.2);

        var drink = drinkMaker.make(chocolate);

        assertThat(drink).isEqualTo("M:Not enough money given");
    }

    @Test
    void makeAnOrangeJuiceFor6Cents() {
        var orange = new Order("Orange", 0, 0.6);

        var drink = drinkMaker.make(orange);

        assertThat(drink).isEqualTo("O::");
    }

    @Test
    void makeAnExtraHotCoffee() {
        var coffee = new Order("Coffee", 1, 0.6, true);

        var drink = drinkMaker.make(coffee);

        assertThat(drink).isEqualTo("Ch:1:0");
    }

    @Test
    void makeAnExtraHotTea() {
        var tea = new Order("Tea", 1, 0.6, true);

        var drink = drinkMaker.make(tea);

        assertThat(drink).isEqualTo("Th:1:0");
    }

    @Test
    void makeAnExtraHotChocolate() {
        var chocolate = new Order("Chocolate", 0, 0.6, true);

        var drink = drinkMaker.make(chocolate);

        assertThat(drink).isEqualTo("Hh::");
    }

}
