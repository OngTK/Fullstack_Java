package daily.day23_250730;

/*

[ 컬렉션 프레임워크 2 ]
    Set 인터페이스 : 집합구조, index가 존재하지 않음 > 중복을 허용하지 않으며 element 자체가 식별자
    사용 : 중복없는 집합
    ex ) HashSet, TreeSet etc

*/

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Example2 {
    public static void main(String[] args) {

        // [1] HashSet 객체 생성
        Set<String> set1 = new HashSet<>();

        // [2] 주요 메소드
        
        // [2.1] .add( element ) : 집합 내 element를 삽입
        set1.add("배두훈");
        set1.add("강형호");
        set1.add("조민규");
        set1.add("고우림");
        System.out.println(set1);                       // [배두훈, 조민규, 강형호, 고우림]

        set1.add("배두훈");    // 이미 존재하는 element이므로 중복 불가
        System.out.println(set1);                       // [배두훈, 조민규, 강형호, 고우림]

        // [2.2] .size() : 집합의 총 element 개수를 반환
        System.out.println(set1.size());                // 4
        
        // [2.3] .containts( element ) : element가 존재하면 true, 없으면 false
        System.out.println(set1.contains("강형호"));       //  true

        // [2.4] .remove( element ) : element가 존재하면 삭제
        set1.remove("고우림");
        System.out.println(set1);                           //[배두훈, 조민규, 강형호]

        // [2.5] .inEmpty() : 집합 내 element가 없으면 true, 있으면 false
        System.out.println(set1.isEmpty());                 // false

        // [2.6] .clear() : 집합 내 모든 element를 삭제


        // ※ 집합은 index가 존재하지 않으므로, index를 사용하는 모든 메소드를 사용할 수 없음
        // .get() .set() .indexOf()
        
        
        // [3] Set·집합과 반복문의 관계
        // [3.1] 일반 for
        //          index가 없으므로 사용 불가

        // [3.2] 향상 for
        for(String str: set1){
            System.out.println(str);
        }

        // [3.3] forEach 문
        set1.forEach( (str) -> System.out.println(str));
        
        // [4] 구현체
        // Set 인터페이스 : 순서·index 없고, element를 중복 저장하는 집합체

        // [4.1] HashSet : 일반적으로 가장 많이 사용
        HashSet<Integer> hashSet = new HashSet<>();

        // [4.2] TreeSet : 오름차순 자동 정렬
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(20);
        treeSet.add(10);
        System.out.println(treeSet);        //[10, 20]

        // [4.3] LinkedHashSet : 링크구조 집합체, index는 없지만 linked 되므로 순서가 있음
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        
        // 아래가 가능한 이유!! ☆★☆★☆★ 다형성 ☆★☆★☆★
        Set<Integer> set2;
        set2 = hashSet;
        set2 = treeSet;
        set2 = linkedHashSet;

        
        // [활용] JDBC : ResultSet : 집합구조 -> .next() 메소드
        // -> 집합구조이므로 for문을 쓸 수 없으므로 next 메소드로 다음 element를 가져옴
        
        
    } // main end
} // class end
