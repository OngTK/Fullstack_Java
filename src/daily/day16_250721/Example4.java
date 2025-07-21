package daily.day16_250721;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Example4 {
    /*
    [ 1 입력받은 text를 저장 ]

    */

    public static void main(String[] args) {
        // [1.1] console에서 입력받기
        Scanner scan = new Scanner(System.in);
        System.out.print("저장할 내용 : ");
        String str = scan.next();

        // [1.2] 저장할 파일 경로 지정
        String path = "src/daily/day16_250721/text2.txt";

        // [1.3] 파일 쓰기 객체
        try {
            FileOutputStream fout = new FileOutputStream(path);

            // [1.4] 입력받은 문자열을 byte로 변환
            byte[] outByte = str.getBytes();

            // [1.5] 변환된 바이트 내보내기
            fout.write( outByte );

            // [2] 파일에서부터 텍스트 호출
            // [2.1] File 클래스 : 지정한 파일의 정보를 반환해주는 객체
            File file = new File(path);
            System.out.println(file.isFile());      // 파일의 경로/존재 여부 > boolean
            System.out.println(file.getName());     // 파일의 이름 반환
            System.out.println(file.length());      // 파일의 용량(단위:Byte / 타입 : long)
            System.out.println(file.exists());      // 파일의 실제 존재 여부
            // file.delete();                          // 지정 경로의 파일 삭제
            // file.createNewFile();                   // 지정 경로에 파일 생성

            // [2.2] 파일이 존재할 경우
            if(file.exists()){
                // [2.3] 입력 객체 생성
                FileInputStream fin = new FileInputStream(path);

                // [2.4] 문자열 저장을 위한 바이트 배열 선언
                byte[] inByte = new byte[ (int) file.length() ];
                // file.length() > 타입 long >> int로 타입 강제 변환

                // [2.5] 문자열 읽어오기 = 문자열 바이트를 배열에 저장
                fin.read( inByte );

                // [2.6] 읽어온 바이트배열을 문자열로 변환
                String instr = new String(inByte);
                System.out.println(instr);
            }
        } catch (Exception e) {
            System.out.println("예외발생 : " + e);
        }
    } // main end
} // class end
