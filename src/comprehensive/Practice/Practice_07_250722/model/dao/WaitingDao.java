package comprehensive.Practice_07_250722.model.dao;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import comprehensive.Practice_07_250722.model.dto.WaitingDto;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Dao 역할 : 실존 데이터에 접근하는 기능 (CRUD)
public class WaitingDao {
    // 싱글톤 =======================================
    private WaitingDao() {
        openCSV(); //Dao 객체 생성과 동시에 CSV 연동 시작
        connectDB(); //Dao 객체 생성과 동시에 DB 연동 시작
    }

    ;
    private static final WaitingDao instance = new WaitingDao();

    public static WaitingDao getInstance() {
        return instance;
    }

    // 리스트 선언
    ArrayList<WaitingDto> waitingDB = new ArrayList<>();


    // 메소드 =======================================

    // 1. 등록
    public boolean addWaiting(WaitingDto waitingDto) {
        waitingDB.add(waitingDto);
        saveDtoDB(waitingDto);
        saveCSV(); //waitingDto 생성과 동시에 CSV 작성 함수 발동
        return true;
    }

    // 2. 조회
    public ArrayList<WaitingDto> getWaitingDB() {
        return waitingDB;
    }

    // CSV 기능 ☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★

    // [1] 경로
    private String path = "src/comprehensive/Practice_07_250722/data.csv";

    // [2] CSV 파일 연동
    public void openCSV() {
        File file = new File(path);     // 경로에 있는 파일 객체 생성

        if (file.exists()) {
            loadCSV();
        } else {
            try {
                file.createNewFile();       // 파일이 없다면, 새로운 파일을 생성
            } catch (Exception e) {
                System.out.println("[경고] waiting csv 생성 실패" + e);
            }
        }
    }

    // [3] csv 입력·호출 함수
    public void loadCSV() {
        try {
            // fileReader : 파일 읽기 객체 생성
            FileReader fileReader = new FileReader(path);

            // CSVReader에 fileReader 대입
            CSVReader csvReader = new CSVReader(fileReader);

            // readAll()로 모든 정보 가져오기
            List<String[]> inData = csvReader.readAll();

            // for문으로 inData 정보를 가져와 waitingDB에 대입
            for (String[] row : inData) {
                String phone = row[0];
                int count = Integer.parseInt(row[1]);
                // inData에 있는 count는 String 타입이므로, int로 변환 필요

                WaitingDto waitingDto = new WaitingDto(phone, count);
                waitingDB.add(waitingDto);
            }
            csvReader.close();      //csvReader 안전 종료
        } catch (Exception e) {
            System.out.println("[경고] 입력 중 CSV 예외 발생 " + e);
        }
    }

    // [4] CSV 저장 함수
    public void saveCSV() {
        try {
            // FileWriter : 파일 쓰기 객체 생성
            FileWriter fileWriter = new FileWriter(path);

            // CSVWriter에 fileWriter을 대입
            CSVWriter csvWriter = new CSVWriter(fileWriter);

            // 빈 리스트 생성
            List<String[]> outData = new ArrayList<>();

            // Dto 정보를 모두 outData에 대입
            for (WaitingDto waitingDto : waitingDB) {
                String[] row = {waitingDto.getPhone(), String.valueOf(waitingDto.getCount())};
                // waitingDto.getCount() 의 타입은 int, 이를 String으로 바꾸기 위해서 String.valueOf() 처리

                //outData에 DB에 각 열을 저장
                outData.add(row);
            }

            // outdata를 csv 파일로 출력
            csvWriter.writeAll(outData);
            csvWriter.close(); // 안정하게 종료

        } catch (Exception e) {
            System.out.println("[경고] CSV 저장 중 예외 발생" + e);
        }
    }

    // DB 연결 기능 ☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★

    // DB 연동을 위해 필요 정보
    private String db_url = "jdbc:mysql://localhost:3306/waiting";
    private String db_user = "root";
    private String db_pw = "1234";

    Connection conn;

    // DB 연동 함수
    public void connectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(db_url, db_user, db_pw);
        } catch (ClassNotFoundException e) {
            System.out.println("[경고] MySQL 드라이버 로드 실패 " + e);
        } catch (
                SQLException e) {
            System.out.println("[경고] DB 연동 실패 " + e);
        }
    }

    // DB 저장 함수
    public void saveDtoDB(WaitingDto waitingDto){
        String phone = waitingDto.getPhone();
        int count = waitingDto.getCount();

        String sql = "insert into waiting(phone, count) values(\""+phone+"\","+count+")";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
        } catch (Exception e) {
            System.out.println("[경고] DB 저장 중 예외 발생 "+e);
        }
    }

} // class end