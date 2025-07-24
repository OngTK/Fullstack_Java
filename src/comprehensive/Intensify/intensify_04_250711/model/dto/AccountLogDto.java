package comprehensive.intensify_04_250711.model.dto;

// Dto 역할 : 데이터 모델·이동 객체
public class AccountLogDto {

    // 멤버변수 : all private ===================================
    private int logNo;
    private String accountNo;
    private String sort;
    private int money;
    private int balance;
    private String date;

    // 생성자 : 기본생성자와 풀생성자는 기본! 추가는 자유 ===================================
    // 기본 생성자

    public AccountLogDto() {
    }

    // 풀생성자

    public AccountLogDto(int logNo, String accountNo, String sort, int money, int balance, String date) {
        this.logNo = logNo;
        this.accountNo = accountNo;
        this.sort = sort;
        this.money = money;
        this.balance = balance;
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

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    // toString

    @Override
    public String toString() {
        return "AccountLogDto{" +
                "logNo=" + logNo +
                ", accountNo='" + accountNo + '\'' +
                ", sort='" + sort + '\'' +
                ", money=" + money +
                ", balance=" + balance +
                ", date='" + date + '\'' +
                '}';
    }
}// class end
