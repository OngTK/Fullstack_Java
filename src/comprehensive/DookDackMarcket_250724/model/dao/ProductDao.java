package comprehensive.DookDackMarcket_250724.model.dao;

//Data Access Object : 데이터 접근 객체

import comprehensive.DookDackMarcket_250724.model.dto.ProductDto;

import java.sql.*;
import java.util.ArrayList;

public class ProductDao {
    // 싱글톤 =====================================================
    private ProductDao() {
        connectDB(); //Dao 객체 생성과 동시에 DB 연동 시작
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
            System.out.println("[경고] MySQL 드라이버 로드 실패 " + e);
        } catch (SQLException e) {
            System.out.println("[경고] DB 연동 실패 " + e);
        }
    }

    //[1] 물품 등록 =======================
    public boolean productRegi(ProductDto productDto) {
        try {
            //[1.1] SQL 작성
            String sql = "insert into product(pName, pSeller, pMemo, pPrice, pPW) VALUES (?,?,?,?,? )";
//            System.out.println(sql);
            //[1.2] SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            //[1.3] SQL 매개변수 대입
            ps.setString(1, productDto.getpName());
            ps.setString(2, productDto.getpSeller());
            ps.setString(3, productDto.getpMemo());
            ps.setInt(4, productDto.getpPrice());
            ps.setString(5, productDto.getpPw());

            //[1.4] SQL 실행
            int count = ps.executeUpdate();
            //[1.5] SQL 실행 결과 확인
            if (count >= 1) {
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println("[예외발생] productDao.1 " + e);
        }
        return false;
    } //func end

    //[2] 물품 조회 =======================
    public ArrayList<ProductDto> productPrint() {
        ArrayList<ProductDto> productList = new ArrayList<>();

        try {
            //[2.1] SQL 작성
            // 등록일 기준 내림차순 정렬 후 조회
            String sql = "select * from product order by pDate desc;";
            //[2.2] SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            //[2.3] SQL 매개변수 삽입 (생략)

            //[2.4] SQL 실행
            ResultSet rs = ps.executeQuery();
            //[2.5] SQL 실행 결과 확인
            //[2.5.1] 반복문
            while (rs.next()) {
                //[2.5.2] productDto 객체 생성
                ProductDto productDto = new ProductDto(rs.getInt("pNo"),
                        rs.getString("pName"),
                        rs.getString("pSeller"),
                        rs.getString("pMemo"),
                        rs.getInt("pPrice"),
                        rs.getString("pPw"),
                        rs.getString("pDate"),
                        rs.getBoolean("pStatus")
                );
//                System.out.println(productDto.toString());
                //[2.5.3] product 객체를 ArrayList에 삽입
                productList.add((productDto));
            }
        } catch (Exception e) {
            System.out.println("[예외 발생] productDao.2 " + e);
        }
        //[2.6] 결과 반환
        return productList;
    }//func end

    //[3] 물품 수정 =======================
    public boolean productUpdate(ProductDto productDto) {
        try {
            //[3.1] SQL 작성
            String sql = "update product set pName=?, pMemo=?, pPrice=?, pStatus=? where pNo = ?";
//            System.out.println(sql);
            //[3.2] SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            //[3.3] SQL 매개변수 대입
            ps.setString(1, productDto.getpName());
            ps.setString(2, productDto.getpMemo());
            ps.setInt(3, productDto.getpPrice());
            ps.setBoolean(4, productDto.getsStatus());
            ps.setInt(5, productDto.getpNo());
            //[3.4] SQL 실행
            int count = ps.executeUpdate();
            //[3.5] SQL 실행 결과 확인
            if (count == 1) {
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println("[예외발생] productDao.3 " + e);
        }
        return false;
    } // func end

    //[4] 물품 삭제 =======================
    public boolean productDelete(int pNo) {
        try {
            //[4.1] SQl 작성
            String sql = "delete from product where pNo = ?";
            //[4.2] SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            //[4.3] SQL 매개변수 대입
            ps.setInt(1, pNo);
            //[4.4] SQL 실행
            int count = ps.executeUpdate();
            //[4.5] SQL 실행 결과
            if(count == 1){
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println("[예외발상] pdao 4 " + e);
        }
        return false;
    }//func end

    //[6] 물품 상세 조회 =======================
    public ProductDto productSearch(int pNo) {
//        System.out.println(pNo);
        ProductDto productDto = new ProductDto();
        try {
            //[6.1] SQL 작성
            String sql = "select * from product where pNo = ?";
            //[6.2] SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            //[6.3] SQL 매개변수 대입
            ps.setInt(1, pNo);
            //[6.4] SQL 실행
            ResultSet rs = ps.executeQuery();
            //[6.5] SQL 실행 결과로 dto 객채 생성
            rs.next(); // 무조건 1칸 밀고 나서 시작
            productDto = new ProductDto(rs.getInt("pNo"),
                    rs.getString("pName"),
                    rs.getString("pSeller"),
                    rs.getString("pMemo"),
                    rs.getInt("pPrice"),
                    rs.getString("pPw"),
                    rs.getString("pDate"),
                    rs.getBoolean("pStatus")
            );
//            System.out.println(productDto.toString());
        } catch (Exception e) {
            System.out.println("[예외 발생] productDao.6 " + e);
        }
//        System.out.println("pdo func 6 " + productDto.toString());
        return productDto;

    } // func end

    //[7] 랭킹조회 =======================
    //[7.1]
    //[7.2]
    //[7.3]
    //[7.4]
    //[8] 키워드 검색 조회 =======================
    //[8.1]
    //[8.2]
    //[8.3]
    //[8.4]
} // class end