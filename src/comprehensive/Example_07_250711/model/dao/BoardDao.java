package comprehensive.Example_07_250711.model.dao;

import comprehensive.Example_07_250711.model.dto.BoardDto;

// BoardDao 역할 : 실존 데이터에 접근하는 기능 (CRUD)
public class BoardDao {

    // 추후 데이터 베이스로 변경 예정.... 오늘은 배열로 진행

    // 멤버변수 private
    private BoardDto[] boardDb = new BoardDto[100];

    // 1. 등록 처리 메소드
    // controller 로 부터 배열에 저장할 객체를 받아와서 저장
    // 매개변수 : BoardDto
    // return boolean

    public boolean boardWrite(BoardDto boardDto){
        for (int i = 0 ; i < boardDb.length ; i++){
            if(boardDb[i] == null){
                boardDb[i] = boardDto;
                return true;
            }
        }
        return false;
    }

    // 2. 조회 처리 메소드
    // controller에 모든 배열을 반환
    // 매개변수 : X
    // return BoardDto


}
