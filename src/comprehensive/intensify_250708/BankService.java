package comprehensive.intensify_250708;

import java.util.Scanner;

public class BankService {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        BankController ct = new BankController();

        for (; ; ) {
            System.out.println("============== KB Bank  ==============");
            System.out.println("1.계좌등록 | 2.입금 | 3.출금 | 4.잔고");
            System.out.println("======================================");
            System.out.print("선택 >");
            int choice = scan.nextInt();
            ;

            if (choice == 1) { // 1. 계좌 등록
                System.out.println("--- 계좌 등록 ---");
                System.out.print("계좌번호 : ");
                String accountNo = scan.next();
                System.out.print("비밀번호 : ");
                int pw = scan.nextInt();

                ct.createAccount(accountNo, pw);

            } else if (choice == 2) { // 2. 입금
                System.out.println("--- 입금 ---");
                System.out.print("계좌번호 : ");
                String accountNo = scan.next();
                System.out.print("비밀번호 : ");
                int pw = scan.nextInt();
                System.out.print("입금액 : ");
                int balance = scan.nextInt();

                ct.deposit(accountNo, pw, balance);

            } else if (choice == 3) { // 3. 출금
                System.out.println("--- 출금 ---");
                System.out.print("계좌번호 : ");
                String accountNo = scan.next();
                System.out.print("비밀번호 : ");
                int pw = scan.nextInt();
                System.out.print("출금액 : ");
                int withdrawAmount = scan.nextInt();

                ct.withdrawal(accountNo,pw,withdrawAmount);

            } else if (choice == 4) { // 4. 잔고
                System.out.println("--- 잔고 확인 ---");
                System.out.print("계좌번호 : ");
                String accountNo = scan.next();
                System.out.print("비밀번호 : ");
                int pw = scan.nextInt();

                ct.viewBalance(accountNo, pw);

            } else {
                System.out.println("[경고] 올바르지 못한 기능입니다.");
            }
            // choice 관련 if end
        } //무한루프 end
    } // main end
} // class end
