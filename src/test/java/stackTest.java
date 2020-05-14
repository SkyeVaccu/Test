import org.junit.Assert;
import org.junit.Test;

public class stackTest {
    Stack<Integer> stack=new Stack<>();

    @Test
    public void push() {
        stack.arrayList.add(1);
        stack.arrayList.add(2);
        Assert.assertEquals(true,stack.push(1));
    }

    @Test
    public void pop() {
        stack.arrayList.add(1);
        stack.arrayList.add(2);
        Assert.assertEquals(2,(int)(stack.pop()));
        stack.arrayList.clear();
        Assert.assertEquals(null,(stack.pop()));
    }

    @Test
    public void getTop() {
        stack.arrayList.add(1);
        stack.arrayList.add(2);
        Assert.assertEquals(1,(int)(stack.getTop()));
        stack.arrayList.clear();
        Assert.assertEquals(null,(stack.getTop()));
    }
}