package comprehensive.intensify_05_250714.model.dao;

import comprehensive.intensify_05_250714.model.dto.AccountDto;
import java.util.ArrayList;

// Dao 역할 : 실존 데이터에 접근하는 기능 (CRUD)
public class AccountDao {
    // 싱글톤
    private AccountDao() {
    }

    private static final AccountDao accountDao = new AccountDao();

    public static AccountDao getInstance() {
        return accountDao;
    }

    // 멤버변수 private
    private ArrayList<AccountDto> accountDB = new ArrayList<>();

    // 1. 등록 처리 메소드
    // controller 로 부터 배열에 저장할 객체를 받아와서 저장
    // 매개변수 : String accountNo, int pw
    // return boolean

    public boolean setAccount(String accountNo, int pw) {
        boolean result = false;
        AccountDto accountDto = new AccountDto(accountNo , pw);
        accountDB.add(accountDto);
        result = true;
        return result;
    }

    // 2. 조회 처리 메소드
    // controller에 모든 배열을 반환
    // 매개변수 : X
    // return Dto
    public ArrayList<AccountDto> getAccountDB(){
        return accountDB;
    }
}
