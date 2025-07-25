package comprehensive.DookDackMarcket_250724.model.dto;

// Dto : 데이터 모델·이동 객체
public class RankingDto {

    // 멤버변수 ===================================
    private String pSeller ;
    private int count;
    // 생성자===================================
    // 기본 생성자
    public RankingDto() {
    }

    // 풀생성자
    public RankingDto(String pSeller, int count) {
        this.pSeller = pSeller;
        this.count = count;
    }

    // 메소드 =======================================
    // getter·setter

    public String getpSeller() {
        return pSeller;
    }

    public void setpSeller(String pSeller) {
        this.pSeller = pSeller;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    // toString
    public String toString() {
        return "RankingDto{" +
                "pSeller='" + pSeller + '\'' +
                ", countl=" + count +
                '}';
    }
}// class end
