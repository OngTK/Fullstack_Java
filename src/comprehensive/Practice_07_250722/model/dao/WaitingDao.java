package comprehensive.Practice_07_250722.model.dao;

import comprehensive.Practice_07_250722.model.dto.WaitingDto;

import java.util.ArrayList;

// Dao 역할 : 실존 데이터에 접근하는 기능 (CRUD)
public class WaitingDao {
    // 싱글톤 =======================================
    private WaitingDao(){};
    private static final WaitingDao instance = new WaitingDao();
    public static WaitingDao getInstance(){
        return instance;
    }

    // 리스트 선언
    ArrayList<WaitingDto> waitingDB = new ArrayList<>();


    // 메소드 =======================================
    
    // 1. 등록
    public boolean addWaiting(WaitingDto waitingDto){
        waitingDB.add(waitingDto);
        return true;
    }

    // 2. 조회
    public ArrayList<WaitingDto> getWaitingDB() {
        return waitingDB;
    }
} // class end