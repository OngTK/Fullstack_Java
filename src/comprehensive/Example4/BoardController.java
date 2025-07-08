package comprehensive.Example4;

public class BoardController {
    // 멤버변수
    Board[] boards = new Board[100];

    // 메소드
    //         - 게시물 등록 기능 메소드 doPost(String content, String writer)를 정의합니다.
//              -> 매개변수로 content와 writer를 받습니다.
//              -> Board 객체를 생성하고, 매개변수로 받은 값들을 객체의 멤버 변수에 저장합니다.
//              -> boards 배열의 빈 공간(null)을 찾아 생성된 객체를 저장합니다.
//              -> 저장 성공 시 true, 실패(공간 없음) 시 false를 반환(return)합니다.

    boolean doPost(String content, String writer) {

        Board board = new Board();                  // 데이터를 저장할 객체 생성
        board.content = content;
        board.writer = writer;

        for (int i = 0; i < boards.length; i++) {
            if (boards[i] == null) {
                boards[i] = board;
                return true;                        // 반환값
            }
        }
        return false;                               // 위에서 이행되지 않았다면, 실패이므로 false
    }

    //         - 게시물 조회 기능 메소드 doGet()을 정의합니다.
//              -> 자신이 관리하는 boards 배열 전체를 반환(return)합니다.
    Board[] doGet() {
        return boards;                               // boards의 타입은 Board[]
    }
}
