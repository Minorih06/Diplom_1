import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

public class IngredientTest {
    private final String name = "Говяжий метеорит (отбивная)";
    private final float price = 3000.0f;
    private final IngredientType type = IngredientType.FILLING;

    private final float delta = 0.0001f;

    Ingredient ingredient = new Ingredient(type, name, price);

    @Test
    public void getPriceTest() {
        assertEquals("Ошибка: Цена ингредиента не возвращена!",price, ingredient.getPrice(), delta);
    }

    @Test
    public void getNameTest() {
        assertEquals("Ошибка: Название ингредиента не возвращено!", name, ingredient.getName());
    }

    @Test
    public void getTypeTest() {
        assertEquals("Ошибка: Тип ингредиента не возвращен!", type, ingredient.getType());
    }
}
