package daily.day21_250728;


/*
[ 스레드풀 ]
1) 정의
    미리 일정 개수의 스레드를 생성하고 필요에 따라 재사용하는 방법

2) 목적
    스레드의 재사용

3) 효과
    자원 효율성, 과부하 방지 etc

4) 구조
    작업 요청 [ 큐 ] 자료구조를 배치하여 순서대로 스레드풀에서 대기중인 스레드에게 작업 배정
        ※ 큐
            : 자료의 데이터들을 요청 순서대로 처리하는 방법

5) 사용처
    (1) 톰켓 (자바웹클래스)
    (2) JDBC
    (3) 업로드/다운로드
    (4) 채팅

6) 사용법

    (1) 작업 스레드 배정

 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Example4 {
    public static void main(String[] args) {

        // (1) 작업 스레드 배정
        // Executor.newFixedThreadPool( 스레드풀에 저장할 스레드 수 );
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // (2) 반복문을 이용하여 각 스레드를 생성
        for(int i = 0 ; i < 3 ; i++){
            String name = "Thread" + i ;

            // (3) 스레드 생성 - 익명 구현체
            Runnable runnable = new Runnable(){
                @Override
                public void run() {
                    try{
                        Thread.sleep(2000);
                    } catch (Exception e ) {System.out.println("[예외발생] + e ");}
                    System.out.println("Task Thread ? ; "+ name);
                } //func end

            }; // 익명구현체 end

            // (4) 생성된 스레드를 스레드풀에 삽입
            executorService.submit( runnable );
        } // for end

        // (5) 스레드풀 종료
        executorService.shutdown();

    } //main end
} // class end




