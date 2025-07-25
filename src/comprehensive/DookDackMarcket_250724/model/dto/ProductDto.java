package comprehensive.DookDackMarcket_250724.model.dto;

// Dto : 데이터 모델·이동 객체
public class ProductDto {

    // 멤버변수 ===================================
    private int pNo;            // 물품번호
    private String pName;       // 물품명
    private String pSeller;     // 판매자
    private String pMemo;       // 설명
    private int pPrice;         // 가격
    private String pPw;         // 비밀번호
    private String pDate;       // 등록일시
    private boolean pStatus;    // 판매여부/ false="판매중" / true="판매완료"
    // 생성자===================================
    // 기본 생성자
    public ProductDto() {
    }

    // 풀생성자

    public ProductDto(int pNo, String pName, String pSeller, String pMemo, int pPrice, String pPw, String pDate, boolean pStatus) {
        this.pNo = pNo;
        this.pName = pName;
        this.pSeller = pSeller;
        this.pMemo = pMemo;
        this.pPrice = pPrice;
        this.pPw = pPw;
        this.pDate = pDate;
        this.pStatus = pStatus;
    }

    // 메소드 =======================================
    // getter·setter
    public int getpNo() {
        return pNo;
    }

    public void setpNo(int pNo) {
        this.pNo = pNo;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpSeller() {
        return pSeller;
    }

    public void setpSeller(String pSeller) {
        this.pSeller = pSeller;
    }

    public String getpMemo() {
        return pMemo;
    }

    public void setpMemo(String pMemo) {
        this.pMemo = pMemo;
    }

    public int getpPrice() {
        return pPrice;
    }

    public void setpPrice(int pPrice) {
        this.pPrice = pPrice;
    }

    public String getpPw() {
        return pPw;
    }

    public void setpPw(String pPw) {
        this.pPw = pPw;
    }

    public String getpDate() {
        return pDate;
    }

    public void setpDate(String pDate) {
        this.pDate = pDate;
    }

    public boolean getsStatus() {
        return pStatus;
    }

    public void setpStatus(boolean pStatus) {
        this.pStatus = pStatus;
    }

    // toString
    public String toString() {
        return "ProductDto{" +
                "pNo=" + pNo +
                ", pName='" + pName + '\'' +
                ", pSeller='" + pSeller + '\'' +
                ", pMemo='" + pMemo + '\'' +
                ", pPrice=" + pPrice +
                ", pPw='" + pPw + '\'' +
                ", pDate='" + pDate + '\'' +
                ", pStatus=" + pStatus +
                '}';
    }
}// class end
