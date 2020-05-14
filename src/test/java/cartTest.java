import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.*;

public class cartTest {
    cart cart=new cart();
    @Test
    public void addCommdity() {
        Assert.assertEquals(true,cart.addCommdity("笔记本","联想"));
        Assert.assertEquals(false,cart.addCommdity("手机","华为"));
        Assert.assertEquals(false,cart.addCommdity("手机","良品铺子"));
    }

    @Test
    public void removeCommdity() {
        Assert.assertEquals(false,cart.removeCommdity("手机"));
        Assert.assertEquals(false,cart.removeCommdity("零食"));
    }

    @Test
    public void count() {
        Assert.assertEquals(2,cart.count());
    }
}