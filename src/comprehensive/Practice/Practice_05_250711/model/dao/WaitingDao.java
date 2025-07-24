package comprehensive.Practice_05_250711.model.dao;

import comprehensive.Practice_05_250711.model.dto.WaitingDto;

// Dao 역할 : 실존 데이터에 접근하는 기능 (CRUD)
public class WaitingDao {

    // 싱글톤
    private WaitingDao(){}
    private static final WaitingDao dao = new WaitingDao();
    public  static WaitingDao getInstance(){
        return dao;
    }

    // 멤버변수 private
    private WaitingDto[] waitingDb = new WaitingDto[100];

    // 1. 등록 처리 메소드
    // controller 로 부터 배열에 저장할 객체를 받아와서 저장
    // 매개변수 : Dto
    // return boolean
    public boolean waitingWrite(WaitingDto waitingDto){
        for(int i =0; i < waitingDb.length ; i++){
            if(waitingDb[i] == null){
                waitingDb[i] = waitingDto;
                return true;
            }
        }
        return false;
    }

    // 2. 조회 처리 메소드
    // controller에 모든 배열을 반환
    // 매개변수 : X
    // return Dto
    public WaitingDto[] waitingPrint(){
        return waitingDb;
    }
}
