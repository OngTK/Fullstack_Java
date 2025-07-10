package comprehensive.Practice_03_250708;

//    2. 메인 프로그램 흐름 구현하기 (WaitingService의 main 함수)
//        · WaitingController 객체를 하나 생성합니다. WaitingController controller = new WaitingController();
//        · for(;;) 무한루프 안에서 사용자에게 메뉴(1.대기 등록 | 2.대기 현황)를 보여주고, Scanner로 입력을 받습니다.
//        · 기능 1: 대기 등록 (입력값: 1)
//            - 사용자로부터 전화번호와 인원수를 입력받습니다.
//            - 생성해둔 WaitingController 객체의 addWaiting() 메소드를 호출하면서, 입력받은 값들을 인자로 전달합니다.
//            - addWaiting() 메소드가 반환한 boolean 값에 따라 "[안내] 대기 등록이 완료되었습니다." 또는 "[경고] 더 이상 대기 등록을 할 수 없습니다." 메시지를 출력합니다.
//        · 기능 2: 대기 현황 보기 (입력값: 2)
//            - WaitingController 객체의 getWaitingList() 메소드를 호출하여 Waiting 배열을 반환받습니다.
//            - 반환받은 배열을 for문으로 순회하며, null이 아닌 요소의 전화번호와 인원수를 출력합니다.

import java.util.Scanner;

public class WaitingService {
    public static void main(String[] args) {

        WaitingController ct = new WaitingController(); //컨트롤러 호출
        Scanner scan = new Scanner(System.in);
        for (; ; ) { //무한루프 start

            System.out.println("=========== 맛집 대기 시스템 ===========");
            System.out.println("1.대기 등록 | 2.대기 현황");
            System.out.println("========================================");
            System.out.print("선택 > ");
            int choice = scan.nextInt();

            if (choice == 1) {  // 선택 1

                System.out.print("전화번호 : ");
                String phone = scan.next();
                System.out.print("인원수 : ");
                int count = scan.nextInt();

                boolean result = ct.addWaiting(phone, count);           // 입력받은 값을 매개변수로 하여 메소드 실행

                if (result) {                                           // addWaiting 메소드 결과 boolen에 따른 출력문
                    System.out.println("[안내] 대기 등록이 완료되었습니다.");
                } else {
                    System.out.println("[경고] 더 이상 대기 등록을 할 수 없습니다.");
                }

            } else if (choice == 2) { // 선택 2
                System.out.println("============= 대기 현황 =============");    
                Waiting[] waitings = ct.getWaitingList();                               // waitings 리스트 가져오기
                for (int i = 0; i < waitings.length; i++) {                             // 리스트 탐색
                    if (waitings[i] != null) {                                          // 리스트가 null이 아닐때, 다음을 수행
                        System.out.printf("%d. 연락처: %s - 인원: %d명\n", i + 1, waitings[i].phone, waitings[i].count);
                        System.out.println("------------------------------------");
                    }
                }
            } // 선택 end
        } //무한루프 end
    } // main end
} // class end
