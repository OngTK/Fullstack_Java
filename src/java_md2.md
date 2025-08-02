# Java_24_컬렉션 프레임 워크
## 1. 컬렉션 프레임 워크
----
### 1) 정의
자료 수집·구조화 방법

### 2) 종류
#### (1) List 인터페이스
- index·순서를 가지는 배열 구조
#### (2) Set 인터페이스
- index·순서를 가지지 않고, element를 중복 저장이 불가능한 집합 구조
#### (3) Map 인터페이스
- Key·Value를 한 쌍·entry로 하는 여러 쌍의 데이터를 저장하는 구조

### 3) 구현체
#### (1) List 인터페이스
##### ① ArrayList
- 배열 구조로 사용되는 List 구현체
- 메소드 비동기화
- 단일 스레드 플랫품에 적합

##### ② Vector
- 배열 구조로 사용되는 List 구현체
- 메소드 동기화
- 멀티 스레드 플랫폼에 적합

##### ③ LinkedList
- 링크·체인·꼬리연결 구조로 사용되는 List 구현체
- 중간 삽입/삭제를 통한 효율성 극대화

> ※ '링크구조' 란?
>                  [ 5 ] → [ 4 ] → [ 7 ] → [ 10 ]
> 연결 방법 : 자신 + 뒤 값의 주소
>               5·4주소 → 4·7주소 → 7·10주소 → 10·뒤 주소X
> if) 중간 [ 4 ] 삭제 시, index를 전체 옮기는 것이 아니라,
>                      삭제된 element의 앞에 연결된 뒤의 주소만 수정함 >> 처리가 빠름!!!

#### (2) Set 인터페이스
##### ① HashSet
- 일반적으로 가장 많이 사용하는 Set 구현체

##### ② TreeSet
- 오름차순 자동 정렬이 수행되는 Set 구현체

##### ③ LinkedHashSet
- 링크구조 Set 구현체
- index는 없지만 linked 되므로 순서가 있음

#### (3) Map 인터페이스
##### ① HashMap
- 일반적으로 가장 많이 사용하는 Map 구현체

##### ② HashTable
- 동기화 메소드 제공
- 멀티 스레드 플렛폼에 적합

##### ③ TreeMap
- Key를 기준으로 오름차순 정렬

##### ④ Properties
- 별도의 제네릭 타입을 가지지 않음
- 주로 세팅·설정 파일에 사용됨

### 4) 주요 메소드
#### (1) List

| 주요 메소드                            | 설명                                                |
|-----------------------------------|---------------------------------------------------|
| .add( element )                   | element를 리스트 가장 뒤에 추가                             |
| .add( index, element )            | 지정 index에 element를 삽입                             |
| .set( index, element )            | 지정 index에 element를 수정                             |
| .get( index )                     | 지정 index에 element를 호출                             |
| .size()                           | 리스트 내 element의 개수 반환                              |
| .contains( element )              | element가 존재하면 true, 없으면 false                     |
| .indexOf( element )               | element가 존재하면 index 수를 반환, 없으면 -1을 반환             |
| .remove( index )                  | index의 element를 삭제                                |
| .isEmpty()                        | element가 비어있으면 true, element가 존재하면 false          |
| .clear()                          | list의 모든 element를 삭제                              |
| .forEach( ( 반복변수 ) -> { 실행문 } );  | list의 첫번째 요소부터 마지막 요소까지 순서대로 반복변수에 대입하여 실행 </br> -> : 화살표 연산자 |

```java
public class Practice {
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

        // 람다식 함수 =====☆★☆★☆★☆★☆★☆★☆★
        //      복잡한 함수 선언 방식을 간소화
        //      ( 매개변수 ) -> { 실행문 }

    } //main end
} // class end
```

#### (2) Set
※ Set 인터페이스는 index가 존재하지 않으므로, index를 사용하는 모든 메소드를 사용할 수 없음
ex ) .get() .set() .indexOf()

| 주요 메소드                | 설명 |
|-----------------------|----|
| .add( element )       |집합 내 element를 삽입    | 
| .size()               |집합의 총 element 개수를 반환    | 
| .containts( element ) |element가 존재하면 true, 없으면 false    | 
| .remove( element )    |element가 존재하면 삭제    | 
| .inEmpty()            |집합 내 element가 없으면 true, 있으면 false    | 
| .clear()              |집합 내 모든 element를 삭제    | 

```java
public class Practice {
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
    } //main end
} // class end
```

#### (3) Map

| 주요 메소드                  | 설명 |
|-------------------------|----|
| .put( key , value )     |Map 객체에 Key·속성명과 value·속성값을 한 쌍·entry로 한 자료를 삽입|
| .get(Key)               |Map 객체 내에서 Key의 Value를 반환|
| .size()                 |Map 객체내의 entry 개수를 반환|
| .remove(key)            |Map 객체 내의 Key에 해당하는 entry를 삭제|
| .containsKey( key )     |Key가 존재하면 true / 없으면 false|
| .containsValue( Value ) |Value가 존재하면 true / 없으면 false|
| .clear()                |모든 entry를 삭제|
| .isEmpty()              | Map객체 내에 entry가 없으면 true, 있으면 false|
| .entrySet()             |Map 객체내 모든 entry를 set 인터페이스로 반환|
| .keySet()               |Map 객체 내의 모든 key를 set 인터페이스로 반환|
| .values()               |모든 Value를 List 인터페이스로 반환|

```java
public class Practice {
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
    } //main end
} // class end
```

### 5) 인터페이스와 반복문
| 구분 | List인터페이스 | Set인터페이스 | Map인터페이스 |
|---|---|---|---|
|일반 for|O|X|X|
|향상 for|O|O|O|
|forEach|O|O|O|

※ Set, Map 인터페이스는 index를 가지지 않으므로 일반 for문을 사용할 수 없음!!

---

# Java_25_


---

# Java_26_


---

# Java_27_


---

# Java_28_


---

```java
public class Practice {
    public static void main(String[] args) {

    } //main end
} // class end
```

