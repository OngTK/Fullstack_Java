package daily.day18_250723;

// DAO : Data Access Object

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {

    // 싱글톤
    private UserDao() {
        connect();
    }

    ;
    private static final UserDao instance = new UserDao();

    public static UserDao getInstance() {
        return instance;
    }

    // 1. DB 연동 코드(함수)

    // 1) MySQL 드라이버/클래스 불러오기 ============================================

    // DB 연동에 필요한 기본 정보
    private String db_url = "jdbc:mysql://localhost:3306/mydb0723";
    private String db_user = "root";
    private String db_pw = "1234";

    // DB연동 결과를 저장하기 위한 인터페이스
    private Connection conn;

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(db_url, db_user, db_pw);
        } catch (ClassNotFoundException e) {
            System.out.println("[경고] MySQL 드라이버 로드 실패 " + e);
        } catch (SQLException e) {
            System.out.println("[경고] DB 연동 실패 " + e);
        }
    }

    // 2) MySQL DB서버 연동 ============================================
    public boolean userInsert() {

        // SQL 작성
        String sql = "insert into user( uname, uage ) values('유재석',40 )";

        try {
            // SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);

            // SQL 실행
            int count = ps.executeUpdate(); // SQL 실행 결과 insert 레코드 수를 int로 반환

            // SQL 결과 확인
            System.out.println(count);
            return true;

        } catch (SQLException e) {
            System.out.println("[경고] 예외발생 " + e);
        }
        return false;
    }

}
