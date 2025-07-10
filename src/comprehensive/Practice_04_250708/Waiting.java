package comprehensive.Practice_04_250708;

public class Waiting {

    // 멤버변수=============================
    private String phone;
    private int count;

    // 생성자=============================

    public Waiting(String phone) {
        this.phone = phone;
    }

    public Waiting(String phone, int count) {
        this.phone = phone;
        this.count = count;
    }

    // 메소드=============================

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
        return "Waiting{" +
                "phone='" + phone + '\'' +
                ", count=" + count +
                '}';
    }
}
