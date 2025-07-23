package daily.day18_250723;

public class Example1 {
    public static void main(String[] args) {

        //[1] DB 연동 확인
        UserDao userDao = UserDao.getInstance();

        //[2] SQL 작성 메소드 실행
        userDao.userInsert();



    } // main end
} // class end
