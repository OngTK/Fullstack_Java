package comprehensive.Example.Example_10_250723.model.dto;

// Dto 역할 : 데이터 모델·이동 객체
public class BoardDto {

    // 멤버변수 ===================================
    private int bno;
    private String bcontent;
    private String bwriter;

    // 생성자===================================
    // 기본 생성자
    public BoardDto() {
    }

    // 풀생성자
    public BoardDto(int bno, String bcontent, String bwriter) {
        this.bno = bno;
        this.bcontent = bcontent;
        this.bwriter = bwriter;
    }

    // 메소드 =======================================
    // getter·setter
    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getBcontent() {
        return bcontent;
    }

    public void setBcontent(String bcontent) {
        this.bcontent = bcontent;
    }

    public String getBwriter() {
        return bwriter;
    }

    public void setBwriter(String bwriter) {
        this.bwriter = bwriter;
    }

    // toString
    public String toString() {
        return "BoardDto{" +
                "bno=" + bno +
                ", bcontent='" + bcontent + '\'' +
                ", bwriter='" + bwriter + '\'' +
                '}';
    }
}// class end
