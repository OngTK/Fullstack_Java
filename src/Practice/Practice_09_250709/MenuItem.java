package Practice.Practice_09_250709;

public class MenuItem {
    // 멤버변수
    String name;
    int price;
    boolean isSignature;

    // 생성자
    MenuItem() {
    }

    MenuItem(String name, int price, boolean isSignature) {
        this.name = name;
        this.price = price;
        this.isSignature = isSignature;
    }
}
