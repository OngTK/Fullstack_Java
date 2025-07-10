package Practice.Practice_10_250710;

public class BankAccount {

    // 멤버변수
    private String accountNumber;

    // 생성자
    BankAccount(){
    }

    BankAccount(String accountNumber){
        this.accountNumber = accountNumber;
    }

    // 메소드

    public String getAccountNumber() {
        return accountNumber;
    }
}
