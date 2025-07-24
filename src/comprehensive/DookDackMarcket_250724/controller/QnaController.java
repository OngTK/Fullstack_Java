package comprehensive.DookDackMarcket_250724.controller;

// Controller : 통신

import comprehensive.DookDackMarcket_250724.model.dao.QnaDao;

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
    //[5.1]
    //[5.2]
    //[5.3]
    //[5.4]
    //[6] 문의 조회
    //[6.1]
    //[6.2]
    //[6.3]
    //[6.4]

} // class end
