package daily.day14_050717;

public interface TestInterface {
    // [3] 멤버변수 >> 불가능
    // int value1;

    // [4] 생성자 >> 불가능
    // TestInterface(){}

    // [5] 메소드 >> 불가능
    // void method1(){}

    // [6] 상수
    int value2 = 10; // interface에서 만든 변수는 무조건 상수 (publice static final이 생략되어 있음)
    int value3 = 20;

    // [7] 추상메소드
    //      실행문`{}`이 없는 메소드
    //      실행문은 각 클래스가 오버라이딩한다.
    //      abstract 생략가능
    abstract void method2();

    boolean method3(int a);
}
