package comprehensive.DookDackMarcket_250724.view;

import java.util.InputMismatchException;
import java.util.Scanner;

// View : 게시물 관련 입출력

public class MarketView {
    // 싱글톤 선언 =======================================
    private MarketView() {
    }

    ;
    private static final MarketView instance = new MarketView();

    public static MarketView getInstance() {
        return instance;
    }
    // Controller 싱글톤 호출  =======================================

    // 0. 여러 메소드에서 사용할 입력 객체를 입력변수로 선언 =================================
    private Scanner scan = new Scanner(System.in);

    // 화면 구성 =================================
    public void index() {
        for (; ; ) {
            System.out.println("============================= 뚝딱마켓 =============================");
            System.out.println("1. 중고 물품 등록 | 2. 물품 목록 조회 | 3. 물품 정보 수정 | 4. 물품 삭제");
            System.out.println("5. 문의 남기기    | 6. 물품 상세 조회 | 7. 등록 랭킹 조회 | 8. 검색");
            System.out.println("====================================================================");
            System.out.print("선택 > ");
            int choice = scan.nextInt();

            try {
                if (choice == 1) {
                    // TODO 1. 물품등록

                } else if (choice == 2) {
                    // TODO 2. 물품 목록 조회

                } else if (choice == 3) {
                    // TODO 3. 물품 정보 수정

                } else if (choice == 4) {
                    // TODO 4. 물품 삭제

                } else if (choice == 5) {
                    // TODO 5. 문의 남기기

                } else if (choice == 6) {
                    // TODO 6. 물품 상세 조회

                } else if (choice == 7) {
                    // TODO 7. 등록 랭킹 조회

                } else if (choice == 8) {
                    // TODO 8. 검색
                } else {
                    System.out.println("[경고] 올바르지 못한 기능입니다.");
                }
            } catch (InputMismatchException e) {
                System.out.println("[경고] 입력 타입이 올바르지 못합니다.");
            } catch (Exception e) {
                System.out.println("[경고] 관리자에게 문의하세요.");
            }
        }// infinity loop end
    } // func end
    //[1]
    //[1.1]
    //[1.2]
    //[1.3]
    //[1.4]
    //[2]
    //[2.1]
    //[2.2]
    //[2.3]
    //[2.4]
    //[3]
    //[3.1]
    //[3.2]
    //[3.3]
    //[3.4]
    //[4]
    //[4.1]
    //[4.2]
    //[4.3]
    //[4.4]
    //[5]
    //[5.1]
    //[5.2]
    //[5.3]
    //[5.4]

} //class end
