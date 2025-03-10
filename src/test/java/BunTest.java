import org.junit.Test;

import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private final String name = "Краторная булка N-200i";
    private final float price = 1255.0f;
    private final float delta = 0.0001f;

    private Bun bun = new Bun(name, price);

    @Test
    public void getNameTest() {
        assertEquals("Ошибка: Название булки не возвращено!", name, bun.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals("Ошибка: Цена булки не возвращена!", price, bun.getPrice(), delta);
    }
}
