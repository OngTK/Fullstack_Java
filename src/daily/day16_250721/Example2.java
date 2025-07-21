package daily.day16_250721;

/*
[ 예외 던지기 ]
예외 발생 시, 메소드를 호출한 곳으로 예외를 전달(return)

한 곳에서 예외처리를 하기 위해 메소드 내부에서 발생한 예외를 다른 곳으로 이동·전달·리턴할 수 있음
*/
public class Example2 {

    //(1) 예외가 발생하는 메소드 생성
    // (3) 예외 발생시 예외 던지기(throws)
    // 메소드명() throws 예외클래스명{}

    // 일반예외 클래스는 주로 throws 예외 코드가 존재
    // 실행예외 클래스들은 주로 throws 예외 코드가 없음
    public static void method1() throws NullPointerException{
        String str = null;
        System.out.println(str.length());       // 예외 발생이 예측됨
    }

    public static void method2() throws ClassNotFoundException {
        Class.forName("com.sql.jdbc"); //클래스가 있는지 없는지 모름, 일반예외
    }

    public static void main(String[] args) {
        try {
            //(2) 예외 메소드 실행
            method1();
        } catch ( NullPointerException e) {
            System.out.println("[method1의 예외 발행]" + e );
        }

        try {
            method2();
        } catch (ClassNotFoundException e){
            System.out.println("[method2의 예외발생]" + e);
        }
    }
    



}
