package daily.day21_250728;

/*
[ 동기화·비동기화 ]

[ synchronized - 동기화 ]
    1) 정의
        메소드를 lock 하여, 메소드를 점령함
    2) 목적
        여러 스레드가 동시에 하나의 스레드를 사용할 경우,
        시간차에 의하여 멤버변수 충돌이 발생할 수 있음
        이를 방지하기 위하여 동기화를 통해 메소드 lock이 필요
    3) 비교
        동기화 VS 비동기화
        - 동기화 
            : 한 번에 하나의 스레드가 처리
            : 처리 순서가 보장됨
        - 비동기화 
            : 한 번에 여러 개의 스레드가 처리될 수 있음
            : 처리 순서가 보장되지 않음
    4) 사용법
        (1) 메소드 선언부에 키워드 삽입 : synchronized
        (2) synchronized(this){ } 블럭을 이용
        
        
        두 개 이상의 스레드가 하나의 메소드를 호출할 때 비동기 처리 필요.
        
        두 개 이상의 스래드가 하나의 메소드를 사용할 때,
        순서대로 호출 > 처리가 필요 >>>> 동기화
*/

// (1) 유저 1 class ( 1작업 thread )
class User1 extends Thread {
    public Calculator calculator;

    @Override
    public void run() {
        calculator.setMemory(100);
    } 
} // class end

// (2) 유저 2 class ( 2작업 thread )
class User2 extends Thread {
    public Calculator calculator;

    @Override
    public void run() {
        calculator.setMemory(200);
    }
} // class end

// (3) 계산기 클래스 / Object
class Calculator {
    // 멤버변수
    public int memory;

    // 메소드

    // synchronized ☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
    public synchronized void setMemory(int memory) {
        this.memory = memory;
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("[예외발생] + 3" + e);
        }
        System.out.println(this.memory);
    } // func end
} //class end

public class Example3 {
    public static void main(String[] args) {
        // 1. 1개의 계산기 객체 만들기
        Calculator calculator = new Calculator();

        // 2. 1개의 계산기를 2개의 스레드에 대입
        User1 user1 = new User1();
        user1.calculator = calculator;

        User2 user2 = new User2();
        user2.calculator = calculator;
        
        // 두 개의 스레드는 동일한 계산기 객체를 가지고 있음

        // 3. 두 개의 스레드를 실행
        user1.start(); // 200 > synchronized > 100
        user2.start(); // 200 > synchronized > 200
    }
}
