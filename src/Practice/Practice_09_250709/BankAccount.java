package Practice.Practice_09_250709;

public class BankAccount {
    // 멤버변수
    String accountNumber;
    String ownerName;
    int balance;

    // 생성자
    // 1. 기본 생성자
    BankAccount() {
    }

    // 2. 매개변수 포함 생성자
    BankAccount(String accountNumber, String ownerName, int balance) {
    this.accountNumber = accountNumber;
    this.ownerName = ownerName;
    this.balance = balance;
    }

    // 메소드

    void deposit(int money){
        balance += money;
    }
    void  withdraw(int money){
        balance -= money;
    }


}
