package daily.day14_050717;

/*
[ 다형성 ]
    1. 정의
        다양한 타입을 갖는 성질 
        
[ 인터페이스 ]
    1) 정의
        서로 다른 시스템이나 장치 사이에서 정보를 주고 받는 접점·경계면
    2) 인터페이스 예시
        키보드 : 게임 시 기능 / 문서작업 시 기능 등 프로그램은 다르지만 하나의 키보드로 조작 가능
        리모콘 : 서로 다른 모델/제조사의 TV를 하나의 리모콘으로 조작 가능
        키오스크 : 식당/편의점/병원 등 사용처는 다르지만 동일한 기계로 사용은 가능 
    3) 목적
        서로 다른 장치 사이에, 동일한 목적을 달성하기 위해, 서로 다른 기능을 작동하게 하는 것 (호환성)
    4) 특징
        - 객채간의 교환성(호환성)을 높이고, 다형성을 구현
        - 서로 다른 클래스들 사이에 중간 매개체 역할
    5) 선언
        (1) 선언할 패키지 우클릭 > new > java class > Interface
        (2) 첫글자를 대문자로 하여 Interface 파일 생성
    6) 인터페이스 타입의 멤버
        ※ 멤버변수, 생성자, 메소드 사용 불가능!!
        (1) 상수
            - 반드시 초기값이 필요
            - 상수이므로 `public static final` 키워드가 필요하나 자동으로 포함되므로 생략 가능
        (2) 추상메소드
            - 실행문`{}`이 없는 메소드
            - `abstract` 키워드가 필요하나 자동으로 포함되므로 생략 가능
            - 추상메소드의 실행문은 implements·구현 class 에서 작성
    7)                  상속               VS        구현(인터페이스)
    - 키워드 :         extends                         Implements
    - 객체생성 :          O                                 X
    - 상위 :          하나의 상위클래스                다수의 인터페이스
    - 메소드 :      **선택적 오버라이딩**            **필수적 오버라이딩**
    - 멤버 :       멤버변수, 생성자, 메소드             상수, 추상메소드

*/

public class Example3 {
    public static void main(String[] args) {

        // [1] interface 만들기
        // [2] interface 객체 만들기 >> 불가능
        // TestInterface t1 = new TestInterface();
        // interface 객체는 생성자가 없음! 따라서 객체 생성 불가

        // [6] 상수 불러오기
        System.out.println(TestInterface.value2);
        
        // [7] 추상메소드
        // TestInterface.value2(); // 추상메소드는 구현{}이 없으면 사용 불가

        // [8-2] 구현한 클래스로 객체를 호출 = 구현(객)체 호출
        new Tool(); // ==> 구현체
        Tool tool1 = new Tool();
        TestInterface tool2 = new Tool(); // 구현체는 해당 인터페이스 타입으로 호출도 가능

        tool1.method2();
        tool2.method2();    // 인터페이스로도 구현체의 메소드 수행 가능


        
    }// main end
} // class end

// [8] 구현 객체 (추상메소드 구현을 위한 class)
// class class명 implements 인터페이이스명{} >> 지정한 인터페이스의 추상메소드 구현 전까지는 계속 오류 상태
class Tool implements TestInterface{

    // [8-1] 추상 메소드 구현
    // 추상메소드와 선언부를 동일하게, 실행부는 자유롭게
    @Override
    public void method2() {
        System.out.println("추상메소드2 구현 완료");
    }

    @Override
    public boolean method3(int a) {
        System.out.println("추상메소드3 구현 완료");
        return a>10;
    }
}