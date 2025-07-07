package daily.day06_250707;

import java.sql.Array;
import java.sql.SQLOutput;
import java.util.Arrays;

public class Example1 {
    public static void main(String[] args) {
        /*
        [ 배열 ]
            1. 정의 : 동일한 자료형(타입)의 여러 데이터를 순서대로 저장하는 타입
            2. 특징
                1) 동일한 타임 : 서로 다른 타입은 같은 배열에 저장 불가
                2) 고정 길이 : 한 번 생성된 배열의 길이 수정 불가
                3) 요소 초기값 : 입력된 값이 없다면,
                                정수 0 / 실수 0.0 / 논리 false / 객체(배열) null
            3. 사용법
                1) 선언
                    (1) new 타입[길이];             ex) int[] 변수명 = new int[3];
                    (2) { 값1 , 값2 , 값3 }        ex) double[] 변수명 = { 3.14, 5.1, 78.69 }
                2) 호출
                    (1) 변수명                     : 객체의 주소값 반환
                    (2) Arrays.toString( 변수명 ); : 배열의 요소 갑 반환
                    (3) 변수명[index]              : index는 0부터 시작
                        변수명.length              : 배열의 길이
                3) 수정
                    (1) 변수명 = new 타입[3]        : 전체 배열 수정
                    (2) 변수명[index] = 새로운 값    : 특정 index 값 수정
                4) 삭제/추가
                    특정 요소 삭제 기능이 존재하지 않음
                    Java 배열은 고정길이이므로 중간에 요소 개수 변경 할 수 없음
                5) 배열과 반복문
                    (1) 일반 for
                        for( int index = 0 ; index < 변수명.length ; index++ ){
                            타입 변수명 = 배열변수명[index]
                        }
                    (2) 향상된 for 문
                        - index 없이 배열 내 요소값을 하나씩 변수에 대입 반복
                        for (타입 변수명 : 배열 변수명) {
                        }
                        // in JS
                            for ( let 변수명 : )
         */

        // [1] 배열 선언1                                        only 선언
        int[] array1 = new int[3];

        // [2] 배열 선언2                                        선언 + 초기화
        String[] array2 = { "봄" , "여름", "가을", "겨울"};

        // [3] 출력 : 배열 주소
        System.out.println(array1);                             //[I@4c873330 >> 객체의 주소값 반환
        System.out.println(array2);                             // [Ljava.lang.String;@119d7047

        // [4] 출력 : 배열 내 요소를 문자열로 반환
        System.out.println(Arrays.toString(array1));            // [0, 0, 0]            : array1은 길이 3, int의 빈 배열
        System.out.println(Arrays.toString(array2));            // [봄, 여름, 가을, 겨울]

        // [5] 출력 : 특정 요소 반환
        System.out.println(array1[0]);                          //  0
        System.out.println(array2[0]);                          //  봄

        // [6] 배열의 길이
        System.out.println(array2.length);                      // 4

        // [7] 특정 요소 값 수정
        array1[0] = 10;                                         //  [0,0,0] > [10,0,0]
        System.out.println(array1[0]);                          //
        array2[0] = "Spring";
        System.out.println(array2[0]);                          // [봄, 여름, 가을, 겨울] > [Spring, 여름, 가을, 겨울]
        
        // [8] 배열의 삭제/추가 불가 : 길이 수정 X
        // array1[3] = 30;                                      // error : Index 3 out of bounds for length 3

        // [9] 반복문
        // 일반 for
        for (int i = 0 ; i < array1.length ; i++){
            int value = array1[i];
            System.out.println(value);
        }

        // 향상된 for
        for ( String value : array2) {
            System.out.println(value);
        }

    }
}
