package Practice.Practice_09_250709;

public class Pet {
    // 멤버변수
    String name;
    String species;
    int age;

    // 생성자
    // 1. 기본생성자
    Pet(){

    }
    // 2. 매개변수 포함 생성자
    Pet( String name , String species, int age){
        this.name = name;
        this.species = species;
        this.age = age;
    }
}
