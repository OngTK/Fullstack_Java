package daily.day02_250630;

public class Example3 {
    public static void main(String[] args) {

        /*
        [ 연산자 ]
            1. 산술 연산자
                + - * / %(나머지)
            2. 연결 연산자
                "문자열" + 10 = 문자열 10
                피연산자 중에 문자열이 포함되면 산술이 아닌 문자열 연결
            3. 비교 연산자
                >  <  ==  !=
                결과를 boolean 으로 반환
            4. 논리 연산자
                && and, || or, ! not
            5. 증감 연상자
                변수 값에 1 증가 or 감소
                ++변수명 : 선위 증가
                변수명++ : 후위 증가
                --변수명 : 선위 감소
                변수명-- : 후위 감소
            6. (복합)대입연산자
                = 오른쪽 값을 왼쪽에 대입
                +=, -=, *=, /=, %= 오른쪽 값을 왼쪽 값에 대해 연산한 후 대입
            7. 삼항연산자
                조건 ? 참 : 거짓
                조건1 ? 참1 : 조건2 ? : 참2 : 거짓 vs if문

            ※ 참고
                문자열 비교 : "문자열A".equals("문자열B")
        */

        int x = 10;
        int y = -3;
        // [1] 산술 연산자
        System.out.println(x + y);       // 7
        System.out.println(x - y);       // 13
        System.out.println(x * y);       // -30
        System.out.println(x / y);       // -3 : int/int >> 속성 int 이므로 소수점이 표시되지 않음
        System.out.println(10.0 / 3.0);  // double/double 이므로 소수점 표시
        System.out.println(x % y);       // 1

        // [2] 연결 연산자
        System.out.println(x + "개"); // 10개

        // [3] 비교 연산자
        System.out.println(x > y);      // true
        System.out.println(x < y);      // false
        System.out.println(x >= y);     // true
        System.out.println(x <= y);     // false
        System.out.println(x == y);     // false
        System.out.println(x != y);     // true

        // [4] 논리 연산자(관계 연산자)
        System.out.println(x > 10 && x < 20); // and, false
        System.out.println(y == 10 || y == 20); // or, false
        System.out.println(!(x > 30)); // not(), true

        // [5] 증감연산자
        System.out.println( x++ );    // 10 출력 후 1 증가 : 11
        System.out.println( ++x );    // 11에서 1 증가 후 출력
        System.out.println( x-- );    // 12 출력 후 1 감소 : 11
        System.out.println( --x );    // 11에서 1 감소 후 출력
        
        // [6] 복합 대입 연산자
        int z = 30;                   // 30이라는 자료를 z에 대입
        z += 10;                      // 40 // z + 10 후에 다시 z에 대입
        z++;                          // 41

        // [7] 삼항 연산자
        System.out.println( x >= 60 ? "합격" : "불합격");

        // [8] 문자열 비교와 리터럴 비교는 다르다.
//      System.out.println( "10" == 10 ); // 에러발생!! 숫자 10과 리터럴 10은 서로 다름
        //문자열 비교 : "문자열A".equals("문자열B")
        System.out.println("10".equals("10"));
        System.out.println("admin".equals("admin"));

    } // main end
} // class end
