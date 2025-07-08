package Practice.Practice_08_250708;

public class Product {
    //멤버변수
    String name;
    int stock;

    //메소드
    boolean sell(int stockInput){
        boolean result;
        if (stock >= stockInput){
            stock -= stockInput;
            result = true;
        } else {
            System.out.println("재고 부족");
            result = false;
        }
        return result;
    };
}
