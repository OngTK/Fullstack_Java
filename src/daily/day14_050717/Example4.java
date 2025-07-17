package daily.day14_050717;

class 자동차 {
    타이어 tire;

    // 메소드
    void run() {
        this.tire.roll();
    }
}

interface 타이어 {
    // 추상메소드 : 구현{ } X
    void roll();
}

class 금호타이어 implements 타이어 {
    @Override
    public void roll() {
        System.out.println("[금호] 타이어가 회전(구현)");
    }
}

class 한국타이어 implements 타이어 {
    @Override
    public void roll() {
        System.out.println("[한국] 타이어가 회전(구현)");
    }
}

public class Example4 {
    public static void main(String[] args) {

        자동차 myCar = new 자동차();

        // myCar.run(); // 오류 발생

        // myCar.tire = new 타이어(); //타이어는 인터페이스이므로 생성 불가

        // [1] 구현체
        myCar.tire = new 한국타이어();   // 한국타이어는 class 이며 인터페이스에 implement 되어있으므로 가능
        myCar.run();                    // [한국] 타이어가 회전(구현)

        myCar.tire = new 금호타이어();
        myCar.run();                    // [금호] 타이어가 회전(구현)

        // tire 멤머변수 >> 타입 타이어
        // 타입 타이어 >> interface
        // 인터페이스 타이어의 구현(implements) >> 한국타이어 / 금호타이어

        System.out.println( myCar.tire instanceof 타이어); // true
        System.out.println( myCar.tire instanceof 금호타이어); // true
        System.out.println( myCar.tire instanceof 한국타이어); // false

    } // main end
} // class  end
