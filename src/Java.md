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
2. [실행] .java 파일을 run  >>(컴파일) >> out 폴더에 .class 파일 생성
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

자바는 클래스 단위로 <span style='color : red; font-weight : bold'>컴파일</span> 되고, 컴파일된 코드는 main함수부터
읽어서(<span style='color : red; font-weight : bold;'>thread</span>) 처리한다

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

| 표시 | 역할         |
|----|------------|
| \n | 줄바꿈        |
| \t | 들여쓰기 (tab) |
| \\ | '\' 출력     |
| \' | ' 출력       |
| \" | " 출력       |

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

| 구분 | 종류      | 크기   | 설명                   |
|----|---------|------|----------------------|
| 정수 | byte    | 1바이트 | -128 ~ 127           |
|    | short   | 2바이트 | +3만 정도               |
|    | int     | 4바이트 | ± 21억 정도 (리터럴 정수)    |
|    | long    | 8바이트 | ± 21억 이상, 리터럴 뒤에 L/l |
| 실수 | float   | 4바이트 | 소수점 8자리, 리터럴 뒤 F/f   |
|    | double  | 8바이트 | 소수점 17자리(리터럴 실수)     |
| 논리 | boolean | 1바이트 | true / false         |
| 문자 | char    | 1바이트 | 유니코드, ''작은따옴표로 감싼 문자 |
|    | String  | 클래스  | 클래스, ""큰따옴표로 감싼 긴 문자 |

### 4) 변수 타입변환(casting)

Java는 다향성을 가짐
= 하나의 자료가 여러 개의 타입을 가질 수 있음

#### (1) 자동 타입변환 (묵시적)

byte > short / char > int > long > float > double

- 메모리 크기 小 > 大 로 변환
- 데이터 손실이 적다.

```java
byte byteValue = 10;
short shortValue = byteValue;       // byte > short
int intValue = shortValue;          // short > int
long longValue = intValue;          // int > long
float floatValue = longValue;       // long > float
double doubleValue = floatValue;    // float > double, doubleValue = 10
```

#### (2) 강제 타입변환 (명시적)

double > float > long > int > short / char > byte

- 메모리 크기 大 > 小로 변환
- 데이터 손실이 크다. (발생할 수 있다.)
- (변환할 타입명) 변수명;

```java
double dvalue = 3.14;
float fvalue = (float) dvalue;  // double > float 으로 명시적 타입변환
long lvalue = (long) fvalue;    // float > long `` // 손실발생 : 3.14 > 3
int ivalue = (int) lvalue;      // long > int   ``
short svalue = (short) ivalue; // int > short  ``
byte bvalue = (byte) svalue;    // short > byte ``
```

#### (3) 연산 타입변환

- int 이하의 연산결과는 int
  byte + byte = int
  byte + short = int
  int + int = int
- int 이상에서는 연산 결과 두 개 중 더 큰 항으로 자동 타입변환

```java
byte b1 = 10;
byte b2 = 20;
short s1 = 30;
int i1 = 40;
long l1 = 50;
float f1 = 3.14f;
double d1 = 41.25;

int result = b1 + b2;       // byte + byte = int
int result2 = b1 + s1;      // byte + short = int
int result3 = i1 + i1;      // int + int = int
long result4 = i1 + l1;     // int + long = long
float result5 = i1 + f1;    // int + float = float
double result6 = i1 + d1;   // int + double = double
```

## 2. 연산자
---

| 연산자       | 설명                                                                                   |
|-----------|--------------------------------------------------------------------------------------|
| 산술연산자     | +덧셈 -뺄셈 *곱셈 /나눗셈 %나머지                                                                |
| 연결 연산자    | "문자열" + 10 = 문자열 10 <br> 피연산자 중에 문자열이 포함되면 산술이 아닌 문자열 연결                             |
| 비교 연산자    | \< <= > >= == != <br> 결과를 boolean 으로 반환                                              |
| 논리 연산자    | && and  \|\| or  ! not                                                               |
| 증감 연상자    | 변수 값에 1 증가 or 감소<br>++변수명 : 선위 증가<br>변수명++ : 후위 증가<br>--변수명 : 선위 감소<br>변수명-- : 후위 감소 |
| (복합)대입연산자 | = 오른쪽 값을 왼쪽에 대입<br> += -= *= /= %= 오른쪽 값을 왼쪽 값에 대해 연산한 후 대입                          |
| 삼항연산자     | 조건 ? 참 : 거짓 <br> 조건1 ? 참1 : 조건2 ? : 참2 : 거짓 vs if문                                   |
| 문자열 비교    | "문자열A".equals("문자열B")                                                                |

```java
public class Example {
    public static void main(String[] args) {
        int x = 10;
        int y = -3;
// [1] 산술 연산자
        System.out.println(x + y);       // 7
        System.out.println(x - y);       // 13
        System.out.println(x * y);       // -30
        System.out.println(x / y);       // -3 : int/int >> 속성 int 이므로 소수점이 표시되지 않음
        System.out.println(10.0 / 3.0);  // double/double 이므로 소수점 표시
        System.out.println(x % y);       // 1

// [2] 연결 연산자
        System.out.println(x + "개"); // 10개

// [3] 비교 연산자
        System.out.println(x > y);      // true
        System.out.println(x < y);      // false
        System.out.println(x >= y);     // true
        System.out.println(x <= y);     // false
        System.out.println(x == y);     // false
        System.out.println(x != y);     // true

// [4] 논리 연산자(관계 연산자)
        System.out.println(x > 10 && x < 20); // and, false
        System.out.println(y == 10 || y == 20); // or, false
        System.out.println(!(x > 30)); // not(), true

// [5] 증감연산자
        System.out.println(x++);    // 10 출력 후 1 증가 : 11
        System.out.println(++x);    // 11에서 1 증가 후 출력
        System.out.println(x--);    // 12 출력 후 1 감소 : 11
        System.out.println(--x);    // 11에서 1 감소 후 출력

// [6] 복합 대입 연산자
        int z = 30;                   // 30이라는 자료를 z에 대입
        z += 10;                      // 40 // z + 10 후에 다시 z에 대입
        z++;                          // 41

// [7] 삼항 연산자
        System.out.println(x >= 60 ? "합격" : "불합격");

// [8] 문자열 비교와 리터럴 비교는 다르다.
//      System.out.println( "10" == 10 ); // 에러발생!! 숫자 10과 리터럴 10은 서로 다름
//문자열 비교 : "문자열A".equals("문자열B")
        System.out.println("10".equals("10"));
        System.out.println("admin".equals("admin"));
    }
}
```

---
---

# Java_03_입력함수, 출력함수

## 1. 입력함수
---
콘솔화면에서 자료를 입력받는 방법

### 1) 형태

new Scanner( System.in ); : 시스템으로부터 입력 관련 기능을 제공하는 객체

일반적으로 아래와 같이 작성하여 사용

```java
Scanner scan = new Scanner();
```

### 2) 종류

| 구분             | 설명                                                                                                                                             |
|----------------|------------------------------------------------------------------------------------------------------------------------------------------------|
| .next()        | 입력받은 문자열(String) 반환 (단, 띄어쓰기 불가)                                                                                                               |
| .nextLine()    | 입력받은 문자열(String) 반환, 띄어쓰기 가능 <br>※ 주의점<br>   nextLine() 앞에 다른 next()가 존재하면 enter(개행)를 포함하므로 문제 발생<br>해결 : nextLine() 앞에 무의미한 nextLine()를 하나 추가 |
| .nextByte()    | 입력받은 정수(byte)를 반환                                                                                                                              |
| .nextShort()   | 입력받은 정수(short)를 반환                                                                                                                             |
| .nextInt()     | 입력받은 정수(int)를 반환                                                                                                                               |
| .nextLong()    | 입력받은 정수(long)를 반환                                                                                                                              |
| .nextFloat()   | 입력받은 실수(float)를 반환                                                                                                                             |
| .nextDouble()  | 입력받은 실수(double)를 반환                                                                                                                            |
| .nextBoolean() | 입력받은 true/false를 반환                                                                                                                            |

※주의 .nextChar()는 없음 ☆★☆★☆★☆★☆★

```java
char value = scan.next().charAt(0);
//입력받은 문자열 중에 첫번째[index 0] 글자를 반환
```

### 3) 예제

```java
public class Example {
    public static void main(String[] args) {
// [2] Scanner 객체를 변수에 저장하여 활용
        Scanner scan = new Scanner(System.in); 
        // 객체타입 : Scanner, 변수명 : scan, 객체 : new Scanner(System.in)

        // [2.1] .next();
        System.out.println("1. next() : ");
        String str1 = scan.next();
        System.out.println("1. next result : " + str1);

        // [2.2] .nextLine();
        System.out.println("2. nextLine() : ");
        scan.nextLine();
        String str2 = scan.nextLine();
        System.out.println("2. next result : " + str2);

        // [2.3] .nextByte();
        System.out.println("3. nextByte() : ");
        byte value1 = scan.nextByte();
        System.out.println("3. nextByte result : " + value1);

        // [2.4] .nextShort();
        System.out.println("4. nextShort() : ");
        short value2 = scan.nextShort();
        System.out.println("4. nextShort result : " + value2);

        // [2.5] .nextInt();
        System.out.println("5. nextInt() : ");
        int value3 = scan.nextInt();
        System.out.println("5. nextInt result : " + value3);

        // [2.6] .nextLong();
        System.out.println("6. nextLong() : ");
        long value4 = scan.nextLong();
        System.out.println("6. nextLong result : " + value4);

        // [2.7] .nextFloat();
        System.out.println("7. nextFloat() : ");
        float value5 = scan.nextFloat();
        System.out.println("7. nextFloat result : " + value5);

        // [2.8] .nextDouble();
        System.out.println("8. nextDouble() : ");
        double value6 = scan.nextDouble();
        System.out.println("8. nextDouble result : " + value6);

        // nextChar는 없음!
        System.out.println("10. next() : ");
        char value8 = scan.next().charAt(0);
        // 입력받은 문자열 중에 첫번째[index 0] 글자를 반환
    }
}
```

## 2. 출력함수
---

#### (1) System.out.print( ); 
console에 출력
#### (2) System.out.println( );
console에 출력 및 줄바꿈
#### (3) System.out.printf("형식문자1 형식문자2", 값1, 값2);

| 구분      | 분류             | 설명                               |
|---------|----------------|----------------------------------|
| 형식문자    | %s             | 문자열                              |
|         | %d             | 정수                               |
|         | %c             | 문자                               |
|         | %f             | 실수                               |
| 자릿수     | %자릿수d          | 자릿수만큼 자리 차지, 만일 비어있으면 공백, 오른쪽 정렬 |
|         | %-자릿수d         | 자릿수만큼 자리 차지, 비어있으면 공백, 왼쪽 정렬     |
|         | %0자릿수d         | 자릿수만큼 자리 차지, 만일 비어있으면 0을 채움      |
| 소수점 자릿수 | %전체자릿수.소수점자릿수f | (소수점 포함) 전체 자릿수 만큼 자리 차지         |

