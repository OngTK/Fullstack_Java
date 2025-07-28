package daily.day21_250728;

/*
- 프로그램 : 코드(명령어)들의 집합
- 프로세스 : 실행중인 프로그램
- 멀티 태스킹 : 두 가지 이상의 작업을 동시에 처리
- 멀티 프로세스 : 동시에 여러 개의 프로세스를 동시에 처리하는 것
    >> 프로그램 단위의 멀티 태스킹
- 멀티 스레드 : 프로세스 내에서 실행되는 자겁 처리 단윈
    >> 하나의 프로그램 내의 멀티 태스킹


[ 스레드 Thread ]
1) 정의
    - 하나의 프로세스 내에서 실행되는 작업의 단위 ≒ 실행 흐름의 단위
2) 목적
    - 스레드를 통해 코드(명령어)를 읽어 CPU가 명령어를 처리하도록 함
3) 자바에서의 스레드
    (1) main method
        : public static void main( String[] args ){} >> main thread를 내장하고 있음
4) 사용법
    (1) main thread·method 선언
        : 자바 프로그램은 항상 main thread·method로 부터 실행 흐름이이 시작됨
        
[ 멀티스레드 Multi Thread ]
1) 정의
    main 스레드 외 새로운 작업 스레드를 생성하여 동시 작업
2) 목적  
    - 병렬 처리 = 동시에 여러 작업을 수행하기 위해
3) 사용처
    - Wep / App, 채팅 / 첨부파일 / JDBC, 동기화/비동기화 처리
4) 사용법
    (1) 익명 구현체
        ``` java
        Thread thread = new Thread(
            new Runnable(){
                @Override
                public void run(){}
            };
        );
        thread.start();
        ```
    (2) 구현체
        ``` java
        Class 작업thread implements Runnable {
                @Override
                public void run(){}
            };
        );
        // main===============================
        public class{
            public static void main(String[] args) {
                Thread thread = new Thread( new 작업Thread );
                thread.start();
            }
        }
        ```

    (3) 상속
        ※ 상속은 클래스당 1번밖에 되지 않아서 사용성이 떨어짐
        ``` java
        class 작업thread extends Thread {
                @Override
                public void run(){}
            };
        // main===============================
        public class{
            public static void main(String[] args) {
                작업thread thread = new 작업thread();
                thread.start();
            }
        }
        ```

5) 주요 Class/Interface
    (1) Thread Class
        ① .start()
        run 추상 메소드를 실행하는 메소드

    (2) Runnable Interface
        ① run(){} 추상 메소드
            : 작업 스레드가 실행되는 최초 시작점
*/

import java.awt.*;

// [2.2] 구현체 =====================================================
class 작업스레드1 implements Runnable {
    @Override
    public void run() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for (int i = 1; i <= 5; i++) {
            toolkit.beep();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("[예외발생] [2.1.2] " + e);
            }
        }
    } // run end
} // class end

// [2.3] 상속 =====================================================
class 작업스레드2 extends Thread {
    Toolkit toolkit = Toolkit.getDefaultToolkit();

    public void run() {
        for (int i = 1; i <= 5; i++) {
            toolkit.beep();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("[예외발생] [2.1.2] " + e);
            }
        }
    } // func end
    // Runnable 없이 run()에 바로 override 함
} // class end

public class Example1 {

    public static void main(String[] args) {

        Toolkit toolkit = Toolkit.getDefaultToolkit(); // Java UI

        // [1] 싱글·단일 스레드
        System.out.println("[1] main thread가 읽어내는 코드");

        for (int i = 1; i <= 5; i++) {
            System.out.println("[1] main thread가 읽어내는 코드" + i);
        }

        for (int i = 1; i <= 5; i++) {
//            System.out.println("[1] Beep sound");
            toolkit.beep(); // beep sound 출력 함수
            try {
                Thread.sleep(1000);             // Thread.sleep = milli sec 만큰 처리·Thread를 지연시킴
            } catch (InterruptedException e) {
                System.out.println("[예외발생] [1] " + e);
            }
        }

        // [2] 멀티 스레드
        // [2.1] 익명 구현체 : 인터페이스 타입을 Class 없이 main Thread 안에서 직접 구현하는 것

        // [2.1.2] 소리 5번 코드
        // new 인터페이스Type(){ 구현 }
        Runnable runnable1 = new Runnable() {
            // Run 추상 매소드 구현
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    toolkit.beep();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("[예외발생] [2.1.2] " + e);
                    }
                }
            }
        }; // new Runnable() end

        // run 메소드를 구현한 > Runnable 인테페이스 > Thread 생성자에 대입
        Thread thread1 = new Thread(runnable1);
        thread1.start();

        // [2.1.1] 출력 5번 코드
        for (int i = 1; i <= 5; i++) {
            System.out.println("[1] main thread가 읽어내는 코드" + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("[예외발생] [2.1.1] " + e);
            }
        }

        // [2.1.1] [2.1.2] 순서를 바꿨음 >> 소리가 나면서 print 되는 것을 보기 위해서

        // [2.2] 구현체
        // [2.2.1] 구현체 스레드 (작업스레드1 구현체 class 참고하기!)
        작업스레드1 작업스레드1 = new 작업스레드1(); // 구현체
        Thread thread2 = new Thread(작업스레드1); // 구현체 '작업스레드1'을 Thread 타입의 thread2 변수에 대입
        thread2.start();                        // Thread 실행 함수 .start()

        // [2.2.2] 출력 5번
        for (int i = 1; i <= 5; i++) {
            System.out.println("[1] main thread가 읽어내는 코드" + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("[예외발생] [2.1.1] " + e);
            }
        }

        // [2.3] 상속
        // [2.3.1] 상속class
        작업스레드2 thread3 = new 작업스레드2();
        thread3.start();


        // [2.3.2] 출력 5번
        for (int i = 1; i <= 5; i++) {
            System.out.println("[1] main thread가 읽어내는 코드" + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("[예외발생] [2.1.1] " + e);
            }
        }

    } // main end

} // class end
