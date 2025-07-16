package review.library.controller; // 패키지명

import review.library.model.dao.BookDao;
import review.library.model.dto.BookDto;

import java.util.ArrayList;

public class BookController { // class start
    // dao가져오기
    private BookDao bDao = BookDao.getInstance();
    // 싱글톤
    private BookController() {}
    private static final BookController instance = new BookController();
    public static BookController getInstance() {
        return instance;
    }

    // 북 등록 함수
    public boolean addBook(String btitle , String bwriter ){
        boolean result = false;
        int bno = 0;
        if(bDao.bDtoReturn().size() == 0){
            bno = 1;
        } else {
            bno = bDao.bDtoReturn().get(bDao.bDtoReturn().size()-1).getBno() + 1;
        }// if end
        result =  bDao.addBook(btitle,bwriter,bno);
        return result;
    }// func  end

    // 유효성 검사
    public boolean getbook(int bno){
        for (int i = 0; i < bDao.bDtoReturn().size(); i++){
            BookDto bookDto = bDao.bDtoReturn().get(i);
            if (bookDto.getBno() == bno){
                return true;
            }// if end
        }// for end
        return false;
    }// func end

    public ArrayList<BookDto> bookCheck() {
        return bDao.bDtoReturn();
    }
}// class end

