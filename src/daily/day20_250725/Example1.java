package daily.day20_250725;

/*
- 리터럴(상수) 값 / 자료
- 타입 : 값을 분류하는 종류
    * 기본타입 
        : 8가지 
        : byte, short ~~ (소문자)
        : Java에서 기본 제공하는 타입
    * 참조타입 
        : ArrayList / Class / Interface (대문자)
        : 개발자가 만든 타입 or 라이브러리

[ 클래스 ]
    - 기본 타입에 존재하지 않는 새로운 타입에 대한 설계도
    - 라이브러리(도구)로 미리 만들어진 클래스

[ 자바의 기본 클래스 ]
    1. Object 클래스
        - 모든 클래스의 최상위 클래스 (모든 클래스와 상속)
        - 다형성에 따라, 모든 자료를 Object 타입으로 분류 가능
        
        1) 주요 메소드
        - .toString()
            : 객체의 주소를 반환
            : 주로 class에서 override 하여 값이 문자열로 출력하도록 함
        - .equals()
            : 두 객체 내의 값을 비교하여 그 결과를 반환하는 함수 
        - .hashCode()  
            : 객체를 정수로 반환

    2. Class 클래스
        - 클래스의 정보를 담는 Class
        - 리플렉션 : 실행 중 객체할당(동적할당), 멤버 분석 시

        1) 주요 메소드
            - class.forname("Class경로")
                * 지정한 경로에서 클래스를 로드하는 함수
                * 주로 외부 라이브러리 사용 시 이용
                * 예외처리 필수 : 클래스 로딩 성공 / 실패(예외 발생)
            - .getField()
                * 클래스의 모든 멤버변수명을 배열로 반환
            - .getConstructors()
                * 클래스의 모든 생성자를 배열로 반환
            - .getMethods()
                * 클래스의 모든 메소드를 배열로 반환

    3. Wrapper 클래스
        - 기본타입 8개를 참조 타입으로 사용하기 위해 이용
            * 기본타입은 메소드(기능)이 없으므로 Wrapper를 통해 메소드를 제공받음
        1) 종류
            Byte Short Integer Long Boolean Float Double

        2) 주요 메소드
            - .parse타입("문자열"); 
                * 문자열 > 기본타입 변환
                * 문자열을 parse뒤의 타입으로 변환
            - String.valueOf( 자료값 )
                * 자료의 타입을 문자열로 변환
                
    4. LocalDate 클래스
        - 시스템의 날짜/시간 정보 클래스
        1) 주요 메소드

            - LocalDateTime.now()
                * yyyy-MM-ddThh:mm:ss.000000 (nano-sec) 형태로 출력
                * 타입 LocalDateTime
            - LocalDateTime.of(년,월,일,시,분,초) 
                * 지정한 날짜 형태로 반환
                * 타입 LocalDateTime
            
            - 날짜 형식 지정
                - DateTimeFormatter 포멧변수명 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
                    * y 연 / M 월 / d 일 / h 시 / m 분 / s 초   
                - localDateTime.format(포멧변수명);
                    * 지정한 포멧으로 날짜·시간을 String 타입으로 반환

            - 날짜·시간 객체 내에서 원하는 부분만 int 타입으로 반환
                - .getYear();
                - .getMonthValue();
                - .getDayOfMonth();
                - .getHour();
                - .getMinute();
                - .getSecond();

            - 날짜 계산 (반환 타입 LocalDateTime)
                - .plusDays(x);
                    * x일 이후 날짜
                - .minusDays(x);
                    * x일 이전 날짜

*/

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class BookDto {
}

class BoardDto {
    public String toString() {
        return "BoardDto{}";
    }
}

