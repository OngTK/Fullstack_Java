package review.Practice_bankAccount01.model.dao;

import Practice_bankAccount01.model.dto.AccountLogDto;

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
    private AccountLogDto[] accountLogDB = new AccountLogDto[100];

    // 1. 등록 처리 메소드
    // controller 로 부터 배열에 저장할 객체를 받아와서 저장
    // 매개변수 : Dto
    // return boolean
    public boolean setAccountLog(AccountLogDto accountLogDto){
        for(int i = 0 ; i < accountLogDB.length ; i++){
            if (accountLogDB[i] == null ){
                accountLogDB[i] = accountLogDto;
                return true;
            }
        }
        return false;
    }

    // 2. 조회 처리 메소드
    // controller에 모든 배열을 반환
    // 매개변수 : X
    // return Dto
    public AccountLogDto[] getAccountLogDB(){
        return accountLogDB;
    }

}
