import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    private final String NAME = "Говяжий метеорит (отбивная)";
    private final float PRICE = 3000.0f;
    private final IngredientType TYPE = IngredientType.FILLING;

    private final float DELTA = 0.0001f;

    Ingredient ingredient = new Ingredient(TYPE, NAME, PRICE);

    @Test
    public void getPriceTest() {
        assertEquals(PRICE, ingredient.getPrice(), DELTA);
    }

    @Test
    public void getNameTest() {
        assertEquals(NAME, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        assertEquals(TYPE, ingredient.getType());
    }
}