```java
public class Example {
    public static void main(String[] args) {
        //[1]
        System.out.println("자바안녕1");
        System.out.println("자바안녕2");

        System.out.print("자바안녕3"); // 줄바꿈 없음
        System.out.print("자바안녕4");

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

---
---

# Java_4_조건문 if
## 1. 형태
---
#### (1) 단일 조건, 단일 참 명령어
if( 조건문 ) 참 ;
#### (2) 단일 조건, 다수 참 명령어
if( 조건문 ) { 
    참 1;
    참 2;
};
#### (3) 단일 조건, 참 or 거짓
if ( 조건문 ) { 참 } else { 거짓 };
#### (4) 다중 조건
if ( 조건문1 ) { 참1 }
else if( 조건문2 ) { 참2 }
else if( 조건문3 ) { 참3 }
else { 거짓 };
#### (5) 여러 조건에 여러 개의 결과
if ( 조건문1 ) { 참1 };
if ( 조건문2 ) { 참2 };
#### (6) 중첩
if ( 조건문1 ) {
    if ( 조건문2 ) { 참2 } else { 거짓2 }
} else{ 거짓1 };

## 2. 주의사항
---
#### (1) 조건문은 true / false 만 가능
#### (2) {} 중괄호
#### (3) if(); << 하지 않도록 주의
#### (4) if, if~else, if~else if는 하나의 결과만 반환

```java
public class Example {
    public static void main(String[] args) {
        // [1]
        int tem = 5;
        if (tem <= 10) System.out.println("외투를 입는다.");

        // [2]
        int age = 10;
        if (age >= 19) {
            System.out.println("성인입니다.");
            System.out.println("19세 이상입니다.");
        }
        ;

        // [3]
        boolean check = false;
        if (check == true) {
            System.out.println("안녕하세요. 회원님");
        } else {
            System.out.println("비회원입니다.");
        }
    }
}
```

# Java_05_반복문
## 1. 정의 
---
조건에 따른 결과가 true 일때 코드를 반복 실행
## 2. 형태
---
for(초기값 ; 조건문 ; 증감식){ 실행문;}

- 초기값 : 반복문에서 사용되는 변수  ex. int i = 0
- 조건문 : 반복변수의 조건문        ex. i < 10
- 증감식 : 반복변수의 증감          ex. i++
- 실행문 : 조건 충족시 실행되는 코드/명령어;

## 3. 주요 키워드
---
1) break;    : 가장 가까운 반복문 {} 종료/탈출
2) continue; : 가장 가까운 반복문(증감식) 이동

## 4. 무한루프
---
1) for( ; ; ){ }
2) while(true){ }

## 5. 예제
---
```java
import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {
        // [1] 1~5까지 출력
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }

        // [2] 중첩 : 구구단
        for (int i = 2; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%d * %d = %d \n", i, j, i * j);
            }
        }

        // [3] break : 1~10까지 출력, 만약 5를 찾으면 반복 종료
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                break; //for 문을 탈출!
            }
            System.out.println(i);
        }

        // [4] continue : 1부터 10까지 반복, 만약 5를 찾았으면 출력 생략
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                continue; //조건 충족시 아래를 수행하지 않고 for문으로 돌아감!
            }
            System.out.println(i);
        }

        // [5] for( ; ; ){} : 무한반복 , 종료조건을 만들어 놓을 수 있음
        for (; ; ) {
            System.out.print("무한입력 [종료:'x'] : ");
            String input = new Scanner(System.in).next(); //무한 입력
            if (input.equals("x")) {
                break; // "x"가 입력되면 for(무한반복)문 종료

            }
        }
    }
}
```

---
---

# Java_06_배열 array
---
## 1. 정의 
---
동일한 자료형(타입)의 여러 데이터를 순서대로 저장하는 타입
## 2. 특징
---
#### (1) 동일한 타임
서로 다른 타입은 같은 배열에 저장 불가
#### (2) 고정 길이
한 번 생성된 배열의 길이 수정 불가
#### (3) 요소 초기값 
입력된 값이 없다면, 아래 값이 default으로 설정

정수 0 / 실수 0.0 / 논리 false / 객체(배열) null

## 3. 사용법
---
### 1) 선언
(1) new 타입[길이];             ex) int[] 변수명 = new int[3];
(2) { 값1 , 값2 , 값3 }        ex) double[] 변수명 = { 3.14, 5.1, 78.69 }

### 2) 호출
(1) 변수명                     : 객체의 주소값 반환
(2) Arrays.toString( 변수명 ); : 배열의 요소 갑 반환
(3) 변수명[index]              : index는 0부터 시작
변수명.length              : 배열의 길이

### 3) 수정
(1) 변수명 = new 타입[3]        : 전체 배열 수정
(2) 변수명[index] = 새로운 값    : 특정 index 값 수정

### 4) 삭제/추가
특정 요소 삭제 기능이 존재하지 않음
Java 배열은 고정길이이므로 중간에 요소 개수 변경 할 수 없음

### 5) 배열과 반복문
(1) 일반 for
for( int index = 0 ; index < 변수명.length ; index++ ){
타입 변수명 = 배열변수명[index]
}
(2) 향상된 for 문
- index 없이 배열 내 요소값을 하나씩 변수에 대입 반복
for (타입 변수명 : 배열 변수명) {
}
// in JS
for ( let 변수명 : )
### 6) 예제
```java
import java.util.Arrays;

public class Example1 {
    public static void main(String[] args) {
        // [1] 배열 선언1                                        only 선언
        int[] array1 = new int[3];

        // [2] 배열 선언2                                        선언 + 초기화
        String[] array2 = { "봄" , "여름", "가을", "겨울"};

        // [3] 출력 : 배열 주소
        System.out.println(array1);                             //[I@4c873330 >> 객체의 주소값 반환
        System.out.println(array2);                             // [Ljava.lang.String;@119d7047

        // [4] 출력 : 배열 내 요소를 문자열로 반환
        System.out.println(Arrays.toString(array1));            // [0, 0, 0]            : array1은 길이 3, int의 빈 배열
        System.out.println(Arrays.toString(array2));            // [봄, 여름, 가을, 겨울]

        // [5] 출력 : 특정 요소 반환
        System.out.println(array1[0]);                          //  0
        System.out.println(array2[0]);                          //  봄

        // [6] 배열의 길이
        System.out.println(array2.length);                      // 4

        // [7] 특정 요소 값 수정
        array1[0] = 10;                                         //  [0,0,0] > [10,0,0]
        System.out.println(array1[0]);                          //
        array2[0] = "Spring";
        System.out.println(array2[0]);                          // [봄, 여름, 가을, 겨울] > [Spring, 여름, 가을, 겨울]

        // [8] 배열의 삭제/추가 불가 : 길이 수정 X
        // array1[3] = 30;                                      // error : Index 3 out of bounds for length 3

        // [9] 반복문
        // 일반 for
        for (int i = 0 ; i < array1.length ; i++){
            int value = array1[i];
            System.out.println(value);
        }

        // 향상된 for
        for ( String value : array2) {
            System.out.println(value);
        }
        
    }
}
```
---
---

# Java_07_클래스와 객체
**java는 컴파일(번역)을 클래스 단위로 처리**

## 1. 정의
---
#### (1) 객체
행위의 영향을 받는 대상 
#### (2) 클래스
객체를 만들기 위하여 객체를 정의하는 설계도

## 2. 클래스
---
#### (1) 멤버변수    
객체 내에 포함되는 변수, 속성/특징/성질 = 값/데이트
#### (2) 메소드
객체 내에 포함되는 함수, 이벤트/행위/작동 = 실행 명령어의 집합
#### (3) 생성자
객체가 생성될 때의 초기화 함수
사용자가 커스텀해서 사용하므로 정해저있지 않음.

## 3. 클래스 사용법
---
#### (1) 선언
① java 파일 내에서 여러 개의 클래스를 선언(비추천)
② java 파일 내 클래스 1개만 존재하도록 개별 파일로 선언(권장)
```java
class 클래스명{
    멤버변수;
    메소드;
    생성자;
}
```

## 4. 객체 사용법
---
#### (1) 선언
new 클래스명();
ex) 클래스명 변수명 = new 클래스명();
    ※ new 연산자 : 클래스를 기반으로 객체를 생성하며 메모리를 할당하는 키워드
#### (2) 객체 내 멤버변수 호출
변수명.멤버변수명
    ※ .(온점, 도트) 접근연산자 : 객체 내에 포함된 멤버변수, 메소드 등에 접근하는 키워드
#### (3) 객체 내 멤버변수 값 수정
변수명.멤버변수명 = 새로운 값
#### (4) 객체 내에 멤버변수 추가/삭제 불가
    : 클래스는 컴파일(실행/번역)된 이후에는 수정 불가!!

## 5. 예제
---
```java
public class Example1 {
    public static void main(String[] args) {
        Student s1 = new Student(); // Student 클래스를 이용한 객체 선언
        System.out.println(s1); // >> 위치를 출력 daily.day06_250707.Student@119d7047
        s1.studentName = "홍길동";
        System.out.println(s1.studentName); // : 홍길동
    } // main end
    
    // 클래스 선언/정의
    class Student {
        // Class = 객체 내 필요한 속성과 기능을 정의 >> 객체를 만드는 것이 아님

        // 멤버변수
        int studentID;              //'학번' 속성 정의
        String studentName;         //'이름' 속성 정의

    } // student class end
}
```

---
---
# Java_08_메소드
**메소드 = 멤버변수**
## 1. 정의
----
하나의 기능을 수행하는 일련의 코드/명령어
## 2. 선언
```java
    반환타입 메소드명 ( 타입 매개변수1, 타입 매개변수2 ){
        실행코드
        return 반환값; (반환값이 없으면 생략 가능 = void)
    };
```
## 3. 용어 정리
---
- 인수(인자)값  : 메소드 호출 시 메소드에 전달되는 값
- 매개변수      : 메소드 실행 시, 메소드로 인수값으로부터 들어오는 값
  * 없을 수도 있음
  * 반드시! 인수 값의 타입과 매개변수의 타입이 일치해야 함
- 반환값       : 메소드 실행 후 결과값
  * 반드시! 반환값의 타입과 반환타입이 일치
  * 반환값은 1개만 가능
  * 반환값이 없을 때는 [ void ] 반환타입 키워드 사용
- 반환타입     : 메소드 실행 후 결과인 반환값의 타입
- 메소드명     : 임의의 기능명칭 (카멜표기법 권장)

## 4. 호출
---
#### (방법 1) 실행 클래스와 메소드의 클래스가 별도로 존재하여, 실행 클래스에서 메소드를 호출할 때
1) 클래스명 변수명 = new 클래스명();    // 객체 생성
2) 변수명.메소드명();                  // 객체를 통한 메소드 호출
3) 타입명 매개변수 = 변수명.메소드명();  // 메소드의 반환값을 매개변수에 저장
```java
public class Example1 {
    public static void main(String[] args) {
        // [1] 클래스에서 메소드 선언
        // [2] 다른 클래스에서 매소드 호출
        //      1) 호출하고자 하는 메소드를 갖는 클래스로 객체 생성
        Calculator cal1 = new Calculator();
        //      2) 호출하고자 하는 메소드를 갖는 객체를 이용한 메소드 호출
        cal1.getPI();   //객체.메소드명

        // [3] 매개변수 X, 반환값 O
        //      : 반환값이 있으면 주로 변수에 저장
        double result = cal1.getPI();

        // [4] 매개변수 X, 반환값 X
        cal1.powerOn();
        //      주의할 점 : 여러 객체들 간의 멤버변수
        //                 new 연산자는 항상 새로운 객체를 만듦
        //                 즉, 객체마다 멤버변수는 다 각자임
        Calculator cal2 = new Calculator();
        System.out.println(cal1.isPowerOn); // true
        System.out.println(cal2.isPowerOn); // false

        // [5] 매개변수 O, 반환값 X
        cal1.printSum(3,5); // 3, 5 : 인수값
        // cal1.printSum(3.14 , 4.45); error!! : 매개변수 타입 int!! 이므로 double(실수)는 입력 불가
        cal2.printSum(10,2); // isPowerOn = false 이므로 "전원이 꺼져 있습니다."가 발생

        // [6] 매개변수 O, 반환값 O
        int result2 = cal1.add(10,3);
        // add 메소드의 타입이 int 이므로 저장할 변수 또한 int
    }
}
```
```java
public class Calculator {
    /* 클래스 멤버(객체내 포함)
            1. 멤버변수 : 객체 마다 할당
            2. 생성자
            3. 메소드 : 여러 객체가 공유해서 사용
    */

    boolean isPowerOn = false; //전원상태

    // [ 메소드 선언 ]

    // (1) 매개변수 X, 반환값 O
    double getPI(){
        return 3.14159;
    };
    // double : return값 3.14159의 타입이 실수이므로 double
    // getPI : 메소드 명
    // ( ) : 매개변수 (여기선 없음) 
    // return 값 : 메소드를 호출했던 곳으로 반환하는 값

    // (2) 매개변수 X, 반환값 X >> void
    void powerOn(){
        System.out.println("계산기 전원을 켭니다.");
        isPowerOn = true;
    };
    // void : return(반환값)이 없다는 키워드

    // (3) 매개변수 O, 반환값 X
    void printSum(int x, int y){
        if( isPowerOn ) {
            int sum = x + y;
            System.out.println(sum);
            return; // void(반환값 X 이므로 생략 가능)
        } else {
            System.out.println("전원이 꺼져 있습니다.");
            return; // void(반환값 X 이므로 생략 가능)
        }
    };
    // int x, int y : 메소드 호출 시, 인수값을 저장하기 위한 타입과 매개변수

