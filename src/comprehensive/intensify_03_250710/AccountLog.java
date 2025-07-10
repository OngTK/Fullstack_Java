package comprehensive.intensify_03_250710;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AccountLog {

    private static final AccountLog[] accountLogs = new AccountLog[100];

    // 멤버변수 ============================
    private int logNo;
    private String accountNo;
    private String sort;
    private int money;
    private int balance;
    private String date;

    // 생성자 ============================


    public AccountLog() {
    }

    public AccountLog(int logNo, String accountNo, String sort) { //계좌 등록
        this.logNo = logNo;
        this.accountNo = accountNo;
        this.sort = sort;
        this.money = 0;
        this.balance = 0;
    }

    public AccountLog(int logNo, String accountNo, String sort, int money, int balance, String date) {
        this.logNo = logNo;
        this.accountNo = accountNo;
        this.sort = sort;
        this.money = money;
        this.balance = balance;
        this.date = date;
    }


    // 메소드 ============================


    @Override
    public String toString() {
        return "AccountLog{" +
                "logNo=" + logNo +
                ", accountNo='" + accountNo + '\'' +
                ", sort='" + sort + '\'' +
                ", money=" + money +
                ", balance=" + balance +
                ", date='" + date + '\'' +
                '}';
    }

    // 메소드 0-2. 거래 내역 저장
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    static String now = formatter.format(LocalDateTime.now());

    public static void setLog(String accountNo, String sort, int money, int balance) {
        // logNo
        int logNoInput = 0;

        for (int i = 0; i < accountLogs.length; i++) {
            if (accountLogs[0] == null){
                logNoInput = 1;
            }else if (accountLogs[i] != null) {
                logNoInput = accountLogs[i].logNo + 1;
            }
        }
        System.out.println(logNoInput);
        // accountNo/ sort / money / balance 는 외부에서 들어옴

        String nowdate = now;

        AccountLog accountLog = new AccountLog(logNoInput, accountNo, sort, money, balance, nowdate);
        System.out.println(accountLog.toString());

        for(int i = 0; i < accountLogs.length; i++){
            if (accountLogs[i] == null){
                accountLogs[i] = accountLog;
                return;
            }
        }
    }

    public static AccountLog[] getlog(){
        return accountLogs ;
    }

    //setter, getter===================


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

    public static DateTimeFormatter getFormatter() {
        return formatter;
    }

    public static void setFormatter(DateTimeFormatter formatter) {
        AccountLog.formatter = formatter;
    }

    public static String getNow() {
        return now;
    }

    public static void setNow(String now) {
        AccountLog.now = now;
    }
}

