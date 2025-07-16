package daily.day13_050716;

public class Example1 {
    /*
    [ 상속 ]
        1) 정의
            부모 클래스로 부터 하위 클래스에게 멤버변수, 메소드를 물려주는 행위
        2) 목적
            한 번 만든 클래스 재사용·활용을 위하여
        3) 키워드 : extends (확장·연장)
        4) 특징
            - 유지보수가 편리
            - 계층 표현이 가능
            - 재사용
            - ☆★ **다형성** ☆★
        5) 사용법
            `class 하위클래스 extends 상위클래스{ }`
        6) 주의
            - 상위 클래스는 1개만 존재할 수 있음
            - 하위 클래스가 상위 클래스를 선택
        7) 활용
            - 웹/앱 라이브러리
            - 클래스 간의 멤버변수 중복 시, (클래스 설계에서 미리 잡아두는게 좋음)

    [ 다형성 ]
        1) 자동(묵시적) 타입변환
            (1) 기본타입
                byte > short > int > long > float > double 
            (2) 참조타입
                하위클래스 타입 > 상위클래스 타입
                `class 하위 extents 상위` 상속 관계일 때 만, 가능
        2) 강제(명시적) 타입변환
            (1) 기본타입
                double > float > long > int > short > byte
            (2) 참조타입
                상위클래스 타입 > 하위클래스 타입
                단, 이전에 **하위>상위 변환**이 있었던 객체에 한해서만 가능
                ```
                    하위 obj1 = new 하위();     // 최초 타입 : 하위
                    상위 obj2 = obj1;           // 상속에 따라 하위 >> 상위
                    하위 obj3 = (하위)obj2;     // 최초 타입과 일치한다면, 상위>>하위로 강제 타입 변환
                ```    
    */
    public static void main(String[] args) {
        // [5] 동물 클래스 객체 생성
        동물 animal = new 동물();
        animal.name = "강아지";
        animal.show();

        // [6] 조류 클래스 객체 생성
        조류 bird = new 조류();
        bird.name = "비둘기"; // 조류 class에 존재하지 않지만 상위class인 '동물'의 멤버변수를 상속받아 사용
        bird.show();         // 조류 class에 존재하지 않지만 상위class인 '동물'의 메소드를 상속받아 사용

        // [7] 참새 클래스 객체 생성
        참새 sparrow = new 참새();
        sparrow.name = "참새";
        sparrow.show();             // 상위의 상위로부터 멤버변수, 메소드를 상속받아 사용

        // [8] 닭 클래스 객체 생성
        닭 chicken = new 닭();
        chicken.name = "닭";
        chicken.show();             // 상위의 상위로부터 멤버변수, 메소드를 상속받아 사용


        // [ 다형성 ]
        // (1) 참새(객체)의 형식/타입/클래스 >> 조류로 변경
        조류 bird2 = sparrow; // 객체가 바뀌는 것이 아니라!! 타입만 바뀌는 것!!

        // (2) 참새 >> 동물
        동물 amimal2 = sparrow;
        
        // (3) 동물 >> 참새 : 불가능
        // 참새 sparrow2 = animal; Error 발생!
        // 조류 bird3 = animal;    Error 발생!

        // ※ 상위 타입에서 하위타입 변경 가능 조건!!
        // 객체의 최초 타입이 하위이면서, 상위 타입을 거치고 돌아올 경우만 가능

        닭 obj1 = new 닭();     // 최초 타입 : 닭
        동물 obj2 = obj1;       // 상속에 따라 동물 타입 가능
        닭 obj3 = (닭)obj2;     // 최초 타입과 일치한다면 강제 타입 변환
        
        // ※ 형제 관계에서는 타입변환 불가
    }
}

// [1] 동물 class 생성
class 동물{
    // 멤버변수
    String name; 

    // 메소드
    void show(){
        System.out.println("내 이름은 " + name);
    }
}
// [2] 조류 class 생성 - 동물 class 상속
class 조류 extends 동물{
    
}

// [3] 참새 class 생성 - 조류 class 상속
class 참새 extends 조류{

}

// [4] 닭 class 생성 - 조류 class 상속
class 닭 extends 조류{

}