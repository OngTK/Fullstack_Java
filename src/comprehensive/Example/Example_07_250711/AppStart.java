package comprehensive.Example_07_250711;

import comprehensive.Example_07_250711.view.BoardView;

// AppStart 역할 : 프로그램 시작 클래스

public class AppStart {
    public static void main(String[] args) {

        // 1. BoardView index()호출
        // BoardView index() : 전체적인 화면 출력함수

        // 1.1. 불러올 메소드가 static 인지 확인
        // BoardView.index();

        // 1.2. 불러올 메소드가 static이 아니라면 instance 필요
        // BoardView view = new BoardView();
        // view.index();

        // 1.3. 해당 클래스가 `싱클톤`일 때,
        BoardView.getInstance().index(); 


    } // main end
} //class end
