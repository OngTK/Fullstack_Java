package comprehensive.DookDackMarcket_250724.model.dto;

// Dto : 데이터 모델·이동 객체
public class QnaDto {

    // 멤버변수 ===================================
    private int qNO;            // 문의번호 (PK)
    private int pNo;            // 물품번호 (FK)
    private String qQuestioner; // 문의자
    private String qContent;    // 문의내용
    private String qPw;         // 문의 비밀번호
    private String qDate;       // 문의일시
    // 생성자===================================
    // 기본 생성자
    public QnaDto() {
    }

    // 풀생성자
    public QnaDto(int qNO, int pNo, String qQuestioner, String qContent, String qPw, String qDate) {
        this.qNO = qNO;
        this.pNo = pNo;
        this.qQuestioner = qQuestioner;
        this.qContent = qContent;
        this.qPw = qPw;
        this.qDate = qDate;
    }

    // 메소드 =======================================
    // getter·setter
    public int getqNO() {
        return qNO;
    }

    public void setqNO(int qNO) {
        this.qNO = qNO;
    }

    public int getpNo() {
        return pNo;
    }

    public void setpNo(int pNo) {
        this.pNo = pNo;
    }

    public String getqQuestioner() {
        return qQuestioner;
    }

    public void setqQuestioner(String qQuestioner) {
        this.qQuestioner = qQuestioner;
    }

    public String getqContent() {
        return qContent;
    }

    public void setqContent(String qContent) {
        this.qContent = qContent;
    }

    public String getqPw() {
        return qPw;
    }

    public void setqPw(String qPw) {
        this.qPw = qPw;
    }

    public String getqDate() {
        return qDate;
    }

    public void setqDate(String qDate) {
        this.qDate = qDate;
    }

    // toString
    public String toString() {
        return "QnaDto{" +
                "qNO=" + qNO +
                ", pNo=" + pNo +
                ", qQuestioner='" + qQuestioner + '\'' +
                ", qContent='" + qContent + '\'' +
                ", qPw='" + qPw + '\'' +
                ", qDate='" + qDate + '\'' +
                '}';
    }
}// class end