    // (4) 매개변수 O, 반환값 O
    int add(int x, int y) {
        if(isPowerOn){
            int result = x + y ;
            return result;
        } else{
            System.out.println("전원이 꺼져 있습니다.");
            return 0; // 메소드가 int로 정의되었으므로, else의 return 값도 필요
        }
    };

}
```
#### (방법 2) 동일한 클래스에 선언된 메소드를 호출
1) 메소드명(인수);
```java
public class Example {
    class Student { // Class = 객체 내 필요한 속성과 기능을 정의
        int studentID;              //'학번' 속성 정의
        String studentName;         //'이름' 속성 정의
    } // student class end
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.studentName = "홍길동";
    }
}
```
---
---

# Java_09_생성자

## 1. 정의
객체를 생성할 때 사용되는 초기화를 담당하는 키워드

<span style="color:#203864 ; font-size:20px ; font-weight : bold"> 클래스명 변수명 = new 생성자명(); </span>

## 2. 목적
- 객체 생성시 멤버변수의 초기화
- 매개변수 유효성 검사를 통해 멤버변수에 일관성 유지

## 3. 규칙
### 1) ☆★ 클래스명 = 생성자명 ☆★

### 2) overload 가능
overload란?
- 변수명/식별자는 동일한 이름을 가질 수 없음 
- 즉, 메소드/생성자는 동일한 이름으로 여러 개 만들 수 없음.
- **But, 메소드/생성자는 매개변수의 개수/타입/순서가 다르다면, <br>동일한 이름으로 여러 개의 메소드/생성자를 선언할 수 있음**
- why? 객체의 멤버변수는 객체마다 할당되며, 객체의 메소드는 객체 모두에게 공유됨

## 4. 종류
### 1) 기본 생성자
- 정의 : 생성자명( ){ }
- 특징 : 매개변수가 없음
- 사용 : new 생성자명();
### 2) 매개변수가 있는 생성자
- 정의 : 생성자명( 타입 매개변수명, 타입 매개변수명 ){}
### 3) 생성자 오버로드
- 정의 : 생성자명( 타입 매개변수명, 타입 매개변수명, 타입 매개변수명 ){}
        // 2번 vs 3번
        // 매개변소의 타입/순서/개수가 다르므로 생성자가 overload 되었음!

## 5. 사용
### 1) 선언 (클래스명 = 생성자명!!!)
(1) class 클래스명{
    생성자명( ){ }
    }
(2) class 클래스명{
    생성자명( 타입 매개변수명, 타입 매개변수명 ){ }
    }

### 2) 호출/사용 방법
new 생성자명( );
new 생성자명( 매개변수, 매개변수 );

※ 생성자 자동 생성 방법
마우스 우클릭 > Generate (alt + Insert) > Constructor > 매개변수 선택 > OK

※ this.멤버변수
현재 메소드/생성자를 호출한 객체를 가리킴
일반적으로 멤버변수명과 매개변수명이 동일하여 this를 쓰는 경우가 많음

## 6. 예시
작업순서
1. Class를 생성하면 멤버변수/생성자/메소드를 작성할 수 있도록 준비한다.
```java
public class Phone {
    // [1] 멤버변수                     // 1
    
    // [2] 생성자                       // 1
    
    // [3] 메소드                       // 1
}
```

2. 객체 정의에 필요한 멤버변수와 타입을 정의한다.
```java
public class Phone {
    // [1] 멤버변수                     // 1
    String model; // 기종              // 2
    String color; // 색상
    int price;    // 가격

    // [2] 생성자                       // 1
    
    // [3] 메소드                       // 1
}
```

3. 생성자를 정의한다.
이때, 생성자는 (1) 매개변수가 없는 **기본생성자**와 (2) **매개변수를 포함한 생성자**를 정의한다.
그리고 추가적으로 overload를 이용한 생성자를 정의한다.
```java
public class Phone {
    // [1] 멤버변수                     // 1
    String model; // 기종              // 2
    String color; // 색상
    int price;    // 가격

    // [2] 생성자                       // 1
    //  1) 기본 생성자                                   // 3
    //      * 클래스 내 생성자가 없으면 자동으로 생성
    //      * 클래스 내 하나 이상의 생성자가 있을 때는, 기본 생성자를 직접 정의
    Phone() {
    }

    //  2) 매개변수가 있는 생성자                          // 3
    //      * 생성자는 매개변수를 갖지만 반환값은 없음
    Phone(String pModel, String pColor){
        // 매개변수 값을 멤버변수에 저장
        // 모든 멤버변수를 매개변수를 통해 받을 필요는 없음
        model = pModel;
        color = pColor;
        price = 1200000; // 초기값을 임의의 값으로 설정
    }

    //  3) 생성자의 오버로드                               // 3
    //      기존 생성자와 매개변수의 타입/순서/개수가 다르므로 Overload!!
    Phone(String model, String color, int price){
        // 멤버변수 : 객체 내 변수 vs 매개변수 : 메소드/생성자가 사용하는 인수값(외부로부터 들어옴)
        // >> 이름이 같은 issue = 코드 내에서 멤버변수와 매개변수 구별이 불가함
        // 해결책(☆★☆★☆★☆★) :
        //      this 키워드 - 현재 메소드/생성자를 호출한 객체를 가리킴
        //      일반적으로 멤버변수명과 매개변수명이 동일하여 this를 쓰는 경우가 많음
        this.model = model;
        this.color = color;
        this.price = price;
    }
    
    // [3] 메소드                       // 1
}
```
# Java_10_접근제한자 관련 키워드

## 0. 요약

---

### [ 주요 키워드 ]
#### 1) 접근 제한자 
다른 클래스가 특정한 클래스에 접근할 때, 접근권한을 제한하는 키워드
(1) public : 모든 클래스에서 접근 가능
(2) private : 현재 클래스에서만 접근 가능
(3) default : 같은 패키지에서만 접근 가능, 키워드 생략 가능
(4) protected : 같은 패키지에서만 접근 가능, 단, 상속관계 예외
#### 2. 클래스 불러오기
(1) import : 현재 클래스에서 다른 패키지의 클래스를 불러올 때 사용, (라이브러리 사용시 흔히 import를 볼 수 있음)
#### 3. 상수
(1) final : 초기화 선언 이후에는 수정이 블가
(2) static : 프로그램 실행시 메모리가 우선 할당되고 프로그램 종료 시 삭제, 객체 없이 이용 가능

### [ 관례적 용어 ]
#### 1. getter · setter
멤버변수가 private로 선언되었을 경우,
다른 클래스에서 해당 private 멤버변수를 읽고 쓸데 사용되는 간접접근 메소드
#### 2. public static final (상수)
프로그램 내 유일한 존재일 경우 선언
---

## 1. 접근제한자
---
### 1) 정의
서로 다른 클래스에 존재하는 클래스, 멤버변수, 생성자, 메소드 등에 접근하는 것을 제한하기 위한 키워드

### 2) 종류
#### (1) public (공개)
프로젝트 폴더 내 어디서든 접근 가능
#### (2) private (비공개)
현재 class 내에서만 접근 가능
일반적으로 Class를 private 처리할 수 없음,
일반적으로 모든 멤버변수는 private 처리
#### (3) default (기본)
접근 제한자를 선언하지 않으면 기본으로 defualt 제한자로 인식
같은·하위 패키지에서만 접근 가능
#### (4) protected
같은·하위 패키지에서만 접근 가능, 단 상속 관계에서는 예외
※ 추후 자세히 다룰 예정

### 3) 사용
타입 앞에 기재
#### (1) 멤버변수에 타입 앞에 기재
   `접근제한자 타입 변수명;`
#### (2) 생성자명 앞에 기재
   `접근제한자 생성자명( ){ };`
#### (3) 클래스명 앞에 기재
   `접근제한자 class 클래스명{ }`
#### (4) 메소드명 반환타입 앞에 기재
   `접근제한자 반환타입 메소드명( ){ }`

## 2. 상수
---
### 1) 상수란?
변하지 않는 변수
### 2) 사용법
static final 타입 상수명;
### 3) 주의
- 수정 불가
- 프로그램 내에서 단 1개, 유일한 존재일 경우에만 선언
- (일반적으로) 상수명을 전체 대문자로 명명

## 3. final
---
### 1) final 이란?
수정 불가능한 상태 = 고정 상태 정의하는 키워드
### 2) 사용법
final 타입 멤버변수명 = 초기값;
### 3) 주의
초기값 필수
```java
static final int 상수 = 10;
```


## 4. static
---

### 1) static 이란?
실행 중에 변화가 없는 상태를 정의하는 키워드
= 프로젝트 컴파일 시 메모리에 할당되고, 종료 시 메모리가 삭제되는 키워드
**메모리 우선 할당**
static 변수 = 정적변수 = 공유변수 = 전역변수
### 2) 사용법
static 타입 멤버변수
### 3) 주의
멤버변수 = 객체 내 변수 VS static = 객체 외 변수(우선 할당)
메모리 할당 시점 : new 선언 VS static 자체

### 4) 호출
클래스명.정적변수명;

### 5) static 유무가 중요한 이유☆★☆★
static으로 선언된 메소드는 동일한 클래스 내 다른 메소드를 호출할 수 없음.

enable ex)
```java
class Text{
    void main2(){}
    static main3(){}
    static void main(){
        main2(); // 불가능 : main-메모리가 할당되어 있음 / main2-메모리가 할당되어 있지 않음! >> 따라서 main2 메소드를 실행할 수 없음
        main3(); // 가능 : main, main3 모두 메모리가 할당되어 있으므로, main3 메소드 실행 가능

        new Text().main2()
            // 가능 : 클래스 전체에 대한 할당/객체 생성 후 main 2 메소드를 선언함
                      >> main, main2에 모두 메모리가 할당되어 있으므로, main2 메소드 실행 가능
    }
}
```

## 5. getter and setter
---

### 1) 정의
private 멤버변수를 다른 클래스에서 사용할 수 있도록 정의하는 메소드
### 2) 명명
#### 2) 저장/대입
public void set멤버변수명( 타입 매개변수 ){
this.멤버변수명 = 매개변수;
};
#### 3) 호출/반환
public 반환타입 get멤버변수명( ){
return 멤버변수명;
}

```java
public class WaitingDto {

    // 멤버변수 : all private ===================================
    private String phone;       //전화번호
    private int count;          // 인원수

    // 생성자 : 기본생성자와 풀생성자는 기본! 추가는 자유 ===================================
    // 기본 생성자

    public WaitingDto() {
    }
    // 풀생성자
    public WaitingDto(String phone, int count) {
        this.phone = phone;
        this.count = count;
    }
    
    // 메소드 ======================================================================
    // getter·setter

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    // toString
    public String toString() {
        return "WaitingDto{" +
                "phone='" + phone + '\'' +
                ", count=" + count +
                '}';
    }
}// class end

```

# Java_11_디자인 패턴(싱글톤, MVC)
## 1. 디자인 패턴
---
### 1) 정의
소프트웨어 설계과정에서 자주 발생하는 문제에 대한 설계 유형

### 2) 목적
반복되는 문제를 감소시켜 여러 개발자·협업 간에 관례적인 규칙을 정하고, 이를 통해 효율성을 높임

### 3) 종류
(1) 싱글톤 패턴
(2) MVC 패턴
... 그 외에도 다양

## 2. 싱글톤 패턴
---
### 1) 정의
프로그램 내 단 1개·유일한 존재 객체(인스턴스)에 대한 선언

### 2) 목적
유일한 객체(인스턴스)를 만들고 이를 공유

여러 개의 객체가 존재하면 서로 다른 메모리를 사용하므로 협업·공유 시 제약이 발생
협업 간에서는 여러 개의 객체가 필요 없는, 유일한 객체인 경우 싱글톤을 사용

### 3) 사용
1) 지정한 클래스의 default 생성자를 private로 함
    private 생성자명( ){ }
2) 지정한 클래스에 `private static final`으로 객체 선언
    private static final 클래스명 변수명 = new 생성자명();
3) 지정한 클래스에 `public static`으로 getInstance 메소드를 선언
    public static 클래스명 getInstance(){
        return 변수명;
    }
```java
public class WaitingView {
    // 0. 싱글톤 선언 =================================
    // 0.1. 기본 생성자를 private화
    private WaitingView() {
    }

    // 0.2. `private static final` instance 선언
    private static final WaitingView waitingView = new WaitingView();

