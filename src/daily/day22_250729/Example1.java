package daily.day22_250729;

/*
[ String 클래스 ]
    - 컴퓨터는 문자는 알지만 문자열은 알지 못함
    - 문자 번역 : 바이트 <-- 번역 --> 문자
        1. 아스키코드
            : 7비트, 128문자 표현 규칙, 영문, 숫자, 특수문자
        2. 유니코드
            : 전 세계 공용어, Java에서 사용

    1. 문자열 사용하는 방법
        1) "문자열"                : 큰 따옴표("")안에 문자열 표현
        2) new String("문자열")    : 생성자를 이용한 문자열 표현
    2. 문자열 비교 방법
        1) 문자열A == 문자열B       : 리터럴 문자만 비교 가능
        2) 문자열A.equals(문자열B)  : 리터럴과 객체 문자열 비교 가능
    3. 주요 메소드
        1) 문자열A.concat(문자열B)                            : 연결 메소드
        2) String.format("형식문자", 문자열)                  : 지정한 형식으로 문자열을 반환하는 메소드
        3) StringBuilder builder = new StringBuilder();     : 문자열을 연결해주는 클래스
            builder.append(문자열A);
        4) 문자열.charAt( index );                 : 지정한 index의 문자 1개를 반환
        5) 문자열.length();                        : 문자열의 길이(글자 수) 반환
        6) 문자열.replace( Asis, Tobe)             : 문자열 내의 Asis문자를 tobe문자를 바꾼후 새로운 문자열로 저장하는 함수, 1개         
           문자열.replaceAll( Asis, Tobe)          : 문자열 내의 Asis문자를 tobe문자를 바꾼후 새로운 문자열로 저장하는 함수, 모든           
        7) 문자열.subString( StartIndex, EndIndex) : 문자열 내의 StartIndex부터 EndIndex 전까지 문자열을 반환
        8) 문자열.split( 구분문자 )                 : 문자열을 구분문자로 나눈 후, String[] 타입으로 반환
        9) 문자열.indexOf("찾을문자열")             : 문자열 내 "찾을 문자열"이 존재하면 index 번호 / 없으면 -1을 반환
        10) 문자열.contains("찾을문자열")           : 문자열 내 "찾을 문자열"이 존재하면 ture / 없으면 false을 반환
        11) 문자열.getBytes()                      : 문자열을 byte[] 타입으로 반환    
            new String( byte[] )                  : byte[] 타입을 String 타입으로 반환

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


        // 5) .charAt( 인덱스 ) : 지정한 인덱스 번호의 문자 1개 반환 메소드
        char gender = "012345-1234567".charAt(7);
        System.out.println(gender);                         // 1
        // [활용] scan.next().charAt(x) : console에서 받은 값의 index x 번째 1개를 추출

        // 6) . length() : 문자 수 반환 메소드
        System.out.println("012345-1234567".length());      // 14
        // [활용] 반복문

        // 7) .replace( As-is문자열, To-be문자열 )
        //      : 문자열 추출 > As-is문자열 삭제, To-be문자열 삽입 > 새로운 문자열 생성 메소드
        //      : 새로 생성하는 메소드이므로 주소값이 바뀜
        String str12 = "자바프로그래밍".replace("자바","Java");
        System.out.println(str12);
        // [활용] HTML 줄바꿈 <br> >> Java '\n'
        String htmlData = "유재석<br>안녕하세요.";
        htmlData.replaceAll("<br>","\n");

        // 8) .subString( 시작인덱스, (끝인덱스) ); : 시작 인덱스부터 마지막 인덱스 전까지 추출
        String str13 = "012345-1234567".substring(0,6);
        System.out.println(str13);      // 012345

        String str14 = "012345-1234567".substring(7);  // 7번 index부터 마지막 까지 출력
        System.out.println(str14);      // 1234567
        // [활용] 차량번호 조회 : 214가7531 / 차량번호 뒷차리 = 차량번호.subString( 차량번호.length()-4 )

        // 9) .split("구분문자") : 문자열 내 구분문자를 기준으로 문자열을 자른 후 배열로 반환
        String[] str15 = "012345-1234567".split("-");
        System.out.println(str15[0]);           // 012345
        System.out.println(str15[1]);           // 1234567
        // [활용] CSV 형식 다루기
        //      쉼표(,)로 속성을 구분하고 \n으로 줄구분을 함
        //      날짜(y-m-d) / 주소 (시, 군, 구, 동)

        // 10) .indexOf("찾을 문자열") : 문자열 내 "찾을 문자열"이 존재하면 찾은 인덱스를 반환, 없으면 -1을 반환
        int findIndex = "자바 프로그래밍 언어".indexOf("프로");
        System.out.println(findIndex);      // 3
        // [활용] 검색

        // 11) .contains("찾을 문자열") : 문자열 내 "찾을 문자열"이 존재하면 true, 없으면 false
        boolean findBool = "자바 프로그래밍 언어".contains("프로");
        System.out.println(findBool);       //true
        // [활용] 검색

        // 12) .getBytes() : 지정 문자열을 byte[] 타입으로 반환하는 메소드
        byte[] str16 = "JAva program".getBytes();
        System.out.println(Arrays.toString(str16));     // 아스키 코드 [74, 65, 118, 97, 32, 112, 114, 111, 103, 114, 97, 109]
        // [활용] 파일처리, 네트워크 통신 etc


    } // main end
} // class end
