package review.library.model.dto;

public class LogDto {
    private int cno, mno, bno;
    private String borrowDate, returnDate;

    public LogDto(int cno ,int mno, int bno, String borrowDate) {
        this.cno = cno;
        this.mno = mno;
        this.bno = bno;
        this.borrowDate = borrowDate;
    }

    public LogDto(int cno, int mno, int bno, String borrowDate, String returnDate) {
        this.cno = cno;
        this.mno = mno;
        this.bno = bno;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public int getMno() {
        return mno;
    }

    public void setMno(int mno) {
        this.mno = mno;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "LogDto{" +
                "cno=" + cno +
                ", mno=" + mno +
                ", bno=" + bno +
                ", borrowDate='" + borrowDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                '}';
    }
}

