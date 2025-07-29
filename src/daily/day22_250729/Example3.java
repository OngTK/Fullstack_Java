package daily.day22_250729;

/*
[ Generic type ]
1) 정의
    : 여러 가지 타입에서 동작할 수 있도록 만든 키워드
2) 목적
    : 클래스를 정의할 때, 변수 타입을 정하지 않고 인스턴스를 생성할 때 변수 타입을 정함.
    : 즉, 설계시에는 타입을 정하지 않고, 객체 생성시 타입을 정함
    >> 다양한 타입의 데이터를 처리할 수 있음
3) 사용법
    ` < > `

    (1) Class 정의
        class 클래스명< 제네릭타입 >{
            제네릭타입 변수명;
        }
    (2) 인스턴스 생성
        클래스명< 타입명 > 변수명 = new 생성자명<>();
4) 활용처 
    컬렉션 프레임워크
    ArrayList< 제네릭타입 >
5) 특징
    변수의 타입 유연성
    코드 중복 제거
    잘못된 타입 방지
6) 주의
    기본타입을 제네릭타입으로 사용 불가
    기본타입 → wrapper class 는 사용 가능
*/

import java.util.ArrayList;

// 1.
class Box1 {
    String content;
}

// 2.
class Box2 {
    int content;
}

// 3. `< T >` : 제네릭 타입
//            : 클래스에서 타입을 정하지 않고 매개될 수 있음을 표현
// new 인스턴스 생성 시, T에 대한 타입이 정해짐
class Box<T> {
    T content;
}

// 예시 : 배열을 이용한 ArrayList 표현
class miniArrayList<E> {
    E[] data = (E[]) new Object[10];
}

// 4.
class Dto<T, E> {
    T value1;
    E value2;
}

public class Example3 {
    public static void main(String[] args) {

        // 1. String 타입 멤버변수 / String 자료
        Box1 box1 = new Box1();
        box1.content = "안녕하세요.";
        String content1 = box1.content;

        // 2. Int 타입 멤버변수 / int 자료
        Box2 box2 = new Box2();
        box2.content = 100;
        int content2 = box2.content;

        // 3.
        Box<String> box3 = new Box<>();         // 생성자의 제네릭 타입은 생략 가능
        Box<Integer> box4 = new Box<>();

        box3.content = "자바";
        box4.content = 200;
        // 동일한 타입 내에 서로 다른 멤버변수 타입 사용이 가능

        // [활용] 컬렉션 프레임워크
        ArrayList<String> sList = new ArrayList<>();
        ArrayList<Integer> iList = new ArrayList<>();

        // ArrayList : 타입·클래스 / < String > : ArrayList 내에서 사용할 타입

        // 4. 여러 개의 제네릭 타입
        Dto<String, Integer> dto = new Dto<>();
        dto.value1 = "String";
        dto.value2 = 100;

        Dto<Double , Byte> dto2 = new Dto<>();
        dto2.value1 = 3.14;
        dto2.value2 = 99;

        // [활용]
        Dto<Integer, ArrayList<String> > dto3 = new Dto<>();
        dto3.value1 = 3;
        dto3.value2 = new ArrayList<>();


    } // main end
} // class end
