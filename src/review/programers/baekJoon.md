# 15552 빠른 A+B
@since 2025.09.16

본격적으로 for문 문제를 풀기 전에 주의해야 할 점이 있다. 입출력 방식이 느리면 여러 줄을 입력받거나 출력할 때 시간초과가 날 수 있다는 점이다.

Java를 사용하고 있다면, Scanner와 System.out.println 대신 BufferedReader와 BufferedWriter를 사용할 수 있다. BufferedWriter.flush는 맨 마지막에 한 번만 하면 된다.

## BufferedReader / BufferedWriter
- BufferedReader와 BufferdWriter는 버퍼를 사용하여 읽기와 쓰기를 하는 함수
- 버퍼를 사용하지 않는 입력은, 키보드의 입력이 키를 누르는 즉시 바로 프로그램에 전달된다.
- 반면 버퍼를 사용하는 입력은, 키보드의 입력이 있을 때마다 한 문자씩 버퍼로 전송한다. 버퍼가 가득 차거나 혹은 개행 문자가 나타나면 버퍼의 내용을 한 번에 프로그램에 전달한다.
- 키보드의 입력이 있을 때마다 바로 이동시키는 것 보다는, 중간에 버퍼를 두어 한번에 묶어 보내는 것이 더 효율적이고 빠른 방법이다.

### BufferedReader
- Scanner와 달리 BufferedReader는 개행문자만 경계로 인식하고 입력받은 데이터가 String으로 고정
-  데이터를 가공해야하는 경우가 많음
```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언
String s = br.readLine();
int i = Integer.parseInt(br.readLine());
```
```java
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int a = Integer.parseInt(s.split(" ")[0]);
            int b = Integer.parseInt(s.split(" ")[1]);
            bw.write("Case #"+ (i+1) +": " + a +" + "+ b +" = "+(a+b) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
```

---

# 1152 단어의 개수

## StringTokenizer
문자열을 지정한 구분자로 쪼개주는 클래스
```java
public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        // 공백을 포함한 문자열을 받음
        String s = scan.nextLine();
        scan.close();
                
        // StringTokenizer 객체 선언
        // 문자열을 " "로 나눔
        StringTokenizer st = new StringTokenizer(s, " ");
        
        // st 내에 Token의 갯수를 반환
        System.out.println(st.countTokens());
    }
}

```
