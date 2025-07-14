package comprehensive.intensify_05_250714.model.dao;

import comprehensive.intensify_05_250714.model.dto.AccountLogDto;

import java.util.ArrayList;

// Dao 역할 : 실존 데이터에 접근하는 기능 (CRUD)
public class AccountLogDao {
    // 싱글톤
    private AccountLogDao() {
    }

    private static final AccountLogDao accountLogDao = new AccountLogDao();

    public static AccountLogDao getInstance() {
        return accountLogDao;
    }

    // 멤버변수 private
    private ArrayList<AccountLogDto> accountLogDB = new ArrayList<AccountLogDto>();

    // 1. 등록 처리 메소드
    // controller 로 부터 배열에 저장할 객체를 받아와서 저장
    // 매개변수 : Dto
    // return boolean
    public void setAccountLog(int logNo, String accountNo, int sort, int money, int currentBalance, String date) {
        AccountLogDto accountLogDto = new AccountLogDto(logNo, accountNo, sort, money, currentBalance, date);
        accountLogDB.add(accountLogDto);
    }

    // 2. 조회 처리 메소드
    // controller에 모든 배열을 반환
    // 매개변수 : X
    // return Dto
    public ArrayList<AccountLogDto> getAccountLogDB() {
        return accountLogDB;
    }

}
