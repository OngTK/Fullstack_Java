package daily.day09_050710.package1;

public class B {
    public void method(){
        A a = new A();
        System.out.println(a.공개변수);     // 접근 가능 : public
        //System.out.println(a.비공개변수);   // 접근 불가 : private
        System.out.println(a.일반변수);     // 접근 가능 : defualt : 같은·하위 패키지에 있으므로 접근 가능
        
    }
}
