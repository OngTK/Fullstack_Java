// 한 줄 주석
/* 여러줄 주석*/

package daily.day01_250627; // 현 java 파일이 위치한 package명, 패키지 = 폴더

public class Example1 {
    // public : 프로젝트 내 모든 곳에서 호출 가능한 키워드
    // class : 클래스 선언
    // 클래스 명 : 첫 글자를 무조건 대문자, 단, 동일 폴더 내에서 중복 불가
    // {} : 클래스의 처음과 끝
    // 자바의 모든 코드는 클래스 안에서 작성!! >> 자바는 모든 컴파일의 단위가 class!!


    // 비교1
    int a = 10; //변수 선언
    //System.out.print( a ); // 출력함수 >> 에러 발생

    // 비교2
    public static void main(String[] args) { //함수 정의
        int b = 20; // 변수 선언
        System.out.print( b ); //출력 함수
    }

    /* 비교1 vs 비교2

    class : 설계도 : 정의를 하는 곳으로 실행되지 않음 (정의되지 않음 함수가 실행되지 않음)
    함수를 실행하기 위해서는 함수를 정의가 우선되어야 함!
    */

    /*
    * JAVA를 실행하는 방법 = main함수 (*thread : 실, 끈, 흐름)
    * main 함수가 자동 실행되면서 코드가 순차적으로 읽혀짐
    *
    * */
}