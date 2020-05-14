import org.junit.Assert;
import org.junit.Test;

public class ATMServiceTest {
    IDBConnection mockDbConnection=new MockDbConnection();
    ATMService atmService=new ATMService(mockDbConnection);

    @Test
    public void withDraw() {
        atmService.withDraw("1",100);
        Assert.assertEquals(200,mockDbConnection.getAccount("1").getBalance());
        atmService.withDraw("3",100);
        Assert.assertEquals("该用户不存在",mockDbConnection.getAccount("3").getBalance());
        atmService.withDraw("1",-100);
        Assert.assertEquals("存储金额不能为负数",mockDbConnection.getAccount("1").getBalance());
    }

    @Test
    public void deposit() {
        atmService.deposit("1",100);
        Assert.assertEquals(400,mockDbConnection.getAccount("1").getBalance());
        atmService.deposit("3",100);
        Assert.assertEquals("该用户不存在",mockDbConnection.getAccount("1").getBalance());
        atmService.deposit("1",-100);
        Assert.assertEquals(300,mockDbConnection.getAccount("1").getBalance());
    }

    @Test
    public void transfer() {
        atmService.transfer("1","2",100);
        Assert.assertEquals(200,mockDbConnection.getAccount("1").getBalance());
        Assert.assertEquals(2100,mockDbConnection.getAccount("2").getBalance());

        atmService.transfer("3","2",100);
        Assert.assertEquals("该用户不存在",mockDbConnection.getAccount("1").getBalance());

        atmService.transfer("1","3",100);
        Assert.assertEquals("被转账用户不存在",mockDbConnection.getAccount("1").getBalance());

        atmService.transfer("1","2",-100);
        Assert.assertEquals("转账金额不能为负",mockDbConnection.getAccount("1").getBalance());

        atmService.transfer("1","2",400);
        Assert.assertEquals("转账金额超过转账者余额",mockDbConnection.getAccount("1").getBalance());
    }

    @Test
    public void inquiry() {
        Assert.assertEquals(300,atmService.inquiry("1"));
        Assert.assertEquals("该用户不存在",atmService.inquiry("3"));
    }
}
