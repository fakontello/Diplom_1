package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTests {

    Bun bun = new Bun("бриошь",15.56f);

    @Test
    public void getBunNameTest() {
        // Arrange
        String expectedName = "бриошь";
        // Act
        String actualName = bun.getName();
        // Assert
        Assert.assertEquals(actualName, expectedName);
    }

    @Test
    public void getBunPriceTest() {
        // Arrange
        float expectedPrice = 15.56f;
        // Act
        float actualPrice = bun.getPrice();
        // Assert
        Assert.assertEquals(actualPrice, expectedPrice,0);
    }

}
