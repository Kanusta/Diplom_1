import Praktikum.Ingredient;
import Praktikum.IngredientType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static Praktikum.IngredientType.FILLING;
import static Praktikum.IngredientType.SAUCE;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    public IngredientType type;
    public String name;
    public float price;

    public IngredientTest(IngredientType type,String name,float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[][] data(){
        return new Object[][]{
                {SAUCE, "Соус", 5.5F},
                {FILLING, "Начинка", 1.0F},

        };
    }
    @Test
    public void ingredientTest(){
        Ingredient ingredient = new Ingredient(type,name,price);
        assertEquals(type,ingredient.getType());
        assertEquals(name,ingredient.getName());
        assertEquals(price,ingredient.getPrice(),0.01);
    }
}