package review.Practice_bankAccount01.controller;

import Practice_bankAccount01.model.dao.AccountDao;
import Practice_bankAccount01.model.dao.AccountLogDao;
import Practice_bankAccount01.model.dto.AccountDto;
import Practice_bankAccount01.model.dto.AccountLogDto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Controller 역할 : view >> controller >> dao
// controller는 view에서 매개변수를 받아와서 
// 저장을 위한 작업 후 dao에 전달
// dao로부터 저장 결과를 view로 다시 전달
public class BankController {
    // 싱글톤
    private BankController() {
    }

    private static final BankController controller = new BankController();

    public static BankController getInstance() {
        return controller;
    }

    // 싱글톤 호출
    private AccountDao accountDao = AccountDao.getInstance();
    private AccountLogDao accountLogDao = AccountLogDao.getInstance();

    // 멤버변수로 사용할 dao객체가 저장된 dto배열을 Dto에서 호출
    private static AccountDto[] accountDB = AccountDao.getInstance().getAccountDB();
    private static AccountLogDto[] accountLogDB = AccountLogDao.getInstance().getAccountLogDB();


    // 메소드 생성

    // 0.1. 계좌, 비밀번호 유효성 검사
    static boolean checkAccount(String accountNo, int pw) {
        for (int i = 0; i < accountDB.length; i++) {
            if (accountDB[i] != null && accountDB[i].getAccountNo().equals((accountNo)) && accountDB[i].getPw() == pw) {
                return true;
            }
        }
        return false;
    } // 0.1 func end

    // 0.2. setLog 거래내역 저장
    static void setAccountLogDB(String accountNo, int sort, int money, int currentBalance) {
// logDto의 멤버변수
//                    private int logNo;              // log 고유 번호
//                    private String accountNo;       // 계좌번호
//                    private int sort;               // 구분 /1 입금/2 출금/3 이체_출금/4 이체_입금
//                    private int money;              // 거래금액
//                    private int currentBalance;     // 거래후 잔고
//                    private String date;

        int logNo = 0;
        if (accountLogDB[0] == null) {
            logNo = 1;
        } else {
            for (int i = 0; i < accountLogDB.length; i++) {
                if (accountLogDB[i] != null) {
                    logNo = accountLogDB[i].getLogNo() + 1;
                }
            }
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date = formatter.format(LocalDateTime.now());

        AccountLogDto accountLog = new AccountLogDto(logNo, accountNo, sort, money, currentBalance, date);

        for (int i = 0; i < accountLogDB.length; i++) {
            if (accountLogDB[i] == null) {
                accountLogDB[i] = accountLog;
                return;
            }
        }

    } // 0.2 func end

    // 1. 계좌등록
    public int createAccount(String accountNo, int pw) {
        for (int i = 0; i < accountDB.length; i++) {
            if (accountDB[i] != null && accountDB[i].getAccountNo().equals(accountNo)) {
                return 3; //이미 존재하는 계좌입니다.
            }
        }

        AccountDto accountDto = new AccountDto(accountNo, pw);
        for (int i = 0; i < accountDB.length; i++) {
            if (accountDB[i] == null) {
                accountDB[i] = accountDto;
                return 1;   // 계좌 생성 성공
            }
        }
        return 2;// 계좌 생성 실패
    } // 1 func end

    // 2. 입금
    public boolean deposit(String accountNo, int pw, int money) {
        boolean result = checkAccount(accountNo, pw);
        if (result) {
            for (int i = 0; i < accountDB.length; i++) {
                if (accountDB[i] != null && accountDB[i].getAccountNo().equals((accountNo))) {
                    int balance = accountDB[i].getBalance();
                    balance += money;
                    accountDB[i].setBalance(balance);
                    setAccountLogDB(accountNo, 1, money, balance);
                    return true;
                }
            }
        }
        return false;
    } // 2 func end

    // 3. 출금
    public int withdraw(String accountNo, int pw, int money) {
        boolean result = checkAccount(accountNo, pw);
        if (result) {
            for (int i = 0; i < accountDB.length; i++) {
                if (accountDB[i] != null && accountDB[i].getAccountNo().equals((accountNo))) {
                    int balance = accountDB[i].getBalance();
                    if (balance < money) {
                        return 0;
                    }
                    balance -= money;
                    accountDB[i].setBalance(balance);
                    setAccountLogDB(accountNo, 2, money, balance);
                    return 1;
                }
            }
        }
        return -1;
    } // 3 func end

    // 4. 잔고
    public int getBalance(String accountNo, int pw) {
        boolean result = checkAccount(accountNo, pw);
        if (result) {
            for (int i = 0; i < accountDB.length; i++) {
                if (accountDB[i] != null && accountDB[i].getAccountNo().equals((accountNo))) {
                    int balance = accountDB[i].getBalance();
                    return balance;
                }
            }
        }
        return -1;
    } // 4 func end

    // 5. 계좌이체
    public int transfer(String accountNo, int pw, String depositAccount, int money) {
        boolean check = checkAccount(accountNo, pw);
        if (check) { //계좌정보 일치
            for (int i = 0; i < accountDB.length; i++) {
                if (accountDB[i] != null && accountDB[i].getAccountNo().equals(accountNo)) {
                    if (accountDB[i].getBalance() >= money) {
                        for (int j = 0; j < accountDB.length; j++) {
                            if (accountDB[j] != null && accountDB[j].getAccountNo().equals(depositAccount)) {
                                // 본인 계좌 잔고 수정
                                int my_balance = accountDB[i].getBalance();
                                my_balance -= money;
                                accountDB[i].setBalance(my_balance);

                                // 상대 계좌 잔고 수정
                                int re_balance = accountDB[j].getBalance();
                                re_balance += money;
                                accountDB[j].setBalance(re_balance);

                                setAccountLogDB(accountNo, 3, money, my_balance);
                                setAccountLogDB(depositAccount, 4, money, re_balance);

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
    } // 5 func end

    // 6. 거래내역
    public void getAccountLog(String accountNo, int pw) {
        boolean result = checkAccount(accountNo, pw);
        if (result) {
            for (int i = 0; i < accountLogDB.length; i++) {
                if (accountLogDB[i] != null && accountLogDB[i].getAccountNo().equals(accountNo)) {
                    String plus = "";
                    if (accountLogDB[i].getSort() == 1 || accountLogDB[i].getSort() == 4) {
                        plus = "+";
                    } else {
                        plus = "-";
                    }

                    String sort = "";
                    if (accountLogDB[i].getSort() == 1) {
                        sort = "입금";
                    } else if (accountLogDB[i].getSort() == 2) {
                        sort = "출금";
                    } else {
                        sort = "이체";
                    }

                    System.out.printf("[%s]\t%s\t|\t%s%d원\t|\t잔액: %d원 \n", accountLogDB[i].getDate(), sort, plus, accountLogDB[i].getMoney(), accountLogDB[i].getCurrentBalance());
                }
            }
        } else {
            System.out.println("[경고] 계좌 정보를 찾을 수 없습니다. ");
        }

    } // 6 func end


}// class end
