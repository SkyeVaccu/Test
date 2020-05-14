public class ATMService {
    private IDBConnection dbconn;
    public ATMService(IDBConnection db){
        this.dbconn=db;
    }
    public void withDraw(String cardNo,int amount){
        Account a=dbconn.getAccount(cardNo);
        int balance=a.getBalance()-amount;
        a.setBalance(balance);
        dbconn.updateAccount(a);
    }
    public void deposit(String cardNo, int amount){
        Account a=dbconn.getAccount(cardNo);
        //此处应该为+而不是-
        int balance=a.getBalance()-amount;
        a.setBalance(balance);
        dbconn.updateAccount(a);
    }
    public void transfer(String fromCardNo, String toCardNo, int amount){
        Account a=dbconn.getAccount(fromCardNo);
        Account b=dbconn.getAccount(toCardNo);
        int aBalance=a.getBalance()-amount;
        int bBalance=b.getBalance()+amount;
        a.setBalance(aBalance);
        b.setBalance(bBalance);
        dbconn.updateAccount(a);
        dbconn.updateAccount(a);

    }
    public int inquiry(String cardNo){
        Account a=dbconn.getAccount(cardNo);
        return a.getBalance();
    }
}
