package Practice.Practice_10_250710;

public class TicketMachine {

    // 멤버변수
    static int totalTickets = 0;

    // 생성자


    // 메소드
    void issueTicket(){
        totalTickets++;
        System.out.println("티켓 1장을 발권했습니다.");
    }

    static void printTotalTickets(){
        System.out.printf("현재까지 총 %d장이 발권되었습니다.\n",totalTickets);
    }

}