    // 0.3. `public static` getInstance 메소드
    public static WaitingView getInstance() {
        return waitingView;
    }
}
```

### 4) 호출 (
다른 클래스에서 선언된 싱글톤 호출
- 다른 클래스에 싱글톤이 정상적으로 선언되어있다면, `getInstance()` 함수가 존재함
- 따라서 해당 클래스의 `getInstance()`함수를 실행
        `클래스명.getInstance();`
```java
public class WaitingView {
    // controller 싱글톤 호출
    private WaitingController controller = WaitingController.getInstance();
}
```


## 3. MVC 패턴
---
### 1) 정의
주로 web/app 소프트웨어 개발 시 사용되는 디자인 패턴으로, 
**세가지 주요 역할을 분리하여 모듈화**하는 방법

### 2) 목적
협업 간의 코드와 파일들을 MVC 패턴의 따라 구성하여 효율성 및 유지보수 편의성을 높임
#### (1) 장점
유지보수, 모듈화, 단일기능 책임 등
#### (2) 단점
분리에 따른 복잡도 증가

### 3) 사용처
다양한 실무 프레임 워크에서 권장하는 패턴
ex) Spring etc.

### 4) 레이어·계층
#### (1) M : model
데이터 관리 담당

① 주로 web/app 에서는 Java/Python/Node.js 등 back-end
② 데이터베이스와 상호작용
③ 주요 키워드
- **DAO (data access object)** : 데이터 접근 객체
    - DB와 연결 
    - DB가 없을 경우, dao에서 정의한 객체 정의에 따른 `dto[] (배열)` 또는 `ArrayList<> (리스트 객체)`을 만듦
- **DTO (data transfer object)** : 데이터 이동 객체
    - data 멤버변수 정의 / 생성자 / getter setter / toSting 정의
  ④ 일반적으로 DTO는 데이터 모델이므로 **싱글톤**을 사용하지 않는다.

#### (2) V : view
입출력 담당

① 주로 web/app 에서는 HTML/CSS/JS/JPS 등 front-end
② 사용자로부터 입력·출력이 실행
③ 일반적으로 console 기준으로 view 클래스에서만 `print`와 `scan` 함수를 사용

#### (3) C : controller
model과 view 사이의 제어/전달/유효성 검사 등을 담당
① 주로 web/app 에서는 Java/Python/Node.js 등 back-end
② view로부터 요청을 받아 model에게 전달하고, 처리 결과를 view에게 전달
③ 키워드
    - MVC1 패턴 : controller + view (ex. JSP, 머스테치, 타임리프 etc)
    - MVC2 패턴 : controller · view 분리
    - MVC2 패턴 3 Tier : controller · service · view · model 분리 (ex. Spring)

### 5) 레이어·계층 간의 흐름도
#### (1) 요청
> view ---(DTO)---> controller ---(DTO)---> model(DAO)
#### (2) 응답
> view <---(DTO)--- controller <---(DTO)--- model(DAO)

**※ view가 dao와 직접 통신하지 않도록 주의!!!**

### 6) 파일/폴더 MVC 기준 구분
- 프로젝트 폴더                        
    - Controller 폴더                 
      - **Controller.java**
    - Model 폴더
        - DAO 폴더 
          - **Dao.java**
        - DTO 폴더  
          - **Dto.java**
    - View 폴더
      - **View.java**
    - AppStart 폴더
      - **AppStart.java **

☆★☆★☆★디자인 패턴 내용은 다음에도 이어짐....☆★☆★☆★

# Java_12_싱글톤, MVC 패턴 실습(console 게시판)
```
[요약]
    Q. 문제 파악
    1. 메모리 설계 (생략)
    2. API 명세서 작성 (생략)
    3. PJ·controller·modle·view 패키지 생성
    4. 기능별 class 생성
    5. class 파일 기본 셋팅
        5.1. Dto 멤버변수·생성자·getter·setter·toString 선언
        5.2. 싱글톤 선언
        5.3. 싱글톤 호출
    6. API 명세서 기반 기능 구현 (생략)
```


## Q. console을 이용하여 간단한 게시판을 만드세요.
```
        ============= My Community =============
        1.게시물쓰기 | 2.게시물출력
        ========================================
        선택 > 1
        내용 : 안녕하세요
        작성자 : 유재석
        [안내] 글쓰기 성공

        ============= My Community =============
        1.게시물쓰기 | 2.게시물출력
        ========================================
        선택 > 1
        내용 : 반갑습니다
        작성자 : 강호동
        [안내] 글쓰기 성공

        ============= My Community =============
        1.게시물쓰기 | 2.게시물출력
        ========================================
        선택 > 2
        ============= 게시물 목록 =============
        작성자 : 유재석
        내용 : 안녕하세요
        ------------------------------------
        작성자 : 강호동
        내용 : 반갑습니다
        ------------------------------------

        ============= My Community =============
        1.게시물쓰기 | 2.게시물출력
        ========================================
        선택 > 1
        내용 : 테스트
        작성자 : 이수근
        [경고] 게시물을 등록할 공간이 부족합니다.
```

## 3. PJ·controller·modle·view 패키지 생성
---
```
- 프로젝트 폴더
    - Controller 폴더
    - Model 폴더
        - DAO 폴더
        - DTO 폴더
    - View 폴더
    - AppStart 폴더
```
## 4. 기능별 class 생성
---
```
- 프로젝트 폴더
    - Controller 폴더
        ▶ Controller.java
    - Model 폴더
        - DAO 폴더
            ▶ Dao.java
        - DTO 폴더
            ▶ Dto.java
    - View 폴더
        ▶ View.java
    ▶ appStart.java
```

## 5. class 파일 기본 셋팅
---

### 5.1. Dto 멤버변수·생성자·getter·setter·toString 선언
```java
public class BoardDto {

    // 멤버변수 : all private ===================================
    private String content;
    private String writer;

    // 생성자 : 기본생성자와 풀생성자는 기본! 추가는 자유 ===================================
    // 생성자 단축키 : alt + insert > constructor
    // 기본 생성자
    public BoardDto() {}

    // 풀생성자
    public BoardDto(String content, String writer) {
        this.content = content;
        this.writer = writer;
    }

    // 메소드 ======================================================================
    // getter·setter 단축키 : alt + insert > getter·setter 
   
    // getter·setter
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    // toString 단축키 : alt + insert > toString
    public String toString() {
        return "BoardDto{" +
                "content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                '}';
    }
}// class end
```
### 5.2. 싱글톤 선언
MVC 패턴에서 싱글톤이 필요한 class : view, controller, dao
```
싱글톤 템플릿
    private class명(){}
    private static final class명 변수명 = new class명();
    public static class명 getInstance(){
        return 변수명;
    }
```
#### Dao
```java
public class BoardDao {
    // 추후 DB로 변경 예정

    // 싱글톤
    private BoardDao(){}
    private static final BoardDao dao = new BoardDao();
    public static BoardDao getInstance(){
        return dao;
    }
}
```

#### controller
```java
public class BoardController {
    // 싱글톤
    private BoardController(){}
    private static final BoardController control = new BoardController();
    public static BoardController getInstance(){
        return control;
    }
}
```
#### view
```java
public class BoardView {
    // 싱글톤
    private BoardView(){}
    private static final BoardView view = new BoardView();
    public static BoardView getInstance() {
        return view;
    }
}
```

### 5.3. 싱글톤 호출
※ 싱글톤 호출이 필요한 class
- controller : dao 호출
- view : controller 호출
#### controller
```java
import boardProject.model.dao.BoardDao;

public class BoardController {
    // 싱글톤
    private BoardController(){}
    private static final BoardController control = new BoardController();
    public static BoardController getInstance(){
        return control;
    }

    // dao의 싱글톤 객체 호출
    private BoardDao boardDao = BoardDao.getInstance();
}
```

※ Dao의 싱글톤 객체를 호출하면,
controller class 위로 `import`와 함께 Dao class의 경로가 함께 선언됨!!
따라서 다른 class의 객체를 호출할 때는 **import의 생성 여부**와
**올바른 경로 연결**을 반드시 확인해야함!!

#### view
```java
import boardProject.controller.BoardController;

public class BoardView {
    // 싱글톤
    private BoardView(){}
    private static final BoardView view = new BoardView();
    public static BoardView getInstance() {
        return view;
    }
    
    // controller의 싱글톤 객체 호출
    private BoardController boardController = BoardController.getInstance();
}
```
※ controller 싱글톤 객체를 호출하면,
view class 위로 `import`와 함께 controller class의 경로가 함께 선언됨!!
따라서 다른 class의 객체를 호출할 때는 **import의 생성 여부**와
**올바른 경로 연결**을 반드시 확인해야함!!

# Java_13_ArrayList

## 1. 정의
---
컬렉션 프레임워크 중 리스트 자료형 클래스

## 2. 목적
---
가변 길이의 배열을 지원

## 3. 사용법
---
#### 1) 선언
`ArrayList< 항목타입 > 변수명 = new ArrayList<>();`

#### 2) 관련 함수

| 기능        |선언| 설명                                       |
|-----------|---|------------------------------------------|
| 추가        |변수명.add( 요소값 )| 마지막 인덱스 뒤로 요소 추가                         |
| 삽입        |변수명.add( index, 요소값 )| 지정한 index에 요소를 삽입하고, 기존 요소들은 한 칸 씩 뒤로 밀림 |
| 수정        |변수명.set( index, 요소값 )| 지정한 index를 새로운 요소값으로 수정                                         |
| 리스트 크기 반환 |변수명.size( )|                                          |
| 특정 요소 반환  |변수명.get( index );|                                          |
| 삭제        |변수명.remove( index );|                                          |

## 4. 리스트와 반복문
---
#### 1) 일반 반복문
for (int i = 0 ; i < 변수명.size() ; i++) {
변수명.get(i);
}
#### 2) 향상된 for
for ( 타입명 변수명 : 리스트변수명 ){
변수명;
}

# Java_14_상속

## 1. 상속
---

### 1) 정의
부모 클래스로 부터 하위 클래스에게 멤버변수, 메소드를 물려주는 행위
### 2) 목적
한 번 만든 클래스 재사용·활용을 위하여
### 3) 키워드 
extends (확장·연장)
### 4) 특징
- 하위클래스가 객체(인스턴스)를 생성하면 상위 클래스도 객체(인스턴)가 생성됨
- 유지보수가 편리
- 계층 표현이 가능
- 재사용
- ☆★ **다형성** ☆★
  - 하위클래스/타입에서 상위클래스/타입으로 자동 타입 변환이 가능함
  - 상위클래스/타입에서 하위클래스/타입으로 강제 타입 변환이 가능함
### 5) 사용법
`class 하위클래스 extends 상위클래스{ }`
### 6) 주의
- 상위 클래스는 1개만 존재할 수 있음
- 하위 클래스가 상위 클래스를 선택
### 7) 활용
- 웹/앱 라이브러리
- 클래스 간의 멤버변수 중복 시, (클래스 설계에서 미리 잡아두는게 좋음)

## 2. 예시
#### [문제 1] 기본 상속
1) name(문자열) 멤버 변수를 가진 Person 클래스를 만드세요.
2) Person 클래스를 상속받는 Student 클래스를 만드세요. Student 클래스에는 studentId(정수) 멤버 변수를 추가하세요.
3) main 함수에서 Student 객체를 생성하고, 상속받은 name과 자신의 studentId에 값을 저장한 뒤 모두 출력하세요.

---
```java
class Person {
    String name;
}

class Student extends Person {
    int studentID;
}
public class Practice {
    public static void main(String[] args) {
        Student student = new Student();
        student.name = "홍길동";
        student.studentID = 10001;
        System.out.println("이름 : " + student.name + " 학번 : " + student.studentID);
    }
}
```
#### [문제 2] 메소드 오버라이딩 (Method Overriding)
1) "동물이 소리를 냅니다."를 출력하는 makeSound() 메소드를 가진 Animal 클래스를 만드세요.
2) Animal을 상속받고, makeSound() 메소드를 재정의하여 "고양이가 야옹하고 웁니다."를 출력하는 Cat 클래스를 만드세요.
3) main 함수에서 Cat 객체를 생성하고 makeSound() 메소드를 호출하여, 재정의된 내용이 출력되는지 확인하세요.

```java
class Animal {
    void makeSound() {
        System.out.println("동물이 소리를 냅니다.");
    }
}

class Cat extends Animal {
    void makeSound() {
        System.out.println("고양이가 야옹하고 웁니다.");
    }
}

