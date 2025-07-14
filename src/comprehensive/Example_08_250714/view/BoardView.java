package comprehensive.Example_08_250714.view;


import comprehensive.Example_08_250714.controller.BoardController;
import comprehensive.Example_08_250714.model.dto.BoardDto;

import java.util.ArrayList;
import java.util.Scanner;

// View 역할 : 게시물 관련 입출력
public class BoardView {
    // 0. 싱글톤 만들기 =================================
    // 화면 출력 이라는 기능은 전체 중 유일한 일이므로 >> 싱글톤
    // 0.1. 기본 생성자를 private화
    // 0.2. `private static final` instance 선언
    // 0.3. `public static` getInstance 메소드
    private BoardView() {
    }

    ;
    private static final BoardView boardView = new BoardView();

    public static BoardView getInstance() {
        return boardView;
    }

    // controller 싱글톤 호출
    private BoardController controller = BoardController.getInstance();

    // 0. 여러 메소드에서 사용할 입력 객체를 입력변수로 선언 =================================
    private Scanner scan = new Scanner(System.in);

    // 1. main view : 최초로 보이는 화면 구성 =================================
    public void index() {
        for (; ; ) {
            System.out.println("============= My Community =============");
            System.out.println("  1.게시물쓰기 | 2.게시물출력");
            System.out.println("========================================");
            System.out.print("선택 > ");
            int choose = scan.nextInt();

            if (choose == 1) {
                addBoard();       // 2. 등록 view func
            } else if (choose == 2) {
                getBoardList();
            }
        }
    }

    // 2. func
    public void addBoard() {
        System.out.print("내용 : ");
        String content = scan.next();
        System.out.println("작성자 : ");
        String writer = scan.next();

        boolean result = controller.addBoard(content, writer);

        if (result) {
            System.out.println("[안내] 게시물이 등록되었습니다.");
        } else {
            System.out.println("[경고] 게시물 등록을 실패하였습니다.");
        }
    } // addBoard func end

    public void getBoardList() {
        ArrayList<BoardDto> boardDB = controller.getBoardList();

        for (int i = 0; i < boardDB.size(); i++) {
            System.out.println("작성자 : " + boardDB.get(i).getWriter());
            System.out.println("내용 : " + boardDB.get(i).getContent());
            System.out.println("-------------------------------");
        }

    }

} //class end
