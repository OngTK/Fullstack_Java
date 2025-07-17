package comprehensive.Library_250715.view;

import comprehensive.Library_250715.controller.BookController;
import comprehensive.Library_250715.controller.LogController;
import comprehensive.Library_250715.controller.MemberController;
import comprehensive.Library_250715.model.dto.BookDto;
import comprehensive.Library_250715.model.dto.LogDto;
import comprehensive.Library_250715.model.dto.MemberDto;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryView {
    private Scanner scan = new Scanner(System.in);
    private BookController bController = BookController.getInstance();
    private LogController lController = LogController.getInstance();
    private MemberController mController = MemberController.getInstance();

    private LibraryView() {}
    private static final LibraryView instance = new LibraryView();
    public static LibraryView getInstance() {
        return instance;
    }

    public void index() {
        for (;;) {
            System.out.println("=========== 도서관리 시스템 ===========");
            System.out.println("  1.회원가입 | 2.로그인");
            System.out.println("==========================================");
            System.out.print("선택 > ");
            int num = scan.nextInt();

            if (num == 1) signUp();
            else if (num == 2) signIn();
        }
    }

    public void signUp() {
        System.out.println("--- 회원 가입 ---");
        System.out.print("아이디 : ");
        String mid = scan.next();
        System.out.print("비밀번호 : ");
        String mpw = scan.next();
        System.out.print("이름 : ");
        String mname = scan.next();
        System.out.print("연락처 : ");
        String mphone = scan.next();

        int result = mController.signUp(mid, mpw, mname, mphone);
        if (result == 0) System.out.println("[안내] 회원가입이 완료되었습니다.");
        else if (result == 1) System.out.println("[경고] 회원가입에 실패하였습니다.");
        else if (result == 2) System.out.println("[안내] 관리자 계정이 등록되었습니다.");
    }

    public void signIn() {
        System.out.println("--- 로그인 ---");
        System.out.print("아이디 : ");
        String mid = scan.next();
        System.out.print("비밀번호 : ");
        String mpw = scan.next();

        int result = mController.signIn(mid, mpw);

        if (result == 0) {
            MemberDto member = mController.userCheck();
            System.out.println("[안내] " + member.getMname() + "님, 환영합니다.");
            userMenu();
        } else if (result == 1) {
            System.out.println("[경고] 계정 정보가 일치하지 않습니다.");
        } else if (result == 2) {
            MemberDto member = mController.userCheck();
            System.out.println("[안내] " + member.getMname() +"님, 환영합니다.");
            adminMenu();
        }
    }

    public void userMenu() {
        for (;;) {
            System.out.println("=========== 도서관리 시스템 ===========");
            System.out.println("  1.도서대출 | 2.도서반납 | 3.내대출현황 | 4.도서목록 | 5.로그아웃");
            System.out.println("================================================================");
            System.out.print("선택 > ");
            int num = scan.nextInt();
            scan.nextLine();

            if (num == 1) borrowBook();
            else if (num == 2) returnBook();
            else if (num == 3) logCheck();
            else if (num == 4) bookCheck();
            else if (num == 5) signOut();
            else System.out.println("[경고] 해당 메뉴는 관리자만 접근 가능합니다.");
        }
    }

    public void adminMenu() {
        for (;;) {
            System.out.println("=========== 도서관리 시스템 ===========");
            System.out.println("  1.도서등록 | 2.도서대출 | 3.도서반납 | 4.내대출현황 | 5.도서목록 | 6.로그아웃");
            System.out.println("================================================================");
            System.out.print("선택 > ");
            int num = scan.nextInt();
            scan.nextLine();

            if (num == 1) addBook();
            else if (num == 2) borrowBook();
            else if (num == 3) returnBook();
            else if (num == 4) logCheck();
            else if (num == 5) bookCheck();
            else if (num == 6) signOut();
            else System.out.println("[경고] 존재하지 않는 메뉴입니다.");
        }
    }

    public void addBook() {
        System.out.println("--- 도서 등록 ---");
        System.out.print("도서명 : ");
        String btitle = scan.nextLine();
        System.out.print("저자 : ");
        String bwriter = scan.nextLine();

        boolean result = bController.addBook(btitle, bwriter);
        if (result) System.out.println("[안내] '" + btitle + "' 도서 등록이 완료되었습니다.");
        else System.out.println("[경고] 도서 등록에 실패하였습니다.");
    }

    public void borrowBook() {
        System.out.println("--- 도서 대출 ---");
        System.out.print("대출할 도서 번호 : ");
        int bno = scan.nextInt();

        int result = lController.borrowBook(bno);
        ArrayList<BookDto> bookResult = bController.bookCheck();

        if (result == 0) {
            for (BookDto book : bookResult) {
                if (bno == book.getBno()) {
                    System.out.println("[안내] '" + book.getBtitle() + "' 도서 대출이 완료되었습니다.");
                    break;
                }
            }
        }
        else if (result == 1) System.out.println("[경고] 이미 대출중인 도서입니다.");
        else if (result == 2) System.out.println("[경고] 존재하지 않는 도서 번호입니다.");
    }

    public void returnBook() {
        System.out.println("--- 도서 반납 ---");
        System.out.print("반납할 도서 번호 : ");
        int bno = scan.nextInt();

        boolean result = lController.returnBook(bno);
        ArrayList<BookDto> bookResult = bController.bookCheck();

        if (result) {
            for (BookDto book : bookResult) {
                if (bno == book.getBno()) {
                    System.out.println("[안내] '" + book.getBtitle() + "' 도서 반납이 완료되었습니다.");
                    break;
                }
            }
        }
        else System.out.println("[경고] 대출중인 도서가 아닙니다.");
    };

    public void logCheck() {
        System.out.println("--- 나의 대출 현황 ---");
        ArrayList<BookDto> bookResult = bController.bookCheck();
        ArrayList<LogDto> logResult = lController.logCheck();
        for (int i=0; i<logResult.size(); i++) {
            LogDto log = logResult.get(i);
            if (MemberController.staticMno == log.getMno()) {
                for(int j = 0 ; j < bookResult.size() ; j++ ){
                    if(bookResult.get(j).getBno() == log.getBno()) {
                        BookDto book = bookResult.get(j);
                        System.out.printf("[%d] %s | %s | 대출일: %s 반납일: %s\n", log.getCno(), book.getBtitle(), book.getBwriter(), log.getBorrowDate()  ,log.getReturnDate()==null?"":log.getReturnDate());
                    }
                }
            }
        }
    }

    public void bookCheck() {
        System.out.println("--- 도서 목록 ---");
        ArrayList<BookDto> bookResult = bController.bookCheck();
        for (int i=0; i<bookResult.size(); i++) {
            BookDto book = bookResult.get(i);
            System.out.printf("[%d] %s | %s\n", book.getBno(), book.getBtitle(), book.getBwriter());
        }
    }

    public void signOut() {
        mController.signOut();
        System.out.println("[안내] 로그아웃 되었습니다.");
        System.out.println("(초기 메뉴 화면으로 돌아감)");
        index();
    }
}

