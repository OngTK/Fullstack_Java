package comprehensive.Example_10_250723.controller;

// Controller : 통신

import comprehensive.Example_10_250723.model.dao.BoardDao;
import comprehensive.Example_10_250723.model.dto.BoardDto;

import java.util.ArrayList;

public class BoardController {
    // 싱글톤 =======================================
    private BoardController() {
    }

    ;
    private static final BoardController instance = new BoardController();

    public static BoardController getInstance() {
        return instance;
    }

    // Dao 싱글톤 호출  =======================================
    private BoardDao boardDao = BoardDao.getInstance();

    // 메소드 =======================================

    //[1] 등록 기능 구현
    public boolean boardWrite(String bcontent, String bwriter) {
        //[1.1] 유효성 검사 (생략)

        //[1.2] 매개변수로 객체 만들기
        BoardDto boardDto = new BoardDto(0, bcontent, bwriter); //bno에 0을 넣어도 DB 등록 시, bno를 사용하지 않으므로 문제 없음!

        //[1.3] Dto를 Dao에게 전달
        boolean result = boardDao.boardWrite(boardDto);

        //[1.4] view에 결과 반환
        if (result) {
            return true;
        }
        return false;
    } // func end

    //[3] 전체조회 기능 구현
    public ArrayList<BoardDto> boardPrint() {
        //[3.1] dao의 전체조회 기능 실행
        ArrayList<BoardDto> list = boardDao.boardPrint();
        //[3.2] view에 결과 반환
        return list;
    } //func end

    //[4] 삭제 기능 구현
    public boolean boardDelete(int bno) {
        //[4.1] dao에 boardDelete 메소드 실행
        boolean result = boardDao.boardDelete(bno);
        //[4.2] view에 결과 반환
        return result;
    }

    //[5] 수정 기능 구현
    public boolean boardUpdate(int bno, String bcontent) {
        //[5.1] dao에 boardUpdate 메소드 실행
        boolean result = boardDao.boardUpdate(bno, bcontent);
        //[5.2] view에 결과 반환
        return result;
    }

} // class end
