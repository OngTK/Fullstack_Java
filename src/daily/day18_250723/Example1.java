package daily.day18_250723;

public class Example1 {
    public static void main(String[] args) {

        //[1] DB 연동 확인
        UserDao userDao = UserDao.getInstance();

        //[2] SQL 작성 메소드 실행
        userDao.userInsert();

        //[3] SQL 작성 메소드에 매게변수를 이용하여 table에 값 삽입하기.
        userDao.userInsert2("고우림", 30);
        userDao.userInsert2("배두훈", 39);

        //[4] Select 메소드 실행
        userDao.userSelect();

    } // main end
} // class end
