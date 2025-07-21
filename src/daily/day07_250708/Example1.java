package daily.day07_050708;

public class Example1 {
    public static void main(String[] args) {
        /*
[ 메소드 ]
    : 메소드 = 멤버변수
    1. 정의
        하나의 기능을 수행하는 일련의 코드
    2. 선언
        반환타입 메소드명 ( 타입 매개변수1, 타입 매개변수2){
            실행코드
            return 반환값; (반환값이 없으면 생략 가능 = void)
        };
    3. 용어 정리
        - 메소드명 : 임의의 기능명칭 (카멜표기법 권장)
        - 매개변수 : 메소드 실행 시, 메소드로 들어오는/사용되는 값
            * 없을수도 있음
            * 반드시! 인수 값의 타입과 매개변수의 타입이 일치해야 함
        - 반환타입 : 메소드 실행 후 결과인 반환값의 타입
        - 반환값   : 메소드 실행 후 결과값
            * 반드시! 반환값의 타입과 반환타입이 일치
            * 반환값은 1개만 가능
            * 반환값이 없을 때는 [ void ] 반환타입 키워드 사용
        - 인수값 : 메소드 호출 시 메소드에게 전달하는 값        인수값 ≒ 매게변수
    4. 호출
        (방법 1) 호출하고자 하는 메소드가 다른 클래스일 때,
            1) 클래스명 변수명 = new 클래스명();
            2) 변수명.메소드명();
            3) 타입명 매개변수 = 변수명.메소드명();
         */


        // [1] 클래스에서 메소드 선언
        // [2] 다른 클래스에서 매소드 호출
        //      1) 호출하고자 하는 메소드를 갖는 클래스로 객체 생성
        Calculator cal1 = new Calculator();
        //      2) 호출하고자 하는 메소드를 갖는 객체를 이용한 메소드 호출
        cal1.getPI();   //객체.메소드명

        // [3] 매개변수 X, 반환값 O
        //      : 반환값이 있으면 주로 변수에 저장
        double result = cal1.getPI();

        // [4] 매개변수 X, 반환값 X
        cal1.powerOn();
        //      주의할 점 : 여러 객체들 간의 멤버변수
        //                 new 연산자는 항상 새로운 객체를 만듦
        //                 즉, 객체마다 멤버변수는 다 각자임
        Calculator cal2 = new Calculator();
        System.out.println(cal1.isPowerOn); // true
        System.out.println(cal2.isPowerOn); // false

        // [5] 매개변수 O, 반환값 X
        cal1.printSum(3,5); // 3, 5 : 인수값
        // cal1.printSum(3.14 , 4.45); error!! : 매개변수 타입 int!! 이므로 double(실수)는 입력 불가
        cal2.printSum(10,2); // isPowerOn = false 이므로 "전원이 꺼져 있습니다."가 발생

        // [6] 매개변수 O, 반환값 O
        int result2 = cal1.add(10,3);
        // add 메소드의 타입이 int 이므로 저장할 변수 또한 int


    }
}
