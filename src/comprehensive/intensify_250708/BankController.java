package comprehensive.intensify_250708;

public class BankController {
    //멤버변수
    Account[] accountList = new Account[100];

    // 메소드 1. 계좌등록

    void createAccount(String accountNo, int pw) {
        Account account = new Account();
        account.accountNo = accountNo;
        account.pw = pw;

        for (int i = 0; i < accountList.length; i++) {
            if (accountList[i] == null) {
                accountList[i] = account;
                System.out.println("[안내] 계좌 등록이 완료되었습니다.");
                break;
            }
        }
    }

    // 메소드 2. 입금
    // 계좌리스트 조회 > 계좌정보 null 확인 > 계좌번호, 비밀번호가 일치할 경우 입금, 불일치인 경우 입금불가

    void deposit(String accountNo, int pw, int balance) {
        for (int i = 0; i < accountList.length; i++) {
            Account account = accountList[i];
            if (account != null) {
                if (account.accountNo.equals(accountNo) && account.pw == pw) {
                    account.balance += balance;
                    System.out.println("[안내] 입금이 완료되었습니다.");
                } else {
                    System.out.println("[경고] 계좌정보가 일치하지 않습니다.");
                    break;
                }
            }
        }
    }

    // 메소드 3. 출금
    // 계좌리스트 조회 > 계좌정보 null 확인  > 계좌번호, 비밀번호가 일치 >
    // (출금액>잔고): 경고 / else : 출금 성공

    void withdrawal(String accountNo, int pw, int withdrawAmount) {
        for (int i = 0; i < accountList.length; i++) {
            Account account = accountList[i];
            if (account != null) {
                if (account.accountNo.equals(accountNo) && account.pw == pw) {
                    if (account.balance >= withdrawAmount) {
                        account.balance -= withdrawAmount;
                        System.out.println("[안내] 출금이 완료되었습니다.");
                        break;
                    } else {
                        System.out.println("[경고] 잔액이 부족합니다.");
                        break;
                    }
                } else {
                    System.out.println("[경고] 계좌정보가 일치하지 않습니다.");
                    break;
                }
            }
        }
    }

    // 메소드 4. 잔고
    // 계좌리스트 조회 > 계좌정보 null 확인  > 계좌번호, 비밀번호가 일치 > 잔고 출력
    void viewBalance(String accountNo, int pw) {
        int balance = 0;
        for (int i = 0; i < accountList.length; i++) {
            Account account = accountList[i];
            if (account != null) {
                if (account.accountNo.equals(accountNo) && account.pw == pw) {
                    balance = account.balance;
                    System.out.printf("[잔고] %d원\n",balance);
                } else {
                    System.out.println("[경고] 계좌정보가 일치하지 않습니다.");
                    break;
                }
            }
        }
    }

} //class end