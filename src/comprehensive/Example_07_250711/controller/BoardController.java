package comprehensive.Example_07_250711.controller;

import comprehensive.Example_07_250711.model.dao.BoardDao;
import comprehensive.Example_07_250711.model.dto.BoardDto;

// BoardController 역할 : 통신
public class BoardController {

    // 0. 싱글톤 작업
    // 0.1. 생성자 private
    private BoardController(){}
    // 0.2. `private static final` 객체 만들기
    private static final BoardController control = new BoardController();
    // 0.3. public static 메소드
    public static BoardController getInstance(){
        return control;
    }

    // dao의 싱글톤 객체 가저오기 (가져와서 private)
    private BoardDao boardDao = BoardDao.getInstance();

    // 1. 등록 처리 메소드
    // BoardView.boardWrite(content, writer) > controller > BoardDao.boardWrite()
    public boolean boardWrite(String content, String writer){
        // 1.1. 매개변수 객채화
        BoardDto boardDto = new BoardDto(content, writer);
        // 1.2. dao 에게 객체 전달 후 경과 받기
        boolean result = boardDao.boardWrite(boardDto);
        // 1.3. dao 에게 받은 결과를 view에 반환
        return result;
    }


    // 2. 조회 처리 메소드
    // BoardDao.boardWrite() > controller > BoardView.boardWrite()
}
