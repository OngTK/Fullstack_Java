package daily.day15_050718;

interface 키보드{
    // [1] 상수
    public static final String 제조사 = "인텔";
    String 제조일 = "2025-07-18";

    // [2] 추상메소드
    void aKey();
    void bKey();
}

// [3] 구현체
// 구현체 class에는 반드시!!!!!
// interface의 추상메소드를 구현체에 오버라이딩해야 함.
class 격투게임 implements 키보드{
    
    // [3.1] 추상메소드 오버라이딩
    public void aKey() {
        System.out.println("[공격]");
    }
    public void bKey() {
        System.out.println("[방어]");
    }
}

class 축구게임 implements 키보드{
    public void aKey() {
        System.out.println("[슈팅]");
    }
    public void bKey() {
        System.out.println("[태클]");
    }
}

public class Example1 {
    public static void main(String[] args) {

        // [1] 인터페이스는 객체 생성 불가!

        // [2] 인터페이스 타입 선언은 가능 >>
        키보드 myKeyBoard; // `new 키보드`는 객체 선언에 해당하므로 불가

        // [3] 구현체 대입
        
        myKeyBoard = new 격투게임();
        myKeyBoard.aKey(); // 공격

        // [4] 다형성 특징 : 다른 구현체로 타입 변환
        myKeyBoard = new 축구게임();
        myKeyBoard.aKey(); // 슈팅
        
        // [5] 익명 구현체 ☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
        //      이름이 없는 구현체
        //      Class 없이 객체 만들기
        //      타입 변수 = new 인터페이스(){};  // 객체 선언과 동시에 구현부를 작성
        //      저장이 필요없는·간단한·일회성 인터페이스 생성시 사용
        키보드 yourKeyBoard = new 키보드(){
            
            // class 없이 오버라이딩 선언

            public void aKey() {
                System.out.println("[키보드A]");
            }

            public void bKey() {
                System.out.println("[키보드B]");
            }
        };

        // [6] 익명 구현체 메소드 실행
        yourKeyBoard.aKey();
        yourKeyBoard.bKey();

    } // main end
} // class end
