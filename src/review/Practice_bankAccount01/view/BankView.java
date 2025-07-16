package review.Practice_bankAccount01.view;


import review.Practice_bankAccount01.controller.BankController;

import java.util.Scanner;

// View 역할 : 게시물 관련 입출력
public class BankView {
    // 0. 싱글톤 만들기 =================================
    // 화면 출력 이라는 기능은 전체 중 유일한 일이므로 >> 싱글톤
    // 0.1. 기본 생성자를 private화
    // 0.2. `private static final` instance 선언
    // 0.3. `public static` getInstance 메소드
    private BankView() {
    }

    private static final BankView bankView = new BankView();

    public static BankView getInstance() {
        return bankView;
    }

    // 0. 여러 메소드에서 사용할 입력 객체를 입력변수로 선언 =================================
    private Scanner scan = new Scanner(System.in);
    private BankController controller = BankController.getInstance();

    // 1. main view : 최초로 보이는 화면 구성 =================================
    public void index() {
        for (; ; ) {
            System.out.println("========================= KB Bank =========================");
            System.out.println("1.계좌등록 | 2.입금 | 3.출금 | 4.잔고 | 5.계좌이체 | 6.거래내역");
            System.out.println("===========================================================");
            System.out.print("선택 > ");
            int choice = scan.nextInt();

            System.out.print("계좌번호 : ");
            String accountNo = scan.next();
            System.out.print("비밀번호 : ");
            int pw = scan.nextInt();

            if (choice == 1) {
                createAccount(accountNo, pw);
            } else if (choice == 2) {
                System.out.print("입금액 : ");
                int money = scan.nextInt();
                deposit(accountNo, pw, money);
            } else if (choice == 3) {
                System.out.print("출금액 : ");
                int money = scan.nextInt();
                withdraw(accountNo, pw, money);
            } else if (choice == 4) {
                getBalance(accountNo, pw);
            } else if (choice == 5) {
                System.out.print("받는 분 계좌 : ");
                String depositAccount = scan.next();
                System.out.print("이체 금액 : ");
                int money = scan.nextInt();
                trasfer(accountNo, pw, depositAccount, money);
            } else if (choice == 6) {
                getAccountLog(accountNo, pw);
            } else {
                System.out.println("[경고] 올바르지 않은 기능입니다.");
            }
        }
    }

    // 2. func
    // 1. 계좌생성
    public void createAccount(String accountNo, int pw) {
        int result = controller.createAccount(accountNo, pw);
        if (result == 1) {
            System.out.println("[안내] 계좌 등록이 완료되었습니다.");
        } else if (result == 2) {
            System.out.println("[안내] 계좌 등록을 실패하였습니다.");
            System.out.println();
        } else if (result == 3) {
            System.out.println("[안내] 이미 존재하는 계좌입니다.");
        }
    }

    // 2. 입금
    public void deposit(String accountNo, int pw, int money) {
        boolean result = controller.deposit(accountNo, pw, money);
        // true : 계좌정보 확인 완료 && 입금완료 / false : 계좌정보 불일치
        if (result) {
            System.out.println("[안내] 입금이 완료되었습니다.");
        } else {
            System.out.println("[경고] 계좌 정보를 찾을 수 없습니다.");
        }
    }

    // 3. 출금
    public void withdraw(String accountNo, int pw, int money) {
        int result = controller.withdraw(accountNo, pw, money);
        // 유효성 확인 - ture : (잔고 > 출금액) : 정상 출금                   int 1
        //                     (잔고 < 출금액) : [안내] 잔고가 부족합니다.    int 0
        //              false : [경고] 계좌 정보를 찾을 수 없습니다.          int -1
        if (result == 1) {
            System.out.println("[안내] 정상 출금되었습니다.");
        } else if (result == 0) {
            System.out.println("[안내] 잔액이 부족합니다.");
        } else {
            System.out.println("[경고] 계좌 정보를 찾을 수 없습니다.");
        }
    }

    // 4. 잔액
    public void getBalance(String accountNo, int pw) {
        int result = controller.getBalance(accountNo, pw);
        // 유효성 검사 - true : [잔고] 00원입니다.                    int balance
        //              false : [경고] 계좌 정보를 찾을 수 없습니다.   int -1
        if (result == -1) {
            System.out.println("[경고] 계좌 정보를 찾을 수 없습니다. ");
        } else {
            System.out.printf("[잔고] %d원입니다.\n", result);
        }
    }

    // 5. 계좌이체
    public void trasfer(String accountNo, int pw, String depositAccount, int money) {
        int result = controller.transfer(accountNo, pw, depositAccount, money);
        // 유효성 검사 - true : (잔액 > 이체금액) && (이체계좌 검색) true  int 1 : [안내] 정상적으로 이체되었습니다.
        //                                     &&               flase  int -2 : [경고] 받는 분의 계좌를 찾을 수 없습니다.
        //                                     flase                   int 0 : [안내] 잔액이 부족합니다.
        //              false : [경고] 계좌 정보를 찾을 수 없습니다.       int -1
        if (result == 1) {
            System.out.println("[안내] 정상적으로 이체되었습니다.");
        } else if (result == 0) {
            System.out.println("[안내] 잔액이 부족합니다. ");
        } else if (result == -1) {
            System.out.println("[경고] 계좌 정보를 찾을 수 없습니다.");
        } else {
            System.out.println("[경고] 받는 분의 계좌를 찾을 수 없습니다.");
        }
    }

    // 6. 거래내역
    public void getAccountLog(String accountNo, int pw) {
        controller.getAccountLog(accountNo,pw);
    }

} //class end
