package comprehensive.Example_08_250714.model.dao;

import comprehensive.Example_08_250714.model.dto.BoardDto;

import java.util.ArrayList;

// Dao 역할 : 실존 데이터에 접근하는 기능 (CRUD)
public class BoardDao {
    // 싱글톤
    private BoardDao(){};
    private static final BoardDao boardDao = new BoardDao();
    public static BoardDao getInstance(){
        return boardDao;
    }

    // 멤버변수 private
    private ArrayList<BoardDto> BoardDB = new ArrayList<>();

    // 1. 등록 처리 메소드
    // controller 로 부터 배열에 저장할 객체를 받아와서 저장
    // 매개변수 : content, writer
    // return boolean

    public  boolean addBoard(String content, String writer){
        boolean result = false;

        // 객체 생성
        BoardDto boardDto = new BoardDto(content, writer);
        // 객체를 리스트에 add
        BoardDB.add(boardDto);
        result = true;

        return result;
    }

    // 2. 조회 처리 메소드
    // controller에 모든 배열을 반환
    // 매개변수 : X
    // return Dto
    public ArrayList<BoardDto> getBoardList(){
        return BoardDB;
    }
}
