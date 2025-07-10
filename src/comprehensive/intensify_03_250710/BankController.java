package comprehensive.intensify_03_250710;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BankController {

    // 멤버변수 ============================
    private static final Account[] accounts = new Account[100];

    // 생성자 ============================


    // 메소드 ============================

    // 메소드 0-1. 계좌번호, 비밀번호 유효성 검사
    public static boolean checkAccount(String accountNo, int pw) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null && accounts[i].getAccountNo().equals(accountNo) && accounts[i].getPw() == pw) {
                return true; // 계좌번호, 비밀번호 일치
            }
        }
        return false; // 계좌번호, 비밀번호 불일치
    }


    // 메소드 1. 계좌등록
    public static boolean createAccount(String accountNo, int pw) {
        Account account = new Account(accountNo, pw);
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = account;
                return true;
            }
        }
        return false;
    }
    // 메소드 2. 입금
    // 유효성 확인 true : 입금액 입력 > 계좌정보 balnce 업데이트 + log이력 업데이트
    //            fale : [경고] 계좌 정보를 찾을 수 없습니다.

    public static boolean deposit(String accountNo, int pw, int money) {
        boolean check = BankController.checkAccount(accountNo, pw);
        if (check) { //계좌정보 일치
            for (int i = 0; i < accounts.length; i++) {
                if (accounts[i] != null && accounts[i].getAccountNo().equals(accountNo)) {
                    int balance = accounts[i].getBalance();
                    balance += money;
                    accounts[i].setBalance(balance);
                    AccountLog.setLog(accountNo, "입금", money, balance);
                    return true;
                }
            }
        }
        return false; // 계좌정보 불일치
    }

    // 메소드 3. 출금
    // 유효성 확인 - ture : (잔고 > 출금액) : 정상 출금                   int 1
    //                     (잔고 < 출금액) : [안내] 잔고가 부족합니다.    int 2
    //              false : [경고] 계좌 정보를 찾을 수 없습니다.          int 3
    public static int withdraw(String accountNo, int pw, int money) {
        boolean check = BankController.checkAccount(accountNo, pw);
        if (check) { //계좌정보 일치
            for (int i = 0; i < accounts.length; i++) {
                if (accounts[i] != null && accounts[i].getAccountNo().equals(accountNo)) {
                    int balance = accounts[i].getBalance();
                    if (balance >= money) {
                        balance -= money;
                        accounts[i].setBalance(balance);
                        AccountLog.setLog(accountNo, "출금", money, balance);
                        return 1;
                    } else {
                        return 2;
                    }
                }
            }
        }
        return 3; // 계좌정보 불일치
    }

    // 메소드 4. 잔고
    // 유효성 검사 - true : [잔고] 00원입니다.                    int balance
    //              false : [경고] 계좌 정보를 찾을 수 없습니다.   int -1
    public static int getBalance(String accountNo, int pw) {
        boolean check = BankController.checkAccount(accountNo, pw);
        if (check) { //계좌정보 일치
            for (int i = 0; i < accounts.length; i++) {
                if (accounts[i] != null && accounts[i].getAccountNo().equals(accountNo)) {
                    return accounts[i].getBalance();
                }
            }
        }
        return -1;
    }

    // 메소드 5. 계좌이체
    // 유효성 검사 - true : (잔액 > 이체금액) && (이체계좌 검색) true  int 1 : [안내] 정상적으로 이체되었습니다.
    //                                     &&               flase  int 2 : [경고] 받는 분의 계좌를 찾을 수 없습니다.
    //                                     flase                   int 3 : [안내] 잔액이 부족합니다.
    //              false : [경고] 계좌 정보를 찾을 수 없습니다.       int 4

    public static int transfer(String accountNo, int pw, String receiveAccountNo, int money) {
        boolean check = BankController.checkAccount(accountNo, pw);
        if (check) { //계좌정보 일치
            for (int i = 0; i < accounts.length; i++) {
                if (accounts[i] != null && accounts[i].getAccountNo().equals(accountNo)) {
                    if (accounts[i].getBalance() >= money) {
                        for (int j = 0; j < accounts.length; j++) {
                            if (accounts[j] != null && accounts[j].getAccountNo().equals(receiveAccountNo)) {
                                // 본인 계좌 잔고 수정
                                int my_balance = accounts[i].getBalance();
                                my_balance -= money;
                                accounts[i].setBalance(my_balance);

                                // 상대 계좌 잔고 수정
                                int re_balance = accounts[j].getBalance();
                                re_balance += money;
                                accounts[j].setBalance(re_balance);

                                AccountLog.setLog(accountNo, "이체_출금", money, my_balance);
                                AccountLog.setLog(receiveAccountNo, "이체_입금", money, re_balance);
                                
                                
                                return 1;// 이체성공
                            }
                        }
                        return 2; //int 2 : [경고] 받는 분의 계좌를 찾을 수 없습니다.
                    }
                    return 3; //int 3 : [안내] 잔액이 부족합니다.
                }
            }
        }
        return 4;
    }

    // 메소드 6. 거래내역
    // 유효성 검사 : true                        AccountLog[] accountLogs
    //              flase                       실패
    // >> accountLog class로 이동



}