public class Practice {
    public static void main(String[] args) {

        Cat cat = new Cat();
        cat.makeSound();
    }
}
```
# Java_15_인터페이스

## 1. 인터페이스
---
### 1) 정의
서로 다른 시스템이나 장치 사이에서 정보를 주고 받는 접점·경계면
인터페이스로부터 클래스가 메소드를 물려받고 이를 구현하는 행위
### 2) 인터페이스 예시
키보드 : 게임 시 기능 / 문서작업 시 기능 등 프로그램은 다르지만 하나의 키보드로 조작 가능
리모콘 : 서로 다른 모델/제조사의 TV를 하나의 리모콘으로 조작 가능
키오스크 : 식당/편의점/병원 등 사용처는 다르지만 동일한 기계로 사용은 가능
### 3) 목적
서로 다른 장치 사이에, 동일한 목적을 달성하기 위해, 서로 다른 기능을 작동하게 하는 것 (호환성)
### 4) 특징
- 객채간의 교환성(호환성)을 높이고, 다형성을 구현
- 서로 다른 클래스들 사이에 중간 매개체 역할
- 인터페이스는 상수와 추상메소드를 갖는다.
- 구현클래스/타입에서 인터페이스 타입으로 변환 가능
### 5) 선언
(1) 선언할 패키지 우클릭 > new > java class > Interface
(2) 첫글자를 대문자로 하여 Interface 파일 생성
### 6) 인터페이스 타입의 멤버
※ 멤버변수, 생성자, 메소드 사용 불가능!!
(1) 상수
- 반드시 초기값이 필요
- 상수이므로 `public static final` 키워드가 필요하나 자동으로 포함되므로 생략 가능
(2) 추상메소드
- 실행문`{}`이 없는 메소드
- `abstract` 키워드가 필요하나 자동으로 포함되므로 생략 가능
- 추상메소드의 실행문은 implements·구현 class 에서 작성
(3) 확인 방법
- `객체 instanceof 타입` >> boolean으로 결과 반환

### 7) 구현 객체 (추상메소드 구현을 위한 class)
`class 구현클래스 implements 인터페이스1, 인터페이스2{ }`

### 8) 익명 구현체
- 이름이 없는 구현체
- Class 없이 객체 만들기
- 타입 변수 = new 인터페이스(){};  // 객체 선언과 동시에 구현부를 작성
- 저장이 필요없는·간단한·일회성 인터페이스 생성시 사용

## 2. 예시
---
#### [문제 1] 기본 인터페이스와 구현
1) "소리를 냅니다."라는 추상 메소드 makeSound()를 가진 Soundable 인터페이스를 정의하세요.
2) Soundable 인터페이스를 구현(implements)하는 Cat 클래스와 Dog 클래스를 만드세요.
3) 각 클래스에서 makeSound() 메소드를 오버라이딩하여, 각각 "야옹", "멍멍"을 출력하도록 구현하세요.
4) main 함수에서 Cat 객체와 Dog 객체를 생성하고, 각 객체의 makeSound() 메소드를 호출하여 결과를 확인하세요.


```java
// 인터페이스 선언
interface Soundable {
    void makeSound();		//실행문이 없는 추상메소드 makeSound()선언
}

// Soundable 인터페이스 구현을 위한 Cat class
class Cat implements Soundable {
    public void makeSound() {			//makeSound() 메소드 구현 
        System.out.println("야옹");
    }
}

// Soundable 인터페이스 구현을 위한 Dog class
class Dog implements Soundable {
    public void makeSound() {			//makeSound() 메소드 overriding
        System.out.println("멍멍");
    }
}

public class Practice {
    public static void main(String[] args) {

        Cat cat = new Cat();
        Dog dog = new Dog();
        cat.makeSound();			// 출력 : 야옹
        dog.makeSound();			// 출력 : 멍멍

    }
}
```
#### [문제 2] 인터페이스 상수
1) RemoteControl 인터페이스를 만드세요.
2) 이 인터페이스 안에, public static final로 최대 볼륨 MAX_VOLUME = 10과 최소 볼륨 MIN_VOLUME = 0 상수를 정의하세요.
3) main 함수에서 객체를 생성하지 않고, RemoteControl.MAX_VOLUME과 같이 인터페이스 이름으로 직접 접근하여 두 상수를 출력하세요.

```java
// RemoteControl 인터페이스 선언
interface RemoteControl {
    // 멤버변수
    // interface의 멤버변수는 `public static final`이 자동이므로 생략 가능
    int MAX_VOLUME = 10;
    int MIN_VOLUME = 0;
}

public class Practice {
    public static void main(String[] args) {
        System.out.println(RemoteControl.MAX_VOLUME);		// 출력 : 10 
        System.out.println(RemoteControl.MIN_VOLUME);		// 출력 : 0

        // RemotoeControl은 [인터페이스이]므로 
        // `RemotoeControl 변수 = new RemotoeControl()`와 같이 인스턴스 불가!!
        // `타입.메소드();`와 같이 바로 메소드 실행은 가능!!
    }
}
```

#### [문제 3] 다중 인터페이스 구현
1) "하늘을 납니다."를 출력하는 fly() 추상 메소드를 가진 Flyable 인터페이스를 만드세요.
2) "물에서 헤엄칩니다."를 출력하는 swimmable() 추상 메소드를 가진 Swimmable 인터페이스를 만드세요.
3) Duck 클래스가 Flyable과 Swimmable 두 인터페이스를 모두 구현하도록 작성하세요.
4) main 함수에서 Duck 객체를 생성하고, fly()와 swimmable() 메소드를 모두 호출하여 결과를 확인하세요.

```java
// Flyable 인터페이스 선언
interface Flyable {
    // fly() 추상 메소드 선언
    void fly();
}

// Swimmalbe 인터페이스 선언
interface Swimmalbe {
    void swimmable();
}

// 상기의 두 인터페이스를 구현하는 Duck class
class Duck implements Flyable, Swimmalbe {
    // Flyable 인터페이스의 fly() 메소드를 overriding
    public void fly() {
        System.out.println("하늘을 납니다.");
    }

    // Swimmalbe 인터페이스의 swimmable() 메소드를 overriding
    public void swimmable() {
        System.out.println("물에서 헤엄칩니다.");
    }
}


public class Practice {
    public static void main(String[] args) {
        Duck duck = new Duck();
        duck.fly();
        duck.swimmable();
    }
}
```
#### [문제 4] 익명 구현 객체
1) "환영합니다."를 출력하는 welcome() 추상 메소드를 가진 Greeting 인터페이스를 만드세요.
2) main 함수에서, 별도의 클래스 파일을 만들지 않고, Greeting 인터페이스 타입의 변수를 선언하면서 익명 구현 객체를 생성하여 welcome() 메소드를 즉석에서 구현하고 호출하세요.
예] Greeting g = new Greeting() { ... };

```java
interface Greeting{
    void welcome();
}
public class Practice {
    public static void main(String[] args) {

        Greeting greeting = new Greeting() {
            public void welcome() {
                System.out.println("환영합니다.");
            }
        };
        greeting.welcome();
    }
}
```


## 3. 상속 vs 구현
----
||상속|VS| 구현(인터페이스)  |
|--|--|--|------------|
|키워드|extends||Implements|
|객체생성|O||X|
|상위|하나의 상위클래스||다수의 인터페이스|
|메소드|**선택적 오버라이딩**  ||**필수적 오버라이딩**|
|멤버|멤버변수, 생성자, 메소드 ||상수, 추상메소드|

---


# Java_16_다형성
## 1. 다형성
---
### 1) 다형성이란?
- 다영한 형태/타입을 같는 성질
- 상속과 인터페이스와 관련
- 오버라이딩 : 상수 또는 인터페이스에서 물려받은 메소드를 재구현(상속) 또는 구현(인터페이스)하는 행위
    - 타입 간의 중복된 메소드가 있을 경우, 오버라이딩된 메소드가 우선 실행


### 2) 자동(묵시적) 타입변환
#### (1) 기본타입
byte > short > int > long > float > double

#### (2) 참조타입
하위클래스 타입 > 상위클래스 타입
`class 하위 extents 상위` 상속 관계일 때 만, 가능

### 3) 강제(명시적) 타입변환
#### (1) 기본타입
double > float > long > int > short > byte

#### (2) 참조타입
상위클래스 타입 > 하위클래스 타입
단, 이전에 **하위>상위 변환**이 있었던 객체에 한해서만 가능

```
하위 obj1 = new 하위();     // 최초 타입 : 하위
상위 obj2 = obj1;           // 상속에 따라 하위 >> 상위
하위 obj3 = (하위)obj2;     // 최초 타입과 일치한다면, 상위>>하위로 강제 타입 변환
```

## 2. 예제

```java

// [1] 동물 class 생성
class 동물{
    // 멤버변수
    String name;

    // 메소드
    void show(){
        System.out.println("내 이름은 " + name);
    }
}
// [2] 조류 class 생성 - 동물 class 상속
class 조류 extends 동물{

}

// [3] 참새 class 생성 - 조류 class 상속
class 참새 extends 조류{

}

// [4] 닭 class 생성 - 조류 class 상속
class 닭 extends 조류{

}

public class Practice {
    public static void main(String[] args) {
    // (1) 참새(객체)의 형식/타입/클래스 >> 조류로 변경
        조류 bird2 = sparrow; // 객체가 바뀌는 것이 아니라!! 타입만 바뀌는 것!!

        // (2) 참새 >> 동물
        동물 amimal2 = sparrow;

        // (3) 동물 >> 참새 : 불가능
        // 참새 sparrow2 = animal; Error 발생!
        // 조류 bird3 = animal;    Error 발생!

        // ※ 상위 타입에서 하위타입 변경 가능 조건!!
        // 객체의 최초 타입이 하위이면서, 상위 타입을 거치고 돌아올 경우만 가능

        닭 obj1 = new 닭();     // 최초 타입 : 닭
        동물 obj2 = obj1;       // 상속에 따라 동물 타입 가능
        닭 obj3 = (닭)obj2;     // 최초 타입과 일치한다면 강제 타입 변환

        // ※ 형제 관계에서는 타입변환 불가
    }
}
```

---

# Java_17_예외·Exception

## 1. 예외처리 
---
### 1) 예외
   - 개발자가 구현한 로직이나 사용자 영향으로 발생한 문제
※ 시스템 오류
   - 시스템이 종료되는 심각한 수준의 문제

### 2) 예외의 종류

#### (1) 일반 예외
- 컴파일(실행)될 때, 예외 처리 코드 여부 검사, 즉 인위적으로 발생시킨 예외
- 입출력, 네트워크, 파일, JBDC, 등 외부와 연동 시, 주로 사용
- ex)
  - Class.forName( 클래스경로 );    : 해당 경로의 클래스 유무를 확인하는 함수
  - Thread.sleep( 미리초 );        : 1000 미리초(1초)간 thread가 sleep(정지)

#### (2) 실행 예외
- 컴파일(실행)될 때, 예외 처리 코드 여부 검사를 하지 않고 발생하는 예외
- 개발자의 경험 의존도가 높음
### 3) 특징
- 예외 발생 시, 예외 발생 멘트와 함께 시스템이 중지됨
- 실행 예외처리를 통해, 예외 발생 시 예외를 고치는 것이 아닌 흐름을 제어
- 프로그램의 24시간 중단 없이 실행하기 위한 안전한 로직 구현을 위해 사용
### 4) 예외 클래스
Exception : 모든 예외들의 상위 클래스(SuperClass)
ClassNotFoundException : 클래스를 찾지 못하였을 때, 예외 발생 정보를 저장하는 클래스
InterruptedException : 흐름이 중단되었을 때, 예외 발생 정보를 저장하는 클래스
NullPointerException : 실제 값이 아닌 null을 가지고 있는 객체/변수를 호출할 때 발생
NumberFormatException : 숫자가 아닌 리터럴을 숫자로 변환할 경우 발생
ArrayIndexOutOfBoundsException : 정해진 배열의 크기보다 크거나 음수 index에 대한 요청
InputMismatchException : input의 타입이 일치하지 않을 때

### 5) 사용법
```java
   try { 
        '예외가 발생할 것 같은 코드 or 일반예외'
    } catch( 예외클래스명 매개변수명 ){ 
        `예외발생시 실행문` 
    } catch(){
    } finally{'예외 유무와 상관없이 무조건 실행'}
