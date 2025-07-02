package daily.day04_250702;

import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {
    /*
        [반복문]
            1. 정의 : 조건에 따른 결과가 true 일때 코드를 반복 실행
            2. 형태
                for(초기값 ; 조건문 ; 증감식){ 실행문;}

                - 초기값 : 반복문에서 사용되는 변수  ex. int i = 0
                - 조건문 : 반복변수의 조건문        ex. i < 10
                - 증감식 : 반복변수의 증감          ex. i++
                - 실행문 : 조건 충족시 실행되는 코드/명령어;
            3. 실행순서
                초기값 > 조건문(true) > 실행문 > 증감식
                      > 조건문(true) > 실행문 > 증감식
                      > 조건문(false) >> 조건문 종료
            4. for 중첩 가능 : 상위 for문이 1회전 마다 하위 for문은 전체 회전
            5. 주요 키워드
                1) break;    : 가장 가까운 반복문 {} 종료/탈출
                2) continue; : 가장 가까운 반복문(증감식) 이동
            6. 무한루프
                1) for( ; ; ){ }
                2) while(true){ }
    */

        // [1] 1~5까지 출력
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }

        // [2] 중첩 : 구구단
        for (int i = 2; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%d * %d = %d \n", i, j, i * j);
            }
        }

        // [3] break : 1~10까지 출력, 만약 5를 찾으면 반복 종료
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                break; //for 문을 탈출!
            }
            System.out.println(i);
        }

        // [4] continue : 1부터 10까지 반복, 만약 5를 찾았으면 출력 생략
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                continue; //조건 충족시 아래를 수행하지 않고 for문으로 돌아감!
            }
            System.out.println(i);
        }

        // [5] for( ; ; ){} : 무한반복 , 종료조건을 만들어 놓을 수 있음
        for( ; ; ){
            System.out.print("무한입력 [종료:'x'] : ");
            String input = new Scanner(System.in).next(); //무한 입력
            if (input.equals("x")){
                break; // "x"가 입력되면 for(무한반복)문 종료
            }
        }

    }
}
