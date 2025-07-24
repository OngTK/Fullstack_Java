package comprehensive.intensify_01_250708;

import java.util.Arrays;

public class BankController {
    //멤버변수
    Account[] accountList = new Account[100];

    // 메소드 1. 계좌등록

    boolean createAccount(String accountNo, int pw) {
        Account account = new Account();
        account.accountNo = accountNo;
        account.pw = pw;

        boolean check = false;
        for (int i = 0; i < accountList.length; i++) {
            if (accountList[i] == null) {
                accountList[i] = account;
                check = true;
                System.out.println(Arrays.toString(accountList));
                break;
            }
        }
        return check;
    }

    // 메소드 2. 입금
    // 계좌리스트 조회 > 계좌정보 null 확인 > 계좌번호, 비밀번호가 일치할 경우 입금, 불일치인 경우 입금불가

    boolean deposit(String accountNo, int pw, int balance) {
        boolean check = false;
        for (int i = 0; i < accountList.length; i++) {
            Account account = accountList[i];
            if (account != null) {
                if (account.accountNo.equals(accountNo) && account.pw == pw) {
                    account.balance += balance;
                    System.out.println(Arrays.toString(accountList));
                    check = true;
                    break;
                } else {
                    check = false;
                }
            }
        }
        return check;
    }

    // 메소드 3. 출금
    // 계좌리스트 조회 > 계좌정보 null 확인  > 계좌번호, 비밀번호가 일치 >
    // (출금액>잔고): 경고 / else : 출금 성공

    int withdrawal(String accountNo, int pw, int withdrawAmount) {
        int check = 0;

        for (int i = 0; i < accountList.length; i++) {
            Account account = accountList[i];
            if (account != null) {
                if (account.accountNo.equals(accountNo) && account.pw == pw) {
                    if (account.balance >= withdrawAmount) {
                        account.balance -= withdrawAmount;
                        check = 1;
                        System.out.println(Arrays.toString(accountList));
                        break;
                    } else {
                        check = 2;
                    }
                } else {
                    check = 3;
                }
            }
        }
        return check;
    }

    // 메소드 4. 잔고
    // 계좌리스트 조회 > 계좌정보 null 확인  > 계좌번호, 비밀번호가 일치 > 잔고 출력
    int viewBalance(String accountNo, int pw) {
        int balance = 0;
        for (int i = 0; i < accountList.length; i++) {
            Account account = accountList[i];
            if (account != null) {
                if (account.accountNo.equals(accountNo) && account.pw == pw) {
                    balance = account.balance;
                    System.out.println(Arrays.toString(accountList));
                    break;
                } else {
                    balance = -1;
                }
            }
        }
        return balance;
    }

} //class end