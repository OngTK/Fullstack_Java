package comprehensive.Example_10_250723.view;
// View : 게시물 관련 입출력

import comprehensive.Example_10_250723.controller.BoardController;
import comprehensive.Example_10_250723.model.dto.BoardDto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BoardView {
    // 싱글톤 선언 =======================================
    private BoardView() {
    }

    ;
    private static final BoardView instance = new BoardView();

    public static BoardView getInstance() {
        return instance;
    }

    // Controller 싱글톤 호출  =======================================
    private BoardController controller = BoardController.getInstance();

    // 모든 메소드에서 사용할 입력 객체를 입력변수로 선언 =================================
    private Scanner scan = new Scanner(System.in);

    // main view : 최초로 보이는 화면 구성 =================================

    //[1] main view
    public void index() {
        for (; ; ) {
            try {
                // [1.1] 메인화면 구현
                System.out.println("============= 비회원 게시판 =============");
                System.out.println("1. 등록 | 2. 전체조회 | 3. 삭제 | 4. 수정 ");
                System.out.println("=======================================");
                System.out.print("선택 > ");
                int choice = scan.nextInt();

                //[1.2] choice에 대한 메소드 연결
                if (choice == 1) {          //TODO [2] 등록 메소드 연결
                    boardWrite();
                } else if (choice == 2) {   //TODO [3] 전체조회 메소드 연결
                    boardPrint();
                } else if (choice == 3) {   //TODO [4] 삭제 메소드 연결
                    boardDelete();
                } else if (choice == 4) {   //TODO [5] 수정 메소드 연결
                    boardUpdate();
                } else {
                    System.out.println("[경고] 존재하지 않는 기능입니다.");
                }

                // [1.3] choice의 타입이 int가 아닌 String 등 다른 타입 입력 대비 [InputMismatchException] 예외처리
            } catch (InputMismatchException e) {
                System.out.println("[경고] 입력 타입이 올바르지 않습니다.");
                scan = new Scanner(System.in); // 입력객체 초기화 ☆★☆★☆★
            } catch (Exception e) {
                System.out.println("[경고] 관리자에게 문의하세요.");
            }
        } //infinity roof end
    } // func end

    //[2] 등록 화면
    public void boardWrite() {
        //[2.1] 입력받기
        scan.nextLine();
        System.out.print("▶ 내용 : ");
        String bcontent = scan.nextLine();
        System.out.print("▶ 작성자 : ");
        String bwriter = scan.next();

        //[2.2] controller 전달 · 결과 저장
        boolean result = controller.boardWrite(bcontent, bwriter);

        //[2.3] controller 결과 출력
        if (result) {
            System.out.println("[안내] 게시물 작성 성공");
        } else {
            System.out.println("[경고] 게시물 작성 실패");
        }
    }

    //[3] 전체조회 화면
    public void boardPrint() {
        //[3.1] controller의 boardPrint()를 실행
        ArrayList<BoardDto> list = controller.boardPrint();

        System.out.println("============= 게시물 목록 =============");
        //[3.2] 반복문을 통해 출력
        for (BoardDto dto : list) {
            System.out.printf("번호 : %d \n", dto.getBno());
            System.out.printf("작성자 : %s \n", dto.getBwriter());
            System.out.printf("내용 : %s \n", dto.getBcontent());
            System.out.println("---------------------------------");
        }
    } //func end

    //[4] 삭제 화면
    public void boardDelete() {
        try {
            //[4.1] 삭제할 게시물 번호를 console에서 받기
            System.out.print("▶ 삭제할 게시물 : ");
            int bno = scan.nextInt();
            //[4.2] controller 의 boardDelete 메소드 실행
            boolean result = controller.boardDelete(bno);
            //[4.3] 결과 출력
            if (result) {
                System.out.println("[안내] 게시물 삭제 완료");
            } else {
                System.out.println("[경고] 게시물 삭제 실패");
            }
        } catch (InputMismatchException e) {
            System.out.println("[경고] 게시물 번호는 숫자로 입력해주세요.");
        } catch (Exception e) {
            System.out.println("[예외발생] " + e);
        }
    }

    //[5] 수정 화면
    public void boardUpdate() {
        try {
            //[5.1] 수정 bno, 수정 bcontent를 console에서 받기
            System.out.print("▶ 수정할 게시물 : ");
            int bno = scan.nextInt();
            scan.nextLine();
            System.out.print("▶ 수정 내용 :");
            String bcontent = scan.nextLine();
            //[5.2] controller 의 boardUpdate 메소드 실행
            boolean result = controller.boardUpdate(bno, bcontent);
            //[5.3] 결과 출력
            if (result) {
                System.out.println("[안내] 게시물 수정 완료");
            } else {
                System.out.println("[경고] 게시물 수정 실패");
            }
        } catch (InputMismatchException e) {
            System.out.println("[경고] 게시물 번호는 숫자로 입력해주세요.");
        } catch (Exception e) {
            System.out.println("[예외발생] " + e);
        }
    }
    //[5.1]
    //[5.2]
    //[5.3]

} //class end
