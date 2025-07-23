package comprehensive.Practice_08_250723.view;

import comprehensive.Practice_08_250723.controller.WaitingController;
import comprehensive.Practice_08_250723.model.dto.WaitingDto;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.InputMismatchException;
import java.util.Scanner;

// View : 게시물 관련 입출력

public class WaitingView {
    // 싱글톤 선언 =======================================
    private WaitingView() { //Dao 객체 생성과 동시에 DB 연동 시작
    }

    private static final WaitingView instance = new WaitingView();

    public static WaitingView getInstance() {
        return instance;
    }

    // Controller 싱글톤 호출  =======================================
    private WaitingController controller = WaitingController.getInstance();
    // 0. 여러 메소드에서 사용할 입력 객체를 입력변수로 선언 =================================
    private Scanner scan = new Scanner(System.in);

    // 화면 구성 =================================

    //[0] index view
    public void index() {
        for (; ; ) {
            System.out.println("========================== 대기 시스템 ==========================");
            System.out.println("1. 대기 등록 | 2. 대기 전체 조회 | 3. 대기 취소 | 4. 대기 정보 수정");
            System.out.println("===============================================================");
            System.out.print("선택 > ");
            int choice = scan.nextInt();
            try {
                if (choice == 1) {             // TODO 대기 등록
                    waitingRegi();
                } else if (choice == 2) {      // TODO 전체 조회
                    waitingPrint();
                } else if (choice == 3) {      // TODO 대기 취소
                    waitingDelete();
                } else if (choice == 4) {      // TODO 대기 수정
                    waitingUpdate();
                } else {
                    System.out.println("[경고] 올바르지 못한 기능입니다.");
                }
            } catch (InputMismatchException e) {
                System.out.println("[경고] 입력 타입이 올바르지 못합니다.");
            } catch (Exception e) {
                System.out.println("[경고] 관리자에게 문의하세요.");
            }
        } //infinity roof end
    } // func end

    //[1] 대기 등록
    public void waitingRegi() {
        //[1.1] 매개변수를 console로 부터 받기
        System.out.print("전화번호 : ");
        String phone = scan.next();
        System.out.print("인원수 : ");
        int count = scan.nextInt();
        //[1.2] controller의 waitingRegi 실행
        boolean result = controller.waitingRegi(phone, count);
        //[1.3] 결과 출력
        if (result) {
            System.out.println("[안내] 대기열 등록을 성공했습니다.");
        } else {
            System.out.println("[경고] 대기열 등록을 실패했습니다.");
        }
    } // func end

    //[2] 전체 대기 조회
    public void waitingPrint() {
        //[2.1] controller의 waitingPrint 함수 실행
        ArrayList<WaitingDto> waitingList = controller.waitingPrint();
        //[2.2] 반복문을 통해 출력
        System.out.println("---------------- 대기열 조회 ----------------");
        System.out.println("no \t 연락처 \t\t\t 대기인원 ");
        System.out.println("---------------------------------------------");
        for (WaitingDto dto : waitingList) {
            System.out.printf("%d \t %s \t %d \n", dto.getWno(), dto.getPhone(), dto.getCount());
            System.out.println("---------------------------------------------");
        }
    } // func end

    //[3] 대기 삭제
    public void waitingDelete() {
        //[3.1] console에서 삭제할 대기열 받기
        System.out.print("삭제할 대기열 : ");
        int wno = scan.nextInt();
        //[3.2] controller의 waitingDelete 실행
        boolean result = controller.waitingDelete(wno);
        //[3.3] 결과 출력
        if (result) {
            System.out.println("[안내] 대기열을 성공적으로 삭제했습니다.");
        } else {
            System.out.println("[경고] 대기열 삭제를 실패하였습니다.");
        }

    } //func end

    //[4] 대기 수정
    public void waitingUpdate() {
        //[4.1] console을 통해 wno, count 받기
        System.out.print("수정할 대기열 : ");
        int wno = scan.nextInt();
        System.out.print("수정 인원수 : ");
        int count = scan.nextInt();

        //[4.2] controller의 waitingUpdate 실행
        boolean result = controller.waitingUpdate(wno, count);
        //[4.3] 결과 출력
        if (result) {
            System.out.println("[안내] 대기열을 성공적으로 수정했습니다.");
        } else {
            System.out.println("[경고] 대기열 수정을 실패하였습니다.");
        }
    } // func end

} //class end
