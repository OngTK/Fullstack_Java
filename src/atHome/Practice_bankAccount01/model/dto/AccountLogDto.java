package atHome.Practice_bankAccount01.model.dto;

// Dto 역할 : 데이터 모델·이동 객체
public class AccountLogDto {

    // 멤버변수 : all private ===================================
    private int logNo;              // log 고유 번호
    private String accountNo;       // 계좌번호
    private int sort;               // 구분 /1 입금/2 출금/3 이체_출금/4 이체_입금
    private int money;              // 거래금액
    private int currentBalance;     // 거래후 잔고
    private String date;            // 날짜 + 시간

    // 생성자 : 기본생성자와 풀생성자는 기본! 추가는 자유 ===================================
    // 기본 생성자
    public AccountLogDto() {
    }

    // 풀생성자
    public AccountLogDto(int logNo, String accountNo, int sort, int money, int currentBalance, String date) {
        this.logNo = logNo;
        this.accountNo = accountNo;
        this.sort = sort;
        this.money = money;
        this.currentBalance = currentBalance;
        this.date = date;
    }


    // 메소드 ======================================================================
    // getter·setter

    public int getLogNo() {
        return logNo;
    }

    public void setLogNo(int logNo) {
        this.logNo = logNo;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // toString
    public String toString() {
        return "AccountLogDto{" +
                "logNo=" + logNo +
                ", accountNo='" + accountNo + '\'' +
                ", sort=" + sort +
                ", money=" + money +
                ", currentBalance=" + currentBalance +
                ", date='" + date + '\'' +
                '}';
    }
}// class end
