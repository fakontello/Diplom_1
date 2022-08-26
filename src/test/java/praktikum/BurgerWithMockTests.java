package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BurgerWithMockTests {

    @Mock
    Burger burger;

    @Test
    public void setBunsTest() {
        // Arrange
        Bun bun = new Bun("с кунжутом", 12);
        // Act
        burger.setBuns(bun);
        // Assert
        Mockito.verify(burger).setBuns(bun);
    }

    @Test
    public void sddIngredientTest() {
        // Arrange
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "кепчук", 56);
        // Act
        burger.addIngredient(ingredient);
        // Assert
        Mockito.verify(burger).addIngredient(ingredient);
    }
}
