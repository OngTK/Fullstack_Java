package comprehensive.intensify_02_250709;

import java.util.Arrays;

public class BankController {

    //멤버변수
    Account[] accounts = new Account[100];

    // 1. 계좌 등록
    boolean createAccount(String accountNo, int pw) {
        Account account = new Account(accountNo, pw);      // 생성자 활용, 새로운 계좌 객체 생성
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = account;
//                System.out.println(Arrays.toString(accounts));
//                System.out.println(accounts[i].accountNo + accounts[i].pw );
                return true;
            }
        }
        return false;
    }

    // 2. 입금
    // 0(계좌번호, 비밀번호 메소드 실행)
    // ture :
    //      해당 계좌번호에 balance에 입금 / return true
    // false : return false
    boolean deposit(String accountNo, int pw, int money) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null && accounts[i].accountNo.equals(accountNo) && accounts[i].pw == pw) {
                accounts[i].balance += money;
//                System.out.println(Arrays.toString(accounts));
//                System.out.println(accounts[i].accountNo + accounts[i].pw );
                return true;
            }
        }
        System.out.println(Arrays.toString(accounts));
        return false;
    }

    // 3. 출금 메소드 실행 >> return boolean
    // 계좌번호, 비밀번호 유효성 검사
    // ture :  (잔고 > 출금 )[안내] 출금이 완료되었습니다. / (잔고 < 출금) [경고] 잔액이 부족합니다.
    // false : [경고] 계좌정보가 일치하지 않습니다.

    int withdraw(String accountNo, int pw, int money) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null && accounts[i].accountNo.equals(accountNo) && accounts[i].pw == pw) {
                if (accounts[i].balance >= money) {
                    accounts[i].balance -= money;
//                    System.out.println(Arrays.toString(accounts));
//                    System.out.println(accounts[i].accountNo + accounts[i].pw );
                    return 1; // 출금완료
                } else {
//                    System.out.println(Arrays.toString(accounts));
//                    System.out.println(accounts[i].accountNo + accounts[i].pw );
                    return 2; // 출금실패 : 금액부족
                }
            }
        }
//        System.out.println(Arrays.toString(accounts));
        return 3;
    }

    // 4. 잔고 조회 메소드 실행 >> return balance
    // 계좌번호, 비밀번호 유효성 검사
    // ture :  [잔고] 00원
    // false : [경고] 계좌정보가 일치하지 않습니다.

    int viewBalance(String accountNo, int pw) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null && accounts[i].accountNo.equals(accountNo) && accounts[i].pw == pw) {
//                System.out.println(Arrays.toString(accounts));
//                System.out.println(accounts[i].accountNo + accounts[i].pw );
                return accounts[i].balance;
            }
        }
        System.out.println(Arrays.toString(accounts));
        return -1; // 계좌정보 불일치
    }

    // 계좌이체 fun >> return boolen
    // 계좌번호, 비밀번호 유효성 검사
    // true
    //      받는분 계좌번호에 대한 유효성 검사
    //          ture : [안내] 이체가 완료되었습니다.
    //          false : [경고] 받는 분의 계좌번호를 다시 확인해주세요.
    // false : 계좌정보가 일치하지 않습니다.

    int transfer(String accountNo, int pw, String receiveAccountNo, int money) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null && accounts[i].accountNo.equals(accountNo) && accounts[i].pw == pw) {
                if (accounts[i].balance < money) {
//                    System.out.println(Arrays.toString(accounts));
//                    System.out.println(accounts[i].accountNo + accounts[i].pw );
                    return -1;// 금액부족
                } else {
                    for (int j = 0; j < accounts.length; j++) {
                        if (accounts[j] != null && accounts[j].accountNo.equals(receiveAccountNo)) {
                            accounts[i].balance -= money;
                            accounts[j].balance += money;
//                            System.out.println(Arrays.toString(accounts));
//                            System.out.println(accounts[i].accountNo + accounts[i].pw );
                            return 1;// 이체성공
                        }
                    }
                    return -2 ;// 이체할 계좌 확인 불가
                }
            }
        }
//        System.out.println(Arrays.toString(accounts));
        return 0; // 계좌정보 불일치
    }
}
