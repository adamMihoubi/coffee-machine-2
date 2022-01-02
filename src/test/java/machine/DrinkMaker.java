package machine;

import dtos.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Drink maker should")
class DrinkMakerTest {
    public static final String COFFEE = "Coffee";
    public static final String TEA = "Tea";
    public static final String CHOCOLATE = "Chocolate";
    public static final String ORANGE = "Orange";
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;
    private final DrinkMaker drinkMaker = new DrinkMaker();

    private static Stream<Arguments> givenArguments() {
        return Stream.of(
                Arguments.of(COFFEE, TWO, 0.6, "C:2:0", false),
                Arguments.of(TEA, ONE, 0.4, "T:1:0", false),
                Arguments.of(CHOCOLATE, ZERO, 0.5, "H::", false),
                Arguments.of(COFFEE, ZERO, 0.2, "M:Not enough money given", false),
                Arguments.of(TEA, ZERO, 0.2, "M:Not enough money given", false),
                Arguments.of(CHOCOLATE, ZERO, 0.2, "M:Not enough money given", false),
                Arguments.of(ORANGE, ZERO, 0.6, "O::", false),
                Arguments.of(COFFEE, ONE, 0.6, "Ch:1:0", true),
                Arguments.of(TEA, ONE, 0.6, "Th:1:0", true),
                Arguments.of(CHOCOLATE, ONE, 0.6, "Hh:1:0", true)
        );
    }

    @DisplayName("provide")
    @ParameterizedTest(name = "{3} when order is {0} with {1} sugars and an amount of {2} and extraHot is {4}")
    @MethodSource("givenArguments")
    void makeTheGoodDrink(String givenOrder, int sugars, double amount, String expectedDrink, boolean isExtraHot) {
        var tea = new Order(givenOrder, sugars, amount, isExtraHot);

        var drink = drinkMaker.make(tea);

        assertThat(drink).isEqualTo(expectedDrink);
    }
}