```
```java
public class Practice {
    public static void main(String[] args) {
        // [1] 일반 예외
        // 예외 유무와 상관없이 무조건 예외처리를 하는 인위적으로 예외를 발생시킴
        try {
            Class.forName("java.lang.String");
            //Class.forName( 클래스경로 );   : 해당 경로의 클래스를 읽어오는 함수
            // String Class가 존재함 >> 밑의 catch 까지 실행하지 않음
        } catch (ClassNotFoundException e) {
            // catch( 예외클래스면 매개변수명 ) // 예외발생 시 처리를 위한 코드
            System.out.println("[예외발생] String 클래스가 없습니다." + e);
        }

        // [2] 일반예외, 예외 발생
        try {
            Class.forName("java.lang.String2");
            // String2 Class는 존재하지 않음
        } catch (ClassNotFoundException e) {
            System.out.println("[예외발생] String2 클래스가 없습니다." + e);
            // String2 Class가 없으므로 >> catch 실행
        }
    }
}
```

## 2. 예외 던지기
---

예외 발생 시, 메소드를 호출한 곳으로 예외를 전달(return)
한 곳에서 예외처리를 하기 위해 메소드 내부에서 발생한 예외를 다른 곳으로 이동·전달·리턴할 수 있음
```java

public class Practice {
    //(1) 예외가 발생하는 메소드 생성
    // (3) 예외 발생시 예외 던지기(throws)
    // 메소드명() throws 예외클래스명{}

    // 일반예외 클래스는 주로 throws 예외 코드가 존재
    // 실행예외 클래스들은 주로 throws 예외 코드가 없음
    public static void method1() throws NullPointerException{
        String str = null;
        System.out.println(str.length());       // 예외 발생이 예측됨
    }

    public static void method2() throws ClassNotFoundException {
        Class.forName("com.sql.jdbc"); //클래스가 있는지 없는지 모름, 일반예외
    }

    public static void main(String[] args) {
        try {
            //(2) 예외 메소드 실행
            method1();
        } catch ( NullPointerException e) {
            System.out.println("[method1의 예외 발행]" + e );
        }

        try {
            method2();
        } catch (ClassNotFoundException e){
            System.out.println("[method2의 예외발생]" + e);
        }
    }
}
```


---

# Java_18_파일 입·출력, OpenCSV 라이브러리

## 1. 파일 입·출력 클래스
---
※ 파일 입출력 클래스 사용시 반드시 try-catch 예외처리 필요!
- Java에서 작성한 String, int 등을 파일로 저장하기 위해서는, 해당 내용을 byte로 바꿔야함.
- 또한 파일에 저장된 byte를 java로 불러일으킬 때, 또 다시 번역이 필요함

### 1) FileOutputStream class
- 쓰기·출력·내보내기(Java > web, local file)
#### (1) .write( 바이트배열 )
- 바이트 배열을 지정된 파일에 작성하는 함수
#### (2) 문자열.getBytes()
- 문자열을 바이트 배열로 반환하는 함수

```java
public class Practice {
    public static void main(String[] args) {
        // [1] 파일 쓰기
        // [1.1] 파일 경로
        String path = "./src/test1.txt"; //파일의 위치, 절대경로 or 상대경로
        
        // [1.3] 예외처리 (FileNotFoundException)
        try {
            // [1.2] 파일 출력 FileOutputStream 객체 생성
            // - FileOutputStream >> 무조건 일반예외 경고 발생함
            FileOutputStream fout = new FileOutputStream(path);
            
            //[1.4] 파일에 쓰기 .write(바이트 데이터)
            //[1.5] 문자열의 바이트로 변환 : "문자열".getBytes() >> 무조건 일반예외 발생
            fout.write("자바에서 작성한 텍스트입니다.".getBytes());
        } catch (FileNotFoundException e) {
            System.out.println("파일 또는 경로가 존재하지 않습니다." + e );
        } catch (IOException e) {
            System.out.println("입출력 도중에 오류가 발생합니다." + e );
        }
    }
}

// 결과 
// 위치 : ./src
// 파일명 : test1.txt
// 내용 : 자바에서 작성한 텍스트입니다.
```

### 2) FileInputStream
- 읽기·입력·가져오기(web, local file > Java)
#### (1) .read( 바이트배열 )
- 바이트 배열에서 읽어온 파일들을 저장하는 함수
#### (2) new String(바이트 배열)
- 바이트 배열을 문자열로 반환하는 함수

```java
public class Practice {
    public static void main(String[] args) {
        // [2] 파일 읽기
        // [2.1] 경로 선언
        String path = "./src/test1.txt";
        
        // [2.2] 파일 입력 FileInputStream 객체를 생성
        // FileInputStream >> 무조건 예외 발생
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
    }
}

// 결과 
// console : 자바에서 작성한 텍스트입니다.
```

## 2.OpenCSV 라이브러리
---
자바에서 CSV 파일 읽기·쓰기를 편하게 해주는 API들을 제공하는 라이브러리

### 1) 라이브러리 등록 방법
- jar 파일을 원하는 package로 이동 > 우클릭 > add as library

### 2) OpenCSV· 관련 객체와 함수
#### (1) new CSVReader( new FileReader( 경로 ) ) 
CSV를 입력하는 클래스
#### (2) new CSVWriter( new FileWriter( 경로 ) ) 
CSV 출력하는 클래스

### 3) 파일 In·Out 관련 객체와 함수
#### (1) new FileReader( 경로, Charset.forName(인코딩))
경로로부터 파일을 읽어오고, 언어에 따라서 인코딩 언어를 설정할 수 있음
#### (2) .writeAll( List객체 )
List 객체를 CSV로 내보내는 함수
#### (3) .readAll()
List<String[]> 타입으로 반환하는 함수
```java

public class Practice {
    public static void main(String[] args) {
        try {
            // [1] OpenCSV 라이브러리 사용해보기
            // [1.1] 파일 경로 지정
            String path = "src/업소List.csv";

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
```
---

# Java_19_JDBC(Java DataBase Connect)

## 1. JDBC
---
자바와 DB를 연결해주는 라이브러리

### 1) 라이브러리 준비
- JDBC MySQL (https://dev.mysql.com/downloads/connector/j/)
    → Platform Independent (Architecture Independent)
    → ZIP Archive
    → mysql-connector-j-9.3.0.jar
    → 프로젝트 내 패키지로 이동 후 라이브러리 설치
### 2) 연동코드
MVC 패턴에서 DB와 연결을 담당하는 Dao 클래스에 DB 연동을 위한 코드를 작성

```java
public class Dao {
    // [1] 싱글톤 선언 =====================================================
    private Dao() {
        // [] Dao 객체 생성과 동시에 DB 연동 시작을 위한 메소드 실행
        connectDB(); 
    }
    private static final Dao instance = new Dao();
    public static Dao getInstance() { return instance; }

    // [2] DB 연동에 필요한 정보 작성 ========================================
    // [2.1] DB연동 경로와 DB명을 선언
    // 외부 DB 이용 시 [ 경로(localhost) : 포트(3306) / DB명칭 ] 작성
    private String db_url = "jdbc:mysql://localhost:3306/DBName";
    // [2.2] db user name 작성
    private String db_user = "root";
    // [2.3] db user password 작성
    private String db_pw = "1234";

    // DB연동 결과를 저장하기 위한 인터페이스
    // 자세한 설명은 하단 참고
    Connection conn;    

    // [3] DB 연동 함수 ================================================
    public void connectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // [3.1] DB 연동 클래스(구현체) DriverManager
            // [3.2] DB 연동 함수 : .getConnection( 주소 , 계정 , 비밀번호)
            conn = DriverManager.getConnection(db_url, db_user, db_pw);
        } catch (ClassNotFoundException e) {
            System.out.println("[경고] MySQL 드라이버 로드 실패 "+e);
        } catch (SQLException e) {
            System.out.println("[경고] DB 연동 실패 " + e);
        }
    } // func end
} // class end
```

### 3) 핵심 인터페이스
#### (1) Connection, DB 연동
① Connection  
- DB 연동 후 연동 결과를 보관하는 인터페이스
② DriverManager
- DB 연동 클래스(구현체) DriverManager
③ .getConnection(db_url, db_user, db_pw)
- DB 연동 함수 : .getConnection( 주소 , 계정 , 비밀번호)
④ PreparedStatement ps = conn.prepareStatement(sql);
- 기재된 상태의 인터페이스 변수명 = DB연동.기재함수(SQL문법);
- String sql = "insert into tb명( 속성1, 속성2 ) values( ? , ? )";

#### (2) PreparedStatement, SQL 조작
① .execute();
- 실행 함수
② .executeQuery();
- Select 문법 실행 결과를 **ResultSet** 타입으로 반환
③ .executeUpdate();
- insert, update, delete 문법 실행 결과, sql 성공 레코드 수를 int 타입으로 변환
④ .set타입(?번째, 변수);
- ?번째에 변수 값을 대입하는 함수
- executeUpdate 이전에 실행하여 sql 문을 작성하는 역할

#### (3) ResultSet, SQL 실행 조작
① rs.next();
- 조회된 레코드 중에서 다음 레코드 이동 함수
② rs.get타입("속성명" or colNo);
- 현재 레코드에서 지정한 속성명의 값 반환 함수

```java

public class Dao {
    // 1) User 테이블 insert : SQL 고정
    public boolean userInsert() {
        // SQL 작성
        String sql = "insert into user( uname, uage ) values('유재석',40 )";
        try {
            // SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // SQL 실행
            int count = ps.executeUpdate(); // SQL 실행 결과 insert 레코드 수를 int로 반환
            // SQL 결과 확인
            System.out.println(count);
            return true;
        } catch (SQLException e) {
            System.out.println("[경고] 예외발생 " + e);
        }
        return false;
    } // func end

    // 2) User 테이블 insert : 매개변수 활용
    public boolean userInsert2(String uname, int uage) {
        try {
            // SQL 작성
            String sql = "insert into user( uname, uage ) values( ? , ? )";
            // SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // SQL에 매개변수 대입하기!! ☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
            // ps.set타입( ?순서, 변수)
            ps.setString(1, uname);
            ps.setInt(2, uage);
            // SQL 실행
            int count = ps.executeUpdate();
            // SQL 결과 확인
            if (count >= 1) return true;
            return false;
        } catch (SQLException e) {
            System.out.println("[예외발생] " + e);
        }
        return false;
    } // func end

