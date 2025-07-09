package Practice.Practice_09_250709;

public class Goods {

    // 멤버변수
    String name;
    int price;

    // 생성자
    Goods() {
        name = "미정";
        price = 0;
    }

    Goods(String name, int price) {
        this.name = name;
        this.price = price;
    }

    Goods(int price, String name) {
        this.name = name;
        this.price = price;
    }


}
