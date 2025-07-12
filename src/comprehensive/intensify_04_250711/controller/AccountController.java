package comprehensive.intensify_04_250711.controller;

import comprehensive.intensify_04_250711.model.dao.AccountDao;
import comprehensive.intensify_04_250711.model.dao.AccountLogDao;
import comprehensive.intensify_04_250711.model.dto.AccountDto;
import comprehensive.intensify_04_250711.model.dto.AccountLogDto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Controller 역할 : 통신
public class AccountController {

    // 싱글톤 선언
    private AccountController(){}
    private static final AccountController controller = new AccountController();
    public static AccountController getInstance(){
        return controller;
    }

    // 싱글톤 호출
    private AccountDao accountDao = AccountDao.getInstance();
    private AccountLogDao accountLogDao = AccountLogDao.getInstance();

    //멤버변수로 사용할 것들 호출
    private static AccountDto[] accountDB = AccountDao.getInstance().accountPrint();
    private static AccountLogDto[] accountLogDB = AccountLogDao.getInstance().printAcoountLog();


    // 2.0.1. 유효성검사/checkAccount/계좌번호, 비밀번호 검사
    public static boolean checkAccount(String accountNo, int pw) {
        for (int i = 0; i < accountDB.length; i++) {
            if (accountDB[i] != null && accountDB[i].getAccountNo().equals(accountNo) && accountDB[i].getPw() == pw) {
                return true; // 계좌번호, 비밀번호 일치
            }
        }
        return false; // 계좌번호, 비밀번호 불일치
    }

