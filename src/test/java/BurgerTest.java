import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import org.assertj.core.api.SoftAssertions;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private final String nameBun = "Флюоресцентная булка R2-D3";
    private final float priceBun = 988.0f;

    private final String nameIngredientFilling = "Мясо бессмертных моллюсков Protostomia";
    private final float priceIngredientFilling = 1337.0f;
    private final IngredientType typeFilling = IngredientType.FILLING;

    private final String nameIngredientSauce = "Соус традиционный галактический";
    private final float priceIngredientSauce = 15.0f;
    private final IngredientType typeSauce = IngredientType.SAUCE;

    private final float delta = 0.0001f;

    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredientFilling;

    @Mock
    private Ingredient mockIngredientSauce;

    @InjectMocks
    private Burger burger;

    @Before
    public void before() {
        when(mockBun.getName()).thenReturn(nameBun);
        when(mockIngredientFilling.getName()).thenReturn(nameIngredientFilling);
        when(mockIngredientSauce.getName()).thenReturn(nameIngredientSauce);

        when(mockBun.getPrice()).thenReturn(priceBun);
        when(mockIngredientFilling.getPrice()).thenReturn(priceIngredientFilling);
        when(mockIngredientSauce.getPrice()).thenReturn(priceIngredientSauce);

        when(mockIngredientFilling.getType()).thenReturn(typeFilling);
        when(mockIngredientSauce.getType()).thenReturn(typeSauce);
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(mockBun);
        assertEquals("Ошибка: Булка не установлена", mockBun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(mockIngredientFilling);
        assertEquals("Ошибка: Ингредиент не добавлен.", 1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(mockIngredientFilling);
        assertEquals("Ошибка: Ингредиент не добавлен.", 1, burger.ingredients.size());

        burger.removeIngredient(0);
        assertEquals("Ошибка: Ингредиент не удалён.", 0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(mockIngredientFilling);
        burger.addIngredient(mockIngredientSauce);

        burger.moveIngredient(0, 1);

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(burger.ingredients.get(0)).as("Ошибка: Соус не изменил своё первоначальное место").isEqualTo(mockIngredientSauce);
        softly.assertThat(burger.ingredients.get(1)).as("Ошибка: Начинка не изменила своё первоначальное место").isEqualTo(mockIngredientFilling);
        softly.assertAll();
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredientFilling);
        burger.addIngredient(mockIngredientSauce);

        float mockPrice = mockBun.getPrice() * 2 + mockIngredientFilling.getPrice() + mockIngredientSauce.getPrice();

        assertEquals("Ошибка: Цена бургера не возвращена!", mockPrice, burger.getPrice(), delta);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredientFilling);
        burger.addIngredient(mockIngredientSauce);

        float mockPrice = mockBun.getPrice() * 2 + mockIngredientFilling.getPrice() + mockIngredientSauce.getPrice();

        String expectReceipt = String.format(
                "(==== %s ====)%n" +
                "= %s %s =%n" +
                "= %s %s =%n" +
                "(==== %s ====)%n%n" +
                "Price: %f%n",
                mockBun.getName(),
                mockIngredientFilling.getType().toString().toLowerCase(), mockIngredientFilling.getName(),
                mockIngredientSauce.getType().toString().toLowerCase(), mockIngredientSauce.getName(),
                mockBun.getName(),
                mockPrice);

        assertEquals("Ошибка: Чек не соответствует добавленным ингредиентам", expectReceipt, burger.getReceipt());
    }
}
