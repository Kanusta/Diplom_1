import Praktikum.IngredientType;
import  org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import Praktikum.Bun;
import Praktikum.Burger;
import Praktikum.Ingredient;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;
    Ingredient ingredient;
    Ingredient secondIngredient;

    @Mock
    Bun bun;
    @Mock
    Ingredient cheese;
    @Mock
    Ingredient salad;

    @Before
    public void initBurger() {
        burger = new Burger();
    }

    @Test
    public void setBun(){
        burger.setBuns(bun);
        assertEquals( bun, burger.bun);
    }

    @Test
    public void addIngredient(){
        burger.addIngredient(ingredient);
        assertEquals( ingredient, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredient(){
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals(0, burger.ingredients.size());
    }

    @Test
    public void moveIngredient(){
        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);
        burger.moveIngredient(0, 1);
        assertEquals( ingredient, burger.ingredients.get(0));
        assertEquals( secondIngredient, burger.ingredients.get(1));
    }
    @Test
    public void getPriceTest() {
        Mockito.when(bun.getPrice()).thenReturn(1.0f);
        Mockito.when(cheese.getPrice()).thenReturn(2.0f);
        Mockito.when(salad.getPrice()).thenReturn(3.0f);
        burger.setBuns(bun);
        burger.addIngredient(cheese);
        burger.addIngredient(salad);
        float expectedPrice = (bun.getPrice() * 2) + cheese.getPrice() + salad.getPrice();
        assertEquals(expectedPrice, burger.getPrice(), 0.0f);
    }
    @Test
    public void getReceiptTest() {
        Mockito.when(bun.getName()).thenReturn("Crator bun");
        Mockito.when(bun.getPrice()).thenReturn(1.0f);
        Mockito.when(cheese.getName()).thenReturn("cheese");
        Mockito.when(cheese.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(cheese.getPrice()).thenReturn(2.0f);
        burger.setBuns(bun);
        burger.addIngredient(cheese);
        String expectedResult = String.join(
                System.lineSeparator(),
                String.format("(==== %s ====)", bun.getName()),
                String.format("= %s %s =", cheese.getType().toString().toLowerCase(), cheese.getName()),
                String.format("(==== %s ====)", bun.getName()),
                "",
                String.format("Price: %.6f", bun.getPrice()*2 + cheese.getPrice()),
                ""
        );
        System.out.println("Expected receipt:\n" + expectedResult);
        System.out.println("Actual receipt:\n" + burger.getReceipt());
        assertEquals(expectedResult, burger.getReceipt());
    }
}