package comprehensive.Example_07_250711.model.dto;

// BoardDto 역할 : 데이터 모델·이동 객체
public class BoardDto {

    // 멤버변수 : all private ===================================
    private String content;
    private String writer;

    // 생성자 : 기본생성자와 풀생성자는 기본! 추가는 자유 ===================================
    // 기본 생성자
    public BoardDto() {
    }

    // 풀생성자
    public BoardDto(String content, String writer) {
        this.content = content;
        this.writer = writer;
    }

    // 메소드 ======================================================================
    // getter·setter
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

    // toString
    public String toString() {
        return "BoardDto{" +
                "content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }

}// class end
