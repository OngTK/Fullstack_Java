package daily.day16_250721;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Example3 {

    /*
    [ 파일 입·출력 클래스 ]
        1) 쓰기/출력/내보내기(Java > web)
            FileOutputStream

        2) 읽기/입력/가져오기(web > Java)
            FileInputStream

    */
    public static void main(String[] args) {


        // [1] 파일 쓰기
        // [1.1] 파일 경로
        String path = "./src/daily/day16_250721/test1.txt"; //파일의 위치, 절대경로 or 상대경로

        // [1.2] 파일 출력 객체 생성
        //      - FileOutputStream >> 무조건 일반예외 경고 발생함
        // [1.3] 예외처리 (FileNotFoundException)
        try {
            FileOutputStream fout = new FileOutputStream(path);
            //[1.4] 파일에 쓰기 .write(바이트 데이터)
            // 문자열의 바이트로 변환 : "문자열".getBytes() >> 무조건 일반예외 발생
            fout.write("자바에서 작성한 텍스트입니다.".getBytes());
        } catch (FileNotFoundException e) {
            System.out.println("파일 또는 경로가 존재하지 않습니다." + e );
        } catch (IOException e) {
            System.out.println("입출력 도중에 오류가 발생합니다." + e );
        }

        // [2] 파일 읽기
        // [2.1] 경로는 위의 path 사용
        // [2.2] 파일 입력 객체를 생성 : FileInputStream >> 무조건 예외 발생
        try {
            FileInputStream fin = new FileInputStream(path);

            // [2.3] 읽어온 바이트를 저장할 배열 선언
            byte[] bytes = new byte[42];

            // [2.4] bytes에 읽어오기 : .read( 바이트배열 ); >> 무조건 예외 발생
            fin.read(bytes);
            
            // [2.5] new String( 바이트배열 ); 읽어온 바이트를 문자열로 변환
            System.out.println(new String(bytes));
        } catch (FileNotFoundException e ){
            System.out.println("파일 또는 경로가 존재하지 않습니다." + e );
        } catch (IOException e){
            System.out.println("파일을 읽는데 문제가 발생했습니다." + e);
        }
    } // main end
} // class end
