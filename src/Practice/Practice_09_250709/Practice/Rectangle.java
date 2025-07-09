package Practice.Practice_09_250709.Practice;

public class Rectangle {
    // 멤버변수
    int width;
    int height;

    // 생성자

    // 1. 기본생성자
    Rectangle(){}

    // 2. 매개변수 포함 생성자
    Rectangle(int width, int height){
        this.width = width;
        this.height = height;
    }

    // 메소드
    int getArea(){
        int result = width * height;
        return  result;
    }
}
