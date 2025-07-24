package comprehensive.Practice_08_250723.controller;

// Controller : 통신

import comprehensive.Practice_08_250723.model.dao.WaitingDao;
import comprehensive.Practice_08_250723.model.dto.WaitingDto;

import java.util.ArrayList;

public class WaitingController {
    // 싱글톤 =======================================
    private WaitingController() { //Dao 객체 생성과 동시에 DB 연동 시작
    }

    private static final WaitingController instance = new WaitingController();

    public static WaitingController getInstance() {
        return instance;
    }

    // Dao 싱글톤 호출  =======================================
    private WaitingDao waitingDao = WaitingDao.getInstance();
    // 메소드 =======================================


    //[1] 대기 등록
    public boolean waitingRegi(String phone, int count) {
        //[1.1] 매개변수 > dto 객체 만들기
        WaitingDto waitingDto = new WaitingDto(0, phone, count);
        //[1.2] dto에 waitingRegi 실행
        boolean result = waitingDao.waitingRegi(waitingDto);
        //[1.3] view에 결과 반환
        if (result) {
            return true;
        } else {
            return false;
        }
    }//func end

    //[2] 전체 대기 조회
    public ArrayList<WaitingDto> waitingPrint() {
        //[2.1] dao에 waitingPrint 메소드 실행
        ArrayList<WaitingDto> waitingList = waitingDao.waitingPrint();
        //[2.2] view에 결과 반환
        return waitingList;
    }//func end

    //[3] 대기 삭제
    public boolean waitingDelete(int wno) {
        //[3.1] dao의 waitingDelete 메소드 실행
        boolean result = waitingDao.waitingDelete(wno);
        //[3.2] view에 결과 반환
        if (result) {
            return true;
        } else {
            return false;
        }
    }//func end

    //[4] 대기 수정
    public boolean waitingUpdate(int wno, int count) {
        //[4.1] 매개변수로 dto 객체 생성
        WaitingDto waitingDto = new WaitingDto(wno, null, count);
        //[4.2] dao의 waitingUpdate 실행
        boolean result = waitingDao.waitingUpdate(waitingDto);
        //[4.3] view에 결과 반환
        if (result) {
            return true;
        } else {
            return false;
        }
    }
} // class end
