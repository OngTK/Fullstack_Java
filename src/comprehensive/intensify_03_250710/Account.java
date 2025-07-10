package comprehensive.intensify_03_250710;

public class Account {

    // 멤버변수 ============================

    private String accountNo;
    private int pw;
    private int balance;

    // 생성자 ============================

    public Account(String accountNo, int pw) {
        this.accountNo = accountNo;
        this.pw = pw;
        this.balance = 0;
    }

    public Account() {
    }

    // 메소드 ============================


    // getter/setter======================
    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public int getPw() {
        return pw;
    }

    public void setPw(int pw) {
        this.pw = pw;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    // toString========================================
    public String toString() {
        return "Account{" +
                "accountNo='" + accountNo + '\'' +
                ", pw=" + pw +
                ", balance=" + balance +
                '}';
    }
}
