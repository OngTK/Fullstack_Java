package daily.day17_250722;


// [ OpenCSV ]
// 자바에서 CSV 파일 읽기, 쓰기를 편하게 해주는 API들을 제공하는 라이브러리
// https://mvnrepository.com/ : java 관련 라이브러리를 제공하는 web site

// 라이브러리 등록 방법
// jar 파일을 원하는 package로 이동 > 우클릭 > add as library

// new CSVReader( new FileReader( 경로 ) ) : CSV를 입력하는 클래스
//      .readAll() : List<String[]> 타입으로 반환하는 함수

// new CSVWriter( new FileWriter( 경로 ) ) : CSV 출력하는 클래스
//      .writeAll( List객체 ) : List 객체를 CSV로 내보내는 함수

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.List;

public class Example1 {
    public static void main(String[] args) {

        try {
            // [1] OpenCSV 라이브러리 사용해보기
            // [1.1] 파일 경로 지정
            String path = "src/daily/day17_250722/인천광역시 부평구_맛있는 집(맛집) 현황.csv";

            // [1.2] FileReader로 파일 읽기모드 객체 만들기 +try·catch 예외처리 + 한글 인코딩
            // new FileReader( 경로, Charset.forName(인코딩))
            FileReader fileReader = new FileReader(path, Charset.forName("EUC-KR"));

            // [1.3] CSV Reader 클래스를 이용하여 읽기모드 객체 읽기
            CSVReader csvReader = new CSVReader(fileReader);

            // [1.4] .readAll() : List<String[]> 타입으로 반환하는 함수
            List<String[]> inData = csvReader.readAll();
            // ArrayList : 구현체 // List : 인터페이스

            System.out.println(inData);

            // [1.5] 반복문
            for (int i = 0 ; i < inData.size() ; i++){
                String[] row = inData.get(i);
                System.out.printf("업소명 : %s, 지정메뉴 : %s \n",row[1],row[3]);
            }

        }catch (Exception e){
            System.out.println("예외발생 " + e);
        }

    }
}
