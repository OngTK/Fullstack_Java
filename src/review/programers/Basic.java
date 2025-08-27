package review.programers;

import java.util.Arrays;

public class Basic {
    public static void main(String[] args) {
        // [ day4 ] ====================================

        // [ n의 배수 ]
//        int num = 34;
//        int n = 3;
//        int answer = 0;
//
//        answer = num%n==0?1:0;
//        System.out.println(answer);

        // [ 홀짝에 따라 다른 값 반환하기 ]
//        int n = 10;
//        int answer = 0;
//
//        if ( n%2 == 1 ){
//            for(int i = 1 ; i <= n ; i = i+2 ){
//                answer += i ;
//            }
//        } else {
//            for(int i = 0 ; i <= n ; i = i+2 ){
//                answer += i*i ;
//            }
//        }
//        System.out.println(answer);

        // [ 조건 문자열 ]
//        String ineq = ">";
//        String eq = "!";
//        int n = 41;
//        int m = 78;
//        int answer = 0;
//        if (ineq.equals("<") && eq.equals("=")) {
//            answer = n <= m ? 1 : 0;
//        } else if (ineq.equals(">") && eq.equals("=")) {
//            answer = n >= m ? 1 : 0;
//        } else if (ineq.equals("<") && eq.equals("!")) {
//            answer = n < m ? 1 : 0;
//        } else if (ineq.equals(">") && eq.equals("!")) {
//            answer = n > m ? 1 : 0;
//        }
//        System.out.println(answer);
        
        // [ flag에 따라 다른 값 반환하기 ]
//        int answer = 0;
//        int a = -4;
//        int b = 7;
//        boolean flag = false;
//
//        answer = flag==true?a+b:a-b;
//        System.out.println(answer);

        // [ 카운트 다운 ]
//        int start_num = 10;
//        int end_num = 3;
//
//        int size = start_num - end_num +  1;
//        int[] answer = new int [size];
//        for(int i = 0 ; i < size ; i++ ){
//            answer[i] = start_num-i;
//        }

        // [ 배열 만들기 ]
//        int n = 10;
//        int k = 3 ;
//
//        int size = n/k;
//        int[] answer = new int[size];
//
//        for(int i = 0 ; i < size ; i++){
//            answer[i] = (i+1) * k ;
//        }

        // [ 접두사인지 확인하기 ]
//        String my_string = "banana";
//        String is_prefix = "ban";
//
//        int answer = 0;
//        if (my_string.startsWith(is_prefix)) {
//            answer = 1;
//        }
//        System.out.println(answer);

        // [ 글자 이어 붙여 문자열 만들기 ]
        String my_string = "cvsgiorszzzmrpaqpe";
        int[] index_list = new int[11];

        String answer = "";
        for(int i = 0 ; i < index_list.length ; i++){
            int index = index_list[i];}
    } // main end
} // class end
