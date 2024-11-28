import org.junit.Before;
import org.junit.Test;
import Praktikum.Bun;
import static org.junit.Assert.assertEquals;

public class BunTest {
    private Bun bun;
    private String name;
    private float price;

    @Before
    public void initBun() {
        bun = new Bun(name,price);
    }

    @Test
    public void getName() {
        assertEquals(name,bun.getName());
    }

    @Test
    public void getPrice() {
        assertEquals(price,bun.getPrice(),0.01);
    }
}