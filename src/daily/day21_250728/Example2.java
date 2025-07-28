package daily.day21_250728;

// [ 시계 만들기 ]
import java.time.LocalTime;
import java.util.Scanner;

// [2] 시계 스레드
class WatchTread implements Runnable{
    @Override
    public void run() {
        for(;;){
            System.out.println(LocalTime.now());
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("[예외발생] 2 " +e);
            }
        }
    }// func end
} // class end

// [3] 타이머 스레드
class TimerThread extends Thread{
    Boolean state = true;

    @Override
    public void run() {
        int second = 0;
        for(;;){
            if(state == false){
                break;
            }
            second++;
            System.out.println("[타이머] 초 : " + second);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("[예외발생] 3 " +e);
            }
        } // infinite loop end
    } // func end
} // class end

public class Example2 {
    public static void main(String[] args) {
        
        // [1] 메인·입력 스레드

        // [2] 시계 스레드
        WatchTread watchTread = new WatchTread();       // interface 구현체 선언
        Thread thread = new Thread(watchTread);         // thread에 구현체 삽입
        thread.start();

        // [3] 타이머 스레드
        TimerThread timerThread = null;

        for(;;){
            System.out.println(" 타이머 1 : on | 타이머 2 : off");
            Scanner scan = new Scanner(System.in);
            System.out.print("선택 : ");
            int choice = scan.nextInt();
            if(choice == 1 ) {          // 타이머 스레드 on
                timerThread = new TimerThread();
                timerThread.start();
            } else if (choice == 2 ) {  // 타이머 스레드 off
                if( timerThread != null)
                timerThread.state = false;
            }
        } // infinite loop end
    } // main end
} // class end