    // 2.0.2. setLog(String accountNo, String sort, int money, int balance) 거래내역 저장
    public static void setLog(String accountNo, String sort, int money, int balance) {
        // logNo
        int logNoInput = 0;
        for (int i = 0; i < accountLogDB.length; i++) {
            if (accountLogDB[0] == null){
                logNoInput = 1;
            }else if (accountLogDB[i] != null) {
                logNoInput = accountLogDB[i].getLogNo() + 1;
            }
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String now = formatter.format(LocalDateTime.now());

        AccountLogDto accountLogDto = new AccountLogDto(logNoInput, accountNo, sort, money, balance, now);

        for(int i = 0; i < accountLogDB.length; i++){
            if (accountLogDB[i] == null){
                accountLogDB[i] = accountLogDto;
                return;
            }
        }
    }

    // 2.0.3. 계좌등록 시 겹치는 계좌번호가 있는지 유효성 검사

    // 2.1. createAccount() 계좌등록
    public boolean createAccount(String accountNo, int pw){;
        AccountDto account = new AccountDto(accountNo, pw);
        for (int i = 0; i < accountDB.length; i++) {
            if (accountDB[i] == null) {
                accountDB[i] = account;
                return true;
            }
        }
        return false;
    }

    // 2.2. deposit() 출금
    // 유효성 확인 true : 입금액 입력 > 계좌정보 balnce 업데이트 + log이력 업데이트
    //            fale : [경고] 계좌 정보를 찾을 수 없습니다.

    public boolean deposit(String accountNo, int pw, int money) {
        boolean check = AccountController.checkAccount(accountNo, pw);
        if (check) { //계좌정보 일치
            for (int i = 0; i < accountDB.length; i++) {
                if (accountDB[i] != null && accountDB[i].getAccountNo().equals(accountNo)) {
                    int balance = accountDB[i].getBalance();
                    balance += money;
                    accountDB[i].setBalance(balance);

                    AccountController.setLog(accountNo,"입금",money,balance);

                    return true;
                }
            }
        }
        return false; // 계좌정보 불일치
    }


    // 2.3. withdraw() 출금
    // 유효성 확인 - ture : (잔고 > 출금액) : 정상 출금                   int 1
    //                     (잔고 < 출금액) : [안내] 잔고가 부족합니다.    int 2
    //              false : [경고] 계좌 정보를 찾을 수 없습니다.          int 3
    public int withdraw(String accountNo, int pw, int money) {
        boolean check = AccountController.checkAccount(accountNo, pw);
        if (check) { //계좌정보 일치
            for (int i = 0; i < accountDB.length; i++) {
                if (accountDB[i] != null && accountDB[i].getAccountNo().equals(accountNo)) {
                    int balance = accountDB[i].getBalance();
                    if (balance >= money) {
                        balance -= money;
                        accountDB[i].setBalance(balance);
                        AccountController.setLog(accountNo, "출금", money, balance);
                        return 1;
                    } else {
                        return 2;
                    }
                }
            }
        }
        return 3; // 계좌정보 불일치
    }

    // 2.4. getBalance() 잔고확인
    // 유효성 검사 - true : [잔고] 00원입니다.                    int balance
    //              false : [경고] 계좌 정보를 찾을 수 없습니다.   int -1
    public  int getBalance(String accountNo, int pw) {
        boolean check = AccountController.checkAccount(accountNo, pw);
        if (check) { //계좌정보 일치
            for (int i = 0; i < accountDB.length; i++) {
                if (accountDB[i] != null && accountDB[i].getAccountNo().equals(accountNo)) {
                    return accountDB[i].getBalance();
                }
            }
        }
        return -1;
    }

    // 2.5. transfer() 이체
    // 유효성 검사 - true : (잔액 > 이체금액) && (이체계좌 검색) true  int 1 : [안내] 정상적으로 이체되었습니다.
    //                                     &&               flase  int 2 : [경고] 받는 분의 계좌를 찾을 수 없습니다.
    //                                     flase                   int 3 : [안내] 잔액이 부족합니다.
    //              false : [경고] 계좌 정보를 찾을 수 없습니다.       int 4

    public int transfer(String accountNo, int pw, String receiveAccountNo, int money) {
        boolean check = AccountController.checkAccount(accountNo, pw);
        if (check) { //계좌정보 일치
            for (int i = 0; i < accountDB.length; i++) {
                if (accountDB[i] != null && accountDB[i].getAccountNo().equals(accountNo)) {
                    if (accountDB[i].getBalance() >= money) {
                        for (int j = 0; j < accountDB.length; j++) {
                            if (accountDB[j] != null && accountDB[j].getAccountNo().equals(receiveAccountNo)) {
                                // 본인 계좌 잔고 수정
                                int my_balance = accountDB[i].getBalance();
                                my_balance -= money;
                                accountDB[i].setBalance(my_balance);

                                // 상대 계좌 잔고 수정
                                int re_balance = accountDB[j].getBalance();
                                re_balance += money;
                                accountDB[j].setBalance(re_balance);

                                AccountController.setLog(accountNo, "이체_출금", money, my_balance);
                                AccountController.setLog(receiveAccountNo, "이체_입금", money, re_balance);

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

    // 2.6. getAccountLog() 거래이력
    public void getAccountLog(String accountNo, int pw){
        String result = "";
        boolean check = AccountController.checkAccount(accountNo, pw);
        if (check){

            for(int i = 0 ; i < accountLogDB.length ; i++){
                if(accountLogDB[i] != null && accountLogDB[i].getAccountNo().equals(accountNo)){
                    String plus = "";
                    if(accountLogDB[i].getSort().equals("입금")  || accountLogDB[i].getSort().equals("이체_입금") ){
                        plus = "+";
                    } else {
                        plus = "-";
                    }
                    System.out.printf("[%s]\t%s\t|\t%s%d원\t|\t잔액: %d원 \n",accountLogDB[i].getDate(),accountLogDB[i].getSort(),plus,accountLogDB[i].getMoney(),accountLogDB[i].getBalance());
                }
            }
        } else {
            System.out.println("[경고] 계좌 정보를 찾을 수 없습니다. ");
        }
    }

}
