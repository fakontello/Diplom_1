package praktikum;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class BurgerTests {

    @Test
    public void removeIngredient() {
        // Arrange
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "лучок", 37);
        // Act
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        // Assert
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void moveIngredient() {
        // Arrange
        Burger burger = new Burger();
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "лучок", 37);
        Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "мазик", 6);
        // Act
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        List<Ingredient> actualIngredients = new ArrayList<>(burger.ingredients);
        burger.moveIngredient(1, 0);
        List<Ingredient> expectedIngredients = burger.ingredients;
        // Assert
        Assert.assertEquals(expectedIngredients.get(0), actualIngredients.get(1));
    }

    @Test
    public void getPrice() {
        // Arrange
        Bun bun = new Bun("с кунжутом", 12);
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "мазик", 6);
        // Act
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        // Assert
        float expectedPrice = burger.getPrice();
        Assert.assertEquals(expectedPrice, 30, 0);

    }

    @Test
    public void getReceipt() {
        // Arrange
        Bun bun = new Bun("с кунжутом", 12);
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "мазик", 6);
        // Act
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        // Assert
        String expectedReceipt = burger.getReceipt();
        String actualReceipt = "(==== с кунжутом ====)\r\n" + "= sauce мазик =\r\n" + "(==== с кунжутом ====)\r\n" +
                "\r\nPrice: 30,000000\r\n";
        Assert.assertEquals(expectedReceipt, actualReceipt);
    }

}
