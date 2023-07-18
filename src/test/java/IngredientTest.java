import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTest {
    float ingredientPrice = 111.0F;
    String ingredientName = "Test Name";
    @Mock
    IngredientType ingredientTypeMock;
    Ingredient ingredient = new Ingredient(ingredientTypeMock, ingredientName, ingredientPrice);

    @Test
    public void getPriceTest() {
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals(String.format("ожидаемая стоимость ингредиента: %f", ingredientPrice),
                ingredientPrice, actualPrice, 0.001);
    }
    @Test
    public void getNameTest() {
        String actualName = ingredient.getName();
        Assert.assertEquals(String.format("ожидаемое название ингредиента: %s", ingredientName),
                ingredientName, actualName);
    }

    @Test
    public void getTypeTest() {
        IngredientType actualType = ingredient.getType();
        Assert.assertEquals(String.format("ожидаемый тип ингредиента: %s", null),
                null, actualType);
    }
}
