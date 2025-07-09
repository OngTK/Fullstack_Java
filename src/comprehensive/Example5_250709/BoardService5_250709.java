package comprehensive.Example5_250709;

import comprehensive.Example4_250708.Board;
import comprehensive.Example4_250708.BoardController;

import java.util.Scanner;

//[JAVA] 종합예제5 : boardService5 (생성자)
//[ 목표 ] boardService4(종합예제4) 에서 객체 생성를 생성자로 변경 하시오.
//[ 이하 조건 ] : boardService4 동일

public class BoardService5_250709 {
    public static void main(String[] args) {


                for( ; ; ) {// (1) 무한루프 : 프로그램 계속적으로 실행하기 위해서
                    System.out.println("============= My Community =============");// (2) 출력
                    System.out.println("  1.게시물쓰기 | 2.게시물출력");
                    System.out.println("========================================");
                    System.out.print("선택 > ");
                    Scanner scan = new Scanner( System.in ); // (3) 입력
                    int choose = scan.nextInt();
                    if( choose == 1 ) { // (4) 입력 에 따른 화면 출력
                        System.out.print("내용 : ");
                        System.out.print("작성자 : ");
                        System.out.println("[안내] 글쓰기 성공");
                    }else if( choose == 2 ) {
                        System.out.println("============= 게시물 목록 =============");
                        System.out.println("작성자 : " );
                        System.out.println("내용 : " );
                        System.out.println("------------------------------------");
                    } // if end
                } // for end


    } // main end
} //class end
