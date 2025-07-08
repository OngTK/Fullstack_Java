package comprehensive.intensify_250708;

import java.util.Arrays;
import java.util.Scanner;

public class BankService {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        BankController ct = new BankController();

        for (; ; ) {
            System.out.println("============== KB Bank  ==============");
            System.out.println("1.계좌등록 | 2.입금 | 3.출금 | 4.잔고");
            System.out.println("======================================");
            System.out.print("선택 > ");
            int choice = scan.nextInt();

            if (choice == 1) {                      // 1. 계좌 등록
                System.out.println("--- 계좌 등록 ---");
                System.out.print("계좌번호 : ");
                String accountNo = scan.next();
                System.out.print("비밀번호 : ");
                int pw = scan.nextInt();

                boolean result = ct.createAccount(accountNo, pw);
                if (result) {
                    System.out.println("[안내] 계좌 등록이 완료되었습니다.");
                }

            } else if (choice == 2) {               // 2. 입금
                System.out.println("--- 입금 ---");
                System.out.print("계좌번호 : ");
                String accountNo = scan.next();
                System.out.print("비밀번호 : ");
                int pw = scan.nextInt();
                System.out.print("입금액 : ");
                int balance = scan.nextInt();

                boolean result = ct.deposit(accountNo, pw, balance);
                if (result) {
                    System.out.println("[안내] 입금이 완료되었습니다.");
                } else {
                    System.out.println("[경고] 계좌정보가 일치하지 않습니다.");
                }

            } else if (choice == 3) {               // 3. 출금
                System.out.println("--- 출금 ---");
                System.out.print("계좌번호 : ");
                String accountNo = scan.next();
                System.out.print("비밀번호 : ");
                int pw = scan.nextInt();
                System.out.print("출금액 : ");
                int withdrawAmount = scan.nextInt();

                int result = ct.withdrawal(accountNo, pw, withdrawAmount);
                if (result == 1) {
                    System.out.println("[안내] 출금이 완료되었습니다.");
                } else if (result == 2) {
                    System.out.println("[경고] 잔액이 부족합니다.");
                } else if (result == 3) {
                    System.out.println("[경고] 계좌정보가 일치하지 않습니다.");
                }

            } else if (choice == 4) {                // 4. 잔고
                System.out.println("--- 잔고 확인 ---");
                System.out.print("계좌번호 : ");
                String accountNo = scan.next();
                System.out.print("비밀번호 : ");
                int pw = scan.nextInt();

                int result = ct.viewBalance(accountNo, pw);
                if (result >= 0) {
                    System.out.printf("[잔고] %d원\n", result);
                } else {
                    System.out.println("[경고] 계좌정보가 일치하지 않습니다.");
                }
            } else {
                System.out.println("[경고] 올바르지 못한 기능입니다.");
            }
            // choice 관련 if end
        } //무한루프 end
    } // main end
} // class end
