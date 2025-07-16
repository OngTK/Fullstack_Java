package review.library.controller;

import review.library.model.dao.MemberDao;
import review.library.model.dto.MemberDto;

import java.util.ArrayList;

public class MemberController {
    private MemberDao mDao = MemberDao.getInstance();
    private ArrayList<MemberDto> memberList = mDao.getMemberList();
    public static int staticMno = 0;

    private MemberController() {}
    private static final MemberController instance = new MemberController();
    public static MemberController getInstance() {
        return instance;
    }


    // 1. 회원가입 메소드
    public int signUp(String mid, String mpw, String mname, String mphone) {
        boolean memberResult = mDao.signUp(mid, mpw, mname, mphone);
        if (memberResult) { // 회원가입 성공
            if (mname.equals("admin")) {
                return 2; // 관리자 회원가입
            } else {
                return 0; // 회원가입 성공}
            }
        }
        return 1; // 회원가입 실패
    }

    // 2. 로그인 메소드
    public int signIn(String mid, String mpw){
        boolean signinResult = mDao.signIn(mid, mpw);

        if(signinResult){ // 로그인 성공
            // staticMno 저장
            for(int i = 0 ; i < memberList.size() ; i++ ){
                if(memberList.get(i).getMid().equals(mid)){
                    staticMno = memberList.get(i).getMno();
                }
            };
            // 로그인 결과 반환
            if( mid.equals("admin")){
                return 2 ; // 관리자 로그인
            } else {
                return 0 ; // 일반 사용자 로그인
            }
        }
        return 1;  // 로그인 실패
    }

    // 3. 로그아웃 메소드
    public void signOut(){
        staticMno = 0;
    }

    // 9. 로그인 유저 정보 조회
    public MemberDto userCheck(){
        MemberDto member = null;
        for(int i = 0 ; i < memberList.size() ; i++ ){
            if(memberList.get(i).getMno() == staticMno)
                member = memberList.get(i);
        }
        return member;
    }

}


