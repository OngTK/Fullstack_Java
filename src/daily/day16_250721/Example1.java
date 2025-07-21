package daily.day16_250721;

/*
[ 예외 처리 ]
1) 예외
    - 개발자가 구현한 로직이나 사용자 영향으로 발생한 문제

    ※ 시스템 오류
        - 시스템이 종료되는 심각한 수준의 문제

2) 예외의 종류
    (1) 일반 예외
        - 컴파일(실행)될 때, 예외 처리 코드 여부 검사, 즉 인위적으로 발생시킨 예외
        - 입출력, 네트워크, 파일, JBDC, 등 외부와 연동 시, 주로 사용
        - ex)
        Class.forName( 클래스경로 );    : 해당 경로의 클래스 유무를 확인하는 함수
        Thread.sleep( 미리초 );        : 1000 미리초(1초)간 thread가 sleep(정지)
    (2) 실행 예외
        - 컴파일(실행)될 때, 예외 처리 코드 여부 검사를 하지 않고 발생하는 예외
        - 개발자의 경험 의존도가 높음
3) 특징
    - 예외 발생시, 예외를 고치는 것이 아닌 흐름을 제어
    - 프로그램의 24시간 중단 없이 실행하기 위한 안전한 로직 구현을 위해 사용
4) 예외 클래스
    ClassNotFoundException : 클래스를 찾지 못하였을 때, 예외 발생 정보를 저장하는 클래스
    InterruptedException : 흐름이 중단되었을 때, 예외 발생 정보를 저장하는 클래스
    NullPointerException
    NumberFormatException
    ArrayIndexOutOfBoundsException
    InputMismatchException
    
    Exception : 모든 예외들의 상위 클래스(SuperClass)

5) 사용법
    try { '예외가 발생할 것 같은 코드 or 일반예외' }
    catch( 예외클래스명 매개변수명 ){ `예외발생시 실행문` }
    catch(){}
    finally{} : 예외 유무와 상관없이 무조건 실행

*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {
        // [1] 일반 예외
        // 예외 유무와 상관없이 무조건 예외처리를 하는 인위적으로 예외를 발생시킴
        try {
            Class.forName("java.lang.String");
            //Class.forName( 클래스경로 );   : 해당 경로의 클래스를 읽어오는 함수
            // String Class가 존재함 >> 밑의 catch 까지 실행하지 않음
        } catch (ClassNotFoundException e) {
            // catch( 예외클래스면 매개변수명 ) // 예외발생 시 처리를 위한 코드
            System.out.println("[예외발생] String 클래스가 없습니다." + e);
        }

        // [2] 일반예외, 예외 발생
        try {
            Class.forName("java.lang.String2");
            // String2 Class는 존재하지 않음
        } catch (ClassNotFoundException e) {
            System.out.println("[예외발생] String2 클래스가 없습니다." + e);
            // String2 Class가 없으므로 >> catch 실행
        }

        // [3] 일반예외 Thread.sleep
        try {
            Thread.sleep(1000);         // 1000 미리초(1초)간 thread가 sleep(정지)
        } catch (InterruptedException e) {
            System.out.println("[예외발생] sleep 도중에 오류 발생" + e);   //sleep이 발생하지 않으므로 출력되지 않음X
        }

        // [4] 실행예외 : 프로그램 실행 도중 예외 발생가능을 예측
        // NullPointerException
        try {
            String str1 = "강호동";
            System.out.println(str1.length());
            String str2 = null;
            // 자바에서 'null'이란 변수가 참조하는 값/객체가 없다.
            System.out.println(str2.length());
            // NullPointerException : 객체가 없는데 객체를 호출, 접근연산자(.)를 사용하였을 때 발생하는 예외
        } catch (NullPointerException e) {
            System.out.println("[예외발생] str2에 객체가 없으므로. length() 사용 불가" + e);
        }

        // [5] 실행 예외
        // NumberFormatException
        try {
            String str3 = "100";
            String str4 = "1aa";

            Integer.parseInt(str3); // Integer.parseInt(); 문자열 타입을 int 타입으로 변환하는 함수 // String 100 > int 100 변환 가능
            Integer.parseInt(str4); // NumberFormatException 발생 / String 1aa > int 변환 불가!
        } catch (NumberFormatException e) {
            System.out.println("[예외발생] 정수로 변환 불가능" + e);
        }

        // [6] 실행 예외
        // ArrayIndexOutOfBoundsException
        try {
            int[] intArray = {1, 2, 3};
            System.out.println(intArray[0]);
            System.out.println(intArray[4]); // ArrayIndexOutOfBoundsException : array에 index가 존재하지 않음
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("[예외발생] 존재하지 않는 인덱스" + e);
        }

        // [7] InputMismatchException : scanner 사용 시, input의 타입이 일치하지 않을 때,
        try {
            Scanner scan = new Scanner(System.in);
            System.out.print("정수 입력 : ");
            int value7 = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("[예외발생] 입력한 타입과 선언한 변수의 타입이 일치하지 않음" + e);
        }

        // [8] 다중 catch + finally, 상위 클래스 Exception
        try {
            Integer.parseInt("1AA");

            int[] intArray = {1, 2, 3};
            System.out.println(intArray[10]);

            String str = null;
            System.out.println(str.length());
        } catch (NumberFormatException e1) {
            System.out.println(e1);
        } catch (ArrayIndexOutOfBoundsException e2) {
            System.out.println(e2);
        } catch (NullPointerException e3) {
            System.out.println(e3);
        } catch (Exception e4) {
            System.out.println(e4);
        } finally {
            System.out.println("예외가 있든 없든 무조건 실행");
        }

        // ※ 주의!! 
        // 다중 catch 시, 예외는 1번만 발생하며 그에 해당하는 catch 1개만 실행
        // Exception 클래스는 모든 예외를 처리하므로 다중 catch 맨 아래에서 정의
    }
}
