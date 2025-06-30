package daily.day02_250630;

import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) {
        
        /* [ 입력 함수 ]
                콘솔화면에서 자료를 입력받는 방법
             1. new Scanner( System.in ); : 시스템으로부터 입력 관련 기능을 제공하는 객체
             2. 종류
                .next()     : 입력받은 문자열 반환 (단, 띄어쓰기 불가)
                .nextLine() : 입력받은 문자열 반환, 띄어쓰기 가능
                        ※ 주의점 
                            nextLine() 앞에 다른 next()가 존재하면 enter(개행)를 포함하므로 문제 발생
                            해결 : nextLine() 앞에 무의미한 nextLine()를 하나 추가
                .nextByte() : 입력받은 정수(byte)를 반환
                .nextShort() : 입력받은 정수(short)를 반환
                .nextInt() : 입력받은 정수(int)를 반환
                .nextLong() : 입력받은 정수(long)를 반환
                .nextFloat() : 입력받은 실수(float)를 반환
                .nextDouble() : 입력받은 실수(double)를 반환
                .nextBoolean() : 입력받은 true/false를 반환

                * .nextChar()는 없음 ☆★☆★☆★☆★☆★
                >> char value8 = scan.next().charAt( 0 ) ;
                >> 입력받은 문자열 중에 첫번째[index 0] 글자를 반환
         */

        // [1] Scanner 객체로부터 next 함수 호출
//        new Scanner( System.in ).next();

        // [2] Scanner 객체를 변수에 저장하여 활용
        Scanner scan = new Scanner(System.in); // 객체타입 : Scanner, 변수명 : scan, 객체 : new Scanner(System.in)

        // [2.1] .next();
        System.out.println("1. next() : ");
        String str1 = scan.next(); //  scan.next(); == new Scanner(System.in).next(); : 위에서 선언했음
        System.out.println("1. next result : " + str1);

        // [2.2] .nextLine();
        System.out.println("2. nextLine() : ");
        scan.nextLine();
        String str2 = scan.nextLine();
        System.out.println("2. next result : " + str2);

        // [2.3] .nextByte();
        System.out.println("3. nextByte() : ");
        byte value1 = scan.nextByte();
        System.out.println("3. nextByte result : "+ value1);

        // [2.4] .nextShort();
        System.out.println("4. nextShort() : ");
        short value2 = scan.nextShort();
        System.out.println("4. nextShort result : "+ value2);

        // [2.5] .nextInt();
        System.out.println("5. nextInt() : ");
        int value3 = scan.nextInt();
        System.out.println("5. nextInt result : "+ value3);

        // [2.6] .nextLong();
        System.out.println("6. nextLong() : ");
        long value4 = scan.nextLong();
        System.out.println("6. nextLong result : "+ value4);

        // [2.7] .nextFloat();
        System.out.println("7. nextFloat() : ");
        float value5 = scan.nextFloat();
        System.out.println("7. nextFloat result : "+ value5);

        // [2.8] .nextDouble();
        System.out.println("8. nextDouble() : ");
        double value6 = scan.nextDouble();
        System.out.println("8. nextDouble result : "+ value6);

        // [2.9] .nextBoolean()

        // nextChar는 없음!
        System.out.println("10. next() : ");
        char value8 = scan.next().charAt( 0 ) ;
        // 입력받은 문자열 중에 첫번째[index 0] 글자를 반환

    }   //main end
}   // class end
