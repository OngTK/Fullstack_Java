package comprehensive.Practice_04_250708;

import java.util.Scanner;

public class WatingService04 {
//[JAVA] 종합과제4 : 식당 대기번호 프로그램 ( 생성자 , 접근제한자 , static , final)
//[ 목표 ] 종합과제3의 로직에 캡슐화(접근 제한자, Getter/Setter),
//          생성자, 그리고 static 키워드를 모두 적용하여, 데이터가 보호되는 견고한 프로그램을 구현합니다.
//[ 요구사항 ]
//    1. Waiting.java 클래스 설계 (Model - 캡슐화)
//        · private 접근 제한자를 사용하여 phone(문자열)과 count(정수) 멤버 변수를 선언하여 외부로부터의 직접적인 접근을 막습니다.
//        · public 접근 제한자를 가진 생성자를 만들어, 객체가 생성될 때 전화번호와 인원수 정보를 받아 초기화하도록 합니다.
//        · private 멤버 변수에 안전하게 접근할 수 있도록,
//          각 변수에 대한 public Getter와 Setter 메소드를 정의합니다. (예: getPhone(), setPhone(), ...)
//    2. WaitingController.java 클래스 설계 (Controller - static 활용)
//        · 대기 명단 배열을 private static final Waiting[] waitings = new Waiting[100]; 으로 선언합니다.
//        · 대기 등록 기능 메소드 addWaiting(String phone, int count)를 public static 으로 정의합니다.
//            - 매개변수로 받은 값들을 Waiting 클래스의 생성자에 전달하여 객체를 생성합니다.
//            - static으로 선언된 waitings 배열의 빈 공간을 찾아 생성된 객체를 저장하고, 성공 여부를 boolean으로 반환합니다.
//        · 대기 현황 조회 기능 메소드 getWaitingList()를 public static 으로 정의합니다.
//            - static으로 선언된 waitings 배열 전체를 반환합니다.
//    3. WaitingService.java 클래스 설계 (View / Entry Point)
//        · main 함수를 포함하는 실행 클래스입니다.
//        · for(;;) 무한루프 안에서 사용자에게 메뉴(1.대기 등록 | 2.대기 현황)를 보여주고, Scanner로 입력을 받습니다.
//        · 기능 1: 대기 등록
//            - 사용자로부터 전화번호와 인원수를 입력받습니다.
//            - 객체를 생성하지 않고, WaitingController.addWaiting() 형태로 클래스에 직접 접근하여 메소드를 호출하고, 반환된 결과에 따라 성공/실패 메시지를 출력합니다.
//        · 기능 2: 대기 현황 보기
//            - 객체를 생성하지 않고, WaitingController.getWaitingList() 형태로 클래스에 직접 접근하여 Waiting 배열을 반환받습니다.
//            - 반환받은 배열을 for문으로 순회하며, null이 아닌 요소의 정보를 Getter 메소드를 이용해 출력합니다.
//
//[ 실행 예시 ]
//=========== 맛집 대기 시스템 ===========
//1.대기 등록 | 2.대기 현황
//========================================
//선택 > 1
//전화번호 : 010-1234-5678
//인원수 : 2
//[안내] 대기 등록이 완료되었습니다.
//
//=========== 맛집 대기 시스템 ===========
//1.대기 등록 | 2.대기 현황
//========================================
//선택 > 1
//전화번호 : 010-8765-4321
//인원수 : 4
//[안내] 대기 등록이 완료되었습니다.
//
//=========== 맛집 대기 시스템 ===========
//1.대기 등록 | 2.대기 현황
//========================================
//선택 > 2
//============= 대기 현황 =============
//1. 연락처: 010-1234-5678 - 인원: 2명
//------------------------------------
//2. 연락처: 010-8765-4321 - 인원: 4명
//------------------------------------

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        for (; ; ) {
            System.out.println("=========== 맛집 대기 시스템 ===========");
            System.out.println("1.대기 등록 | 2.대기 현황");
            System.out.println("========================================");
            System.out.print("선택 > ");
            int choice = scan.nextInt();

            if (choice == 1) {
                System.out.print("전화번호 : ");
                String phone = scan.next();
                System.out.print("인원수 : ");
                int count = scan.nextInt();

                boolean result = WaitingController.addWaiting(phone, count);
                if(result){
                    System.out.println("[안내] 대기 등록이 완료되었습니다.");
                } else {
                    System.out.println("[경고] 대기열 저장에 실패하였습니다.");
                }

            } else if (choice == 2) {
                Waiting[] waitings = WaitingController.getWaitingList();
                System.out.println("============= 대기 현황 =============");

                for(int i = 0 ; i < waitings.length ; i++){
                    if(waitings[i] != null){
                        System.out.printf("%d. 연락처: %s - 인원: %d명\n",i+1, waitings[i].getPhone(), waitings[i].getCount());
                        System.out.println("------------------------------------");
                    }
                }

            } else {
                System.out.println("[경고] 올바르지 못한 기능입니다.");
            }


        }
    }
}
