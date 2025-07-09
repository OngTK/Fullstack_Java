# Java_01_Java기초
## 1. 파일만들기

---
### 1.1 파일 종류
   - java Class
   - 파일 (txt or md)
   - 패키지 (일종의 폴더)

### 1.1 자바 클래스 파일 생성
1. [src] 폴더 우클릭
2. 새로 만들기 > 패키지
3. 특정폴더 > 새로 만들기 > Java 클랙스
   * 반드시 클래스 파일의 첫글자는 대문자

### 1.2. 자바 구동 원리
1. [코딩] 개발자는 .java 파일 내에서 자바 문법을 작성
2.  [실행] .java 파일을 run  >>(컴파일) >> out 폴더에 .class 파일 생성
3. [처리] 컴퓨터가 .class 파일을 처리

### 1.3 Java 활용처

소프트웨어 : javafx툴 활용 ...

웹 : JSP, Spring ...

앱 : 안드로이드 ...


## 2. Java 첫 걸음

---
### 2.1. 주석
```java
// 한 줄 주석
// ctrl + / >> 해당 줄 주석 on/off
/* 여러줄 주석 */
```
### 2.2. 간단 정의

1. package 
   : 현 java 파일이 위치한 package명, 패키지 = 폴더

2. public
   : 프로젝트 내 모든 곳에서 호출 가능한 키워드

3. class
: 클래스 선언
: 첫 글자는 대문자
: 단, 동일한 폴더 내에서 중복된 이름 불가
: 일종의 설계도로 함수를 정의하는 곳

4. { }
: 클래스·메소드·for·if 등의 시작·끝



### 2.3. Java 코드 실행 원리
자바는 클래스 단위로 <span style='color : red; font-weight : bold'>컴파일</span> 되고, 컴파일된 코드는 main함수부터 읽어서(<span style='color : red; font-weight : bold;'>thread</span>) 처리한다

### 2.4. 자료형/타입

        정수 : byte, short, int, long
        실수 : float, double
        문자 : char                      * String : 문자열
        논리 : boolean                   총 8가지

         모든 정수(3, 10, 356) : int
         모든 실수(3.14, 0.14789) : dobule

※ 자세한 내용은 3.5 참고

## 3. Java 실습

---
### 3.1. main 함수 선언
```java
public class Example2 { // class stat : 모든 자바코드는 클래스 안에 존재
    // main 함수 선언
    public static void main(String[] args) { //main start
        
    } //main end
} // class end
```

### 3.2. 출력함수

<span style="color:#203864 ; font-size:20px ; font-weight : bold">System.out.print()</span>

System : 시스템 관련 기능을 제공하는 클래스

out : 출력 관련 객체를 반환

(1) System.out.print();   
: 출력 함수

(2) System.out.println(); 
: 출력 후 출바꿈
: 자동완성 : sout

(3) System.out.printf("형식" , 값 );  
: 정해진 형식(format)의 출력 함수
: 자동완성 : souf
: 형식

     %s : 문자열 위치
     %c : 문자 위치
     %d : 정수 위치
     %f : 실수 위치
     %자릿수d : 표현할 자리수를 작성
         %자릿수d : 숫자만큼 자릿수 + 오른쪽 정렬
         %-자릿수d : 숫자만큼 자릿수 + 왼쪽 정렬
         %0자릿수d : 숫자만큼 자릿수 + 오른쪽 정렬 + 빈칸을 모두 0으로 채움
         %전체자릿수.소수점자릿수d : 소수점을 포함한 전체자릿수와, 수소점 자릿수를 표현

```java
public class Example3 {
   public static void main(String[] args) {

//[1]
       System.out.println("자바안녕1");

       System.out.print("자바안녕3"); // 줄바꿈 없음

       System.out.printf("%s", "자바안녕5\n");

//[2]
       String name = "유재석";
       int age = 40;
       System.out.printf("저는 %s이고 나이는 %d입니다.\n", name, age);
// vs
       System.out.println("저는 " + name + "이고 나이는 " + age + "입니다.\n");
       System.out.printf("저는 %s이고 나이는 %6d 입니다. \n", name, age); //%6d : 6자리 수라는 정수 표현 (오른쪽 정렬)
       System.out.printf("저는 %s이고 나이는 %-6d 입니다. \n", name, age); // %-6d : 왼쪽 정렬
       System.out.printf("저는 %s이고 나이는 %06d 입니다. \n", name, age); // 6자리를 표현하며 빈 칸은 0으로 채움
       System.out.printf("저는 %s이고 신장은 %5.2f 입니다. \n", name, 188.257);
   }
}
```

### 3.3. 실행

line number 우측 ▶ 클릭 

ctrl + shift + F10


### 3.4. 주의사항

**세미클론( ; )** 은 필수!!

### 3.5. 변수에 리터럴 대입하기
형태 : <span style="color:#203864 ; font-size:20px ; font-weight : bold"> 자료형 변수명 = 리터럴 </span>

