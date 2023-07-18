import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    String expectedType;
    int expectedIndex;

    public IngredientTypeTest(String expectedType, int expectedIndex) {
        this.expectedType = expectedType;
        this.expectedIndex = expectedIndex;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientTypes() {
        return new Object[][] {
                { "SAUCE", 0 },
                { "FILLING", 1 },
        };
    }

    @Test
    public void ingredientTypeTest() {
        int actualIndex = IngredientType.valueOf(expectedType).ordinal();
        Assert.assertEquals(String.format("для типа %s ожидаемый индекс: %d", expectedType, expectedIndex),
                expectedIndex, actualIndex);
    }
}
