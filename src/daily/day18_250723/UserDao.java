package daily.day18_250723;

// DAO : Data Access Object

import java.sql.*;

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
    // 2.1)User 테이블 insert : SQL 고정
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

    // 2.2) User 테이블 insert : 매개변수 활용
    public boolean userInsert2(String uname, int uage) {
        try {
            // SQL 작성
            String sql = "insert into user( uname, uage ) values( ? , ? )";

            // SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // SQL에 매개변수 대입하기!! ☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
            // ps.set타입( ?순서, 변수)
            ps.setString(1, uname);
            ps.setInt(2, uage);

            // SQL 실행
            int count = ps.executeUpdate();

            // SQL 결과 확인
            if (count >= 1) return true;
            return false;
        } catch (SQLException e) {
            System.out.println("[예외발생] " + e);
        }
        return false;
    } // func end

    // 3) Select
    // User table 을 select
    public void userSelect() {
        try {
            // SQL 작성
            String sql = "select * from user;";

            // SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);

            // SQL 매개변수 대입 >> 없으므로 생략
            
            // SQL 실행 ☆★☆★☆★☆★☆★☆★☆★
            // select >> .executeQuery() >> ResultSet 타입
            ResultSet rs = ps.executeQuery();       // 조회결과 조작 인터페이스, [import java.sql] 주의!!

            // SQL 결과 확인
//            int rowNo = 0;

//            while (rs.next()){                      // rs.next() : 다음 레코드로 이동하는 함수
////                System.out.println(rowNo++);
//                System.out.print(rs.getInt("uno") + "\t");
//                System.out.print(rs.getString("uname") + "\t");
//                System.out.println(rs.getInt("uage"));
//            }

            while (rs.next()){
                System.out.printf("번호 : %d \t 이름 : %s \t 나이 : %d \n",rs.getInt(1),rs.getString(2), rs.getInt(3));
            }

        } catch (Exception e) {
            System.out.println("[예외발생] " + e);
        }
    } //func end


} //class end
