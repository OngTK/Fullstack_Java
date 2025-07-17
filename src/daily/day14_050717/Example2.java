package daily.day14_050717;

class Car{
    Tire tire; //멤버변수
    
    void run(){
        this.tire.roll();
    }
}

class Tire{
    void roll(){
        System.out.println("[일반] 타이어가 회전합니다.");
    }
}

class HankookTire extends Tire{
    void roll(){
        System.out.println("[한국] 타이어가 회전합니다.(업그레이드)");
    }
}

class KumhoTire extends Tire{
    void roll(){
        System.out.println("[금호] 타이어가 회전합니다.(업그레이드)");
    }
}

public class Example2 {
    public static void main(String[] args) {
        // Q1.
        Car myCar = new Car();
        // myCar.run(); // 현재 tire이 null이므로 오류

        myCar.tire = new Tire(); // 일반 tire을 장착
        myCar.run(); // [일반] 타이어가 회전합니다.

        System.out.println("====================================");

        // Q2. 타이어 교체
        myCar.tire = new HankookTire();
        myCar.run(); // [한국] 타이어가 회전합니다.(업그레이드)

        myCar.tire = new KumhoTire();
        myCar.run(); // [금호] 타이어가 회전합니다.(업그레이드)
        
        // Tire 타입의 멤버변수로는 일반tire / 한국tire / 금호tire 모두 가능
        // >> 한국, 금호 tire가 일반tire의 상속관계이므로 자동 타입변환으로 가능
        
        // 상위class > 포괄적인 타입 정의 , 하위class > 세분화된 타입 정의

        System.out.println("====================================");

        // Q3.
        System.out.println(myCar.tire instanceof Tire);        // true
        System.out.println(myCar.tire instanceof KumhoTire);   // true
        System.out.println(myCar.tire instanceof HankookTire); // false

        // 금호tire 타입 선언 > 일반tire 타입 선언!! (object까지 선언)
        // 그러나 금호tire는 한국tire을 모름!!!
    }
}
