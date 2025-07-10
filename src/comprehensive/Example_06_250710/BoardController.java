package comprehensive.Example_06_250710;

// 콘트롤러 : 기능 제어
public class BoardController {

    // 멤버변수

    private static final Board[] boards = new Board[100];
    // private : 현재 클래스에서만 접근 가능
    // static : 객체 없이 접근 가능한 키워드
    // final : 수정 불가능 키워드

    // 생성자


    // 메소드

    public static boolean doPost(String content, String writer) {
        Board board = new Board(content, writer);
        for (int i = 0; i < boards.length; i++) {
            if (boards[i] == null) {
                boards[i] = board;
                return true; // 저장 성공
            }
        }
        return false; // 저장 실패
    }

    public static Board[] doGet() {
        return boards;
    }
}
