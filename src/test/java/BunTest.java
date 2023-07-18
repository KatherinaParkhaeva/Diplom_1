import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
public class BunTest {
    private String bunName = "bun stab";
    private float bunPrice = 123.0F;
    private Bun bun = new Bun(bunName, bunPrice);
    @Test
    public void getNameTest() {
        String actualName = bun.getName();
        Assert.assertEquals(String.format("ожидаемое значение: %s", bunName),
                bunName, actualName);

    }
    @Test
    public void getPriceTest() {
        float actualPrice = bun.getPrice();
        Assert.assertEquals(String.format("ожидаемое значение: %f", bunPrice),
                bunPrice, actualPrice, 0.001);
    }
}
