package comprehensive.Library_250715.model.dao;

import comprehensive.Library_250715.model.dto.BookDto;

import java.util.ArrayList;

public class BookDao { // class start
    // 리스트 선언
    private ArrayList<BookDto> bookList = new ArrayList<>();
    //싱글톤
    private BookDao() {}
    private static final BookDao instance = new BookDao();
    public static BookDao getInstance() {
        return instance;
    }


    // 리스트 반환
    public ArrayList<BookDto> bDtoReturn(){
        return bookList;
    }// func end

    // 등록함수
    public boolean addBook(String btitle , String bwriter , int bno){
        BookDto bookDto = new BookDto(bno,btitle,bwriter);
        bookList.add(bookDto);
        return true;
    }// func end

}// class end

