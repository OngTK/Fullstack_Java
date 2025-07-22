package comprehensive.Example_09_250722.model.dao;

// Dao 역할 : 실존 데이터에 접근하는 기능 (CRUD)
public class BoardDao {
    // 싱글톤 =======================================
    private BoardDao(){};
    private static final BoardDao instance = new BoardDao();
    public static BoardDao getInstance(){
        return instance;
    }
    // 멤버변수 =======================================

    // 메소드 =======================================

}