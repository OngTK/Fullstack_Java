package comprehensive.Library.model.dto;

public class MemberDto {
    private int mno;
    private String mid, mpw, mname, mphone;

    public MemberDto(int mno, String mid, String mpw, String mname, String mphone) {
        this.mno = mno;
        this.mid = mid;
        this.mpw = mpw;
        this.mname = mname;
        this.mphone = mphone;
    }

    public int getMno() {
        return mno;
    }

    public void setMno(int mno) {
        this.mno = mno;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMpw() {
        return mpw;
    }

    public void setMpw(String mpw) {
        this.mpw = mpw;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMphone() {
        return mphone;
    }

    public void setMphone(String mphone) {
        this.mphone = mphone;
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "mno=" + mno +
                ", mid='" + mid + '\'' +
                ", mpw='" + mpw + '\'' +
                ", mname='" + mname + '\'' +
                ", mphone='" + mphone + '\'' +
                '}';
    }
}

