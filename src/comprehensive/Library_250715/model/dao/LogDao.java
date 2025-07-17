package comprehensive.Library_250715.model.dao;

import comprehensive.Library_250715.controller.LogController;
import comprehensive.Library_250715.model.dto.LogDto;

import java.util.ArrayList;

public class LogDao {// class start
    // 리스트 선언
    private ArrayList<LogDto> logList = new ArrayList<>();
    // 싱글톤
    private LogDao() {}
    private static final LogDao instance = new LogDao();
    public static LogDao getInstance() {
        return instance;
    }

    // 리스트 반환함수
    public ArrayList<LogDto> logDtos(){
        return logList;
    }// func end

    // 도서 대출 함수
    public boolean borrowBook(int cno ,int mno , int bno ,String borrowDate){
        boolean result = false;
        LogDto logDto = new LogDto(cno,mno,bno,borrowDate);
        logList.add(logDto);
        result = true;
        return result;
    }// func end

    // 도서 반납함수
    public boolean returnBook(LogDto logDto){
        boolean result = false;
        logDto.setReturnDate(LogController.nowDate());
        result = true;
        return result;
    }// func end
}// class end

