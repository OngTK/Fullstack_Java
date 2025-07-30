package daily.day23_250730;

/*
[ 컬렉션 프레임 워크 ]
    : 자료 수집·구조화 방법
    - 종류 : List · Set · Map 인터페이스
    - 구현체와 주요 메소드
        1) List
            : ArrayList, LinkedList, Vector etc
            : index·순서를 가지는 배열 구조

            (1) .add( element )         : element를 리스트 가장 뒤에 추가
                .add( index, element )  : 지정 index에 element를 삽입
            (2) .set( index, element )  : 지정 index에 element를 수정
            (3) .get( index )           : 지정 index에 element를 호출
            (4) .size()                 : 리스트 내 element의 개수 반환
            (5) .contains( element )    : element가 존재하면 true, 없으면 false
            (6) .indexOf( element )     : element가 존재하면 index 수를 반환, 없으면 -1을 반환
            (7) .remove( index )        : index의 element를 삭제
            (8) .isEmpty()              : element가 비어있으면 true, element가 존재하면 false
            (9) .clear()                : list의 모든 element를 삭제
            (10) .forEach( ( 반복변수 ) -> { 실행문 } );
                -> : 화살표 연산자
                list의 첫번째 요소부터 마지막 요소까지 순서대로 반복변수에 대입하여 실행
        2) Set
            : HashSet, TreeSet etc
            : index·순서를 가지지 않는 집합 구조
             @@ Example2 확인


        3) Map
            : HashMap, TableMap etc
            : Key·Value를 한 쌍·entry로 하는 여러 쌍의 데이터를 저장하는 구조



*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Example1 {
    public static void main(String[] args) {

        // [1] 인터페이스타입 변수명 = new 클래스명();
        List<String> list1 = new ArrayList<>();         // List 인터페이스에 ArrayList 클래스 객체를 생성 (다형성에 따라 가능)
        ArrayList<String> list2 = new ArrayList<>();    // ArrayList 클래스 객체 생성

        // [2] List 인터페이스 주요 메소드
        // [2.1] .add( 자료 ) : 자료를 리스트에 마지막 요소로 추가
        list2.add("유재석");
        list2.add("강호동");
        list2.add("신동엽");
        list2.add("유재석");
        System.out.println(list2);                  // [유재석, 강호동, 신동엽, 유재석]

        list2.add(3, "박명수");        // 지정 index에 element를 삽입
        System.out.println(list2);                  // [유재석, 강호동, 신동엽, 박명수, 유재석]

        // [2.2] .set( element ) : 지정 index에 element를 수정
        list2.set(4, "정준하");
        System.out.println(list2);                  // [유재석, 강호동, 신동엽, 박명수, 정준하]

        // [2.3] .get( index ) : 지정 index에 element를 호출
        String result = list2.get(2);
        System.out.println(result);                 // 신동엽

        // [2.4] .size() : 리스트 내 element의 개수 반환
        System.out.println(list2.size());           //5

        // [2.5] .contains( element ) : element가 존재하면 true, 없으면 false
        boolean bool = list2.contains("서장훈");
        System.out.println(bool);                              // false

        // [2.6] .indexOf( element ) : element가 존재하면 index 수를 반환, 없으면 -1을 반환
        System.out.println(list2.indexOf("서장훈"));           // -1  >> 존재하지 않음
        System.out.println(list2.indexOf("유재석"));           // 0

        // [2.7] .remove( index ) : index의 element를 삭제
        list2.remove(1);                              // index 1 : 강호동
        System.out.println(list2);                          //[유재석, 신동엽, 박명수, 정준하]

        // [2.8] .isEmpty() : element가 비어있으면 true, element가 존재하면 false
        System.out.println(list1.isEmpty());                // true
        System.out.println(list2.isEmpty());                // flase
        // 유효성 검사를 통해 배열이 비어있는지 확인

        // [2.9] .clear() : list의 모든 element를 삭제
//        list2.clear();
//        System.out.println(list2);                          // []

        // [2.10] list와 반복문 활용
        // [2.10.1] 일반 for 문
        for(int i = 0 ; i < list2.size() ; i++){
            System.out.println(list2.get(i));
        }

        // [2.10.2] 향상된 for 문
        for(String str : list2){
            System.out.println(str);
        }

        // [2.10.3] forEach 문 ☆★☆★☆★☆★☆★☆★☆★
        // list2.forEach( ( 반복변수 ) -> { 실행문 } );
        // list의 첫번째 요소부터 마지막 요소까지 순서대로 반복변수에 대입하여 실행한다.
        System.out.println("[2.10.3]");
        list2.forEach( str -> {System.out.println(str);} );

        // 람다식 함수 =======================================================================☆★☆★☆★☆★☆★☆★☆★
        //      복잡한 함수 선언 방식을 간소화
        //      ( 매개변수 ) -> { 실행문 }


        // =======================================================================☆★☆★☆★☆★☆★☆★☆★
        // [ ArrayList ]    : 배열 구조로 사용되는 List 구현체 + 메소드 비동기화 = 단일 스레드 플랫품
        ArrayList< Integer > arrayList = new ArrayList<>();

        // [ Vector ]       : 배열 구조로 사용되는 List 구현체 + 메소드 동기화처리 = 멀티 스레드 플랫폼
        Vector<Integer> vector = new Vector<>();

        // [ LinkedList ]   : 링크·체인·꼬리연결 구조로 사용되는 List 구현체 + 중간 삽입/삭제를 통한 효율성 극대화
        // 링크구조
        //                  [ 5 ] → [ 4 ] → [ 7 ] → [ 10 ]
        // 연결 : 자신 + 뒤 값의 주소
        //               5·4주소 → 4·7주소 → 7·10주소 → 10·뒤 주소X
        // if) 중간 [ 4 ] 삭제 시, index를 전체 옮기는 것이 아니라,
        //                      삭제된 element의 앞에 연결된 뒤의 주소만 수정함 >> 처리가 빠름!!!

        //                  [ 5 ] → [ 7 ] → [ 10 ]
        //               5·7주소 → 7·10주소 → 10·뒤 주소X

        LinkedList<Integer> linkedList = new LinkedList<>();

        List< Integer > integerList;
        integerList = arrayList;
        integerList = vector;
        integerList = linkedList;


    } // main end
} // class end
