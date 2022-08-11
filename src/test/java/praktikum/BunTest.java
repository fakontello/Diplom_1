package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {

    Bun bun = new Bun("бриошь", (float) 15.56);

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
        float expectedPrice = (float) 15.56;
        // Act
        float actualPrice = bun.getPrice();
        // Assert
        Assert.assertEquals(actualPrice, expectedPrice,0);
    }

}
