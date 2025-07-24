package comprehensive.Example_09_250722.controller;

// Controller 역할 : 통신, 메소드 실행

import comprehensive.Example_09_250722.model.dao.BoardDao;
import comprehensive.Example_09_250722.model.dto.BoardDto;

import java.util.ArrayList;

public class BoardController {
    // 싱글톤 =======================================
    private BoardController(){};
    private static final BoardController instance = new BoardController();
    public static BoardController getInstance(){
        return instance;
    }

    // Dao 싱글톤 호출  =======================================
    private BoardDao boardDao = BoardDao.getInstance();

    // 메소드 =======================================
    // 1. 등록 boardWrite
    // 매개변수 String content, String writer
    // 반환타입 boolean
    public boolean boardWrite(String content, String writer){
        BoardDto boardDto = new BoardDto(content , writer);     // 매개변수로 dto 객체 생성
        boardDao.boardWrite(boardDto);                          // dto 객체를 dao 메소드에 전달
        return true;                                            // 결과를 view에 반환
    }

    // 2. 전체조회 boardPrint
    // 매개변수 X
    // 반환타입 ArrayList<BoardDto>
    public ArrayList<BoardDto> boardPrint(){
        ArrayList<BoardDto> result = boardDao.boardPrint();     // dao의 출력 메소드 실행 및 결과인 ArrayList를 가져옴
        return result;                                          // 결과로 ArrayList를 반환
    }
}
