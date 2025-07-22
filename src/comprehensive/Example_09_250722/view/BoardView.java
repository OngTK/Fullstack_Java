package comprehensive.Example_09_250722.view;

import comprehensive.Example_09_250722.controller.BoardController;
import comprehensive.Example_09_250722.model.dto.BoardDto;

import java.util.ArrayList;
import java.util.Scanner;

// View 역할 : 게시물 관련 입출력

public class BoardView {
    // 싱글톤 선언 =======================================
    private BoardView(){};
    private static final BoardView instance = new BoardView();
    public static BoardView getInstance(){
        return instance;
    }

    // Controller 싱글톤 호출  =======================================
    private BoardController controller = BoardController.getInstance();

    // 0. 여러 메소드에서 사용할 입력 객체를 입력변수로 선언 =================================
    private Scanner scan = new Scanner(System.in);

    // main view : 최초로 보이는 화면 구성 =================================

    // [1] 메인
    public void index(){
        for(;;){
            System.out.println("=======================");
            System.out.println(" 1.등록 | 2. 전체조회");
            System.out.println("=======================");
            System.out.print("선택 > ");
            int choice = scan.nextInt();

            if (choice == 1 ){
                boardWrite();
            } else if (choice == 2) {
                boardPrint();
            }
        } // infinity roof end
    } // index end
    
    // [2] 등록
    public void boardWrite(){
        System.out.print("내용 : ");
        String content = scan.next();
        System.out.print("작성자 : ");
        String writer = scan.next();

        boolean result = controller.boardWrite(content,writer);

        if(result){
            System.out.println("[안내] 등록을 성공하였습니다.");
        } else {
            System.out.println("[경고] 등록을 실패하였습니다.");
        }
    }
    
    // [3] 전체조회
    public void boardPrint(){
        System.out.println("===================게시물 조회===================");

        ArrayList<BoardDto> boardDB = controller.boardPrint();

        for (BoardDto dto : boardDB) {
            System.out.println("작성자 : " + dto.getWriter());
            System.out.println("내용 : " + dto.getContent());
            System.out.println("---------------------------");
        }
    }
} //class end
