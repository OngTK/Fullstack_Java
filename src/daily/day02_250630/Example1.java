package daily.day02_250630;

public class Example1 {
    public static void main(String[] args) {

        /* [ 변수 타입변환 = casting]
         *                               ☆★☆★☆★☆★☆★ Java는 다향성을 가짐
         *                               : 하나의 자료가 여러 개의 타입을 가질 수 있음 ☆★☆★☆★☆★☆★
         *
         * 1. 자동 타입변환 (묵시적)
         *    byte > short / char > int > long > float > double
         *    (1) 메모리 크기 小 > 大 로 변환
         *    (2) 데이터 손실이 적다.
         *
         * 2. 강제 타입변환 (명시적)
         *    double > float > long > int > short / char > byte
         *    (1) 메모리 크기 大 > 小로 변환
         *    (2) 데이터 손실이 크다.
         *    (3) (변환할 타입명) 변수명;
         *
         * 3. 연산 타입변환
         *    (1) int 이하의 연산결과는 int
         *      byte + byte = int
         *      byte + short = int
         *      int + int = int
         *    (2) int 이상에서는 연산 결과 두 개 중 더 큰 항으로 자동 타입변환
         * */

        //[1] 자동 타입변환
        byte byteValue = 10;
        short shortValue = byteValue;       // byte > short
        int intValue = shortValue;          // short > int
        long longValue = intValue;          // int > long
        float floatValue = longValue;       // long > float
        double doubleValue = floatValue;    // float > double, doubleValue = 10

        System.out.println(doubleValue);

        //[2] 강제 타입변환
        double dvalue = 3.14;
        float fvalue = (float) dvalue;  // double > float 으로 명시적 타입변환
        long lvalue = (long) fvalue;    // float > long `` // 손실발생 : 3.14 > 3
        int ivalue = (int) lvalue;      // long > int   ``
        short svalue = (short) ivalue; // int > short  ``
        byte bvalue = (byte) svalue;    // short > byte ``

        System.out.println(dvalue);
        System.out.println(fvalue);
        System.out.println(lvalue);
        System.out.println(ivalue);
        System.out.println(svalue);
        System.out.println(bvalue);

        //[3] 연산 타입변환
        byte b1 = 10;
        byte b2 = 20;
        short s1 = 30;
        int i1 = 40;
        long l1 = 50;
        float f1 = 3.14f;
        double d1 = 41.25;

        int result = b1 + b2;       // byte + byte = int
        int result2 = b1 + s1;      // byte + short = int
        int result3 = i1 + i1;      // int + int = int
        long result4 = i1 + l1;     // int + long = long
        float result5 = i1 + f1;    // int + float = float
        double result6 = i1 + d1;   // int + double = double


    } // main end
} //class end
