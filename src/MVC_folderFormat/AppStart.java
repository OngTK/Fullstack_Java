package MVC_folderFormat;

// AppStart 역할 : 프로그램 시작 클래스

import comprehensive.Example_09_250722.controller.BoardController;
import comprehensive.Example_09_250722.model.dto.BoardDto;

import java.util.ArrayList;

public class AppStart {
    public static void main(String[] args) {

        // view 작업전 controller / dao test
        // 1. 테스트할 컨트롤러 싱글톤 가져오기
        BoardController BC = BoardController.getInstance();

        // 2. 주석처리하면서 단위 기능 테스트
        // 2.1. 등록
        BC.boardWrite("안녕하세요.", "user");

        // 2.2. 전체조회
        ArrayList<BoardDto> result = BC.boardPrint();
        System.out.println(result);
    } // main end
} //class end
