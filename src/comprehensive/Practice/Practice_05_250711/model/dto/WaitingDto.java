package comprehensive.Practice_05_250711.model.dto;

// Dto 역할 : 데이터 모델·이동 객체
public class WaitingDto {

    // 멤버변수 : all private ===================================
    private String phone;       //전화번호
    private int count;          // 인원수

    // 생성자 : 기본생성자와 풀생성자는 기본! 추가는 자유 ===================================
    // 기본 생성자

    public WaitingDto() {
    }

    public WaitingDto(String phone, int count) {
        this.phone = phone;
        this.count = count;
    }
    // 풀생성자

    // 메소드 ======================================================================
    // getter·setter

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    // toString
    public String toString() {
        return "WaitingDto{" +
                "phone='" + phone + '\'' +
                ", count=" + count +
                '}';
    }
}// class end
