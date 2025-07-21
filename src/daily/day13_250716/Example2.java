package daily.day13_050716;

// Java의 모든 class 는 extends Object : 100% 객체지향

class A {
    A() {
        System.out.println("A 객체 생성");
    } // 생성자
}

class B extends A {
    B(){
        System.out.println("B 객체 생성");
    }
}

class C extends A {
    C(){
        System.out.println("C 객체 생성");
    }
}

class D extends B {
    D(){
        System.out.println("D 객체 생성");
    }
}

class E extends C {
    E(){
        System.out.println("E 객체 생성");
    }
}

public class Example2 {
    public static void main(String[] args) {

        System.out.println("========================");
        // A 객체 생성 시, 총 객체 수 : 2 / object(default), A
        A a = new A();

        System.out.println("========================");
        // B 객체 생성 시, 총 객체 수 : 3 / object, A, B
        B b = new B();

        System.out.println("========================");
        // C 객체 생성 시, 총 객체 수 : 3 / object, A, C
        C c = new C();

        System.out.println("========================");
        // D 객체 생성 시, 총 객체 수 : 4 / object, A, B, D
        D d = new D();

        System.out.println("========================");
        // E 객체 생성 시, 총 객체 수 : 4 / object, A, C, E
        E e = new E();


        // [ 자동 타입 변환 ]
        A a1 = b;      // B 타입 > A타입 가능!
        Object o1 = b; // B > A > Object이므로 가능!

        // B b2 = c;       // C 타입 > B타입 불가능!! 상속 관계 없음!!

        // [ 강제 타입 변환 ]
        B b2 = (B)a1;       // a1은 원래 b로 B타입이었음, 따라서 B타입으로 강제 변환이 가능

        A a2 = e;           // 가능!! e 생성시 (object, A , C , E) 생성되었음, 상속 관계에 따라 e를 A타입으로 자동 변환
        C c1 = (C)a2;       // a2는 현재는 A타입이며 원래는 E타입 / 그리고 생성시 C타입도 생겼음, 따라서 C타입으로 강제 변환이 가능
        // B b3 = (B)a2;       // 문법상에는 오류가 없음(A와 B는 상속관계이므로), 다만 B타입은 E타입 생성시 포함되지 않았으므로 실행시 Error 발생

        // [ 인스턴스(객체/값) 타입 확인 방법 ]
        // 객체 instanceof 타입
        // 강제 타입 변환 전에 확인을 위해 사용
        System.out.println( a instanceof Object ); //true
        System.out.println( b instanceof A ); // ture
        // System.out.println( e instanceof B ); // error!!
        System.out.println( a2 instanceof C); // true
        System.out.println( a2 instanceof B); // false

    } // main end
} // class end
