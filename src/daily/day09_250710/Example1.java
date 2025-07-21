package daily.day09_050710;

import daily.day09_050710.package1.A;
import daily.day09_050710.package2.C;

public class Example1 {
/*

[ 접근 제한자 ]
    1. 정의
        클래스, 멤버변수, 생성자, 메소드 등에 접근하는 것을 제한하기 위한 키워드
        실무 시, 보안 필요 or 보안이 필요한 경우 사용
    2. 종류
        1) public
            공개
            프로젝트 폴더 내 어디서든 접근 가능
        2) private
            비공개
            현재 class 내에서만 접근 가능
            일반적으로 Class를 private 처리할 수 없음,
            일반적으로 멤버변수는 private 처리
        3) default
            기본
            접근 제한자를 선언하지 않으면 기본으로 defualt 제한자로 인식
            같은·하위 패키지에서만 접근 가능
        4) protected
            같은·하위 패키지에서만 접근 가능, 단 상속 관계에서는 예외
            ※ 추후 자세히 다룰 예정
    3. 사용
        타입 앞에 기재
        1) 멤버변수에 타입 앞에 기재
            `접근제한자 타입 변수명;`
        2) 생성자명 앞에 기재
            `접근제한자 생성자명( ){ };`
        3) 클래스명 앞에 기재
            `접근제한자 class 클래스명{ }`
        4) 메소드명 반환타입 앞에 기재
            `접근제한자 반환타입 메소드명( ){ }`

[ 패키지 ]
    1. 정의
        폴더와 같은 개념으로 파일들을 저장하는 공간, 일종의 식별자
        동일한 패키지 내에 class 명 중복은 불가함
    2. 사용
        import : 다른 패키지의 class를 불러올 때, class내 상단에 자동 완성으로 작성됨
        ex) import 경로.패키지명.클래스명;
        동일한 패키지 내에서는 import 필요X

        단, java.lang 패키지는 예외/생략가능
            ex) System class, String class etc.

[ getter and setter ]
    1. 정의 
        클래스 내 private 멤버변수를 다른 클래스에서 사용할 수 있도록 정의하는 메소드
    2. 명명
        1) 저장/대입 목적
            public void set멤버변수명( 타입 매개변수 ){
                this.멤버변수명 = 매개변수;
            };
        2) 호출/반환 목적
            public 반환타입 get멤버변수명( ){
                return 멤버변수명;
            }
*/
    public static void main(String[] args) {

        //[1] 하위 package1 > A class에 접근
        A a = new A();
        System.out.println(a.공개변수);        // 접근 가능
        // System.out.println(a.비공개변수);   // 접근 불가 : 비공개변수 = private
        // System.out.println(a.일반변수);     // 접근 불가 : 같은·하위에서만 접근 가능하므로, 상위에서는 접근불가

        // [2] 하위 package2 > C class 접근
        C c=new C();
        // System.out.println(C.비공개변수); // private 이므로 접근 불가
        System.out.println(c.반환메소드());  // 변수는 private 이지만 메소드는 public 이므로 우회해서 접근 가능
        
        // c.저장메소드(3 ) // method가 private 이므로 접근 불가
    }
}
