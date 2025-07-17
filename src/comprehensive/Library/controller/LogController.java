package comprehensive.Library.controller;

import comprehensive.Library.model.dao.LogDao;
import comprehensive.Library.model.dto.LogDto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class LogController { // class start
    // dao 가져오기
    private LogDao lDao = LogDao.getInstance();
    // 싱글톤
    private LogController() {}
    private static final LogController instance = new LogController();
    public static LogController getInstance() {
        return instance;
    }

    // 날짜 함수
    public static String nowDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String now = formatter.format( LocalDateTime.now() ) ;
        return now;
    }// 날짜등록 메소드 end

    // 로그 유효성검사 함수
    public LogDto logDtoReturn(int bno){
        for (int i = 0; i < lDao.logDtos().size(); i++){
            if (lDao.logDtos().get(i).getBno() == bno){
                return lDao.logDtos().get(i);
            }// if end
        }// for end
        return null;
    }// func end

    // 도서 대출 함수
    public int borrowBook(int bno){
        LogDto logDto = logDtoReturn(bno);

        int cno = 0;
        if(lDao.logDtos().size() == 0){
            cno = 1;
        } else {
            cno = lDao.logDtos().get(lDao.logDtos().size()-1).getCno() + 1;
        }// if end
        if (BookController.getInstance().getbook(bno)){
            if (logDto == null){
                if (lDao.borrowBook(cno,MemberController.getInstance().userCheck().getMno(), bno ,nowDate())){
                    return 0;
                }// if end
            }else if (logDto.getBno() == bno) {
                if (logDto.getReturnDate() != null){
                    if (lDao.borrowBook(cno,MemberController.getInstance().userCheck().getMno(), bno ,nowDate())){
                        return 0;
                    }// if end
                }else { return 1; } // if end
            }// if end
        }else {return 2;}

        return 2;
    }// func end

    // 도서 반납 함수
    public boolean returnBook(int bno){
        LogDto logDto = logDtoReturn(bno);
        if (BookController.getInstance().getbook(bno)){
            for (int i = 0; i < lDao.logDtos().size(); i++){
                LogDto logDto1 = lDao.logDtos().get(i);
                if (logDto1.getMno() == MemberController.getInstance().userCheck().getMno()){
                    if (logDto1.getReturnDate() == null){
                        return LogDao.getInstance().returnBook(logDto1);
                    }// if end
                }// if end
            }// for end
        }// if end
        return false;
    }// func end

    public ArrayList<LogDto> logCheck() {
        return lDao.logDtos();
    }
}// class end

