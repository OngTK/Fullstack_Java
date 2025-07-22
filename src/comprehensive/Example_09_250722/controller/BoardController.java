package comprehensive.Example_09_250722.controller;

// Controller 역할 : 통신

public class BoardController {
    // 싱글톤 =======================================
    private BoardController(){};
    private static final BoardController instance = new BoardController();
    public static BoardController getInstance(){
        return instance;
    }
    // Dao 싱글톤 호출  =======================================


    // 메소드 =======================================
}
