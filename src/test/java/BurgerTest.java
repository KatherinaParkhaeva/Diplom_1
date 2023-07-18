import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    private Bun bunMock;
    @Mock
    private Ingredient ingredientMock1;
    @Mock
    private Ingredient ingredientMock2;
    @Mock
    private IngredientType ingredientTypeMock1;
    @Mock
    private IngredientType ingredientTypeMock2;

    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        burger.setBuns(bunMock);
        Assert.assertEquals(String.format("ожидаемое значение: %s", bunMock),
                bunMock, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientMock1);
        Assert.assertEquals(String.format("ожидаемое количество ингредиентов в списке: %d", 1),
                1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.ingredients.add(ingredientMock1);
        burger.removeIngredient(0);
        Assert.assertEquals(String.format("ожидаемое количество ингредиентов в списке: %d", 0),
                0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.ingredients.add(ingredientMock1);
        burger.ingredients.add(ingredientMock2);
        Ingredient expectedIngredient = burger.ingredients.get(0);
        burger.moveIngredient(1,0);
        Assert.assertEquals(String.format("ожидаемый ингредиент по индексу %d после перемещения: %s", 1, expectedIngredient),
                expectedIngredient, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        Burger burger = new Burger();
        burger.bun = bunMock;
        burger.ingredients.add(ingredientMock1);
        burger.ingredients.add(ingredientMock2);
        Mockito.when(bunMock.getPrice()).thenReturn(5.0F);
        Mockito.when(ingredientMock1.getPrice()).thenReturn(1.0F);
        Mockito.when(ingredientMock2.getPrice()).thenReturn(2.0F);
        float expectedPrice = 13.0F;
        Assert.assertEquals(String.format("ожидаемая стоимость: %f", expectedPrice),
                expectedPrice, burger.getPrice(), 0.001);
    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        burger.bun = bunMock;
        burger.ingredients.add(ingredientMock1);
        burger.ingredients.add(ingredientMock2);
        Mockito.when(bunMock.getName()).thenReturn("BunMock");
        Mockito.when(ingredientMock1.getName()).thenReturn("ingredientMock1");
        Mockito.when(ingredientMock2.getName()).thenReturn("ingredientMock2");
        Mockito.when(ingredientMock1.getType()).thenReturn(ingredientTypeMock1);
        Mockito.when(ingredientMock2.getType()).thenReturn(ingredientTypeMock2);
        String expectedReceipt =
                String.format("(==== %s ====)%n", "BunMock") +
                        String.format("= %s %s =%n", ingredientTypeMock1.toString().toLowerCase(), "ingredientMock1") +
                        String.format("= %s %s =%n", ingredientTypeMock2.toString().toLowerCase(), "ingredientMock2") +
                        String.format("(==== %s ====)%n", "BunMock") +
                        String.format("%nPrice: %f%n", 0.0F);
        String actualReceipt = burger.getReceipt();
        Mockito.verify(bunMock, Mockito.times(2)).getName();
        Mockito.verify(ingredientMock1, Mockito.times(1)).getName();
        Mockito.verify(ingredientMock2, Mockito.times(1)).getName();
        Mockito.verify(ingredientMock1, Mockito.times(1)).getType();
        Mockito.verify(ingredientMock2, Mockito.times(1)).getType();
        Assert.assertEquals(String.format("ожидаемый рецепт: %s", expectedReceipt),
                expectedReceipt, actualReceipt);
    }
}
