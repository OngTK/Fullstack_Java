package comprehensive.Example_06_250710;

import java.util.Scanner;

public class BoardService6 {
    public static void main(String[] args) {

        for (; ; ) {// (1) 무한루프 : 프로그램 계속적으로 실행하기 위해서
            System.out.println("============= My Community =============");// (2) 출력
            System.out.println("  1.게시물쓰기 | 2.게시물출력");
            System.out.println("========================================");
            System.out.print("선택 > ");
            Scanner scan = new Scanner(System.in); // (3) 입력
            int choose = scan.nextInt();

            if (choose == 1) { // (4) 입력 에 따른 화면 출력
                System.out.print("내용 : ");
                String content = scan.next();
                System.out.print("작성자 : ");
                String writer = scan.next();

                boolean result = BoardController.doPost(content, writer);

                if (result) {
                    System.out.println("[안내] 글쓰기 성공");
                } else {
                    System.out.println("[실패] 저장 실패");
                }

            } else if (choose == 2) {
                System.out.println("============= 게시물 목록 =============");
                Board[] boards = BoardController.doGet();
                for (int i = 0; i < boards.length; i++) {
                    if (boards[i] != null) {
                        System.out.println("작성자 : " + boards[i].getWriter());
                        System.out.println("내용 : " + boards[i].getContent());
                        System.out.println("------------------------------------");
                    }
                }
            }
        } // for end
    }
}
