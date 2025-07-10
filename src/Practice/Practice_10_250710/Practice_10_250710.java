package Practice.Practice_10_250710;

public class Practice_10_250710 {
    public static void main(String[] args) {

//[JAVA] 실습10 : 접근 제한자와 주요키워드
//[ 문제 ] 아래 접근 제한자와 주요키워드 관련 문제를 해결하시오.
//[ 제출방법 ] 코드가 작성된 파일이 위치한 깃허브 상세 주소를 제출하시오.

//[문제 1] Member 클래스를 만드세요.
//        1. 이 클래스는 private 접근 제한자를 가진 id(문자열) 멤버 변수를 가집니다.
//        2. private으로 선언된 id 필드의 값을 저장하고,
//              반환할 수 있도록 public 접근 제한자를 가진 setId()와 getId() 메소드(Getter/Setter)를 만드세요.
//        3. main 함수에서 Member 객체를 생성하고,
//              setId()로 아이디를 "admin"으로 설정한 뒤, getId()로 설정된 아이디를 가져와 출력하세요.

        Member member = new Member();
        member.setId("admin");
        System.out.println(member.getId());

//[문제 2] Score 클래스를 만드세요.
//        1. private 접근 제한자를 가진 score(정수) 멤버 변수를 가집니다.
//        2. 점수를 설정하는 setScore(int score) 메소드를 정의하세요.
//        3. 이 메소드는 매개변수로 받은 점수가 0 이상 100 이하일 경우에만 멤버 변수 score에 값을 저장하고,
//              범위를 벗어나면 "유효하지 않은 점수입니다."라고 출력해야 합니다.
//        4. main 함수에서 Score 객체를 생성하고,
//              setScore(85)와 setScore(120)를 각각 호출하여 결과가 올바르게 나오는지 확인하세요.

        Score score = new Score();
        score.setScore(85);
        score.setScore(120);

//[문제 3] BankAccount 클래스를 만드세요.
//        1. private 접근 제한자를 가진 accountNumber(문자열) 멤버 변수를 가집니다.
//        2. 객체를 생성할 때만 계좌번호를 설정할 수 있도록, accountNumber를 초기화하는 생성자를 만드세요.
//        3. 계좌번호를 외부에서 읽을 수만 있도록 public 접근 제한자를 가진
//              getAccountNumber() 메소드(Getter)만 정의하세요. (Setter는 만들지 않습니다.)
//        4. main 함수에서 "123-456"을 계좌번호로 가진 객체를 생성하고,
//              getAccountNumber()로 계좌번호를 출력하여 확인하세요.

        BankAccount account = new BankAccount("123-456");
        System.out.println(account.getAccountNumber());

//[문제 4] CircleCalculator 클래스를 만드세요.
//        1. 이 클래스 안에, 원주율(PI)을 저장할 final double PI = 3.14159; 상수를 선언하세요.
//        2. 반지름(정수)을 매개변수로 받아,
//              원의 넓이(반지름 * 반지름 * PI)를 계산하여 출력하는 printCircleArea 메소드를 정의하세요.
//        3. main 함수에서 CircleCalculator 객체를 생성하고, 반지름이 5인 원의 넓이를 출력하세요.

        CircleCalculator circle = new CircleCalculator();
        System.out.println(circle.printCircleArea(5));

//[문제 5] TicketMachine 클래스를 만드세요.
//        1. 이 클래스 안에, 발권된 총 티켓 수를 저장할 static int totalTickets = 0; 정적 변수를 선언하세요.
//        2. 티켓을 한 장 발권하는 issueTicket() 인스턴스 메소드를 만드세요.
//              이 메소드는 호출될 때마다 totalTickets를 1씩 증가시키고, "티켓 1장을 발권했습니다."라고 출력합니다.
//        3. 현재까지 발권된 총 티켓 수를 출력하는 static void printTotalTickets() 정적 메소드를 만드세요.
//        4. main 함수에서 TicketMachine 객체 3개(machine1, machine2, machine3)를 생성하세요.
//        5. machine1으로 티켓 2장, machine2로 티켓 1장을 발권한 뒤,
//              TicketMachine.printTotalTickets()를 호출하여 총 발권 수가 올바르게 나오는지 확인하세요.

        TicketMachine machine1 = new TicketMachine();
        TicketMachine machine2 = new TicketMachine();
        TicketMachine machine3 = new TicketMachine();

        machine1.issueTicket();
        machine1.issueTicket();
        machine2.issueTicket();
        TicketMachine.printTotalTickets();

//[문제 6] 게임의 고정 설정 값을 관리하는 GameConfig 클래스를 만드세요.
//        1. 이 클래스 안에,
//              어디서든 접근 가능하며 절대 변하지 않는 다음 상수들을 public static final로 선언하세요.
//                  최대 레벨 MAX_LEVEL = 99
//                  최대 HP MAX_HP = 10000
//                  게임 이름 GAME_TITLE = "My RPG"
//        2. main 함수에서 객체를 생성하지 않고,
//              GameConfig.GAME_TITLE과 같이 클래스 이름으로 직접 접근하여 모든 설정 값을 출력하세요.

        System.out.println(GameConfig.GAME_TITLE);
        System.out.println(GameConfig.MAX_LEVEL);
        System.out.println(GameConfig.MAX_HP);


    }
}
