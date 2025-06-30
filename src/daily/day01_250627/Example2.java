package daily.day01_250627; // 현재.java 파일이 위치한 폴더명

public class Example2 { // class stat : 모든 자바코드는 클래스 안에 존재

    // [1] main 함수 선언
    public static void main(String[] args) { //main start
        // [2] 리터럴
        // - Java 언어 등이 미리 정의한 데이터

        // [3] 출력함수 :  System.out.println( ); , sout
        System.out.println(3);
        System.out.println(5);
        System.out.println('김');

        // [4] 실행 : ctrl + shift + f10

        // [5] 자료형/타입               * 기본자료형 vs 참조자료형
        /* 8가지
        정수 : byte, short, int, long
        실수 : float, double
        문자 : char                      * String : 문자열
        논리 : boolean

         모든 정수는 int
         모든 실수는 double

         */

        // [6] 리터럴 값을 변수(하나의 자료를 저장)에 대입하기
        // 자료형 변수명 = 리터럴 ;

        // 1. boolean : only true or false
        boolean bool1 = true;
        boolean bool2 = false;
        // boolean boo3 = 3; >> 오류!! 3이라는 리터럴은 boolean에 저장 불가!!
        System.out.println(bool1);
        System.out.println(bool2);

        // 2. char : 작은따옴표('')으로 감싼 문자1개
        char ch1 = 'A';
        //char ch2 = 'AB'; >> 오류!! 문자가 2개!!
        //char ch3 = "A"; >> 오류!! 큰따옴표("") 불가!!
        System.out.println(ch1);

        // 3. String : 큰 따옴표("")으로 감싼 문자열
        String str1 = "ABC";
        // String str2 = 'ABC'; >> 오류!! 작은 따옴표('') 불가!!
        System.out.println(str1);

        // 4. byte  : -128 ~ +127 범위의 정수       1 바이트
        byte b1 = 100;
        // byte b2 = 300; > 오류!! 저장범위 초과
        System.out.println(b1);

        // 5. short : 약 +- 30,000 범위의 정수      2 바이트
        short s1 = 32000;
        // short s2 = 50000;  > 오류!! 저장범위 초과
        System.out.println(s1);

        // 6. int   : +- 약 21억 정도의 정수         4 바이트, default 정수 리터럴*
        int i1 = 2100000000;
        // int i2 = 2200000000;  > 오류!! 저장범위 초과
        System.out.println(i1);

        // 7. long  : *- 약 21억 이상의 정수         8 바이트, 리터럴 뒤에 L or l을 기재
        // long l1 = 2200000000; > 오류!! 리터럴 뒤에 L or l을 기재 필요
        long l2 = 2200000000l;
        System.out.println(l2);

        // 8. double : 소수점 17자리까지 표현 가능한 실수, default 실수 리터럴*
        double d1 = 0.123456789123456789;
        System.out.println(d1); // 출력하면 17자리까지만 표현
                // ※ 주의!! double 과 Double은 다름!!!!(자세한 것은 나중에!!)

        // 9. float : 소수점 8자리까지 표현 가능한 실수, 리터럴 뒤 F or f를 기재
        // float f1 = 0.12324567898413; > 오류!! 리터럴 뒤에 F or f 기재 필요!!
        float f2 = 0.12324567898413f; // 출력하면 8자리까지만 표현

    } //main end
} // class end
