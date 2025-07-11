package Practice.Practice_10_250710;

public class TicketMachine {

    // 멤버변수
    static int totalTickets = 0; //정적변수

    // 생성자


    // 메소드
    
    // 인스턴스(객체) 메소드
    // static 을 선언하지 않으면 인스턴스 메소드
    void issueTicket(){
        totalTickets++;
        System.out.println("티켓 1장을 발권했습니다.");
    }

    // 정적 메소드
    static void printTotalTickets(){
        System.out.printf("현재까지 총 %d장이 발권되었습니다.\n",totalTickets);
    }

}
