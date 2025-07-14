package review.Practice_bankAccount01.model.dao;


import Practice_bankAccount01.model.dto.AccountDto;

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
    private AccountDto[] accountDB = new AccountDto[100];

    // 1. 등록 처리 메소드
    // controller 로 부터 배열에 저장할 객체를 받아와서 저장
    // 매개변수 : Dto
    // return boolean

    public boolean setAccount(AccountDto accountDto) {
        for (int i = 0; i < accountDB.length; i++) {
            if (accountDB[i] == null) {
                accountDB[i] = accountDto;
                return true;
            }
        }
        return false;
    }

    // 2. 조회 처리 메소드
    // controller에 모든 배열을 반환
    // 매개변수 : X
    // return Dto
    public AccountDto[] getAccountDB(){
        return accountDB;
    }
}
