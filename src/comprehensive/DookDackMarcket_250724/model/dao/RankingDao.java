package comprehensive.DookDackMarcket_250724.model.dao;

//Data Access Object : 데이터 접근 객체

import comprehensive.DookDackMarcket_250724.model.dto.QnaDto;
import comprehensive.DookDackMarcket_250724.model.dto.RankingDto;

import java.sql.*;
import java.util.ArrayList;

public class RankingDao {
    // 싱글톤 =====================================================
    private RankingDao() {
        connectDB(); //Dao 객체 생성과 동시에 DB 연동 시작
    }

    ;
    private static final RankingDao instance = new RankingDao();

    public static RankingDao getInstance() {
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
            System.out.println("[경고] MySQL 드라이버 로드 실패 " + e);
        } catch (SQLException e) {
            System.out.println("[경고] DB 연동 실패 " + e);
        }
    }

    // [7] 랭킹조회
    public ArrayList<RankingDto> rankingPrint() {
        ArrayList<RankingDto> rankList = new ArrayList<>();
        try {
            // [7.1] SQL 작성
            String sql = "select pSeller, count(pName) from product group by pSeller order by count(pName) desc limit 10";
            // [7.2] SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // [7.3] SQL 매개변수 대입 (생략)
            // [7.4] SQL 실행
            ResultSet rs = ps.executeQuery();
            // [7.5] SQL 실행 결과
            // 반복문을 통해 rankList에 저장
            while (rs.next()) {
                //[7.5.2] rankingDto 객체 생성
                RankingDto rankingDto = new RankingDto(
                        rs.getString("pSeller"),
                        rs.getInt("count(pName)"));
//                System.out.println(rankingDto.toString());
                //[2.5.3] rankingDto 객체를 ArrayList에 삽입
                rankList.add((rankingDto));
            }
        } catch (Exception e) {
            System.out.println("[예외발생] rankDao 7" +e);
        }
        return rankList;
    }

} // class end