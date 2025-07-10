package comprehensive.Practice_03_250708;

//        · WaitingController 클래스 (제어/로직 담당)
//            - 대기 명단 데이터를 직접 관리하고 처리하는 클래스입니다.
//            - Waiting 객체를 100개 저장할 수 있는 배열(Waiting[] waitings = new Waiting[100];)을 멤버 변수로 가집니다.
//            - 대기 등록 기능 메소드 addWaiting(String phone, int count)를 정의합니다.
//                -> 매개변수로 phone과 count를 받습니다.
//                ->  Waiting 객체를 생성하고, 매개변수로 받은 값들을 객체의 멤버 변수에 저장합니다.
//                ->  waitings 배열의 빈 공간(null)을 찾아 생성된 객체를 저장합니다.
//                ->  저장 성공 시 true, 실패(공간 없음) 시 false를 반환(return)합니다.
//            -  대기 현황 조회 기능 메소드 getWaitingList()를 정의합니다.
//                ->  자신이 관리하는 waitings 배열 전체를 반환(return)합니다.

public class WaitingController {
    // 멤버변수
    Waiting[] waitings = new Waiting[100];
    
    // 메소드
    // 1. 대기 등록 기능 메소드 addWaiting(String phone, int count)
    boolean addWaiting(String phone, int count){
        Waiting waiting = new Waiting();                // 매개변수를 저장할 수 있는 객체 만들기
        waiting.phone = phone;
        waiting.count = count;                          // 20줄에서 만든 객체에 값 삽입

        for(int i = 0 ; i < waitings.length ; i++ ){    // 배열 탐색
            if(waitings[i] == null) {                   // 배열에 빈자리 찾기
                waitings[i] = waiting;                  // 빈자리에 매개변수가 삽입된 객체 대입
                return true;                            // 등록 성공
            }
        }
        return false;                                   // 등록 실패
    };

    // 2. 대기 현황 조회 메소드 getWaitingList()

    Waiting[] getWaitingList(){                          // 타입 조심하기!
        return waitings;
    }
}
