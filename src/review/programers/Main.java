package review.programers;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        char[][] a = new char[5][15];

        for (int i = 0; i < 5; i++) {
            String s = scan.next();
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == ' ') {
                    a[i][j] = '!';
                } else {
                    a[i][j] = s.charAt(j);
                }
            }
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if(a[j][i] ==  '\0' ){
                    continue;
                } else {
                    System.out.print(a[j][i]);
                }

            }
        }
    }
}
