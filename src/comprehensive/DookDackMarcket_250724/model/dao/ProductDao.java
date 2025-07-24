package comprehensive.DookDackMarcket_250724.model.dao;

//Data Access Object : 데이터 접근 객체

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProductDao {
    // 싱글톤 =====================================================
    private ProductDao() {connectDB(); //Dao 객체 생성과 동시에 DB 연동 시작
    }
    ;
    private static final ProductDao instance = new ProductDao();
    public static ProductDao getInstance() {
        return instance;
    }


    // DB 연동에 필요한 정보 ========================================
    private String db_url = "jdbc:mysql://localhost:3306/dookDackMarket";
    private String db_user = "root";
    private String db_pw = "1234";

    private Connection conn;    // DB연동 결과를 저장하기 위한 인터페이스

    // DB 연동 함수 ================================================
    public void connectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(db_url, db_user, db_pw);
        } catch (ClassNotFoundException e) {
            System.out.println("[경고] MySQL 드라이버 로드 실패 "+e);
        } catch (SQLException e) {
            System.out.println("[경고] DB 연동 실패 " + e);
        }
    }

    //[1] 물품 등록
    //[1.1]
    //[1.2]
    //[1.3]
    //[1.4]
    //[2] 물품 조회
    //[2.1]
    //[2.2]
    //[2.3]
    //[2.4]
    //[3] 물품 수정
    //[3.1]
    //[3.2]
    //[3.3]
    //[3.4]
    //[4] 물품 삭제
    //[4.1]
    //[4.2]
    //[4.3]
    //[4.4]
    //[5] 랭킹조회
    //[5.1]
    //[5.2]
    //[5.3]
    //[5.4]
    //[6] 키워드 검색 조회
    //[6.1]
    //[6.2]
    //[6.3]
    //[6.4]
} // class end