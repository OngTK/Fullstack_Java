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
# Java_09_접근제한자 관련 키워드

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

# Java_10_디자인 패턴(싱글톤, MVC)
