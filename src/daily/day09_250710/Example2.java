package daily.day09_050710;

class D {
    // final int 최종변수; // 초기값이 없으므로 에러 발생
    final int 최종변수 = 10;

    static int 비멤버변수; // 객체내 포함하지 않고 new 하지 않아도 사용 가능

    // [3] 상수 만들기
    static final int 상수 = 10;

    // [5] static이 아닌 메소드에서 static 있거나 없는 메소드 호출 가능 여부
    void 멤버메소드1(){}
    static void 비멤버메소드 (){}
    void 멤버메소드2(){
        멤버메소드1();   // 멤버메소드1 : 메모리 할당X vs 멤버메소드2 : 메모리 할당X : 둘 다 할당되지 않은 상태이므로 문제 없음
        비멤버메소드();  // 멤버메소드2 : 메모리 할당X vs 비멤버메소드 : 메모리 할당O
                        //     : 비멤버메소드를 실행할 멤버메소드 자체가 할당안된 상태이므로 비멤버메소드의 할당 유무는 중요하지 않음
    }
}

public class Example2 {
/*
[ final ]
    1. 수정 불가능한 상태 = 고정 상태 정의하는 키워드
    2. 사용법
        final 타입 멤버변수명
    3. 주의
        초기값은 필수

[ static ]
    1. 실행 중에 변화가 없는 상태를 정의하는 키워드
        = 프로젝트 컴파일 시 메모리에 할당되고, 종료시 메모리가 삭제되는 키워드
    2. 사용법
        static 타입 멤버변수 >> static변수·정적변수·공유변수·전역변수
    3. 주의
        멤버변수 = 객체 내 변수 VS static = 객체 외 변수(우선 할당)
        메모리 할당 시점 : new 선언 VS static 자체
        
        프로그램 내에서 단 1개만 존재하는 변수를 선언할 때 사용,
        서로 다른 객체들이 공유하여 사용
        
    4. 호출
        클래스명.정적변수명;

    5. static 유무가 중요한 이유☆★☆★
        static으로 선언된 메소드는 동일한 클래스 내 다른 메소드를 호출할 수 없음.
        
        enable ex)
        ```
        class Text{
            void main2(){}
            static main3(){}
            static void main(){
                main2() // 불가능 : main-메모리가 할당되어 있음 / main2-메모리가 할당되어 있지 않음! >> 따라서 main2 메소드를 실행할 수 없음
                main3() // 가능 : main, main3 모두 메모리가 할당되어 있으므로, main3 메소드 실행 가능

                new Text().main2() 
                    // 가능 : 클래스 전체에 대한 할당/객체 생성 후 main 2 메소드를 선언함
                              >> main, main2에 모두 메모리가 할당되어 있으므로, main2 메소드 실행 가능
            }
        }
        ```
                       
[ 상수 ]
    변하지 않는 변수
    1. 사용법
        static final 타입 상수명;
    2. 주의
        수정 불가
        프로그램 내에서 단 1개만 존재 가능
        상수명을 전체 대문자로 명명
*/

    // [ static - 5 ]
    void 멤버메소드(){}

    static void 비멤버메소드(){}

    public static void main(String[] args) {

        // [1] final 멤버변수 호출
        D d = new D();
        System.out.println(d.최종변수); // 호출은 가능
        // d.최종변수 = 5; // final 키워드로 인하여 수정 불가

        //[2] static 정적변수 호출
        System.out.println(D.비멤버변수); // 클래스명.정적변수
        D.비멤버변수 = 20;
        System.out.println(d.비멤버변수); // 객체.정적변수 >> 객체에게도 사용이 가능! >> 공유 변수·전역변수
        
        // 클래스에 있는 모든 객체가 static 변수를 공유함!!

        // [3] 상수 호출
        System.out.println(D.상수); // 클래스명.상수
        
        // [4] static 메소드 내 static 있거나 없는 메소드 호출 가능 여부
        //멤버메소드(); // 메모리가 할당되지 않으므로 사용 불가
        비멤버메소드(); // static으로 메모리가 우선 할당되었으므로 사용 가능
        Example2 exam = new Example2();
        exam.멤버메소드();

    }
}
