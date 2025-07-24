package comprehensive.DookDackMarcket_250724.model.dao;

//Data Access Object : 데이터 접근 객체

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class QnaDao {
    // 싱글톤 =====================================================
    private QnaDao() {// connectDB(); //Dao 객체 생성과 동시에 DB 연동 시작
    }
    ;
    private static final QnaDao instance = new QnaDao();
    public static QnaDao getInstance() {
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

    //[5] 문의 등록
    //[5.1]
    //[5.2]
    //[5.3]
    //[5.4]
    //[6] 문의 조회
    //[6.1]
    //[6.2]
    //[6.3]
    //[6.4]

} // class end