    // 3) Select
    // User table 을 select
    public void userSelect() {
        try {
            // SQL 작성
            String sql = "select * from user;";
            // SQL 기재
            PreparedStatement ps = conn.prepareStatement(sql);
            // SQL 매개변수 대입 >> 없으므로 생략
            // SQL 실행 ☆★☆★☆★☆★☆★☆★☆★
            // select >> .executeQuery() >> ResultSet 타입
            ResultSet rs = ps.executeQuery();       // 조회결과 조작 인터페이스, [import java.sql] 주의!!
            // SQL 결과 확인
//            int rowNo = 0;

//            while (rs.next()){                      // rs.next() : 다음 레코드로 이동하는 함수
//                System.out.println(rowNo++);
//                System.out.print(rs.getInt("uno") + "\t");
//                System.out.print(rs.getString("uname") + "\t");
//                System.out.println(rs.getInt("uage"));
//            }
            while (rs.next()){
                System.out.printf("번호 : %d \t 이름 : %s \t 나이 : %d \n",rs.getInt(1),rs.getString(2), rs.getInt(3));
            }
        } catch (Exception e) {
            System.out.println("[예외발생] " + e);
        }
    } //func end
} // class end
```


# Java_20_Java 기본 클래스

## 1. Object 클래스
---
- 모든 클래스의 최상위 클래스 (모든 클래스와 상속)
- 다형성에 따라, 모든 자료를 Object 타입으로 분류 가능

### 1) 주요 메소드
#### (1) .toString()
- 객체의 주소를 반환
- 주로 class에서 override 하여 값이 문자열로 출력하도록 함

#### (2) .equals()
- 두 객체 내의 값을 비교하여 그 결과를 반환하는 함수

#### (3) .hashCode()
- 객체를 정수로 반환
```java

public class Practice {
    public static void main(String[] args) {
        // [1] Object
        // [1.1] Object의 다향성·타입변환
        Object o1 = 3;                  // 정수를 Object 타입으로 분류 가능
        Object o2 = 3.14;               // 실수를 Object 타입으로 분류 가능
        Object o3 = true;               // 논리를 Object 타입으로 분류 가능
        Object o4 = "유재석";            // 문자열을 Object 타입으로 분류 가능
        Object o5 = new Object();       // 객체를 Object 타입으로 분류 가능
        Object o6 = new int[]{1, 2, 3};   // 배열을 Object 타입으로 분류 가능

        // [1.2] Object의 주요 메소드
        Object o7 = new BookDto();

        // [1.2.1] toString() : 인스턴스·자료의 주소·메모리 위치를 반환
        System.out.println(o7.toString()); // 생략 가능
        System.out.println(o7);
        // daily.day20_250725.BookDto@7cca494b

        // BoardDto Class에서 override하여 문자열로 출력
        Object o8 = new BoardDto();
        System.out.println(o8.toString());  // BoardDto{}

        // [1.2.2] == VS .equals()
        // == : 인스턴스의 주소를 비교
        // .equals() : 인스턴스의 값을 비교

        Object o9 = new BookDto();
        Object o10 = new BookDto();
        System.out.println(o9 == o10); // false
        // 이 경우 타입은 같지만, 객체가 같은지를 판단!
        // o9와 o10는 서로 다른 메모리에 저장된 객체, 즉 서로 다른 주소를 갖음
        System.out.println(o9.equals(o10)); // false

        Object o11 = o9;
        System.out.println(o11 == o9); // true
        System.out.println(o11.equals(o9)); // true

        String str1 = new String("유재석");
        String str2 = new String("유재석");
        System.out.println(str1 == str2);       // false
        System.out.println(str1.equals(str2));  // true

        // [1.2.3] .hashCode() : 객체를 정수값으로 반환
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(o9.hashCode());
        System.out.println(o10.hashCode());
        System.out.println(o11.hashCode());
    }
}
```
## 2. Class 클래스
---
- 클래스의 정보를 담는 Class
- 리플렉션 : 실행 중 객체할당(동적할당), 멤버 분석 시

### 1) 주요 메소드
#### (1) class.forname("Class경로")
* 지정한 경로에서 클래스를 로드하는 함수
* 주로 외부 라이브러리 사용 시 이용
* 예외처리 필수 : 클래스 로딩 성공 / 실패(예외 발생)
#### (2) .getField()
* 클래스의 모든 멤버변수명을 배열로 반환
#### (3) .getConstructors()
* 클래스의 모든 생성자를 배열로 반환
#### (4) .getMethods()
* 클래스의 모든 메소드를 배열로 반환
```java

public class Practice {
    public static void main(String[] args) {
        // [2] Class
        String str = new String();
        Class c = str.getClass();
        System.out.println(c); // class java.lang.String  Class의 타입 정보를 반환

        Integer value = 3;
        System.out.println(value.getClass()); // class java.lang.Integer

        // [2.1] 주요 메소드

        // [2.1.1] class.forname("Class경로")
        // 지정한 경로에서 클래스를 로드하는 함수 
        // 주로 외부 라이브러리 사용 시 이용
        // 예외처리 필수 : 클래스 로딩 성공 / 실패(예외 발생)
        try {
            Class.forName(" class java.lang.String");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        // [2.2.2] .getField()
        // 클래스의 모든 멤버변수명을 배열로 반환
        Field[] fields = c.getFields();
        for(int i = 0 ; i < fields.length ; i ++ ){
            System.out.println(fields[i]);
        }

        // [2.2.3] .getConstructors()
        // 클래스의 모든 생성자를 배열로 반환
        Constructor[] constructors = c.getConstructors();
        for(int i = 0 ; i < constructors.length ; i ++){
            System.out.println(constructors[i]);
        }

        // [2.2.4] .getMethods()
        Method[] methods = c.getMethods();
        for(int i = 0 ; i < methods.length ; i++) {
            System.out.println(methods[i]);
        }
    }
}
```
## 3. Wrapper 클래스
---
- 기본타입 8개를 참조 타입으로 사용하기 위해 이용
- 기본타입은 메소드(기능)이 없으므로 Wrapper를 통해 메소드를 제공받음

### 1) 종류
Byte Short Integer Long Boolean Float Double

### 2) 주요 메소드
#### (1) .parse타입("문자열");
* 문자열 > 기본타입 변환
* 문자열을 parse뒤의 타입으로 변환
#### (2) String.valueOf( 자료값 )
* 자료의 타입을 문자열로 변환
```java

public class Practice {
    public static void main(String[] args) {
        // [3] Wrapper
        int value1 = 100;       // 타입 : int
        Integer value2 = 100;   // 타입 : Integer

        // [3.1] autoboxing VS unboxing

        Integer value3 = value1;
        // autoboxing : int(기본) > Integer(클래스) : 자동 타입 변환
        int value4 = value2;
        // unboxing : Integer(클래스) > int(기본) :
        // 클래스에서 기본타입으로 내려가는 것임에도 자동 타입 변환을 지원

        // [3.2] 문자열 > 기본타입 변환
        int val1 = Integer.parseInt("100");    // 문자 "100" > 숫자 100
        double val2 = Double.parseDouble("3.14"); // 문자 "3.14" > 실수 3.14
        float val3 = Float.parseFloat("3.14");   // 문자 "3.14" > 실수 3.14
        byte val4 = Byte.parseByte("100");
        short val5 = Short.parseShort("100");
        long val6 = Long.parseLong("100");
        boolean val7 = Boolean.parseBoolean("false");

        // [3.3] 기본타입 > 문자열 변환

        String s1 = 100 +"";
        // 100 + "" = 자료 + 문자열 = 문자열

        String s2 = String.valueOf(100);
    }
}
```
## 4. LocalDate 클래스
---
- 시스템의 날짜/시간 정보 클래스
### 1) 주요 메소드

#### (1) LocalDateTime.now()
* yyyy-MM-ddThh:mm:ss.000000 (nano-sec) 형태로 출력
* 타입 LocalDateTime
#### (2) LocalDateTime.of(년,월,일,시,분,초)
* 지정한 날짜 형태로 반환
* 타입 LocalDateTime

#### (3) 날짜 형식 지정
- DateTimeFormatter 포멧변수명 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
  * y 연 / M 월 / d 일 / h 시 / m 분 / s 초
- localDateTime.format(포멧변수명);
  * 지정한 포멧으로 날짜·시간을 String 타입으로 반환

- 날짜·시간 객체 내에서 원하는 부분만 int 타입으로 반환
    - .getYear();
    - .getMonthValue();
    - .getDayOfMonth();
    - .getHour();
    - .getMinute();
    - .getSecond();

- 날짜 계산 (반환 타입 LocalDateTime)
    - .plusDays(x);
        * x일 이후 날짜
    - .minusDays(x);
        * x일 이전 날짜
```java

public class Practice {
    public static void main(String[] args) {
// [4] LocalDate 클래스

        // [4.1] 현재 날짜·시간
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);  //2025-07-25

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);  // 11:36:23.209480800 (nano-sec)

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime); // 2025-07-25T11:37:19.188031


        // [4.2] 지정한 날짜/시간

        // [4.2.1] 날짜 시간 (연,월,일,시,분.초)
        LocalDateTime.of(2025,07,25,11,33,15);

        // [4.3] 날짜·시간 형식 변경
        //  y 연 / M 월 / d 일 / h 시 / m 분 / s 초
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 hh:mm:ss");
        String today = localDateTime.format(formatter);
        System.out.println(today); // 2025년 07월 25일 11:43:08

        // [4.4] 날짜 세부 정보
        int year = localDateTime.getYear();
        int month = localDateTime.getMonthValue();
        int day = localDateTime.getDayOfMonth();
        int hour = localDateTime.getHour();
        int min = localDateTime.getMinute();
        int sec = localDateTime.getSecond();

        // [4.5] 날짜 계산

        // 10일 이후의 날짜
        LocalDateTime plusDays = localDateTime.plusDays(10);
        System.out.println(plusDays); // 2025-08-04T11:48:16.075785900

        // -5일 이전의 날짜
        LocalDateTime preDays = localDateTime.minusDays(5);
        System.out.println(preDays); //2025-07-20T11:49:34.710516600
    }
}
```
---

# Java_21_스레드(Thread)
## 1. 스레드 Thread
---
### 1) 정의
- 하나의 프로세스 내에서 실행되는 작업의 단위 ≒ 실행 흐름의 단위

### 2) 목적
- 스레드를 통해 코드(명령어)를 읽어 CPU가 명령어를 처리하도록 함

### 3) 자바에서의 스레드
#### (1) main method
- public static void main( String[] args ){} >> main thread를 내장하고 있음

### 4) 사용법
#### (1) main thread·method 선언
- 자바 프로그램은 항상 main thread·method로부터 실행 흐름이 시작됨

```java
public class Practice {
    public static void main(String[] args) {
        Toolkit toolkit = Toolkit.getDefaultToolkit(); // Java UI

        // [1] 싱글·단일 스레드
        System.out.println("[1] main thread가 읽어내는 코드");

        for (int i = 1; i <= 5; i++) {
            System.out.println("[1] main thread가 읽어내는 코드" + i);
        }

        for (int i = 1; i <= 5; i++) {
//            System.out.println("[1] Beep sound");
            toolkit.beep(); // beep sound 출력 함수
            try {
                Thread.sleep(1000);             // Thread.sleep = milli sec 만큰 처리·Thread를 지연시킴
            } catch (InterruptedException e) {
                System.out.println("[예외발생] [1] " + e);
            }
        }
    } // main end
} // class end
```

## 2. 멀티스레드 Multi Thread
---
### 1) 정의
main 스레드 외 새로운 작업 스레드를 생성하여 동시 작업
### 2) 목적
- 병렬 처리 = 동시에 여러 작업을 수행하기 위해
### 3) 사용처
- Wep / App, 채팅 / 첨부파일 / JDBC, 동기화/비동기화 처리
### 4) 사용법
(1) 익명 구현체
(2) 구현체
(3) 상속
※ 상속은 클래스당 1번밖에 되지 않아서 사용성이 떨어짐

### 5) 주요 Class/Interface
#### (1) Thread Class
① .start()
- run 추상 메소드를 실행하는 메소드

#### (2) Runnable Interface
① run(){} 추상 메소드
- 작업 스레드가 실행되는 최초 시작점

```java
// [2.2] 구현체 =====================================================
class 작업스레드1 implements Runnable {
    @Override
    public void run() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for (int i = 1; i <= 5; i++) {
            toolkit.beep();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("[예외발생] [2.1.2] " + e);
            }
        }
    } // run end
} // class end

// [2.3] 상속 =====================================================
class 작업스레드2 extends Thread {
    Toolkit toolkit = Toolkit.getDefaultToolkit();

    public void run() {
        for (int i = 1; i <= 5; i++) {
            toolkit.beep();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("[예외발생] [2.1.2] " + e);
            }
        }
    } // func end
    // Runnable 없이 run()에 바로 override 함
} // class end

