package Practice.Practice_10_250710;

public class Score {

    // 멤버변수
    private int score;

    // 생성자


    // 메소드
    public void setScore(int score) {
        if (score >= 0 && score <= 100) {
            this.score = score;
            System.out.println(this.score);
        } else {
            System.out.println("유효하지 않은 점수입니다.");
        }
    }
}

