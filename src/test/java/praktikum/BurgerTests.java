package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {

    Burger burger;

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredient1;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsInBurger() {
        // Act
        burger.setBuns(bun);
        // Assert
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientToBurger() {
        // Act
        burger.addIngredient(ingredient);
        // Assert
        Assert.assertEquals(ingredient, burger.ingredients.get(0));
    }

    @Test
    public void getPriceOfBurgerBuns() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(200F);
        Mockito.when(ingredient.getPrice()).thenReturn(300F);
        Assert.assertEquals(burger.getPrice(), 700, 0);
    }

    @Test
    public void removeIngredientFromBurger() {
        // Act
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        // Assert
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void getReceiptForBurger() {
        // Arrange
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        // Act
        Mockito.when(bun.getName()).thenReturn("purple");
        Mockito.when(ingredient.getName()).thenReturn("кепчук");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        // Assert
        String expectedReceipt = "(==== purple ====)\r\n" + "= sauce кепчук =\r\n" + "(==== purple ====)\r\n" +
                "\r\nPrice: 300,000000\r\n";
        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }

    @Test
    public void moveIngredientFromOnePlaceToAnother() {
        // Act
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient1);
        burger.moveIngredient(0,1);
        // Assert
        Assert.assertEquals(1,burger.ingredients.lastIndexOf(ingredient));
    }

}
