package comprehensive.Example_07_250711.view;


// BoardView 역할 : 게시물 관련 입출력

import comprehensive.Example_07_250711.controller.BoardController;

import java.util.Scanner;

public class BoardView {
    // 0. 싱글톤 만들기 =================================
    // 화면 출력 이라는 기능은 전체 중 유일한 일이므로 >> 싱글톤
    // 0.1. 기본 생성자를 private화
    private BoardView() {
    }

    // 0.2. `private static final` instance 선언
    private static final BoardView view = new BoardView();

    // 0.3. `public static` getInstance 메소드
    public static BoardView getInstance() {
        return view;
    }
    // 싱글톤 end ========================================

    // 0. 여러 메소드에서 사용할 입력 객체를 입력(멤버)변수로 선언 =================================
    private Scanner scan = new Scanner(System.in);  //멤버변수이므로 private
    private BoardController boardController = BoardController.getInstance();


    // 1. main view : 최초로 보이는 화면 구성 =================================
    public void index() {
        for (; ; ) { // infi-roof start
            System.out.println("============= My Community =============");
            System.out.println("  1.게시물쓰기 | 2.게시물출력");
            System.out.println("========================================");
            System.out.print("선택 > ");
            int choose = scan.nextInt();

            if (choose == 1) {
                boardWrite();       // 2. 등록 view func
            } else if (choose == 2) {
                boardPrint();
            }

        } // infi-roof end
    } // func end

    // 2. 등록 view func
    public void boardWrite() {
        System.out.print("내용 : ");
        String content = scan.next();
        System.out.print("작성자 : ");
        String writer = scan.next();

        // controller 등록 func에 전달
        boolean result = boardController.boardWrite(content, writer);

        if (result) {
            System.out.println("[안내] 글쓰기 성공");
        } else {
            System.out.println("[안내] 글쓰기 실패");
        }
    } // func end

    // 3. 조회 view func
    public void boardPrint() {
        System.out.println("============= 게시물 목록 =============");
        System.out.println("작성자 : ");
        System.out.println("내용 : ");
        System.out.println("------------------------------------");
    } // func end

} //class end
