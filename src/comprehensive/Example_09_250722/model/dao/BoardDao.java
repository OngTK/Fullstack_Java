package comprehensive.Example_09_250722.model.dao;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import comprehensive.Example_09_250722.model.dto.BoardDto;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

// Dao 역할 : 실존 데이터에 접근하는 기능 (CRUD)
public class BoardDao {
    // 싱글톤 =======================================
    private BoardDao() {
        // 싱글톤 생성시 CSV 로드 ☆★☆★☆★☆★☆★☆★☆★
        openCSV();
    }

    ;
    private static final BoardDao instance = new BoardDao();

    public static BoardDao getInstance() {
        return instance;
    }

    // DB를 대신할 리스트 객체 선언
    ArrayList<BoardDto> boardDB = new ArrayList<>();

    // 멤버변수 =======================================

    // 메소드 =======================================

    // 1. 등록 boardWrite
    // 매개변수 boardDto
    // 반환타입 boolean
    public boolean boardWrite(BoardDto boardDto) {
        boardDB.add(boardDto);
        // CSV 저장 ☆★☆★☆★☆★☆★☆★☆★☆★☆★
        saveCSV();
        return true;
    }

    // 2. 전체 조회boardPrint
    // 매개변수 X
    // 반환타입 ArrayList<BoardDto>
    public ArrayList<BoardDto> boardPrint() {
        return boardDB;
    }

    // 추가 기능 ☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
    private String path = "src/comprehensive/Example_09_250722/data.csv";

    // [1] CSV 파일 연동 함수
    public void openCSV() {
        File file = new File(path);                         // 파일 객체 생성
        if (file.exists()) {                                 // 파일이 존재 확인 >> T : reload(재호출) / F: createNew(생성)
            loadCSV();
        } else {
            try {
                file.createNewFile();                           // 지정한 경로에 파일을 생성
            } catch (Exception e) {
                System.out.println("예외발생 " + e);
            }
        }
    }

    // [2] CSV 입력(호출) 함수
    public void loadCSV() {

        try {
            // [2.1] fileReader 객체를 이용한 읽기모드 객체 생성
            FileReader fileReader = new FileReader(path);
            // [2.2] CSVReader 에 fileReader을 대입한 csv객체 생성
            CSVReader csvReader = new CSVReader(fileReader);
            // [2.3] readAll() 함수로 모든 csv 정보 읽기
            List<String[]> inData = csvReader.readAll();

            // [2.4] 향상된 for문으로 반복
            for (String[] row : inData) {
                String content = row[0];
                String writer = row[1];

                // [2.5] csv의 각 열 별로 dto 객체로 생성 및 List에 저장
                BoardDto boardDto = new BoardDto(content, writer);
                boardDB.add(boardDto);
            }
            csvReader.close(); // csvReader을 종료하여 메모리 누수를 방지
        } catch (Exception e) {
            System.out.println("예외발생 " + e);
        }
    }

    // [3] CSV 출력(저장) 함수
    public void saveCSV() {
        try {
            // [3.1] FileWriter 파일 쓰기모드 객체 생성
            FileWriter fileWriter = new FileWriter(path);

            // [3.2] CSVWriter에 FileWriter 객체를 대임
            CSVWriter csvWriter = new CSVWriter(fileWriter);

            // [3.3] 빈 리스트 생성
            List<String[]> outData = new ArrayList<>();

            // [3.4] 모든 정보를 outData에 옮김
            for(BoardDto boardDto : boardDB){
                // [3.5] dto하나의 내용과 글쓴이를 하나의 배열에 저장
                String[] row = {boardDto.getContent() , boardDto.getWriter()};

                // [3.6] outData에 저장
                outData.add(row);
            }

            // [3.7] 최정적으로 outData를 csv로 내보냄
            csvWriter.writeAll(outData);
            csvWriter.close(); // 안전하게 종료
            
        } catch (Exception e){
            System.out.println("예외발생 " + e);
        }
    }

} // class end