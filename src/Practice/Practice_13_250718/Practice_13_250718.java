package Practice.Practice_13_250718;

// [1]=============================================================================

import daily.day09_050710.package2.C;

interface Soundable {
    void makeSound();
}

class Cat implements Soundable {
    public void makeSound() {
        System.out.println("야옹");
    }
}

class Dog implements Soundable {
    public void makeSound() {
        System.out.println("멍멍");
    }
}

// [2]=============================================================================
interface RemoteControl {
    // 멤버변수
    // interface의 멤버변수는 `public static final`이 자동이므로 생략 가능
    int MAX_VOLUME = 10;
    int MIN_VOLUME = 0;
}

// [3]=============================================================================
interface Runnable {
    void run();
}

class Person implements Runnable {
    @Override
    public void run() {
        System.out.println("사람이 달립니다.");
    }
}

class Car implements Runnable {
    @Override
    public void run() {
        System.out.println("자동차가 달립니다.");
    }
}

// [4]=============================================================================
interface Attackable {
    void attack();
}

class Sword implements Attackable {
    public void attack() {
        System.out.println("칼로 공격");
    }
}

class Gun implements Attackable {
    public void attack() {
        System.out.println("총으로 공격");
    }
}

class Character {
    Attackable attackable;

    void useWeapon(Attackable weapon) {
        weapon.attack();
    }
}

// [5]=============================================================================
interface Flyable {
    void fly();
}

interface Swimmalbe {
    void swimmable();
}

class Duck implements Flyable, Swimmalbe {
    public void fly() {
        System.out.println("하늘을 납니다.");
    }

    public void swimmable() {
        System.out.println("물에서 헤엄칩니다.");
    }
}

// [6]=============================================================================

// [7]=============================================================================
interface DataAccessObject{
    void save();
};

class OracleDao implements DataAccessObject{
    public void save() {
        System.out.println("Oracle DB에 저장");
    }
}

class MySqlDao implements DataAccessObject{
    public void save() {
        System.out.println("MySQL DB에 저장");
    }
}

// [8]=============================================================================
interface Greeting{
    void welcome();
}
// [9]=============================================================================
interface Device{
    void turnOn();
    void turnOff();
    public default void setMute(boolean mute){
        System.out.println("무음 처리합니다.");
    };
}
class Television implements Device{
    public void turnOn() {
        System.out.println("전원을 킵니다.");
    }

    public void turnOff() {
        System.out.println("전원을 끕니다.");
    }
}

// [10]============================================================================
interface Calculator{
    static void plus(int x, int y ){
        System.out.println(x+y);
    };
}

