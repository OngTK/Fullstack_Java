package comprehensive.DookDackMarcket_250724.model.dao;

//Data Access Object : 데이터 접근 객체

import comprehensive.DookDackMarcket_250724.model.dto.ProductDto;
import comprehensive.DookDackMarcket_250724.model.dto.QnaDto;

import java.sql.*;
import java.util.ArrayList;

public class QnaDao {
    // 싱글톤 =====================================================
    private QnaDao() {
        connectDB(); //Dao 객체 생성과 동시에 DB 연동 시작
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
            System.out.println("[경고] MySQL 드라이버 로드 실패 " + e);
        } catch (SQLException e) {
            System.out.println("[경고] DB 연동 실패 " + e);
        }
    }

    //[5] 문의 등록
    public boolean qnaRegi(QnaDto qnaDto) {
        try {
            //[5.1] SQL 작성
            String sql = "INSERT INTO qna (pNo, qQuestioner, qContent, qPw) VALUES (?, ?, ?, ?)";
//            System.out.println(sql);
            //[5.2] SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            //[5.3] SQL 매개변수 대입
            ps.setInt(1, qnaDto.getpNo());
            ps.setString(2, qnaDto.getqQuestioner());
            ps.setString(3, qnaDto.getqContent());
            ps.setString(4, qnaDto.getqPw());
            //[5.4] SQL 실행
            int count = ps.executeUpdate();
            //[5.5] SQL 실행 결과 확인
            if (count >= 1) {
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println("[예외발생] qnaDao.1 " + e);
        }
        return false;
    } //func end

    //[9] 물품(문의) 상세 조회
    public ArrayList<QnaDto> qnaSearch(int pNo) {
        ArrayList<QnaDto> qnaList = new ArrayList<>();
        try {
            //[9.1] SQL 작성
            String sql = "select * from qna where pno = ? order by qdate desc";
            //[9.2] SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            //[9.3] SQL 매개변수 대입
            ps.setInt(1, pNo);
            //[9.4] SQL 실행
            ResultSet rs = ps.executeQuery();
            //[9.5] SQL 실행 결과
            //[9.5.1] 반복문
            while (rs.next()) {
                //[9.5.2] qnaDto 객체 생성
                QnaDto qnaDto = new QnaDto(
                        rs.getInt("qNo"),
                        rs.getInt("pNo"),
                        rs.getString("qQuestioner"),
                        rs.getString("qContent"),
                        rs.getString("qPw"),
                        rs.getString("qDate"));
//                System.out.println(qnaDto.toString());
                //[9.5.3] qnaDto 객체를 ArrayList에 삽입
                qnaList.add((qnaDto));
            }
        } catch (Exception e) {
            System.out.println("[예외발생] qdao 6 " + e);
        }
        return qnaList;
    } // func end

} // class end