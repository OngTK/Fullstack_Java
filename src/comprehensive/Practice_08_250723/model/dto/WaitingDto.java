package comprehensive.Practice_08_250723.model.dto;

// Dto : 데이터 모델·이동 객체
public class WaitingDto {

    // 멤버변수 ===================================
    private int wno;
    private String phone;
    private int count;

    // 생성자===================================
    // 기본 생성자
    public WaitingDto() {
    }

    // 풀생성자
    public WaitingDto(int wno, String phone, int count) {
        this.wno = wno;
        this.phone = phone;
        this.count = count;
    }

    // 메소드 =======================================
    // getter·setter
    public int getWno() {
        return wno;
    }

    public void setWno(int wno) {
        this.wno = wno;
    }

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
                "wno=" + wno +
                ", phone='" + phone + '\'' +
                ", count=" + count +
                '}';
    }
}// class end
