package daily.day14_050717;


class 상위클래스{
    // 멤버변수
    int value1 = 10 ;
    int value2 = 20 ;

    // 생성자
    public 상위클래스() {
        System.out.println("상위클래스 인스턴스 생성");
    }

    //메소드
    void showValue(){
        System.out.println("상위클래스 메소드 실행");
    }
}

class 하위클래스 extends 상위클래스{
    // 멤버변수
    int value3 = 30;
    int value2 = 40; // 상위클래스의 멤버변수와 변수명이 겹칠 때,

    // 생성자
    public 하위클래스() {
        System.out.println("하위클래스 인스턴스 생성");
    }
    
    // 메소드
    void showValue2(){
        System.out.println("하위 메소드 실행");
    }
    
    // 상위 클래스와 동일한 이름의 메소드
    void showValue(){
        System.out.println("하위 메소드2 실행");
    }
}

public class Example01 {
    public static void main(String[] args) {
        // [1] 상위클래스 객체 생성
        상위클래스 obj1 = new 상위클래스();
        obj1.showValue();

        // obj1.showValue2(); // 상위클래스 객체가 하위 클래스의 메소드 사용 불가
        System.out.println("=====================================");

        // [2] 하위클래스 객체 생성
        하위클래스 obj2 = new 하위클래스();
        obj2.showValue();       // 하위클래스 객체는 상위 클래스의 메소드도 사용 가능
        obj2.showValue2();
        System.out.println("=====================================");

        // [3] 멤버변수명이 동일할 경우
        System.out.println(obj2.value1); // 하위클래스 객체를 통해 상위클래스 멤버변수 호출
        System.out.println(obj2.value3); // 하위클래스 객체가 본인 클래스의 멤버변수 호출

        // 상위클래스 멤버변수 value2 = 20; 하위클래스 멤버변수 value2 = 40;로 멤버변수가 동일한 상황에서
        System.out.println(obj2.value2); // 현객체 타입의 멤버변수를 우선시 함 >> 출력 : 40
        상위클래스 obj3 = obj2;
        System.out.println(obj3.value2); //obj3의 현재 타입은 상위클래스이므로, 상위클래스의 멤버수 20을 출력
        System.out.println("=====================================");
        
        // [4] 상위와 하위클래스 내의 메소드 명이 동일할 때,
        // 오버라이딩 overriding : 상속받은 메소드를 재정의
        // 주의 : 메소드 중복 시, 하위 클래스에 오버라이딩된 메소드가 우선시 됨

        obj2.showValue(); // 하위 메소드2 실행
        obj3.showValue(); // 하위 메소드2 실행
                            // obj3은 현재 상위 클래스 타입, but 하위타입의 메소드가 실행 >> "태생 타입의 메소드 실행"

        // 상·하위 클래스에 동일한 멤버변수가 있다면 >> 객체의 현재 타입의 멤버변수를 호출
        // 상·하위 클래스에 동일한 메소드가 있다면 >> 객체의 태생 타입의 메소드를 호출

    }// main end
}//class end