public class Example1 {
    public static void main(String[] args) {

        // [1] Object
        // [1.1] Object의 다향성·타입변환
        Object o1 = 3;                  // 정수를 Object 타입으로 분류 가능
        Object o2 = 3.14;               // 실수를 Object 타입으로 분류 가능
        Object o3 = true;               // 논리를 Object 타입으로 분류 가능
        Object o4 = "유재석";            // 문자열을 Object 타입으로 분류 가능
        Object o5 = new Object();       // 객체를 Object 타입으로 분류 가능
        Object o6 = new int[]{1, 2, 3};   // 배열을 Object 타입으로 분류 가능

        // [1.2] Object의 주요 메소드
        Object o7 = new BookDto();

        // [1.2.1] toString() : 인스턴스·자료의 주소·메모리 위치를 반환
        System.out.println(o7.toString()); // 생략 가능
        System.out.println(o7);
        // daily.day20_250725.BookDto@7cca494b

        // BoardDto Class에서 override하여 문자열로 출력
        Object o8 = new BoardDto();
        System.out.println(o8.toString());  // BoardDto{}

        // [1.2.2] == VS .equals()
        // == : 인스턴스의 주소를 비교
        // .equals() : 인스턴스의 값을 비교

        Object o9 = new BookDto();
        Object o10 = new BookDto();
        System.out.println(o9 == o10); // false
        // 이 경우 타입은 같지만, 객체가 같은지를 판단!
        // o9와 o10는 서로 다른 메모리에 저장된 객체, 즉 서로 다른 주소를 갖음
        System.out.println(o9.equals(o10)); // false

        Object o11 = o9;
        System.out.println(o11 == o9); // true
        System.out.println(o11.equals(o9)); // true

        String str1 = new String("유재석");
        String str2 = new String("유재석");
        System.out.println(str1 == str2);       // false
        System.out.println(str1.equals(str2));  // true

        // [1.2.3] .hashCode() : 객체를 정수값으로 반환
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(o9.hashCode());
        System.out.println(o10.hashCode());
        System.out.println(o11.hashCode());

        System.out.println("=================================");

        // [2] Class
        String str = new String();
        Class c = str.getClass();
        System.out.println(c); // class java.lang.String  Class의 타입 정보를 반환

        Integer value = 3;
        System.out.println(value.getClass()); // class java.lang.Integer

        // [2.1] 주요 메소드

        // [2.1.1] class.forname("Class경로")
        // 지정한 경로에서 클래스를 로드하는 함수 
        // 주로 외부 라이브러리 사용 시 이용
        // 예외처리 필수 : 클래스 로딩 성공 / 실패(예외 발생)
        try {
            Class.forName(" class java.lang.String");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        
        // [2.2.2] .getField()
        // 클래스의 모든 멤버변수명을 배열로 반환
        Field[] fields = c.getFields();
        for(int i = 0 ; i < fields.length ; i ++ ){
            System.out.println(fields[i]);
        }

        // [2.2.3] .getConstructors()
        // 클래스의 모든 생성자를 배열로 반환
        Constructor[] constructors = c.getConstructors();
        for(int i = 0 ; i < constructors.length ; i ++){
            System.out.println(constructors[i]);
        }

        // [2.2.4] .getMethods()
        Method[] methods = c.getMethods();
        for(int i = 0 ; i < methods.length ; i++) {
            System.out.println(methods[i]);
        }

        System.out.println("=================================");
        
        // [3] Wrapper
        int value1 = 100;       // 타입 : int
        Integer value2 = 100;   // 타입 : Integer

        // [3.1] autoboxing VS unboxing

        Integer value3 = value1; 
        // autoboxing : int(기본) > Integer(클래스) : 자동 타입 변환
        int value4 = value2;     
        // unboxing : Integer(클래스) > int(기본) :
        // 클래스에서 기본타입으로 내려가는 것임에도 자동 타입 변환을 지원
        
        // [3.2] 문자열 > 기본타입 변환
        int val1 = Integer.parseInt("100");    // 문자 "100" > 숫자 100
        double val2 = Double.parseDouble("3.14"); // 문자 "3.14" > 실수 3.14
        float val3 = Float.parseFloat("3.14");   // 문자 "3.14" > 실수 3.14
        byte val4 = Byte.parseByte("100");
        short val5 = Short.parseShort("100");
        long val6 = Long.parseLong("100");
        boolean val7 = Boolean.parseBoolean("false");

        // [3.3] 기본타입 > 문자열 변환

        String s1 = 100 +"";
        // 100 + "" = 자료 + 문자열 = 문자열

        String s2 = String.valueOf(100);

        System.out.println("=================================");

        // [4] LocalDate 클래스

        // [4.1] 현재 날짜·시간
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);  //2025-07-25

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);  // 11:36:23.209480800 (nano-sec)

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime); // 2025-07-25T11:37:19.188031


        // [4.2] 지정한 날짜/시간

        // [4.2.1] 날짜 시간 (연,월,일,시,분.초)
        LocalDateTime.of(2025,07,25,11,33,15);

        // [4.3] 날짜·시간 형식 변경
        //  y 연 / M 월 / d 일 / h 시 / m 분 / s 초
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 hh:mm:ss");
        String today = localDateTime.format(formatter);
        System.out.println(today); // 2025년 07월 25일 11:43:08

        // [4.4] 날짜 세부 정보
        int year = localDateTime.getYear();
        int month = localDateTime.getMonthValue();
        int day = localDateTime.getDayOfMonth();
        int hour = localDateTime.getHour();
        int min = localDateTime.getMinute();
        int sec = localDateTime.getSecond();

        // [4.5] 날짜 계산
        
        // 10일 이후의 날짜
        LocalDateTime plusDays = localDateTime.plusDays(10);
        System.out.println(plusDays); // 2025-08-04T11:48:16.075785900

        // -5일 이전의 날짜
        LocalDateTime preDays = localDateTime.minusDays(5);
        System.out.println(preDays); //2025-07-20T11:49:34.710516600

    } // main end
} // class end
