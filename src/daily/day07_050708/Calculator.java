package daily.day07_050708;

// 클래스 목적
// 1) 실행 클래스 : main 함수를 갖는 클래스
// 2) 객체 설게 클래스 : 객체를 만들기 위한 객체 정의 클래스

public class Calculator {
    /* 클래스 멤버(객체내 포함)
            1. 멤버변수 : 객체 마다 할당
            2. 생성자
            3. 메소드 : 여러 객체가 공유해서 사용
    */

    boolean isPowerOn = false; //전원상태

    // [ 메소드 선언 ]

    // (1) 매개변수 X, 반환값 O
    double getPI(){
        return 3.14159;
    };
    // double : return값 3.14159의 타입이 실수이므로 double
    // getPI : 메소드 명
    // ( ) : 매개변수 (여기선 없음) 
    // return 값 : 메소드를 호출했던 곳으로 반환하는 값

    // (2) 매개변수 X, 반환값 X >> void
    void powerOn(){
        System.out.println("계산기 전원을 켭니다.");
        isPowerOn = true;
    };
    // void : return(반환값)이 없다는 키워드

    // (3) 매개변수 O, 반환값 X
    void printSum(int x, int y){
      if( isPowerOn ) {
          int sum = x + y;
          System.out.println(sum);
          return; // void(반환값 X 이므로 생략 가능)
      } else {
          System.out.println("전원이 꺼져 있습니다.");
          return; // void(반환값 X 이므로 생략 가능)
      }
    };
    /* int x, int y : 메소드 호출 시, 인수값을 저장하기 위한 타입과 매개변수
    */
}
