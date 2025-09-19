package review.programers;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        // [기초 - day3 - 더 크게 합치기]
//        int a = 9;
//        int b = 91 ;
//        int answer = 0;
//
//        String result1 = a + "" + b;
//        String result2 = b + "" + a;
//
//        if( Integer.parseInt(result1) > Integer.parseInt(result2) ){
//            answer = Integer.parseInt(result1);
//        } else {
//            answer = Integer.parseInt(result2);
//        }
//
//        System.out.println(answer);

        // [기초 - day3 - 두 수의 연산값 비교]
        int a = 91;
        int b = 2;

        int result1 = Integer.parseInt(a + "" + b );
        int result2 = 2 * a * b ;

        int answer =  result1 >= result2 ? result1 : result2;
        System.out.println(answer);


    }
}

//class Solution {
//    public String solution(String my_string, int k) {
//        String answer = "";
//        for(int i = 0 ; i < k ; i++){
//            answer += my_string;
//        }
//        return answer;
//    }
//}