package Practice.Practice_14_250721;

public class Practice_14 {
    public static void main(String[] args) {
        //[JAVA] 실습14 : 예외 처리
        //[ 문제 ] 아래 예외 처리 관련 문제를 해결하시오.
        //[ 제출방법 ] 코드가 작성된 파일이 위치한 깃허브 상세 주소를 제출하시오.

        //[문제 1] ArithmeticException 처리
        //1. 두 정수를 나누는 코드를 작성하세요.
        //2. try-catch 문을 사용하여, 0으로 나눌 때 발생하는 ArithmeticException을 잡으세요.
        //3. catch 블록에서는 "0으로 나눌 수 없습니다." 라는 메시지를 출력하세요.
        //필요 코드:
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다.");
            System.out.println(e);
        }

        System.out.println("==============================");
        //[문제 2] NumberFormatException 처리
        //1. try-catch 문을 사용하여, 아래 코드 실행 시 발생하는 NumberFormatException을 처리하세요.
        //2. catch 블록에서는 "잘못된 숫자 형식입니다." 라는 메시지를 출력하세요.
        //필요 코드:
        try {
            String notANumber = "오류";
            int value = Integer.parseInt(notANumber);
        } catch (NumberFormatException e) {
            System.out.println("잘못된 숫자 형식입니다.");
            System.out.println(e);
        }

        System.out.println("==============================");

        //[문제 3] ArrayIndexOutOfBoundsException 처리
        //1. try-catch 문을 사용하여, 아래 코드 실행 시 발생하는 ArrayIndexOutOfBoundsException을 처리하세요.
        //2. catch 블록에서는 "잘못된 인덱스에 접근했습니다." 라는 메시지를 출력하세요.
        //필요 코드:
        try {
            String[] fruits = {"사과", "바나나"};
            System.out.println(fruits[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("잘못된 인덱스에 접근했습니다.");
            System.out.println(e);
        }

        System.out.println("==============================");

        //[문제 4] NullPointerException 처리
        //1. try-catch 문을 사용하여, 아래 코드 실행 시 발생하는 NullPointerException을 처리하세요.
        //2. catch 블록에서는 "객체가 초기화되지 않았습니다." 라는 메시지를 출력하세요.
        //필요 코드:
        try {
            String text = null;
            System.out.println("글자 수: " + text.toUpperCase());
        } catch (NullPointerException e) {
            System.out.println("객체가 초기화되지 않았습니다.");
            System.out.println(e);
        }

        System.out.println("==============================");

        //[문제 5] finally 블록으로 리소스 정리하기
        //1. "데이터베이스 연결을 시작합니다."를 출력하는 코드를 try 블록에 작성하세요.
        //2. finally 블록을 사용하여, 예외 발생 여부와 상관없이 항상 "데이터베이스 연결을 종료합니다."가 출력되도록 만드세요.
        try {
            System.out.println("데이터베이스 연결을 시작합니다.");
        } finally {
            System.out.println("데이터베이스 연결을 종료합니다.");
        }

        System.out.println("==============================");

        //[문제 6] 다중 catch 블록
        //1. 하나의 try 블록 안에서 NullPointerException 또는 ArithmeticException이 발생할 수 있도록 코드를 작성하세요.
        //2. catch 블록을 두 개 사용하여, 각 예외를 개별적으로 처리하고 어떤 예외가 발생했는지 메시지를 출력하세요.
        //필요 코드
        try {
            String text = null;
            text.length();              //NullPointerException
            int result = 5 / 0;         //ArithmeticException
        } catch (NullPointerException e1) {
            System.out.println(e1);
        } catch (ArithmeticException e2) {
            System.out.println(e2);
        }

        System.out.println("==============================");

        //[문제 7] throws로 예외 떠넘기기
        //Thread.sleep(1000); 코드를 포함하는 pauseOneSecond() 메소드를 만드세요.
        //이 메소드는 try-catch 대신 throws InterruptedException를 사용하여 예외를 떠넘기도록 선언하세요.
        //main 함수에서 pauseOneSecond() 메소드를 호출하고, try-catch를 사용하여 떠넘겨진 예외를 처리하세요.
        //필요 코드
        //Thread.sleep(1000); // 1초간 프로그램 일시정지
        try {
            pauseOneSecond();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("==============================");

        //[문제 8] Exception 클래스로 모든 예외 처리
        //1. try 블록 안에 ArrayIndexOutOfBoundsException을 유발하는 코드를 작성하세요.
        //2. catch 블록을 단 하나만 사용하여, 모든 예외의 부모 클래스인 Exception 타입으로 예외를 처리하세요.
        //3. catch 블록에서는 "알 수 없는 오류가 발생했습니다." 라고 출력하세요.
        //필요코드
        try {
            int[] arr = new int[2];
            System.out.println(arr[5]);
        } catch (Exception e ){
            System.out.println("알 수 없는 오류가 발생했습니다.");
            System.out.println(e);
        }

        System.out.println("==============================");

    }

    static void pauseOneSecond() throws InterruptedException {
        Thread.sleep(1000);
    }

    ;

}
