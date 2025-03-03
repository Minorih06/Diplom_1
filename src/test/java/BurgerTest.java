import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private final String NAME_BUN = "Флюоресцентная булка R2-D3";
    private final float PRICE_BUN = 988.0f;

    private final String NAME_INGREDIENT_FILLING = "Мясо бессмертных моллюсков Protostomia";
    private final float PRICE_INGREDIENT_FILLING = 1337.0f;
    private final IngredientType TYPE_FILLING = IngredientType.FILLING;

    private final String NAME_INGREDIENT_SAUCE = "Соус традиционный галактический";
    private final float PRICE_INGREDIENT_SAUCE = 15.0f;
    private final IngredientType TYPE_SAUCE = IngredientType.SAUCE;

    private final float DELTA = 0.0001f;

    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredientFilling;

    @Mock
    private Ingredient mockIngredientSauce;

    @InjectMocks
    private Burger burger;

    @Test
    public void setBunsTest() {
        burger.setBuns(mockBun);
        assertEquals(mockBun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(mockIngredientFilling);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(mockIngredientFilling);
        assertEquals(1, burger.ingredients.size());

        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(mockIngredientFilling);
        burger.addIngredient(mockIngredientSauce);

        burger.moveIngredient(0, 1);

        assertEquals(mockIngredientSauce, burger.ingredients.get(0));
        assertEquals(mockIngredientFilling, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        when(mockBun.getPrice()).thenReturn(PRICE_BUN);
        when(mockIngredientFilling.getPrice()).thenReturn(PRICE_INGREDIENT_FILLING);
        when(mockIngredientSauce.getPrice()).thenReturn(PRICE_INGREDIENT_SAUCE);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredientFilling);
        burger.addIngredient(mockIngredientSauce);

        float mockPrice = mockBun.getPrice() * 2 + mockIngredientFilling.getPrice() + mockIngredientSauce.getPrice();

        assertEquals(mockPrice, burger.getPrice(), DELTA);
    }

    @Test
    public void getReceiptTest() {
        when(mockBun.getName()).thenReturn(NAME_BUN);
        when(mockIngredientFilling.getName()).thenReturn(NAME_INGREDIENT_FILLING);
        when(mockIngredientSauce.getName()).thenReturn(NAME_INGREDIENT_SAUCE);

        when(mockBun.getPrice()).thenReturn(PRICE_BUN);
        when(mockIngredientFilling.getPrice()).thenReturn(PRICE_INGREDIENT_FILLING);
        when(mockIngredientSauce.getPrice()).thenReturn(PRICE_INGREDIENT_SAUCE);

        when(mockIngredientFilling.getType()).thenReturn(TYPE_FILLING);
        when(mockIngredientSauce.getType()).thenReturn(TYPE_SAUCE);

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

        assertEquals(expectReceipt, burger.getReceipt());
    }
}