public class Practice {
    public static void main(String[] args) {
        // [2] 멀티 스레드
        // [2.1] 익명 구현체 : 인터페이스 타입을 Class 없이 main Thread 안에서 직접 구현하는 것

        // [2.1.2] 소리 5번 코드
        // new 인터페이스Type(){ 구현 }
        Runnable runnable1 = new Runnable() {
            // Run 추상 매소드 구현
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    toolkit.beep();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("[예외발생] [2.1.2] " + e);
                    }
                }
            }
        }; // new Runnable() end

        // run 메소드를 구현한 > Runnable 인테페이스 > Thread 생성자에 대입
        Thread thread1 = new Thread(runnable1);
        thread1.start();

        // [2.1.1] 출력 5번 코드
        for (int i = 1; i <= 5; i++) {
            System.out.println("[1] main thread가 읽어내는 코드" + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("[예외발생] [2.1.1] " + e);
            }
        }

        // [2.2] 구현체
        // [2.2.1] 구현체 스레드 (작업스레드1 구현체 class 참고하기!)
        작업스레드1 작업스레드1 = new 작업스레드1(); // 구현체
        Thread thread2 = new Thread(작업스레드1); // 구현체 '작업스레드1'을 Thread 타입의 thread2 변수에 대입
        thread2.start();                        // Thread 실행 함수 .start()

        // [2.2.2] 출력 5번
        for (int i = 1; i <= 5; i++) {
            System.out.println("[1] main thread가 읽어내는 코드" + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("[예외발생] [2.1.1] " + e);
            }
        }

        // [2.3] 상속
        // [2.3.1] 상속class
        작업스레드2 thread3 = new 작업스레드2();
        thread3.start();


        // [2.3.2] 출력 5번
        for (int i = 1; i <= 5; i++) {
            System.out.println("[1] main thread가 읽어내는 코드" + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("[예외발생] [2.1.1] " + e);
            }
        }
    }
}
```

## 3. 스레드풀
---
### 1) 정의
- 미리 일정 개수의 스레드를 생성하고 필요에 따라 재사용하는 방법

### 2) 목적
- 스레드의 재사용

### 3) 효과
- 자원 효율성, 과부하 방지 etc

### 4) 구조
- 작업 요청 [ 큐 ] 자료구조를 배치하여 순서대로 스레드풀에서 대기중인 스레드에게 작업 배정
> ※ 큐
> : 자료의 데이터들을 요청 순서대로 처리하는 방법

#### 5) 사용처
(1) 톰켓 (자바웹클래스)
(2) JDBC
(3) 업로드/다운로드
(4) 채팅

#### 6) 사용법
(1) 작업 스레드 배정

```java
public class Practice {
    public static void main(String[] args) {
        // (1) 작업 스레드 배정
        // Executor.newFixedThreadPool( 스레드풀에 저장할 스레드 수 );
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // (2) 반복문을 이용하여 각 스레드를 생성
        for(int i = 0 ; i < 3 ; i++){
            String name = "Thread" + i ;

            // (3) 스레드 생성 - 익명 구현체
            Runnable runnable = new Runnable(){
                @Override
                public void run() {
                    try{
                        Thread.sleep(2000);
                    } catch (Exception e ) {System.out.println("[예외발생] + e ");}
                    System.out.println("Task Thread ? ; "+ name);
                } //func end

            }; // 익명구현체 end

            // (4) 생성된 스레드를 스레드풀에 삽입
            executorService.submit( runnable );
        } // for end

        // (5) 스레드풀 종료
        executorService.shutdown();
    } //main end
} // class end
```


---

# Java_22_동기화·비동기화
## 1. 동기화
---

### 1) 정의
메소드를 lock 하여, 메소드를 점령함

### 2) 목적
여러 스레드가 동시에 하나의 스레드를 사용할 경우,
시간차에 의하여 멤버변수 충돌이 발생할 수 있음
이를 방지하기 위하여 동기화를 통해 메소드 lock이 필요

### 3) 비교
동기화 VS 비동기화

#### (1) 동기화

- 한 번에 하나의 스레드가 처리
- 처리 순서가 보장됨

#### (2) 비동기화

- 한 번에 여러 개의 스레드가 처리될 수 있음
- 처리 순서가 보장되지 않음

### 4) 사용법
##### (1) 메소드 선언부에 키워드 삽입 : synchronized
##### (2) synchronized(this){ } 블럭을 이용

※ 참고
두 개 이상의 스레드가 하나의 메소드를 호출할 때 비동기 처리 필요.

두 개 이상의 스래드가 하나의 메소드를 사용할 때,
순서대로 호출 > 처리가 필요 >>>> 동기화

```java
// (1) 유저 1 class ( 1작업 thread )
class User1 extends Thread {
    public Calculator calculator;

    @Override
    public void run() {
        calculator.setMemory(100);
    }
} // class end

// (2) 유저 2 class ( 2작업 thread )
class User2 extends Thread {
    public Calculator calculator;

    @Override
    public void run() {
        calculator.setMemory(200);
    }
} // class end

// (3) 계산기 클래스 / Object
class Calculator {
    // 멤버변수
    public int memory;

    // 메소드

    // synchronized ☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★☆★
    public synchronized void setMemory(int memory) {
        this.memory = memory;
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("[예외발생] + 3" + e);
        }
        System.out.println(this.memory);
    } // func end
} //class end

public class Practice {
    public static void main(String[] args) {
        // 1. 1개의 계산기 객체 만들기
        Calculator calculator = new Calculator();

        // 2. 1개의 계산기를 2개의 스레드에 대입
        User1 user1 = new User1();
        user1.calculator = calculator;

        User2 user2 = new User2();
        user2.calculator = calculator;

        // 두 개의 스레드는 동일한 계산기 객체를 가지고 있음

        // 3. 두 개의 스레드를 실행
        user1.start(); // 200 > synchronized > 100
        user2.start(); // 200 > synchronized > 200
    } //main end
} // class end
```


---

# Java_23_String 클래스
## 1. String 클래스
---
- 컴퓨터는 문자 1글자에 대한 정의는 있지만, 문자열에 대해서는 정의되지 않음
- 문자 번역 : 바이트 <-- 번역 --> 문자

> 1. 아스키코드
> : 7비트, 128문자 표현 규칙, 영문, 숫자, 특수문자
> 2. 유니코드
> : 전 세계 공용어, Java에서 사용

### 1) 문자열 사용하는 방법
(1) "문자열"                : 큰 따옴표("")안에 문자열 표현
(2) new String("문자열")    : 생성자를 이용한 문자열 표현
### 2) 문자열 비교 방법
(1) 문자열A == 문자열B       : 리터럴 문자만 비교 가능
(2) 문자열A.equals(문자열B)  : 리터럴과 객체 문자열 비교 가능
### 3) 주요 메소드

| 메소드                                                                  | 설명                                                  |
|----------------------------------------------------------------------|-----------------------------------------------------|
| 문자열A.concat(문자열B)                                                    | 연결 메소드                                              |
| String.format("형식문자", 문자열)                                           | 지정한 형식으로 문자열을 반환하는 메소드                              |
| StringBuilder builder = new StringBuilder(); </br> builder.append(문자열A); | 문자열을 연결해주는 클래스                                      |
| 문자열.charAt( index )                                                  | 지정한 index의 문자 1개를 반환                                |
| 문자열.length()                                                         | 문자열의 길이(글자 수) 반환                                    |
| 문자열.replace( Asis, Tobe)                                             | 문자열 내의 Asis문자를 tobe문자를 바꾼후 새로운 문자열로 저장하는 함수, 1개     |
| 문자열.replaceAll( Asis, Tobe)                                          | 문자열 내의 Asis문자를 tobe문자를 바꾼후 새로운 문자열로 저장하는 함수, 모든     |
| 문자열.subString( StartIndex, EndIndex)                                 | : 문자열 내의 StartIndex부터 EndIndex 전까지 문자열을 반환          |
| 문자열.split( 구분문자 )                                                 | 문자열을 구분문자로 나눈 후, String[] 타입으로 반환                   |
| 문자열.indexOf("찾을문자열")                                              | 문자열 내 "찾을 문자열"이 존재하면 index 번호 / 없으면 -1을 반환          |
| 문자열.contains("찾을문자열")                                             |  문자열 내 "찾을 문자열"이 존재하면 ture / 없으면 false을 반환                                                   |
| 문자열.getBytes() </br> new String( byte[] )                            | 문자열을 byte[] 타입으로 반환 </br> byte[] 타입을 String 타입으로 반환 |

```java
public class Practice {
    public static void main(String[] args) {
// 1. 배열을 이용한 문자열 표현
        char str1 = '유';                 // 작은 따옴표('')로  감싼 문자 1개 : char 타입
        char[] str2 = {'유','재','석'};    // 작은 따옴표 3개를 char 배열 타입으로 묶음

        // 2.char 타입의 아스키코드 10진수
        char str3 = 65;
        System.out.println(str3);       //  A : char는 정수를 넣었을 때, 영문(or 아스키코드에 따른 문자)을 반환
        char[] str4 = {74,65,86,65};
        System.out.println(Arrays.toString(str4));  // [J, A, V, A] >> 아스키코드를 이용, char배열을 통한 글자 표현

        char str5 = '김';
        System.out.println( (int) str5 );   // 44608 >> 유니코드에 따른 값

        // 3. 문자열 리터럴 : 큰 따옴표("")
        String str6 = "유재석";                        // 리터럴 대입 : 문자열이 동일할 경우, 동일한 객체 취급
        String str7 = "유재석";
        String str8 = new String("유재석");    // 생성자 : 문자열이 동일하더라도 서로 다른 객체로 취급

        // 4. == VS .equals()
        // == : 주소값 비교
        // .equals() : 문자열(객체) 비교
        // Object class에서 .equals()는 객체 비교 함수, 
        // String class에서 override 되어 문자열 비교 함수로 재정의됨
        // ※ 문자는 불변

        System.out.println( str6 == str7 );     // true 
        // str6, str7는 리터럴 대입을 통해 동일한 문자열을 대입하였으므로 동일한 주소값을 가짐
        System.out.println( str6 == str8 );     // false  
        // str6은 리터럴 대입 · str8은 생성자 사용으로 객체를 생상하였으므로 서로 다른 주소값을 가짐
        System.out.println( str6.equals(str7)); // true
        System.out.println( str6.equals(str8)); // true

        // 5. 주요 메소드
        // 1) "A".concat("B") : 문자열 연결 메소드 ≒ + 연결 연산자
        String str9 = "자바".concat("프로그래밍");
        System.out.println(str9);

        // 2) StringBuilder class : 문자열을 단계적으로 연결하는 메소드를 제공하는 클래스
        StringBuilder builder = new StringBuilder();
        builder.append("자바");
        builder.append("프로그래밍");
        System.out.println(builder); // 메모리 효율 Good!

        // 3) String.format("형식문자", "A", "B")
        String str10 = String.format("%s %s", "자바", "프로그래밍");
        System.out.println(str10);

        // 4) + 연결 연산자
        String str11 = "";
        str11 += "자바";
        str11 += "프로그래밍";
        System.out.println(str11);

        // [활용] JDBC SQL의 매개변수 연결
        String name = "유재석";
        String sql1 = "insert into tb(name) values ( "+name+")";                    // 비추천
        String sql2 = String.format("insert into tb(name) values ( %s )", name);
        String sql3 = "";
        sql3 += "insert into tb(name) values (";                                    //... 비추천 + 띄어쓰기 주의

        StringBuilder builder2 = new StringBuilder();
        builder2.append("insert into tb(name) values (");                           // 그닥.....


        // 5) .charAt( 인덱스 ) : 지정한 인덱스 번호의 문자 1개 반환 메소드
        char gender = "012345-1234567".charAt(7);
        System.out.println(gender);                         // 1
        // [활용] scan.next().charAt(x) : console에서 받은 값의 index x 번째 1개를 추출

        // 6) . length() : 문자 수 반환 메소드
        System.out.println("012345-1234567".length());      // 14
        // [활용] 반복문

        // 7) .replace( As-is문자열, To-be문자열 )
        //      : 문자열 추출 > As-is문자열 삭제, To-be문자열 삽입 > 새로운 문자열 생성 메소드
        //      : 새로 생성하는 메소드이므로 주소값이 바뀜
        String str12 = "자바프로그래밍".replace("자바","Java");
        System.out.println(str12);
        // [활용] HTML 줄바꿈 <br> >> Java '\n'
        String htmlData = "유재석<br>안녕하세요.";
        htmlData.replaceAll("<br>","\n");

        // 8) .subString( 시작인덱스, (끝인덱스) ); : 시작 인덱스부터 마지막 인덱스 전까지 추출
        String str13 = "012345-1234567".substring(0,6);
        System.out.println(str13);      // 012345

        String str14 = "012345-1234567".substring(7);  // 7번 index부터 마지막 까지 출력
        System.out.println(str14);      // 1234567
        // [활용] 차량번호 조회 : 214가7531 / 차량번호 뒷차리 = 차량번호.subString( 차량번호.length()-4 )

        // 9) .split("구분문자") : 문자열 내 구분문자를 기준으로 문자열을 자른 후 배열로 반환
        String[] str15 = "012345-1234567".split("-");
        System.out.println(str15[0]);           // 012345
        System.out.println(str15[1]);           // 1234567
        // [활용] CSV 형식 다루기
        //      쉼표(,)로 속성을 구분하고 \n으로 줄구분을 함
        //      날짜(y-m-d) / 주소 (시, 군, 구, 동)

        // 10) .indexOf("찾을 문자열") : 문자열 내 "찾을 문자열"이 존재하면 찾은 인덱스를 반환, 없으면 -1을 반환
        int findIndex = "자바 프로그래밍 언어".indexOf("프로");
        System.out.println(findIndex);      // 3
        // [활용] 검색

        // 11) .contains("찾을 문자열") : 문자열 내 "찾을 문자열"이 존재하면 true, 없으면 false
        boolean findBool = "자바 프로그래밍 언어".contains("프로");
        System.out.println(findBool);       //true
        // [활용] 검색

        // 12) .getBytes() : 지정 문자열을 byte[] 타입으로 반환하는 메소드
        byte[] str16 = "JAva program".getBytes();
        System.out.println(Arrays.toString(str16));     // 아스키 코드 [74, 65, 118, 97, 32, 112, 114, 111, 103, 114, 97, 109]
        // [활용] 파일처리, 네트워크 통신 etc
    } //main end
} // class end
```
---

# Java_24_


---

# Java_25_


---

# Java_26_


---

# Java_27_


---

# Java_28_


---

```java
public class Practice {
    public static void main(String[] args) {

    } //main end
} // class end
```
































