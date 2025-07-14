package comprehensive.Practice_06_250714.model.dao;

import comprehensive.Practice_06_250714.model.dto.WaitingDto;

import java.util.ArrayList;

// Dao 역할 : 실존 데이터에 접근하는 기능 (CRUD)
public class WaitingDao {
    // 싱글톤
    private WaitingDao(){};
    private static final WaitingDao waitingDao = new WaitingDao();
    public static WaitingDao getInstance(){
        return waitingDao;
    }
    // 멤버변수 private
    private ArrayList<WaitingDto> waitingDB = new ArrayList<>();

    // 1. 등록 처리 메소드
    // controller 로 부터 배열에 저장할 객체를 받아와서 저장
    // 매개변수 : String phone , int count
    // return boolean

    public boolean addWaiting(String phone , int count){
        boolean result = false;

        WaitingDto waitingDto = new WaitingDto(phone, count);
        waitingDB.add(waitingDto);
        result = true;

        return result;
    }

    // 2. 조회 처리 메소드
    // controller에 모든 배열을 반환
    // 매개변수 : X
    // return array
    public ArrayList<WaitingDto> getWaitingList(){
        return  waitingDB;
    }

}
