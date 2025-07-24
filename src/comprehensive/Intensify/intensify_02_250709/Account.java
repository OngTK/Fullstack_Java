package comprehensive.intensify_02_250709;

// 계좌 정보 설계도

public class Account {

    // 멤버변수
    String accountNo;      // 계좌번호
    int pw;         // 비밀번호
    int balance;    // 잔액

    // 생성자
    Account(){}

    Account(String accountNo, int pw){
        this.accountNo = accountNo;
        this.pw = pw;
        balance = 0;
    }
}
