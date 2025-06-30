package daily.day01_250627;

public class Example3 {
    public static void main(String[] args) {
        /*
        [ 출력함수 ]
            System : 시스템 관련 기능을 제공하는 클래스
            out : 출력 관련 객체를 반환

            (1) System.out.print();   : 출력 함수
            (2) System.out.println(); : 출력 후 출바꿈
                - 자동완성 : sout
            (3) System.out.printf("형식" , 값 );  : 정해진 형식(format)의 출력 함수
                - 자동완성 : souf
                - 형식
                    %s : 문자열 위치
                    %c : 문자 위치
                    %d : 정수 위치
                    %f : 실수 위치
                    %자릿수d : 표현할 자리수를 작성
                        %자릿수d : 숫자만큼 자릿수 + 오른쪽 정렬
                        %-자릿수d : 숫자만큼 자릿수 + 왼쪽 정렬
                        %0자릿수d : 숫자만큼 자릿수 + 오른쪽 정렬 + 빈칸을 모두 0으로 채움
                        %전체자릿수.소수점자릿수d : 소수점을 포함한 전체자릿수와, 수소점 자릿수를 표현
                        
                        
         [이스케이프/제어 문자]
             \n : 줄바꿈
             \t : 들여쓰기 (tab)
             \\ : '\' 출력 
             \' : ' 출력
             \" : " 출력      
         */
        //[1]
        System.out.println("자바안녕1");
        System.out.println("자바안녕2");

        System.out.print("자바안녕3"); // 줄바꿈 없음
        System.out.print("자바안녕4");

        System.out.printf("%s" , "자바안녕5\n");

        //[2]
        String name = "유재석";
        int age = 40;
        System.out.printf("저는 %s이고 나이는 %d입니다.\n" , name, age);
        // vs
        System.out.println("저는 " + name + "이고 나이는 " + age + "입니다.\n");
        System.out.printf("저는 %s이고 나이는 %6d 입니다. \n", name , age); //%6d : 6자리 수라는 정수 표현 (오른쪽 정렬)
        System.out.printf("저는 %s이고 나이는 %-6d 입니다. \n" , name , age); // %-6d : 왼쪽 정렬
        System.out.printf("저는 %s이고 나이는 %06d 입니다. \n" , name , age); // 6자리를 표현하며 빈 칸은 0으로 채움
        System.out.printf("저는 %s이고 신장은 %5.2f 입니다. \n" , name, 188.257);
        
        // [3]
        System.out.println("안녕1\n안녕2");
        System.out.println("안녕1\t안녕2");
        System.out.println("안녕1\'안녕2\'");
        System.out.println("안녕1\"안녕2\"");
        System.out.println("안녕1\\안녕2\\");



    } //main end
} // class end
