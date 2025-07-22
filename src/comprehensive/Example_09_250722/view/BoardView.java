package comprehensive.Example_09_250722.view;

import comprehensive.Example_09_250722.controller.BoardController;

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
    private BoardController Controller = BoardController.getInstance();

    // 0. 여러 메소드에서 사용할 입력 객체를 입력변수로 선언 =================================

    private Scanner scan = new Scanner(System.in);

    // main view : 최초로 보이는 화면 구성 =================================


} //class end
