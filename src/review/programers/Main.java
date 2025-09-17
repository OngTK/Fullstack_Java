package review.programers;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] list = new int[10];
        for(int i = 0 ; i < 10 ; i ++ ){
            list[i] = scan.nextInt() % 42 ;
        }

        int count = 0 ;
        for(int i = 0 ; i < list.length ; i++){
            int tmp = 0 ;
            for(int j = i+1 ; j < 10 ; j ++){
                if(list[i]==list[j]){
                    tmp++;
                }
            }
            if(tmp == 0 ){
                count++;
            }
        }
        System.out.println(count);
    }
}
