package comprehensive.Practice_05_250711.controller;

import comprehensive.Practice_05_250711.model.dao.WaitingDao;
import comprehensive.Practice_05_250711.model.dto.WaitingDto;

// Controller 역할 : 통신
public class WaitingController {

    // 0. 싱글톤
    private WaitingController(){}
    private static final WaitingController control = new WaitingController();
    public static WaitingController getInstance(){
        return control;
    }

    // dao 싱클톤 객체 가져오기
    private WaitingDao dao = WaitingDao.getInstance();

    // 1. 등록 처리 메소드
    public boolean waitingWrite(String phone, int count){
        WaitingDto waitingDto = new WaitingDto(phone, count);
        boolean result = WaitingDao.getInstance().waitingWrite(waitingDto);
        return result;
    }

    // 2. 조회 처리 메소드
    public WaitingDto[] waitingPrint(){
        WaitingDto[] waitingDB = dao.waitingPrint();
        return waitingDB;
    }
}