public class Practice_13_250718 {
    public static void main(String[] args) {
//[문제 1] 기본 인터페이스와 구현
//        1. "소리를 냅니다."라는 추상 메소드 makeSound()를 가진 Soundable 인터페이스를 정의하세요.
//        2. Soundable 인터페이스를 구현(implements)하는 Cat 클래스와 Dog 클래스를 만드세요.
//        3. 각 클래스에서 makeSound() 메소드를 오버라이딩하여, 각각 "야옹", "멍멍"을 출력하도록 구현하세요.
//        4. main 함수에서 Cat 객체와 Dog 객체를 생성하고, 각 객체의 makeSound() 메소드를 호출하여 결과를 확인하세요.

        Cat cat = new Cat();
        Dog dog = new Dog();
        cat.makeSound();
        dog.makeSound();

        System.out.println("====================================================");

//[문제 2] 인터페이스 상수
//        1. RemoteControl 인터페이스를 만드세요.
//        2. 이 인터페이스 안에, public static final로 최대 볼륨 MAX_VOLUME = 10과 최소 볼륨 MIN_VOLUME = 0 상수를 정의하세요.
//        3. main 함수에서 객체를 생성하지 않고, RemoteControl.MAX_VOLUME과 같이 인터페이스 이름으로 직접 접근하여 두 상수를 출력하세요.

        System.out.println(RemoteControl.MAX_VOLUME);
        System.out.println(RemoteControl.MIN_VOLUME);
        System.out.println("====================================================");

//[문제 3] 다형성: 인터페이스 타입 변환
//        1. "달립니다."라는 추상 메소드 run()을 가진 Runnable 인터페이스를 정의하세요.
//        2. Runnable을 구현하여 각각 "사람이 달립니다.", "자동차가 달립니다."를 출력하는 Person 클래스와 Car 클래스를 만드세요.
//        3. main 함수에서 Runnable 타입의 변수 runner를 선언하세요.
//        4. runner 변수에 new Person()을 대입하여 run() 메소드를 호출하고, 그 다음 new Car()를 대입하여 run() 메소드를 호출하여 결과가 다르게 나오는 것을 확인하세요.
        Runnable runner = new Person();
        runner.run();
        runner = new Car();
        runner.run();

        System.out.println("====================================================");

//[문제 4] 다형성을 활용한 매개변수
//        1. "공격!"이라는 추상 메소드 attack()을 가진 Attackable 인터페이스를 정의하세요.
//        2. Attackable을 구현하는 Sword 클래스와 Gun 클래스를 만드세요.
//        3. Attackable 타입의 객체를 매개변수로 받아, 해당 객체의 attack() 메소드를 호출하는 Character 클래스와 useWeapon(Attackable weapon) 메소드를 만드세요.
//        4. main 함수에서 Sword 객체와 Gun 객체를 생성한 뒤, 이 객체들을 Character의 useWeapon() 메소드에 인자로 전달하여 동작을 확인하세요.

        Sword sword = new Sword();
        Gun gun = new Gun();
        Character character = new Character();
        character.useWeapon(sword);
        character.useWeapon(gun);

        System.out.println("====================================================");

//[문제 5] 다중 인터페이스 구현
//        1. "하늘을 납니다."를 출력하는 fly() 추상 메소드를 가진 Flyable 인터페이스를 만드세요.
//        2. "물에서 헤엄칩니다."를 출력하는 swimmable() 추상 메소드를 가진 Swimmable 인터페이스를 만드세요.
//        3. Duck 클래스가 Flyable과 Swimmable 두 인터페이스를 모두 구현하도록 작성하세요.
//        4. main 함수에서 Duck 객체를 생성하고, fly()와 swimmable() 메소드를 모두 호출하여 결과를 확인하세요.

        Duck duck = new Duck();
        duck.fly();
        duck.swimmable();
        System.out.println("====================================================");

//[문제 6] instanceof와 인터페이스
//        1. 문제 5에서 만든 Flyable, Swimmable 인터페이스와 Duck 클래스를 활용합니다.
//        2. main 함수에서 Duck 객체를 생성하고, Object 타입의 변수에 저장하세요.
//        3. if문과 instanceof 연산자를 사용하여, 해당 객체가 Flyable 타입인지, Swimmable 타입인지 각각 확인하고, 맞다면 해당 인터페이스 타입으로 강제 형변환하여 메소드를 호출하세요.

        Object obj = duck;
        if (obj instanceof Flyable) {
            Flyable obj1 = (Flyable)obj;
            obj1.fly();
        }
        if (obj instanceof Swimmalbe) {
            Swimmalbe obj1 = (Swimmalbe)obj;
            obj1.swimmable();
        }

        System.out.println("====================================================");

//[문제 7] 인터페이스를 이용한 객체 교체
//        1. "데이터를 저장합니다."라는 추상 메소드 save()를 가진 DataAccessObject 인터페이스를 만드세요.
//        2. DataAccessObject를 구현하여 각각 "Oracle DB에 저장", "MySQL DB에 저장"을 출력하는 OracleDao, MySqlDao 클래스를 만드세요.
//        3. main 함수에서 DataAccessObject 타입의 변수 dao를 선언하세요.
//        4. dao에 new OracleDao()를 대입하여 save()를 호출하고, 그 다음 new MySqlDao()를 대입하여 save()를 호출하여 DB가 쉽게 교체되는 것을 확인하세요.

        DataAccessObject dao;
        dao = new OracleDao();
        dao.save();
        dao = new MySqlDao();
        dao.save();

        System.out.println("====================================================");

//[문제 8] 익명 구현 객체
//        1. "환영합니다."를 출력하는 welcome() 추상 메소드를 가진 Greeting 인터페이스를 만드세요.
//        2. main 함수에서, 별도의 클래스 파일을 만들지 않고, Greeting 인터페이스 타입의 변수를 선언하면서 익명 구현 객체를 생성하여 welcome() 메소드를 즉석에서 구현하고 호출하세요.
//        예] Greeting g = new Greeting() { ... };

        Greeting greeting = new Greeting() {
            public void welcome() {
                System.out.println("환영합니다.");
            }
        };
        greeting.welcome();
        System.out.println("====================================================");

//[문제 9] 디폴트 메소드 (Default Method)
//        1.Device 인터페이스에, turnOn(), turnOff() 추상 메소드와 함께, public default void setMute(boolean mute) 디폴트 메소드를 추가하세요. 디폴트 메소드는 "무음 처리합니다."를 출력하도록 구현합니다.
//        2.Television 클래스가 Device를 구현하도록 하되, turnOn(), turnOff()만 오버라이딩하세요.
//        3.main 함수에서 Television 객체를 생성하고, turnOn(), turnOff()와 함께 디폴트 메소드인 setMute()도 호출되는 것을 확인하세요

        Television tv = new Television();
        tv.turnOn();
        tv.turnOff();
        tv.setMute(true);
        System.out.println("====================================================");

//[문제 10] 정적 메소드 (Static Method)
//        1. Calculator 인터페이스를 만들고, 두 정수의 합을 반환하는 plus(int x, int y) 정적 메소드를 정의하세요.
//        2. main 함수에서 Calculator 인터페이스를 구현하는 클래스나 객체를 만들지 않고, Calculator.plus(10, 20)과 같이 인터페이스 이름으로 직접 정적 메소드를 호출하여 결과를 출력하세요.

        Calculator.plus(10, 20);
    }
}
