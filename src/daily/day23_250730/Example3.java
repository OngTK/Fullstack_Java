package daily.day23_250730;

/*

[ 컬렉션 프레임워크 3 - Map 인터페이스 ]

*/

import com.sun.source.tree.Tree;

import java.util.*;

public class Example3 {
    public static void main(String[] args) {

        // [1] HashMap 객체 생성 : < Key 타입, Value 타입>
        Map<String, Integer> map = new HashMap<>();

        // [2] 주요 메소드
        // [2.1] .put( key , value ) : Map 객체에 Key·속성명과 value·속성값을 한 쌍·entry로 한 자료를 삽입
        map.put("배두훈", 98);
        map.put("강형호", 97);
        map.put("조민규", 96);
        map.put("고우림", 99);
        System.out.println(map);                    // {배두훈=98, 조민규=96, 강형호=97, 고우림=99}

        map.put("고우림", 95);                       // Key·중복불가 >> 중복이 있을 경우, 덮어쓰기 주의
        System.out.println(map);                    // {배두훈=98, 조민규=96, 강형호=97, 고우림=95}
        // 속성값 주의는 OK~~

        // [2.2] .get(Key) : Map 객체 내에서 Key의 Value를 반환
        System.out.println(map.get("고우림"));         // 95

        // [2.3] .size()    : Map 객체내의 entry 개수를 반환
        System.out.println(map.size());                 // 4

        // [2.4] .remove(key)    : Map 객체 내의 Key에 해당하는 entry를 삭제
//        map.remove("고우림");
//        System.out.println(map);                    //{배두훈=98, 조민규=96, 강형호=97}

        // [2.5] .containsKey( key )    : Key가 존재하면 true / 없으면 false
        System.out.println(map.containsKey("배두훈"));     // true

        // [2.6] .containsValue( Value )    : Value가 존재하면 true / 없으면 false
        System.out.println(map.containsValue(96));      // true

        // [2.7] .clear()    : 모든 entry를 삭제

        // [2.8] .isEmpty() : Map객체 내에 entry가 없으면 true, 있으면 false
        System.out.println(map.isEmpty());              // false

        // [2.9] .entrySet() : Map 객체내 모든 entry를 set 인터페이스로 반환
        System.out.println(map.entrySet());            // [배두훈=98, 조민규=96, 강형호=97]

        // [2.10] .keySet() : Map 객체 내의 모든 key를 set 인터페이스로 반환
        System.out.println(map.keySet());               // [배두훈, 조민규, 강형호]

        // [2.11] .values() : 모든 Value를 List 인터페이스로 반환
        System.out.println(map.values());               // [98, 96, 97]

        // [3] Map과 반복문 관계
        // [3.1] 일반 for
        //      index 없으므로 사용 X

        // [3.2] 향상 For
        for (String key : map.keySet()) {
            System.out.println(key);            // key를 출력
            System.out.println(map.get(key));   // key에 해당하는 value 출력
        }

        // [3.3] forEach
        map.keySet().forEach((key) ->
                {
                    System.out.println(key);
                    System.out.println(map.get(key));

                }
        );
        
        // [활용] JASON ( JS 객체 ) <---> MAP / DTO ( Java 객체 )
        // DTO는 다회성 객체, Map은 1회성 객체 >> 개발자 스타일

        // [4] 구현체
        // [4.1] HashMap
        HashMap<Integer, Object> hashMap = new HashMap<>();

        // [4.2] HashTable
        // - 동기화 메소드 제공
        // - 멀티 스레드 플렛폼에 적합
        Hashtable<Integer, Object> hashtable = new Hashtable<>();

        // [4.3] TreeMap
        // - Key를 기준으로 오름차순 정렬
        TreeMap<Integer, Object> treeMap = new TreeMap<>();

        // [4.4] Properties
        // - 별도의 제네릭 타입을 가지지 않음
        // - 주로 세팅·설정 파일에 사용됨
        Properties properties = new Properties();

        // 다형성
        Map<Integer, Object> map2;
        map2 = hashMap;
        map2 = hashtable;
        map2 = treeMap;


    } // main end
} // class end
