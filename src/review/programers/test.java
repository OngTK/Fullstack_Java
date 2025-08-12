package review.programers;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {

    }
}

class Solution {
    public String solution(String my_string, int k) {
        String answer = "";
        for(int i = 0 ; i < k ; i++){
            answer += my_string;
        }
        return answer;
    }
}