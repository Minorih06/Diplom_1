import org.junit.Test;
import praktikum.IngredientType;

import static org.assertj.core.api.Assertions.assertThat;

public class IngredientTypeTest {

    @Test
    public void enumValuesTest() {
        assertThat(IngredientType.values())
                .as("Проверяем, что enum содержит только SAUCE и FILLING в правильном порядке")
                .containsExactly(IngredientType.SAUCE, IngredientType.FILLING);
    }

    @Test
    public void enumSauceValueOfTest() {
        assertThat(IngredientType.valueOf("SAUCE"))
                .as("Проверяем, что valueOf('SAUCE') возвращает SAUCE")
                .isEqualTo(IngredientType.SAUCE);
    }

    @Test
    public void enumFillingValueOfTest() {
        assertThat(IngredientType.valueOf("FILLING"))
                .as("Проверяем, что valueOf('FILLING') возвращает FILLING")
                .isEqualTo(IngredientType.FILLING);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidEnumValueOfTest() {
        IngredientType.valueOf("INVALID");
    }
}
