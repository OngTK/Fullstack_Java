package daily.day09_050710.package2;

public class C {
    // 비공개 멤버변수
    private int 비공개변수;

    // 공개 메소드
    public int 반환메소드(){
        return 비공개변수;
    }

    private void 저장메소드(int 값){
        비공개변수 = 값;
    }
}
