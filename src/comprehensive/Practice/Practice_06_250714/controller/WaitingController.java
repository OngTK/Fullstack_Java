package comprehensive.Practice_06_250714.controller;

import comprehensive.Practice_06_250714.model.dao.WaitingDao;
import comprehensive.Practice_06_250714.model.dto.WaitingDto;

import java.util.ArrayList;

// Controller 역할 : 통신
public class WaitingController {
    //싱글톤
    private WaitingController(){}
    private static final WaitingController controller = new WaitingController();
    public static WaitingController getInstance(){
        return controller;
    }

    // dao 싱글톤 호출
    private WaitingDao waitingDao = WaitingDao.getInstance();

    // 1. 등록 처리 메소드
    public boolean addWaiting(String phone, int count){
        return waitingDao.addWaiting(phone,count);
    }

    // 2. 조회 처리 메소드
    public ArrayList<WaitingDto> getWaitingList(){
        return waitingDao.getWaitingList();
    }


}
