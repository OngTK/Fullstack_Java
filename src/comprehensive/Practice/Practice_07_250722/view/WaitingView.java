package comprehensive.Practice_07_250722.view;

import comprehensive.Practice_07_250722.controller.WaitingController;
import comprehensive.Practice_07_250722.model.dto.WaitingDto;

import java.util.ArrayList;
import java.util.Scanner;

// View 역할 : 게시물 관련 입출력

public class WaitingView {
    // 싱글톤 선언 =======================================
    private WaitingView() {
    }

    ;
    private static final WaitingView instance = new WaitingView();

    public static WaitingView getInstance() {
        return instance;
    }

    // Controller 싱글톤 호출  =======================================
    private WaitingController controller = WaitingController.getInstance();

    // 0. 여러 메소드에서 사용할 입력 객체를 입력변수로 선언 =================================

    private Scanner scan = new Scanner(System.in);

    // view =================================
    // 1. main
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
                getWaitingDB();
            }
        } // infi_roof end
    } // func end

    // 2. 등록
    public void addWaiting(){
        System.out.print("전화번호 : ");
        String phone = scan.next();
        System.out.print("인원수 : ");
        int count = scan.nextInt();

        boolean result = controller.addWaiting(phone,count);
        if(result){
            System.out.println("[안내] 대기 등록이 완료되었습니다.");
        } else {
            System.out.println("[경고] 대기 등록을 실패하였습니다.");
        }
    } // func end

    // 3. 조회
    public void getWaitingDB(){
        ArrayList<WaitingDto> waitingDB = controller.getWaitingDB();

        System.out.println("============= 대기 현황 =============");

        for(WaitingDto dto : waitingDB) {
            System.out.printf("연락처: %s - 인원: %d명 \n", dto.getPhone(), dto.getCount());
            System.out.println("------------------------------------");
        }
    } // func end

} //class end
