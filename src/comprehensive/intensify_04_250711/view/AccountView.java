package comprehensive.intensify_04_250711.view;


import java.util.Scanner;

// View 역할 : 게시물 관련 입출력
public class AccountView {
    // 0. 싱글톤 만들기 =================================
    // 화면 출력 이라는 기능은 전체 중 유일한 일이므로 >> 싱글톤
    // 0.1. 기본 생성자를 private화
    private AccountView() {
    }

    // 0.2. `private static final` instance 선언
    private static final AccountView accountView = new AccountView();

    // 0.3. `public static` getInstance 메소드
    public static AccountView getInstance() {
        return accountView;
    }

    // 0. 여러 메소드에서 사용할 입력 객체를 입력변수로 선언 =================================

    private Scanner scan = new Scanner(System.in);

    // 1. main view : 최초로 보이는 화면 구성 =================================

    public void index() {
        for (; ; ) {                        //infinity roofing start
            System.out.println("============= KB Bank ============");
            System.out.println("1.계좌등록 | 2.입금 | 3.출금 | 4.잔고 | 5.계좌이체 | 6.거래내역");
            System.out.println("===============================");
            System.out.print("선택 > ");
            int choice = scan.nextInt();

            if (choice == 1) {
                // createAccount
            } else if (choice == 2) {
                // deposit
            } else if (choice == 3) {
                // withdraw
            } else if (choice == 4) {
                // getBalance
            } else if (choice == 5) {
                // transfer
            } else if (choice == 6) {
                // getAccountLog
            } else {
                System.out.println("[안내] 잘못된 기능입니다.");
            }

        }
    }

    // 2. func


}//class end