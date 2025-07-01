package daily.day03_250701;

public class Example1 {
    public static void main(String[] args) {
        /*
        [ 조건문 if ]
            1. 형태    
                (1) if( 조건문 ) 참 ;   : 단일 명령어
                (2) if( 조건문 ) {      : 명령어 다수
                    참 1;
                    참 2;};
                (3) if ( 조건문 ) { 참 }
                    else { 거짓 };
                (4) 여러 조건에 하나의 결과
                    if ( 조건문1 ) { 참1 }
                    else if( 조건문2 ) { 참2 }
                    else if( 조건문3 ) { 참3 }
                    else { 거짓 };
                (5) 여러 조건에 여러 개의 결과
                    if ( 조건문1 ) { 참1 };
                    if ( 조건문2 ) { 참2 };
                (6) 중첩
                    if ( 조건문1 ) {
                        if ( 조건문2 ) {참2}
                        else {거짓2}
                    } else{ 거짓1 };

            2. 주의사항
                (1) 조건문은 true / false 만 가능
                (2) {} 중괄호
                (3) if(); << 하지 않도록 주의
                (4) if, if~else, if~else if는 하나의 결과만 반환
        */

        // [1]
        int tem = 5;
        if (tem <= 10) System.out.println("외투를 입는다.");

        // [2]
        int age = 10;
        if (age >= 19) {
            System.out.println("성인입니다.");
            System.out.println("19세 이상입니다.");
        };

        // [3]
        boolean check = false;
        if( check == true){
            System.out.println("안녕하세요. 회원님");
        } else {
            System.out.println("비회원입니다.");
        }

        // [4]
        int money = 1750;
        if (money >= 3000) {
            System.out.println("택시");
        } else if (money >=1700) {
            System.out.println("버스");
        } else if (money >= 1200 ) {
            System.out.println("자전거");
        } else {
            System.out.println("걷기");
        }
        
        // [5]
        if( money >= 3000) {
            System.out.println("택시");
        };
        if( money >= 1700) {
            System.out.println("버스");
        };
        if( money >= 1200) {
            System.out.println("자전거");
        };

        // [6]
        int age6 = 25;
        char gender = 'W';

        if(age >= 19) {
            System.out.println("성인");
            if (gender == 'W') {
                System.out.println("성인여자");
            } else {
                System.out.println("성인남성");
            };
        } else {
            System.out.println("미성년자");
        }

    };
};
