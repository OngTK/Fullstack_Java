package comprehensive.Example_08_250714.controller;

import comprehensive.Example_08_250714.model.dao.BoardDao;
import comprehensive.Example_08_250714.model.dto.BoardDto;

import java.util.ArrayList;

// Controller 역할 : 통신
public class BoardController {
    //싱글톤
    private BoardController() {
    }

    ;
    private static final BoardController controller = new BoardController();

    public static BoardController getInstance() {
        return controller;
    }

    // dao 싱글톤 호출
    private BoardDao boardDao = BoardDao.getInstance();

    // 1. 등록 처리 메소드

    public boolean addBoard(String content, String writer) {
        boolean result = false;

        // dao 메소드 실행 후 결과값 반환 저장
        result = boardDao.addBoard(content, writer);

        return result;
        // return boardDao.addBoard(content, writer); 으로 한 줄로 끝낼 수 있음
    }

    // 2. 조회 처리 메소드

    public ArrayList<BoardDto> getBoardList() {
        ArrayList<BoardDto> boardDB = boardDao.getBoardList();
        return boardDB;
    }
}
