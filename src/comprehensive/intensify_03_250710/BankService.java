package comprehensive.intensify_03_250710;

import java.util.Scanner;

// BankService 에서만 입출력을 합니다.
public class BankService {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        for (; ; ) {                        //infinity roofing start
            System.out.println("============= KB Bank ============");
            System.out.println("1.계좌등록 | 2.입금 | 3.출금 | 4.잔고 | 5.계좌이체 | 6.거래내역");
            System.out.println("===============================");
            System.out.print("선택 > ");
            int choice = scan.nextInt();

            if (choice == 1) {                                              // 1. 계좌등록
                System.out.print("계좌번호 : ");
                String accountNo = scan.next();
                System.out.print("비밀번호 : ");
                int pw = scan.nextInt();

                // ture : 성공 / false : 실패
                boolean result = BankController.createAccount(accountNo, pw);
                if (result) {
                    System.out.println("[안내] 계좌 등록이 완료되었습니다.");
                } else {
                    System.out.println("[안내] 계좌 등록을 실패하였습니다.");
                }

            } else if (choice == 2) {                                       // 2. 입금
                System.out.print("계좌번호 : ");
                String accountNo = scan.next();
                System.out.print("비밀번호 : ");
                int pw = scan.nextInt();
                System.out.print("입금액 : ");
                int money = scan.nextInt();

                // true : 계좌정보 확인 완료 && 입금완려 / fasle : 계좌정보 불일치
                boolean result = BankController.deposit(accountNo, pw, money);
                if (result) {
                    System.out.println("[안내] 입금이 완료되었습니다.");
                } else {
                    System.out.println("[경고] 계좌 정보를 찾을 수 없습니다.");
                }


            } else if (choice == 3) {                                       // 3. 출금
                System.out.print("계좌번호 : ");
                String accountNo = scan.next();
                System.out.print("비밀번호 : ");
                int pw = scan.nextInt();
                System.out.print("출금액 : ");
                int money = scan.nextInt();

                int result = BankController.withdraw(accountNo, pw, money);
                // 유효성 확인 - ture : (잔고 > 출금액) : 정상 출금                   int 1
                //                     (잔고 < 출금액) : [안내] 잔고가 부족합니다.    int 2
                //              false : [경고] 계좌 정보를 찾을 수 없습니다.          int 3
                if (result == 1) {
                    System.out.println("[안내] 정상 출금되었습니다.");
                } else if (result == 2) {
                    System.out.println("[안내] 잔액이 부족합니다.");
                } else {
                    System.out.println("[경고] 계좌 정보를 찾을 수 없습니다.");
                }

            } else if (choice == 4) {                                       // 4. 잔고
                System.out.print("계좌번호 : ");
                String accountNo = scan.next();
                System.out.print("비밀번호 : ");
                int pw = scan.nextInt();
                int result = BankController.getBalance(accountNo, pw);

                // 유효성 검사 - true : [잔고] 00원입니다.                    int balance
                //              false : [경고] 계좌 정보를 찾을 수 없습니다.   int -1
                if (result == -1) {
                    System.out.println("[경고] 계좌 정보를 찾을 수 없습니다. ");
                } else {
                    System.out.printf("[잔고] %d원입니다.\n", result);
                }

            } else if (choice == 5) {                                       // 5. 계좌이체
                System.out.print("계좌번호 : ");
                String accountNo = scan.next();
                System.out.print("비밀번호 : ");
                int pw = scan.nextInt();
                System.out.print("받는 분 계좌번호 : ");
                String receiveAccountNo = scan.next();
                System.out.print("이체금액 : ");
                int money = scan.nextInt();

                int result = BankController.transfer(accountNo, pw, receiveAccountNo, money);

                // 메소드 5. 계좌이체
                // 유효성 검사 - true : (잔액 > 이체금액) && (이체계좌 검색) true  int 1 : [안내] 정상적으로 이체되었습니다.
                //                                     &&               flase  int 2 : [경고] 받는 분의 계좌를 찾을 수 없습니다.
                //                                     flase                   int 3 : [안내] 잔액이 부족합니다.
                //              false : [경고] 계좌 정보를 찾을 수 없습니다.       int 4

                if (result == 1) {
                    System.out.println("[안내] 정상적으로 이체되었습니다.");
                } else if (result == 2) {
                    System.out.println("[경고] 받는 분의 계좌를 찾을 수 없습니다.");
                } else if (result == 3) {
                    System.out.println("[안내] 잔액이 부족합니다.");
                } else {
                    System.out.println("[경고] 계좌 정보를 찾을 수 없습니다. ");
                }

            } else if (choice == 6) {                                       // 6. 거래내역
                System.out.print("계좌번호 : ");
                String accountNo = scan.next();
                System.out.print("비밀번호 : ");
                int pw = scan.nextInt();

                // 유효성 검사 : true                        AccountLog[] accountLogs
                //              flase                       실패

                boolean check = BankController.checkAccount(accountNo, pw);
                if (check){
                    AccountLog[] accountLogs = AccountLog.getlog();

                    for(int i = 0 ; i < accountLogs.length ; i++){
                        if(accountLogs[i] != null && accountLogs[i].getAccountNo().equals(accountNo)){
                            String plus = "";
                            if(accountLogs[i].getSort() == "입금" ||accountLogs[i].getSort() == "이체_입금" ){
                                plus = "+";
                            } else {
                                plus = "-";
                            }
                            System.out.printf("[%s]\t%s\t|\t%s%d원\t|\t잔액: %d원 \n",accountLogs[i].getDate(),accountLogs[i].getSort(),plus,accountLogs[i].getMoney(),accountLogs[i].getBalance());
                        }
                    }

                } else {
                    System.out.println("[경고] 계좌 정보를 찾을 수 없습니다. ");
                }

            } else {
                System.out.println("[경고] 잘못된 선택입니다.");
            }


        }//infinity roofing end
    } // main end
} // class end
