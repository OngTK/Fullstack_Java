package comprehensive.intensify_02_250709;

import java.util.Arrays;
import java.util.Scanner;

public class BankService {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BankController bc = new BankController();

        for (; ; ) {            // 무한루프 start
            System.out.println("=========== KB Bank ===========");
            System.out.println("1.계좌등록 | 2.입금 | 3.출금 | 4.잔고 | 5.계좌이체");
            System.out.println("============================");
            System.out.print("선택 > ");
            int choice = scan.nextInt();    // user이 func을 선택

            if (choice == 1) {              // 선택 1 : 계좌이체 :
                System.out.println("--- 계좌 등록 ---");
                System.out.print("계좌번호 : ");
                String accountNo = scan.next();
                System.out.print("비밀번호 : ");
                int pw = scan.nextInt();

                // 계좌 리스트에 저장하는 메소드 실행 >> return boolean
                boolean result = bc.createAccount(accountNo, pw);

                // 계좌 저장 완료 멘트 출력 > [안내] 계좌 등록이 완료되었습니다.
                if (result) {
                    System.out.println("[안내] 계좌 등록이 완료되었습니다.");
                } else {
                    System.out.println("[경고] 계좌 등록에 실패하였습니다.");
                }

            } else if (choice == 2) {       // 선택 2 : 입금 :
                System.out.println("--- 입금 ---");
                System.out.print("계좌번호 : ");
                String accountNo = scan.next();
                System.out.print("비밀번호 : ");
                int pw = scan.nextInt();
                System.out.print("입금액 : ");
                int money = scan.nextInt();

                // 2. 입금
                // 유효성 검사
                // ture :
                //      해당 계좌번호에 balance에 입금 / return true
                // false : return false

                boolean result = bc.deposit(accountNo, pw, money);

                // 계좌번호, 비밀번호 유효성 검사 > ture : [안내] 입금이 완료되었습니다. / false : [경고] 계좌정보가 일치하지 않습니다.
                if (result) {
                    System.out.println("[안내] 입금이 완료되었습니다.");
                } else {
                    System.out.println("[경고] 계좌정보가 일치하지 않습니다.");
                }
            } else if (choice == 3) {       // 선택 3 : 출금 :
                System.out.println("--- 출금 ---");
                System.out.print("계좌번호 : ");
                String accountNo = scan.next();
                System.out.print("비밀번호 : ");
                int pw = scan.nextInt();
                System.out.print("출금액 : ");
                int money = scan.nextInt();

                // 3. 출금 메소드 실행 >> return int
                // 유효성 검사
                // ture :  ( 잔고 > 출금 )[안내] 출금이 완료되었습니다.  // return 1 : 출금완료
                //         ( 잔고 < 출금) [경고] 잔액이 부족합니다.      // return 2 : 금액부족 출금실패
                // false : [경고] 계좌정보가 일치하지 않습니다.          // return 3 : 유효성검사 false

                int result = bc.withdraw(accountNo, pw, money);
                if(result == 1) {
                    System.out.println("[안내] 출금이 완료되었습니다.");
                }
                else if(result == 2) {
                    System.out.println("[경고] 잔액이 부족합니다.");
                } else {
                    System.out.println("[경고] 계좌정보가 일치하지 않습니다.");
                }

            } else if (choice == 4) {       // 선택 4 : 잔고 :
                System.out.println("--- 잔고 확인 ---");
                System.out.print("계좌번호 : ");
                String accountNo = scan.next();
                System.out.print("비밀번호 : ");
                int pw = scan.nextInt();


                // 4. 잔고 조회 메소드 실행 >> return int
                // 유효성 검사
                // ture :  [잔고] 00원                         // return balance (balance >= 0)
                // false : [경고] 계좌정보가 일치하지 않습니다.    // return -1
                int result = bc.viewBalance(accountNo, pw);
                if (result >= 0){
                    System.out.printf("[잔고] %d원 \n", result);
                } else {
                    System.out.println("[경고] 계좌정보가 일치하지 않습니다.");
                }

            } else if (choice == 5) {       // 선택 5 : 계좌이체 :
                System.out.println("--- 계좌 이체 ---");
                System.out.print("보내는 분 계좌번호 : ");
                String accountNo = scan.next();
                System.out.print("비밀번호 : ");
                int pw = scan.nextInt();
                System.out.print("받는 분 계좌번호 : ");
                String receiveAccountNo = scan.next();
                System.out.print("이체 금액 : ");
                int money = scan.nextInt();

                // 5. 계좌이체
                // 유효성 검사
                // ture :  if (이체금액 > 잔액)
                //        ture : 금액부족                           // return 0
                //        flase : 잔액이 충분 = if 이체할 계좌 검색
                //                              ture  이체 성공      // return 1
                //                              false 이체 실패      // return -2
                // false - 계좌정보 불일치                             // return -1

                int result = bc.transfer(accountNo,pw,receiveAccountNo,money);
                if(result == 0) {
                    System.out.println("[경고] 잔액이 부족합니다.");
                } else if(result == 1) {
                    System.out.println("[안내] 이체가 완료되었습니다.");
                } else if (result == -1) {
                    System.out.println("[경고] 계좌정보가 일치하지 않습니다.");
                } else if (result == -2) {
                    System.out.println("[경고] 받는 분의 계좌번호를 다시 확인해주세요.");
                }

            } else {
                System.out.println("[경고] 올바르지 못한 선택입니다.");
            }// choice if end
        }// 무한루프 end
    }// main end
} // class end
