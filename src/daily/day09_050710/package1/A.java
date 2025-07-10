package daily.day09_050710.package1;

public class A {
    public int 공개변수 = 1;        // public
    private int 비공개변수 = 2;     // private
    int 일반변수 = 3;               // defalut 는 생략 가능

    public void method(){
        System.out.println( this.공개변수 );
        System.out.println( 비공개변수 );
        System.out.println( 일반변수 );
    }

}