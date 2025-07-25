package comprehensive.DookDackMarcket_250724.controller;

// Controller : 통신

import comprehensive.DookDackMarcket_250724.model.dao.QnaDao;
import comprehensive.DookDackMarcket_250724.model.dto.QnaDto;

import java.util.ArrayList;

public class QnaController {
    // 싱글톤 =======================================
    private QnaController() {
    }

    ;
    private static final QnaController instance = new QnaController();

    public static QnaController getInstance() {
        return instance;
    }

    // Dao 싱글톤 호출  =======================================
    private QnaDao qnaDao = QnaDao.getInstance();

    // 메소드 =======================================

    //[5] 문의 등록
    public boolean qnaRegi(int pNo, String qQuestioner, String qContent, String qPw) {
        //[5.1] qnaDto 객체 만들기
        QnaDto qnaDto = new QnaDto(0, pNo, qQuestioner, qContent, qPw, "");
        //[5.2] dao에 qnaRegi 메소드 실행
        boolean result = QnaDao.getInstance().qnaRegi(qnaDto);
        //[5.3] 결과 반환
        return result;
    }

    //[9] 물품(문의) 상세 조회
    public ArrayList<QnaDto> qnaSearch(int pNo)  {
        //[6.1] dao에 pno 전달 및 qnaSearch 실행
        ArrayList<QnaDto> qnaList = qnaDao.qnaSearch(pNo);
        //[6.2] 결과 반환
        return qnaList;
    }

} // class end
