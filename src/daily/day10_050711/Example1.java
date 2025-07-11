package daily.day10_050711;

// [1] 싱글통 생성
class Controller{
    // [1.1] private 기본 생성자 선언
    // 외부에서 new 인스턴스를 방지
    private Controller(){}

    // [1.2] `private static final` 인스턴스 생성 = 싱글톤
    private static final Controller controller = new Controller();

    // [1.3] `public static` 인스턴스 getter 메소드 생성 = 싱글톤 반환
    public static Controller getInstance(){
        return controller;  // 싱글톤을 갖는 변수 반환
    } //func end

} // class ends

public class Example1 {
    public static void main(String[] args) {

        // [2] 싱글톤 호출
        Controller.getInstance();

    } // main end
} // class end
