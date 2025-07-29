package daily.day22_250729;

/*
[ Random, 난수 클래스 ]
1) 사용법
    (1) Random 객체 생성
        Random random = new Random();
    (2) 주요 메소드
        .nextInt()          : int 타입·허용 범위 내의 난수 생성
        .nextInt( n )       : 0부터 (n-1) 값 까지 사이의 난수 생성
        .nextInt( m ) + n   : n 값부터 m 개의 사이의 난수 생성
        .nextDouble()       : 0~1 사이의 실수인 난수 생성
        .nextBoolean()      : true · false 중 랜덤
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Example2 {
    public static void main(String[] args) {

        // 1. Random 객체 생성
        Random random = new Random();
        System.out.println(random);

        int value1 = random.nextInt();
        System.out.println("value1 = " + value1);

        // 2. 1 ~ 9 사이의 난수 생성
        int value2 = random.nextInt(10) + 1;
        System.out.println(value2);

        // 3. 0 ~ 99 사이의 난수 발생
        int value3 = random.nextInt(100);

        // 4. 0 ~ 1 사이의 실수 생성
        double value4 = random.nextDouble();
        System.out.println(value4);

        // 5. random boolean
        boolean value5 = random.nextBoolean();
        System.out.println(value5);

        // [활용 1] 임의의 여러 데이터 중 하나의 데이터 선택
        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("유재석");
        nameList.add("강호동");
        nameList.add("신동엽");

        String name = nameList.get(random.nextInt(nameList.size()));
        System.out.println(name);

        // [활용 2] 새로운 비밀번호, 인증코드 문자
        String code = "";
        for (int i = 1; i <= 6; i++) {
            // a : 97 ~ z : 122
            Random ran = new Random();
            int val = ran.nextInt(26) + 97;     // 97 부터 26개(122번) 까지 중 랜덤
            char str = (char) val;                      // 아스키코드 번호를 char 문자로 변환
//            System.out.println(str);
            code += str;
        }
        System.out.println(code);

        // [활용 3] 아스키코드 패턴으로 난수 계산식을 못만들 경우 (아스키코드 번호가 이어지지 않아, 따로 따로 가져와야 하는 경우)
        // 별도의 데이터 배열을 선언하고, 데이터 배열 내에서 random으로 발생하도록 함

        char[] ranStr = {'0', '1', '2', 'a', 'b', 'c', 'Z', 'Y'};

        String newPwd = "";
        for (int i = 1; i <= 6; i++) {
            Random ran = new Random();
            int index = ran.nextInt(ranStr.length);
            newPwd += ranStr[index];
        }
        System.out.println(newPwd);

        // [활용 4] 주사위 : 1~6
        int dice = random.nextInt(6) + 1;
        System.out.println(dice);

        // [활용 5] 로또 번호 : 1~45, 중복 없이 6개

        ArrayList<Integer> lottoList = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            int lotto = random.nextInt(45) + 1;
            if(lottoList.contains(lotto)){      // lotto 번호가 이미 List에 존재한다면
                i--;                            // 횟수를 원래대로 돌려놓고
                continue;                       // 넘어가기
            }
            lottoList.add(lotto);
        }
        System.out.println(lottoList);

        ArrayList<Integer> lottoList2 = new ArrayList<>();
        for (;;) {
            int lotto = random.nextInt(45) + 1;
            if(lottoList2.contains(lotto)){      // lotto 번호가 이미 List에 존재한다면
               continue;
            }
            lottoList2.add(lotto);
            if(lottoList2.size() == 6 ) break;
        }
        System.out.println(lottoList2);

        // [활용 6] 하나의 문자열에서 추출한 문자열 난수 생성
        String ranStr2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        // 문자열 길이
        int strlen = ranStr2.length();
        // 문자열 길이의 난수 생성
        int ranIndex = random.nextInt( strlen );
        char str1 = ranStr2.charAt(ranIndex);
        System.out.println(str1);

    } // main end
} // class end
