package daily.day08_050709;

public class Phone {
    // 1. 멤버변수
    String model;
    String color;
    int price;

    // 2. 생성자
    //  1) 기본 생성자
    //      * 클래스 내 생성자가 없으면 자동으로 생성
    //      * 클래스 내 하나 이상의 생성자가 있을 때는, 기본 생성자를 직접 정의
    Phone() {
        System.out.println(">> Phone 기본 생성자 실행");
    }

    //  2) 매개변수가 있는 생성자
    //      * 생성자는 매개변수를 갖지만 반환값은 없음
    Phone(String pModel, String pColor){
    // 외부로부터 전달받은 인자값이 저장된 매개변수 값을 멤버변수에 저장
        model = pModel;
        color = pColor;
        price = 1200000; // 초기값을 임의의 값으로 설정
    }

    //  3) 생성자의 오버로드
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
    // 3. 메소드
}
