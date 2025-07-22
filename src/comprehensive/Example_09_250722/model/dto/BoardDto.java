package comprehensive.Example_09_250722.model.dto;

// Dto 역할 : 데이터 모델·이동 객체
public class BoardDto {

    // 멤버변수 ===================================
    private String content;
    private String writer;

    // 생성자===================================
    // 기본 생성자
    public BoardDto() {
    }

    // 풀생성자
    public BoardDto(String content, String writer) {
        this.content = content;
        this.writer = writer;
    }

    // 메소드 =======================================
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
