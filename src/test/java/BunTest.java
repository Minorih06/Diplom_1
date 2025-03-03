import org.junit.Test;

import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private final String NAME = "Краторная булка N-200i";
    private final float PRICE = 1255.0f;
    private final float DELTA = 0.0001f;

    private Bun bun = new Bun(NAME, PRICE);


    @Test
    public void getNameTest() {
        assertEquals(NAME, bun.getName());
    }

    @Test
    public void getPriceTest() {
        assertEquals(PRICE, bun.getPrice(), DELTA);
    }
}
