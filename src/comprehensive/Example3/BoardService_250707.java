package comprehensive.Example3;

import java.util.Scanner;

public class BoardService_250707 {
    //[JAVA] 종합예제3 : boardService3 (객체 활용)
    //[ 목표 ] 종합예제2 에서 객체 문법 추가하여 , 최대 100개의 게시물을 저장하고 조회할 수 있는 간단한 콘솔 게시판 프로그램을 구현합니다.
    //[ 요구사항 ]
    //    1. 게시물 저장 공간 만들기
    //        · 최대 100개의 게시물을 저장할 수 있어야 합니다.
    //        · 각 게시물은 '내용'과 '작성자' 속성 를 가지는 Board 클래스 선언하시오..
    //        · 총 1개의 Board[] 배열변수를 선언하여 저장 공간을 만드세요. (예: Board[] boards = new Board[100] )
    //        · 모든 변수는 null로 초기화하여, 해당 공간이 비어있음을 나타내도록 합니다.
    //    2. 메인 프로그램 흐름 구현하기
    //        · 프로그램은 사용자가 강제 종료하기 전까지 계속 실행되어야 합니다. for(;;) 무한루프를 사용하세요.
    //        · 무한루프 안에서 사용자에게 메뉴를 보여주고, Scanner를 통해 원하는 기능의 번호를 입력받으세요.
    //        · 기능 1: 게시물 쓰기 (입력값: 1)
    //            - 사용자가 1을 입력하면, "내용 : "과 "작성자 : "를 순서대로 물어보고 입력받습니다.
    //            - Board 객체로 생성하여 입력받은 '내용' 과 '작성자'를 각 멤버변수에 대입 합니다.
    //            - 가장 먼저 발견된 빈 공간에 입력받은 내용과 작성자를 저장하고 "[안내] 글쓰기 성공" 메시지를 출력합니다.
    //            - 게시물 공간이 모두 차 있다면, "[경고] 게시물을 등록할 공간이 부족합니다." 라는 메시지를 출력합니다.
    //        · 기능 2: 게시물 출력 (입력값: 2)
    //            - 사용자가 2를 입력하면, 저장된 모든 게시물을 아래 형식으로 출력합니다.
    //            - 저장 공간이 비어있지 않은(null이 아닌) 경우에만 출력합니다.

    //[ 실행 예시 ]  <종합예제2 과 동일 참고>
    //    ============= My Community =============
    //    1.게시물쓰기 | 2.게시물출력
    //    ========================================
    //    선택 > 1
    //    내용 : 안녕하세요
    //    작성자 : 유재석
    //    [안내] 글쓰기 성공
    //
    //    ============= My Community =============
    //        1.게시물쓰기 | 2.게시물출력
    //    ========================================
    //    선택 > 1
    //    내용 : 반갑습니다
    //    작성자 : 강호동
    //    [안내] 글쓰기 성공
    //
    //    ============= My Community =============
    //        1.게시물쓰기 | 2.게시물출력
    //    ========================================
    //    선택 > 2
    //    ============= 게시물 목록 =============
    //    작성자 : 유재석
    //    내용 : 안녕하세요
    //    ------------------------------------
    //    작성자 : 강호동
    //    내용 : 반갑습니다
    //    ------------------------------------
    //
    //    ============= My Community =============
    //        1.게시물쓰기 | 2.게시물출력
    //    ========================================
    //    선택 > 1
    //    내용 : 테스트
    //    작성자 : 이수근
    //    [경고] 게시물을 등록할 공간이 부족합니다.
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Board[] boards = new Board[100];        // 설계class 기반 Board 배열 선언 // 게시물 100 > 변수 2개(객체화) > 변수 1개

        for (; ; ) {                                                           // 무한 루프
            System.out.println("============= My Community =============");
            System.out.println("1.게시물쓰기 | 2.게시물출력");
            System.out.println("========================================");
            System.out.print("선택 > ");
            int choice = scan.nextInt();

            boolean check = false;                                              // true-글쓰기 성공/false-글쓰기 실패
            if (choice == 1) {                                                  // 사용자 1을 선택
                System.out.print("내용 : ");
                String content = scan.next();
                System.out.print("작성자 : ");
                String writer = scan.next();

                Board board = new Board();                                 // 입력받은 content, writer로 객체 생성
                board.content = content;
                board.writer = writer;

                for (int i = 0; i < boards.length; i++) {
                    if (boards[i] == null) {                                // 배열이 비어있으면
                        boards[i] = board;                                 // 생성한 객체를 대입
                        check = true;
                        break;
                    }
                }
                if (check) {                                              // check==true , check 같은 뜻 : if는 true/false에 따른 결과임!!
                    System.out.println("[안내] 글쓰기 성공");
                } else {
                    System.out.println("[경고] 게시물을 등록할 공간이 부족합니다.");
                }
            } else if (choice == 2) {                                           // 사용자 2를 선택
                System.out.println("============= 게시물 목록 =============");

                for (int i = 0; i < boards.length; i++) {
                    if (boards[i] != null) {
                        System.out.println("작성자 : " + boards[i].writer);
                        System.out.println("내용 : " + boards[i].content);
                        System.out.println("------------------------------------");
                    } // 목록 if end
                } // 목록 for end

                /* =========================== 위와 같은방법의 향상 for 문
                    for (Board board : boards) {
                    if (board != null) {
                        System.out.println("작성자 : " + board.writer);
                        System.out.println("내용 : " + board.content);
                        System.out.println("------------------------------------");
                    } // 목록 if end
                } // 목록 for end
                =========================== */


            } // choice end
        } // infinity for end

    } // main end
}
