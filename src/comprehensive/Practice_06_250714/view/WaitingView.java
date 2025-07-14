package comprehensive.Practice_06_250714.view;


import comprehensive.Practice_06_250714.controller.WaitingController;
import comprehensive.Practice_06_250714.model.dto.WaitingDto;

import java.util.ArrayList;
import java.util.Scanner;

// View 역할 : 게시물 관련 입출력
public class WaitingView {
    // 0. 싱글톤 만들기 =================================
    // 화면 출력 이라는 기능은 전체 중 유일한 일이므로 >> 싱글톤
    // 0.1. 기본 생성자를 private화
    // 0.2. `private static final` instance 선언
    // 0.3. `public static` getInstance 메소드
    private WaitingView() {
    }

    ;
    private static final WaitingView waitingView = new WaitingView();

    public static WaitingView getInstance() {
        return waitingView;
    }

    // controller 싱글톤 호출
    private WaitingController controller = WaitingController.getInstance();

    // 0. 여러 메소드에서 사용할 입력 객체를 입력변수로 선언 =================================

    private Scanner scan = new Scanner(System.in);

    // 1. main view : 최초로 보이는 화면 구성 =================================
    public void index() {
        for (; ; ) {
            System.out.println("=========== 맛집 대기 시스템 ===========");
            System.out.println("1.대기 등록 | 2.대기 현황");
            System.out.println("========================================");
            System.out.print("선택 > ");
            int choice = scan.nextInt();

            if (choice == 1) {
                addWaiting();
            } else if (choice == 2) {
                getWaitingList();
            }
        }
    } // index func end

    // 2. func
    public void addWaiting() {
        System.out.print("전화번호 : ");
        String phone = scan.next();
        System.out.print("인원수 : ");
        int count = scan.nextInt();

        // 위의 인수를 매개변수로 하여 검색 및 등록하는 func 연결 @@@@@@@
        boolean result = controller.addWaiting(phone, count);
        if (result) {
            System.out.println("[안내] 대기 등록이 완료되었습니다.");
        } else {
            System.out.println("[안내] 대기 등록을 실패하였습니다.");
        }
    }

    public void getWaitingList() {
        System.out.println("============= 대기 현황 =============");

        ArrayList<WaitingDto> waitingDB = controller.getWaitingList();

        for (int i = 0; i < waitingDB.size(); i++) {
            if (waitingDB.get(i) != null) {
                System.out.printf("%d. 연락처: %s - 인원: %d명\n", i + 1, waitingDB.get(i).getPhone(), waitingDB.get(i).getCount());
                System.out.println("------------------------------------");
            }
        }
    }
} //class end
