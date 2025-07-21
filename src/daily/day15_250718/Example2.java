package daily.day15_050718;

// extends : 상속은 하나의 클래스만 연결 가능
// implements : 여러 개의 인터페이스 연결 가능

interface Buy {
    void buy(); // 추상메소드

    // 디폴트 메소드
    //      인터페이스 타입 내에서 구현 가능한 메소드 >> 구현 Class를 별도로 작성할 필요X
    public default void method1(){};

    // 정적 메소드
    //      인터페이스 타입 내에서 구현 가능한 정적 메소드
    public static void method2(){};

    // Private method
    //      인터페이스 내에서만 `사용 가능한 + 구현 가능한` 메소드
    private void method3(){};

    // Private Static method
    //      인터페이스 내에서만 `사용 가능한 + 구현 가능한` 정적 메소드
    private static void method4(){};
}

interface Sell {
    void sell();
}

class Custormer extends Object implements Buy, Sell {
    // extends는 1개 하위 클래스에 1개 상위클래스만 상속 가능 == 다형성에 제약
    // implements는 1개 구현 클래스에 여러 개의 인터페이스 구현 가능 == 포괄적인 다형성 표현

    public void buy() {
        System.out.println("[판매]");
    }

    public void sell() {
        System.out.println("[구매]");
    }
}

public class Example2 {
    public static void main(String[] args) {

        // [1]
        Buy buy = new Custormer();

        // [2]
        buy.buy();

        // [3] default 메소드 호출
        buy.method1();

        // [4] 정적 메소드 호출
        Buy.method2();          // 정적 메소드는 객체가 아닌 타입을 통해 호출
        
        // [5] private 메소드
        // 인터페이스 내부에서는 구현 가능 하지만, 구현체에서 구현하지 않을 경우 사용 >> 오버라이딩 금지 메소드

        // [6] private static 메소드
        // 오버라이딩 금지 메소드 
        // 인터페이스 타입 내부적으로 사용되는 정적 메소드
        
        
    } //main end
} // class end
