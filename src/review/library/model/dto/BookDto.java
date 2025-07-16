package review.library.model.dto;

public class BookDto {
    private int bno;
    private String btitle, bwriter;

    public BookDto(String btitle, String bwriter) {
        this.btitle = btitle;
        this.bwriter = bwriter;
    }

    public BookDto(int bno, String btitle, String bwriter) {
        this.bno = bno;
        this.btitle = btitle;
        this.bwriter = bwriter;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getBtitle() {
        return btitle;
    }

    public void setBtitle(String btitle) {
        this.btitle = btitle;
    }

    public String getBwriter() {
        return bwriter;
    }

    public void setBwriter(String bwriter) {
        this.bwriter = bwriter;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "bno=" + bno +
                ", btitle='" + btitle + '\'' +
                ", bwriter='" + bwriter + '\'' +
                '}';
    }
}

