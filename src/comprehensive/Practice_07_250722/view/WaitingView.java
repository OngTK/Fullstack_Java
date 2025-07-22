package comprehensive.Practice_07_250722.view;

import comprehensive.Practice_07_250722.controller.WaitingController;

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

            } else if (choice == 2) {

            }

        }
    }
    // 2. 등록

    // 3. 조회


} //class end
