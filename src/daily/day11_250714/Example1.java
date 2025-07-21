package daily.day11_050714;

import java.util.ArrayList;

public class Example1 {
    /*
    [ ArrayList ]
        : Java에서 제공하는 클래스
        1. 정의
            컬렉션 프레임워크 중 리스트 자료형 클래스
        2. 목적
            가변 길이의 배열을 지원
        3. 사용법
            1) 선언
                ArrayList< 항목타입 > 변수명 = new ArrayList<>();
                * <제너릭타입> : 리스트에 저장할 항목/요소의 타입
            2) 추가·삽입
                (1) 변수명.add( 요소값 );
                    : 마지막 인덱스 뒤로 요소 추가
                (2) 변수명.add( index, 요소값 );
                    : 지정한 index에 요소를 삽입하고, 기존 요소들은 한 index 씩 뒤로 밀림
            3) 수정
                    변수명.set( index, 요소값 );
                    : 지정한 index를 새로운 요소값으로 수정
            4) 리스트 크기
                    변수명.size( );
            5) 특정 요소 반환
                    변수명.get( index );
            6) 삭제
                    변수명.remove( index );
        4. 리스트와 반복문
            1) 일반 반복문
                for (int i = 0 ; i < 변수명.size() ; i++) {
                변수명.get(i);
                }
            2) 향상된 for
                for ( 타입명 변수명 : 리스트변수명 ){
                변수명;
                }

    */
    
    public static void main(String[] args) {
        // [1] ArrayList 객체 선언
        ArrayList<String> 리스트객체 = new ArrayList<>();

        // [2] .add(); 
        리스트객체.add("유재석");
        System.out.println("리스트객체 = " + 리스트객체);
        
        // [3] 출력
        리스트객체.add("강호동");
        리스트객체.add("신동엽");
        System.out.println(리스트객체);

        // 중간에 요소 추가
        리스트객체.add(1, "박명수"); // index 위치에 삽입
        System.out.println(리스트객체);

        // [4] .set(); : 요소 수정하기
        리스트객체.set(1, "노홍철");
        System.out.println(리스트객체);

        // [5] .size();                    ≒ array.length();
        System.out.println(리스트객체.size());

        // [6] .get(); 특정 요소 반환        ≒ array[1];
        System.out.println(리스트객체.get(1));

        // [7] .remove();
        리스트객체.remove(1);
        System.out.println(리스트객체);

        // [8] 리스트 객체와 반복문
        //  1) 일반 반복문
        for(int i = 0 ; i < 리스트객체.size() ; i++ ){
            String str = 리스트객체.get(i);
            System.out.println(str);
        }

        // 2) 향상된 for
        // for ( 타입 변수명 : 리스트명 ){ }
        for(String str : 리스트객체){
            System.out.println(str);
        }

        // [9] 클래스 타입 생성 후 리스트 객체 작업
        Member m1 = new Member("배두훈", 39);
        Member m2 = new Member("강형호", 37);
        Member m3 = new Member("조민규", 35);
        Member m4 = new Member("고우림", 31);

        ArrayList< Member > memberList = new ArrayList<>();
        memberList.add(m1);
        memberList.add(m2);
        memberList.add(m3);
        memberList.add(m4);

        for(int i =0;i<memberList.size() ; i++){
            System.out.println(memberList.get(i).toString());
            Member m = memberList.get(i);
            System.out.println("이름 : " + m.getName());
            System.out.println("나이 : " + m.getAge());
        }

        for(Member member : memberList){
            System.out.println(member.toString());
            System.out.println("이름 : " + member.getName());
            System.out.println("나이 : " + member.getAge());
        }
    }
}

class Member{
    // 멤버변수
    private String name;
    private int age;

    // 생성자
    public Member() {
    }
    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
