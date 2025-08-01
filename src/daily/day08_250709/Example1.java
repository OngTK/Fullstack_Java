package daily.day08_050709;

public class Example1 {
    /*

    [ 생성자 ]
        1. 정의
            : 객체를 생성할 때 사용되는 초기화를 담당하는 메소드
            클래스명 변수명 = new 생성자명();
        2. 규칙
            1) 클래스명 = 생성자명 (must!!)
                * 클래스명 ≠ 생성자명 : 메소드
            2) overload vs override
                overload :
                        변수명/식별자는 동일한 이름을 가질 수 없음 → 메소드/생성자는 동일한 이름으로 여러 개 만들 수 없음.
                        ** But, 메소드/생성자는 매개변수의 개수/타입/순서가 다르다면
                        동일한 이름으로 여러 개의 메소드/생성자를 선언할 수 있음**
                        ~~why? 객체의 멤버변수는 객체마다 할당되며, 객체의 메소드는 객체 모두에게 공유됨~~
                override :
                        상속관계에 있는 클래스 간에 같은 이름의 메소드를 정의하는 기술
                        만약 자식클래스가 부모클래스에서 선언된 것과 같은 메소드를 가지는 것
        3. 종류
            1) 기본 생성자
                정의 : 생성자명( ){ }
                사용 : new 생성자명();
            2) 매개변수가 있는 생성자
                정의 : 생성자명( 타입 매개변수명, 타입 매개변수명 ){}
            3) 생성자 오버로드
                정의 : 생성자명( 타입 매개변수명, 타입 매개변수명, 타입 매개변수명 ){}
                        // 2번 vs 3번
                        // 매개변소의 타입/순서/개수가 다르므로 생성자가 overload 되었음!
        4.

    */

    public static void main(String[] args) {
        // [1] 기본 생성자를 이용한 객체 생성
        Phone phone = new Phone();

        // [2] 매개변수를 갖는 생성자를 이용한 객체 생성
        Phone p2 = new Phone("Galaxy S25+","White");
        // 목적 :
        //      객체 생성 시 빠른 멤버변수 초기화
        //      협업에 있어서 규칙적인 값 초기화 가능
        // 단점 :
        //      규칙에 의한 복잡도 증가, 자유도 감소

        // [3]
        Phone p3 = new Phone("iphone 15","white",1500000);
        
        // [4] 생성자로 정의되지 않은 매개변수 입력 > 매개변수 불일치로 인한 오류 발생
//        Phone p4 = new Phone(1500000, "iphone 15","white");

    } // main end
} // class end
