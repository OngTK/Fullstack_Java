package review.programers;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] list = new int[n];
        for(int z = 0 ; z < m ; z++ ){
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            int k = scanner.nextInt();

            list[z] = 0;

            for( int y = i-1 ; y < j ; y++){
                list[y] = k;
            }
        }

        for(int i = 0 ; i < list.length ; i++ ){
            System.out.print(list[i] + " ");
        }
    }
}
