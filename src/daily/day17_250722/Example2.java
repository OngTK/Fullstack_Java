package daily.day17_250722;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
[ JDBC ]
    Java DataBase Connect

    1) 라이브러리 준비
        : JDBC MySQL
        https://dev.mysql.com/downloads/connector/j/
        Platform Independent (Architecture Independent), ZIP Archive >> mysql-connector-j-9.3.0.jar
    2) 연동코드

    3) 핵심 인터페이스
        (1) Connection, DB 연동
            [1] Connection conn = DriverManager.getConnection(db_url, db_user,db_pw)
            [2] PreparedStatement ps = conn.prepareStatement(sql);
                - 기재된 상태의 인터페이스 변수명 = DB연동.기재함수(SQL문법);

        (2) PreparedStatement, SQL 조작
            [1] ps.execute();
                - 실행 함수
            [2] ps.executeQuery();
                - Select 문법 실행 결과를 ResultSet 타입으로 반환
            [3] ps.executeUpdate();
                - insert, update, delete 문법 실행 결과를 int 타입으로 변환

        (3) ResultSet, SQL 실행 조작
            [1] rs.next();
                    - 조회된 레코드 중에서 다음 레코드 이동 함수
            [2] rs.get타입(속성명);
                    - 현재 레코드에서 지정한 속성명의 값 반환 함수

*/
public class Example2 {
    public static void main(String[] args) {
        // [1] Java - Database 연동
        // [1.1] MySQL에서 지원하는 Driver 클래스 로드 (예외처리 필수)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("JDBC 드라이버 가져오기 성공");

            // [1.2] DB 연동 후 연동 결과를 보관하는 인터페이스
            // [1.3] DB 연동 클래스(구현체) DriverManager
            // [1.4] DB 연동 함수 : .getConnection( 주소 , 계정 , 비밀번호)
            String db_url = "jdbc:mysql://localhost:3306/mydb0722";     // DB 주소 "jdbc:mysql://ip주소:port번호/DB명"
            String db_user = "root";                                    // DB 계정명
            String db_pw = "1234";                                      // DB 비밀번호
            Connection conn = DriverManager.getConnection(db_url, db_user,db_pw);           // 예외 발생
            System.out.println("DB연동 성공");

            // [2] java에서 insert 문법 사용하기
            // [2.1] SQL 작성
            String sql = "insert into test(content) values('안녕하세요')";
            // [2.2] SQL을 연동한 인터페이스에 대입,
            // .prepareStatement( sql ) : 연동된 DB에 sql을 작성 준비
            PreparedStatement ps = conn.prepareStatement(sql);          // [2.3] PreparedStatement 저장 인터페이스
            ps.execute();                                               // [2.4] .execute() 실행 메소드


        } catch (ClassNotFoundException e){                             // Class.forName에 대한 예외
            System.out.println("JDBC 드라이버가 없습니다." + e);
        } catch (SQLException e) {                                      // getConnection에 대한 예외
            System.out.println("DB 연동 실패");
        }

    } // main end
} // class end
