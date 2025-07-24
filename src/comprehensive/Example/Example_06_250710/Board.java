package comprehensive.Example_06_250710;

// 데이터 모델
public class Board {

    // 멤버변수
    //      주로 private
    private String content;
    private String writer;

    // 생성자
    //      주로 기본생성자 + 전체 매개변수 생성자
    public Board() {
    }

    public Board(String content, String writer) {
        this.content = content;
        this.writer = writer;
    }

    // 메소드
    //      private로 선언된 멤버변수에 접근 가능한 getter/setter을 선언
    //      우클릭 > generate (alt + insert) > getter and setter
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    // 객체의 주소값이 아닌 멤버변수를 확인하기 위한 toString
    // 우클릭 > generate (alt + insert) > toString()
    public String toString() {
        return "Board{" +
                "content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }
}
