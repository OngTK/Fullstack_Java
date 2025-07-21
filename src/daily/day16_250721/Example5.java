package daily.day16_250721;

import java.io.File;
import java.io.FileInputStream;

/* [ 공공데이터포털 CSV 파일 다루기 ]

CSV
    데이터들 간의 속성을 쉼표(,)·행 간은 \n으로 구분

*/
public class Example5 {
    public static void main(String[] args) {
        
        // [4] 모든 코드를 try로 감싸서 예외처리
        try {
            // [1] 파일의 존재 여부 확인
            String path = "src/daily/day16_250721/인천광역시 부평구_맛있는 집(맛집) 현황_20240801.csv";
            File file = new File(path);
            System.out.println(file.exists());

            // [2] 파일 읽어오기
            if (file.exists()) {
                // [3] 파일 입력 객체 생성
                FileInputStream fin = new FileInputStream(path);

                // [5] 읽어온 파일의 바이트를 저장할 byte 배열 선언
                byte[] bytes = new byte[(int)file.length()];

                // [6] 파일의 바이트를 읽어 배열에 저장
                fin.read(bytes);

                // [7] 읽어온 바이트를 문자열로 변환
                String str = new String(bytes,"EUC-KR");
                // EUC-KR : 한글 인코딩

                System.out.println(str);

                // [8] ☆★☆★☆★☆★☆★☆★ CSV 분해하기 ☆★☆★☆★☆★☆★☆★
                // .split( 구분문자 ) : 구분문자를 기준으로 String을 분해하고 배열로 반환
//                System.out.println(str.split("\n")[0]);
//                System.out.println(str.split("\n")[1].split(",")[1]);

                String[] 행데이터 = str.split("\n"); // 행단위로 나누어 배열로 저장
                for( int i = 0 ; i < 행데이터.length ; i++ ){
                    String row = 행데이터[i];
//                    System.out.println( row );

                    String[] 열데이터 = row.split(","); // 행을 열 단위로 쪼개서 배열에 저장

//                    System.out.println(열데이터[1]); // 업소명
//                    System.out.println(열데이터[3]); // 지정메뉴

                    System.out.printf(" 업소명 : %s 지정메뉴 : %s \n" , 열데이터[1], 열데이터[3]);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    } // main end
} // class end
