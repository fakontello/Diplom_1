package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class IngredientsTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientsTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredients() {
        return new Object[][] {
                {IngredientType.SAUCE, "кепчук", 45.78f},
                {IngredientType.FILLING, "бекон", 89.99f}
        };
    }

    @Test
    public void IngredientConstructorTest() {
        Ingredient ingredient = new Ingredient(type, name, price);

        String actualName = ingredient.getName();
        IngredientType actualType = ingredient.getType();
        float actualPrice = ingredient.getPrice();

        Assert.assertEquals(ingredient.name, actualName);
        Assert.assertEquals(ingredient.type, actualType);
        Assert.assertEquals(ingredient.price, actualPrice, 0);
    }
}