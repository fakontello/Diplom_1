package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTests {

    Bun bun = new Bun("бриошь",15.56f);

    @Test
    public void getBunName() {
        // Arrange
        String expectedName = "бриошь";
        // Act
        String actualName = bun.getName();
        // Assert
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void getBunPrice() {
        // Arrange
        float expectedPrice = 15.56f;
        // Act
        float actualPrice = bun.getPrice();
        // Assert
        Assert.assertEquals(expectedPrice, actualPrice,0);
    }

}
