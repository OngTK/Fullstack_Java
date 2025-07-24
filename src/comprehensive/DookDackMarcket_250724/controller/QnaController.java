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

    //[1] 문의 등록
    //[1.1]
    //[1.2]
    //[1.3]
    //[1.4]
    //[2] 문의 조회
    //[2.1]
    //[2.2]
    //[2.3]
    //[2.4]


    //[3]
    //[3.1]
    //[3.2]
    //[3.3]
    //[3.4]
    //[4]
    //[4.1]
    //[4.2]
    //[4.3]
    //[4.4]
    //[5]
    //[5.1]
    //[5.2]
    //[5.3]
    //[5.4]
} // class end
