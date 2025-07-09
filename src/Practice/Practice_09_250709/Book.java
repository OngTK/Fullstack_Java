package Practice.Practice_09_250709;

public class Book {
    // 멤버변수

    String title;
    String author;
    int price;

    // 생성자
    // 1. 기본생성자
    Book(){

    }
    // 2. 매개변수 포함 생성자
    Book(String title, String author, int price){
        this.title = title;
        this.author = author;
        this.price = price;
    }
}
