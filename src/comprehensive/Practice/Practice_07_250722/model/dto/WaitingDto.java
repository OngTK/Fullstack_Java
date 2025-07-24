package comprehensive.Practice_07_250722.model.dto;

// Dto 역할 : 데이터 모델·이동 객체
public class WaitingDto {

    // 멤버변수 ===================================
    private String phone;
    private int count;
    // 생성자===================================
    // 기본 생성자
    public WaitingDto() {
    }

    // 풀생성자
    public WaitingDto(String phone, int count) {
        this.phone = phone;
        this.count = count;
    }

    // 메소드 =======================================
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
