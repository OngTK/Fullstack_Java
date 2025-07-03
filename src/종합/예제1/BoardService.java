package 종합.예제1;

import java.util.Scanner;

public class BoardService {
    public static void main(String[] args) {
//[JAVA] 종합예제1 : boardService1 (변수 활용)
//    [ 목표 ] Scanner, for(;;), if 문과 변수를 활용하여, 최대 3개의 게시물을 저장하고 조회할 수 있는 간단한 콘솔 게시판 프로그램을 구현합니다.
//    [ 요구사항 ]
//        1. 게시물 저장 공간 만들기
//            · 최대 3개의 게시물을 저장할 수 있어야 합니다.
//            · 각 게시물은 '내용'과 '작성자' 정보를 가집니다.
//            · 총 6개의 String 변수를 선언하여 저장 공간을 만드세요. (예: content1, writer1, content2, writer2, content3, writer3)
//            · 모든 변수는 null로 초기화하여, 해당 공간이 비어있음을 나타내도록 합니다.
//        2. 메인 프로그램 흐름 구현하기
//            · 프로그램은 사용자가 강제 종료하기 전까지 계속 실행되어야 합니다. for(;;) 무한루프를 사용하세요.
//            · 무한루프 안에서 사용자에게 메뉴를 보여주고, Scanner를 통해 원하는 기능의 번호를 입력받으세요.
//            · 기능 1: 게시물 쓰기 (입력값: 1)
//                - 사용자가 1을 입력하면, "내용 : "과 "작성자 : "를 순서대로 물어보고 입력받습니다.
//                - 1번 게시물 공간(content1)부터 순서대로 비어있는지(null인지) 확인합니다.
//                - 가장 먼저 발견된 빈 공간에 입력받은 내용과 작성자를 저장하고 "[안내] 글쓰기 성공" 메시지를 출력합니다.
//                - 만약 3개의 게시물 공간이 모두 차 있다면, "[경고] 게시물을 등록할 공간이 부족합니다." 라는 메시지를 출력합니다.
//            · 기능 2: 게시물 출력 (입력값: 2)
//                - 사용자가 2를 입력하면, 저장된 모든 게시물을 아래 형식으로 출력합니다.
//                - 1번 게시물부터 3번 게시물까지, 저장 공간이 비어있지 않은(null이 아닌) 경우에만 출력합니다.
//    [ 실행 예시 ]
//        ============= My Community =============
//        1.게시물쓰기 | 2.게시물출력
//        ========================================
//        선택 > 1
//        내용 : 안녕하세요
//        작성자 : 유재석
//        [안내] 글쓰기 성공
//
//        ============= My Community =============
//        1.게시물쓰기 | 2.게시물출력
//        ========================================
//        선택 > 1
//        내용 : 반갑습니다
//        작성자 : 강호동
//        [안내] 글쓰기 성공
//
//        ============= My Community =============
//        1.게시물쓰기 | 2.게시물출력
//        ========================================
//        선택 > 2
//        ============= 게시물 목록 =============
//        작성자 : 유재석
//        내용 : 안녕하세요
//        ------------------------------------
//        작성자 : 강호동
//        내용 : 반갑습니다
//        ------------------------------------
//
//        ============= My Community =============
//        1.게시물쓰기 | 2.게시물출력
//        ========================================
//        선택 > 1
//        내용 : 테스트
//        작성자 : 이수근
//        [경고] 게시물을 등록할 공간이 부족합니다.

        // 1. 반복 메인 화면 구현
        // 2. 선택에 다른 화면 구현
        // 3. 기능별 메모리 설계
        //4. 각 선택에 따른 기능 구현
        
        // scanner 선언
        Scanner scan = new Scanner(System.in);
        
        // 게시물 관련 변수 선언
        String content1 = null;
        String writer1 = null;
        String content2 = null;
        String writer2 = null;
        String content3 = null;
        String writer3 = null;


        for (; ; ) { // 무한루프 시작

            // 기본으로 출력될 header
            System.out.println("============= My Community =============");
            System.out.println("1.게시물쓰기 | 2.게시물출력");
            System.out.println("========================================");

            // 사용자에게 선택을 받음
            System.out.print("선택 > ");
            int choice = scan.nextInt();


            if (choice == 1) {                      // 사용자 answer = 1 / 게시물 쓰기
                System.out.print("내용 : ");
                String inputContent = scan.next();
                System.out.print("작성자 : ");
                String inputWriter = scan.next();

                if (content1 == null) { // 게시물 1이 비어있으면 내용을 넣고, 아니면 넘김
                    content1 = inputContent;
                    writer1 = inputWriter;
                    System.out.println("[안내] 글쓰기 성공");
                } else if (content2 == null) { // 게시물 2이 비어있으면 내용을 넣고, 아니면 넘김
                    content2 = inputContent;
                    writer2 = inputWriter;
                    System.out.println("[안내] 글쓰기 성공");
                } else if (content3 == null) { // 게시물 3이 비어있으면 내용을 넣고, 아니면 넘김
                    content3 = inputContent;
                    writer3 = inputWriter;
                    System.out.println("[안내] 글쓰기 성공");
                } else {                                          // 게시물 1, 2, 3이 모두 있으면
                    System.out.println(" [경고] 게시물을 등록할 공간이 부족합니다.");
                }

            } else if (choice == 2) {       // 사용자 answer = 2 / 게시물 출력

                System.out.println("============= 게시물 목록 ============="); //default header

                if (content1 != null ) {        // 게시문 1이 비어있지 않으면 출력, 아니면 넘김
                    System.out.println("내용 : " + content1);
                    System.out.println("작성자 : " + writer1);
                    System.out.println("------------------------------------");
                }
                if (content2 != null ) {        // 게시문 2이 비어있지 않으면 출력, 아니면 넘김
                    System.out.println("내용 : " + content2);
                    System.out.println("작성자 : " + writer2);
                    System.out.println("------------------------------------");
                }
                if (content3 != null) {        // 게시문 3이 비어있지 않으면 출력, 아니면 넘김
                    System.out.println("내용 : " + content3);
                    System.out.println("작성자 : " + writer3);
                    System.out.println("------------------------------------");
                }
                if ( content1 == null && content2 == null && content3 == null) {    //3개의 게시물이 모두 비어있으면 경고
                    System.out.println("[경고] 표시할 데이터가 없습니다.");
                }

            } else {
                System.out.println("[경고] 잘못된 선택입니다.");
            }
        }//무한루프 end
//
//
//

    } // main end
} // class end
