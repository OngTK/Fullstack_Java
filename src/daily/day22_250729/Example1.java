package daily.day22_250729;

/*
[ String 클래스 ]
    - 컴퓨터는 문자는 알지만 문자열은 알지 못함
    - 문자 번역 : 바이트 <-- 번역 --> 문자
        1. 아스키코드
            : 7비트, 128문자 표현 규칙, 영문, 숫자, 특수문자
        2. 유니코드
            : 전 세계 공용어, Java에서 사용

*/

import java.util.Arrays;

public class Example1 {
    public static void main(String[] args) {

        // 1. 배열을 이용한 문자열 표현
        char str1 = '유';                 // 작은 따옴표('')로  감싼 문자 1개 : char 타입
        char[] str2 = {'유','재','석'};    // 작은 따옴표 3개를 char 배열 타입으로 묶음

        // 2.char 타입의 아스키코드 10진수
        char str3 = 65;
        System.out.println(str3);       //  A : char는 정수를 넣었을 때, 영문(or 아스키코드에 따른 문자)을 반환
        char[] str4 = {74,65,86,65};
        System.out.println(Arrays.toString(str4));  // [J, A, V, A] >> 아스키코드를 이용, char배열을 통한 글자 표현

        char str5 = '김';
        System.out.println( (int) str5 );   // 44608 >> 유니코드에 따른 값

        // 3. 문자열 리터럴 : 큰 따옴표("")
        String str6 = "유재석";                        // 리터럴 대입 : 문자열이 동일할 경우, 동일한 객체 취급
        String str7 = "유재석";
        String str8 = new String("유재석");    // 생성자 : 문자열이 동일하더라도 서로 다른 객체로 취급

        // 4. == VS .equals()
        // == : 주소값 비교
        // .equals() : 문자열(객체) 비교
                // Object class에서 .equals()는 객체 비교 함수, 
                // String class에서 override 되어 문자열 비교 함수로 재정의됨
        // ※ 문자는 불변
        
        System.out.println( str6 == str7 );     // true 
        // str6, str7는 리터럴 대입을 통해 동일한 문자열을 대입하였으므로 동일한 주소값을 가짐
        System.out.println( str6 == str8 );     // false  
        // str6은 리터럴 대입 · str8은 생성자 사용으로 객체를 생상하였으므로 서로 다른 주소값을 가짐
        System.out.println( str6.equals(str7)); // true
        System.out.println( str6.equals(str8)); // true

        // 5. 주요 메소드
        // 1) "A".concat("B") : 문자열 연결 메소드 ≒ + 연결 연산자
        String str9 = "자바".concat("프로그래밍");
        System.out.println(str9);

        // 2) StringBuilder class : 문자열을 단계적으로 연결하는 메소드를 제공하는 클래스
        StringBuilder builder = new StringBuilder();
        builder.append("자바");
        builder.append("프로그래밍");
        System.out.println(builder); // 메모리 효율 Good!

        // 3) String.format("형식문자", "A", "B")
        String str10 = String.format("%s %s", "자바", "프로그래밍");
        System.out.println(str10);
        
        // 4) + 연결 연산자
        String str11 = "";
        str11 += "자바";
        str11 += "프로그래밍";
        System.out.println(str11);

        // [활용] JDBC SQL의 매개변수 연결
        String name = "유재석";
        String sql1 = "insert into tb(name) values ( "+name+")";                    // 비추천
        String sql2 = String.format("insert into tb(name) values ( %s )", name);
        String sql3 = "";
        sql3 += "insert into tb(name) values (";                                    //... 비추천 + 띄어쓰기 주의

        StringBuilder builder2 = new StringBuilder();
        builder2.append("insert into tb(name) values (");                           // 그닥.....

    } // main end
} // class end
