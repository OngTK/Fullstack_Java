package atHome.Practice_bankAccount01.model.dto;

// Dto 역할 : 데이터 모델·이동 객체
public class AccountDto {

    // 멤버변수 : all private ===================================
    private String accountNo;
    private int pw;
    private int balance;

    // 생성자 : 기본생성자와 풀생성자는 기본! 추가는 자유 ===================================
    // 기본 생성자

    public AccountDto() {
    }

    // 풀생성자
    public AccountDto(String accountNo, int pw, int balance) {
        this.accountNo = accountNo;
        this.pw = pw;
        this.balance = balance;
    }

    // 계좌 생성시 balance = 0 초기화된 생성자
    public AccountDto(String accountNo, int pw){
        this.accountNo = accountNo;
        this.pw = pw;
        this.balance =0;
    }

    // 메소드 ======================================================================
    // getter·setter

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

    // toString
    public String toString() {
        return "AccountDto{" +
                "accountNo='" + accountNo + '\'' +
                ", pw=" + pw +
                ", balance=" + balance +
                '}';
    }
}// class end
