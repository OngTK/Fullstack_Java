package Practice.Practice_15_250721;

import java.io.*;
import java.util.Scanner;

public class Practice_15_250721 {
    public static void main(String[] args) {
//    [JAVA] 실습15 : 파일 처리
//    [ 문제 ] 아래 파일 처리 관련 문제를 해결하시오.
//    [ 제출방법 ] 코드가 작성된 파일이 위치한 깃허브 상세 주소를 제출하시오.

//    [문제 1] 파일에 일기 쓰기
//    1. FileOutputStream을 사용하여 src 폴더 내에 src/diary.txt 파일을 생성하세요.
//    2. "오늘 날씨는 맑았다. 자바 공부는 재미있다." 라는 문자열을 바이트로 변환하여 파일에 쓰세요.
//    3. try-catch를 사용하여 예외 처리하세요.

        String path1 = "src/Practice/Practice_15_250721/diary.txt";
        try {
            FileOutputStream fout1 = new FileOutputStream(path1);
            fout1.write("오늘 날씨는 맑았다. 자바 공부는 재미있다.".getBytes());
        } catch (Exception e) {
            System.out.println("입출력 도중 오류가 발생했습니다." + e);
        }


        System.out.println("============================================");
//    [문제 2] 파일에 작성된 일기 읽기
//    1. FileInputStream을 사용하여 문제 1에서 생성한 src/diary.txt 파일을 읽어오세요.
//    2. 읽어온 바이트 데이터를 String으로 변환하여 콘솔에 출력하세요.

        try {
            FileInputStream fin = new FileInputStream(path1);
            byte[] bytes2 = new byte[(int) path1.length()];
            fin.read(bytes2);
            System.out.println(new String(bytes2));
        } catch (Exception e) {
            System.out.println("파일을 읽는 중 문제가 발생했습니다." + e);
        }

        System.out.println("============================================");
//    [문제 3] File 클래스로 파일 정보 확인하기
//    1. File 객체를 src/diary.txt 경로로 생성하세요.
//    2. .exists(), .getPath(), .getName(), .length() 메소드를 각각 사용하여 해당 파일의 존재 여부, 경로, 이름, 크기(바이트)를 출력하세요.

        String path3 = "src/Practice/Practice_15_250721/diary.txt";
        File file = new File(path3);
        System.out.println(file.exists());
        System.out.println(file.getPath());
        System.out.println(file.getName());
        System.out.println(file.length());

        System.out.println("============================================");
//    [문제 4] 방문 로그 누적 기록하기
//    1. FileOutputStream을 사용하여 src/visit_log.txt 파일을 여세요.
//    2. Scanner로 방문자 이름을 입력받아, "OOO님이 방문했습니다.\n" 형식의 문자열을 visit_log.txt 파일의 기존 내용 뒤에 추가하세요.
//    3. 프로그램을 여러 번 실행하여 방문 기록이 계속 누적되는지 확인하세요.

        Scanner scan = new Scanner(System.in);
        System.out.print("방문자 : ");
        String name4 = scan.next();
        String visit = name4 + "님이 방문했습니다. \n";

        String path4 = "src/Practice/Practice_15_250721/visit_log.txt";

        try {
            FileOutputStream fout4 = new FileOutputStream(path4, true);
            // new FileOutputStream( 경로 , true ) >> 누적해서 글 쓰기
            byte[] outByte = visit.getBytes();
            fout4.write(outByte);

        } catch (Exception e) {
            System.out.println("예외발생 : " + e);
        }
//----------

        try {
            String inStr4 = "";
            File file4 = new File(path4);
            if (file4.exists()) { //파일이 존재하면
                // 기존 파일의 문자 가져오기
                FileInputStream fin4 = new FileInputStream(path4);
                byte[] bytes = new byte[(int) file4.length()];
                fin4.read(bytes);
                inStr4 = new String(bytes);
            }
            // 문자열 연결·누적
            String outStr4 = inStr4 + visit;

            // 출력 객체 생성
            FileOutputStream fout41 = new FileOutputStream(path4);
            byte[] outByte = outStr4.getBytes();
            fout41.write(outByte);

        } catch (Exception e) {
            System.out.println("예외발생 " + e);
        }
        System.out.println("============================================");
//    [문제 5] 연락처를 CSV 형식으로 파일에 저장하기
//    1. Scanner를 사용하여 사용자로부터 이름, 전화번호, 사는 도시를 순서대로 입력받으세요.
//    2. 입력받은 데이터들을 쉼표(,)로 연결하여 하나의 String으로 만드세요. (예: "유재석,010-1234-5678,서울")
//    3. 해당 문자열을 contacts.csv 파일에 저장하세요. (줄바꿈 문자 \n 포함)

        System.out.print("이름 : ");
        String name5 = scan.next();
        System.out.print("전화번호 : ");
        String phone = scan.next();
        System.out.print("사는 도시 : ");
        String city = scan.next();

        String userInfo = name5 + "," + phone + "," + city + "\n";
        String path5 = "src/Practice/Practice_15_250721/contacts.csv";

        try {
            FileOutputStream fout5 = new FileOutputStream(path5, true);
            byte[] outByte = userInfo.getBytes();
            fout5.write(outByte);

        } catch (Exception e) {
            System.out.println("예외발생 : " + e);
        }

        System.out.println("============================================");
//    [문제 6] 영화 감상평을 파일에 저장하기
//    1. Scanner를 사용하여 사용자로부터 좋아하는 영화 제목과 감상평을 한 줄로 입력받으세요.
//    2. 입력받은 내용을 src 폴더 내의 src/movie_review.txt 파일에 저장하세요.
        System.out.print("좋아하는 영화 : ");
        String movie = scan.next();
        System.out.print("감상평 : ");
        String memo = scan.next();
        String row = movie + memo;

        String path6 = "src/Practice/Practice_15_250721/movie_review.txt";
        try {
            FileOutputStream fout6 = new FileOutputStream(path6);
            byte[] outByte = row.getBytes();
            fout6.write(outByte);
        } catch (Exception e) {
            System.out.println("예외 발생 " + e);
        }

        System.out.println("============================================");

//    [문제 7] 저장된 감상평 파일 읽기
//    1. 문제 3에서 생성된 src/movie_review.txt 파일의 내용을 읽어오세요.
//    2. File 클래스의 .length()를 사용하여 파일 크기만큼 바이트 배열을 선언하고, 파일 전체를 한 번에 읽어오세요.
//    3. 읽어온 내용을 콘솔에 출력하세요.

        try {
            FileInputStream fin = new FileInputStream(path6);
            byte[] bytes7 = new byte[(int) path6.length()];
            fin.read(bytes7);
            System.out.println(new String(bytes7));
        } catch (Exception e) {
            System.out.println("파일을 읽는 중 문제가 발생했습니다." + e);
        }


        System.out.println("============================================");

//    [문제 8] 공공데이터 CSV 파일 읽고 분석하기
//    1. **공공데이터포털(data.go.kr)**에서 '부평구_인구현황'을 검색하여 CSV 파일을 다운로드하고,
//      src 폴더에 bupyeong_population.csv 라는 이름으로 저장하세요.
//    2. FileInputStream을 사용하여 해당 파일을 읽어오세요.
//      (주의: 한글 깨짐 방지를 위해 new String(bytes, "EUC-KR") 사용)
//    3. 읽어온 전체 내용을 줄바꿈(\n) 기준으로 분리하여 String 배열에 저장하세요.
//    4. for문을 사용하여 배열의 각 줄(각 동의 인구 정보)을 순회하며,
//      '행정기관'과 '총인구수'만 추출하여 "동별: [ 동별 ], 총 인구: [ 인구수(계)   ]명" 형식으로 출력하세요.

        try {
            String path8 = "src/Practice/Practice_15_250721/bupyeong_population.csv";
            File file8 = new File(path8);
            if (file8.exists()) {
                FileInputStream fin = new FileInputStream(path8);
                byte[] bytes = new byte[(int) file8.length()];
                fin.read(bytes);

                String str = new String(bytes, "EUC-KR");
                System.out.println(str);

                String[] rowData = str.split("\n"); // 행단위로 나누어 배열로 저장
                for (int i = 0; i < rowData.length; i++) {
                    String row8 = rowData[i];
//                    System.out.println( row );

                    String[] col8 = row8.split(","); // 행을 열 단위로 쪼개서 배열에 저장

                    System.out.printf(" 동별 : %s 총 인구수 : %s \n", col8[0], col8[1]);
                }

            }
        } catch (Exception e) {
            System.out.println("예외 발생 : " + e);
        }


        System.out.println("============================================");

    }
}