```java
public class Example2 {
    public static void main(String[] args) {
        
       // 1. boolean : true or false, 1바이트
       boolean bool1 = true;
       boolean bool2 = false;
       // boolean boo3 = 3; >> 오류!! 3이라는 리터럴은 boolean에 저장 불가!!
       System.out.println(bool1);
       System.out.println(bool2);

       // 2. char : 작은따옴표('')으로 감싼 문자1개
       char ch1 = 'A';
       //char ch2 = 'AB'; >> 오류!! 문자가 2개!!
       //char ch3 = "A"; >> 오류!! 큰따옴표("") 불가!!
       System.out.println(ch1);

       // 3. String : 큰 따옴표("")으로 감싼 문자열
       String str1 = "ABC";
       // String str2 = 'ABC'; >> 오류!! 작은 따옴표('') 불가!!
       System.out.println(str1);

       // 4. byte  : -128 ~ +127 범위의 정수       1 바이트
       byte b1 = 100;
       // byte b2 = 300; > 오류!! 저장범위 초과
       System.out.println(b1);

       // 5. short : 약 +- 30,000 범위의 정수      2 바이트
       short s1 = 32000;
       // short s2 = 50000;  > 오류!! 저장범위 초과
       System.out.println(s1);

       // 6. int   : +- 약 21억 정도의 정수         4 바이트, default 정수 리터럴*
       int i1 = 2100000000;
       // int i2 = 2200000000;  > 오류!! 저장범위 초과
       System.out.println(i1);

       // 7. long  : *- 약 21억 이상의 정수         8 바이트, 리터럴 뒤에 L or l을 기재
       // long l1 = 2200000000; > 오류!! 리터럴 뒤에 L or l을 기재 필요
       long l2 = 2200000000L;
       System.out.println(l2);

       // 8. double : 소수점 17자리까지 표현 가능한 실수, default 실수 리터럴*
       double d1 = 0.123456789123456789;
       System.out.println(d1); // 출력하면 17자리까지만 표현
       // ※ 주의!! double 과 Double은 다름!!!!(자세한 것은 나중에!!)

       // 9. float : 소수점 8자리까지 표현 가능한 실수, 4 바이트, 리터럴 뒤 F or f를 기재
       // float f1 = 0.12324567898413; > 오류!! 리터럴 뒤에 F or f 기재 필요!!
       float f2 = 0.12324567898413f; // 출력하면 8자리까지만 표현
    }
}
```

### 3.6. 이스케이프 문자/제어

| 표시 | 역할 |
|----|----|
|  \n  |  줄바꿈  |
| \t   |  들여쓰기 (tab)  |
|  \\  |  '\' 출력  |
|  \'  |  ' 출력  |
|  \"  |  " 출력  |
 

```java
public class Example3 {
   public static void main(String[] args) {
       System.out.println("안녕1\n안녕2");
       System.out.println("안녕1\t안녕2");
       System.out.println("안녕1\'안녕2\'");
       System.out.println("안녕1\"안녕2\"");
       System.out.println("안녕1\\안녕2\\");
   }
}
```
---

----

# Java_02_타입, 연산자
## 1. 타입
---

### 1) 정의
자료들의 분류
### 2) 목적 
효율적인 자료 처리
### 3) 종류(8가지)
|구분|종류|크기| 설명                   |
|---|---|---|----------------------|
|정수|byte|1바이트| -128 ~ 127           |
||short|2바이트| +3만 정도               |
||int|4바이트| ± 21억 정도 (리터럴 정수)    |
||long|8바이트| ± 21억 이상, 리터럴 뒤에 L/l |
|실수|float|4바이트| 소수점 8자리, 리터럴 뒤 F/f   |
||double|8바이트| 소수점 17자리(리터럴 실수)     |
|논리|boolean|1바이트| true / false         |
|문자|char|1바이트| 유니코드, ''작은따옴표로 감싼 문자 |
||String|클래스| 클래스, ""큰따옴표로 감싼 긴 문자 |

### 4) 변수 타입변환(casting)

Java는 다향성을 가짐
= 하나의 자료가 여러 개의 타입을 가질 수 있음

    1. 자동 타입변환 (묵시적)
        byte > short / char > int > long > float > double
        (1) 메모리 크기 小 > 大 로 변환
        (2) 데이터 손실이 적다.

    2. 강제 타입변환 (명시적)
        double > float > long > int > short / char > byte
        (1) 메모리 크기 大 > 小로 변환
        (2) 데이터 손실이 크다. (발생할 수 있다.)
        (3) (변환할 타입명) 변수명;

    3. 연산 타입변환
        (1) int 이하의 연산결과는 int
            byte + byte = int
            byte + short = int
            int + int = int
        (2) int 이상에서는 연산 결과 두 개 중 더 큰 항으로 자동 타입변환



## 2. 연산자
---
1. 산술 연산자
+ - * / %(나머지)
2. 연결 연산자
   "문자열" + 10 = 문자열 10
   피연산자 중에 문자열이 포함되면 산술이 아닌 문자열 연결
3. 비교 연산자
>  <  ==  !=
결과를 boolean 으로 반환
4. 논리 연산자
   && and, || or, ! not
5. 증감 연상자
   변수 값에 1 증가 or 감소
   ++변수명 : 선위 증가
   변수명++ : 후위 증가
   --변수명 : 선위 감소
   변수명-- : 후위 감소
6. (복합)대입연산자
   = 오른쪽 값을 왼쪽에 대입
   +=, -=, *=, /=, %= 오른쪽 값을 왼쪽 값에 대해 연산한 후 대입
7. 삼항연산자
   조건 ? 참 : 거짓
   조건1 ? 참1 : 조건2 ? : 참2 : 거짓 vs if문
8. 문자열 비교
   "문자열A".equals("문자열B")

