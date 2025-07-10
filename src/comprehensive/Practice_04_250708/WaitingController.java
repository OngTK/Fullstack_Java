package comprehensive.Practice_04_250708;

public class WaitingController {

    // 멤버변수=============================
    private static final Waiting[] waitings = new Waiting[100];

    // 생성자=============================


    // 메소드=============================
    public static boolean addWaiting(String phone, int count){
        Waiting waiting = new Waiting(phone, count);
        for(int i = 0 ; i < waitings.length ; i++){
            if(waitings[i] == null){
                waitings[i] = waiting;
                return true; // 저장 성공
            }
        }
        return false; // 저장 실패
    }

    public static Waiting[] getWaitingList(){
        return waitings; //대기열 배열을 반환
    }


}
