package comprehensive.Practice_07_250722.controller;

// Controller 역할 : 통신

import comprehensive.Practice_07_250722.model.dao.WaitingDao;
import comprehensive.Practice_07_250722.model.dto.WaitingDto;

import java.util.ArrayList;

public class WaitingController {
    // 싱글톤 =======================================
    private WaitingController(){};
    private static final WaitingController instance = new WaitingController();
    public static WaitingController getInstance(){
        return instance;
    }
    // Dao 싱글톤 호출  =======================================
    private WaitingDao waitingDao = WaitingDao.getInstance();

    // 메소드 =======================================

    // 1. 등록
    public boolean addWaiting(String phone, int count){
        WaitingDto waitingDto = new WaitingDto(phone, count);
        waitingDao.addWaiting(waitingDto);
        return true;
    }

    // 2. 조회
    public ArrayList<WaitingDto> getWaitingDB(){
        ArrayList<WaitingDto> waitingDB = waitingDao.getWaitingDB();
        return waitingDB;
    }


} // class end
