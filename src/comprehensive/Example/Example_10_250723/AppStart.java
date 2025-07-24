package comprehensive.Example_10_250723;

// AppStart 역할 : 프로그램 시작 클래스

import comprehensive.Example_10_250723.controller.BoardController;
import comprehensive.Example_10_250723.view.BoardView;

public class AppStart {
    public static void main(String[] args) {

        BoardView.getInstance().index();
        
        // controller test
//        BoardController.getInstance().boardWrite("테스트 내용","홍길동");

    } // main end
} //class end
