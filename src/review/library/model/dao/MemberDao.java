package review.library.model.dao;

import review.library.model.dto.MemberDto;

import java.util.ArrayList;

public class MemberDao {
    private ArrayList<MemberDto> memberList = new ArrayList<>();

    private MemberDao() {}
    private static final MemberDao instance = new MemberDao();
    public static MemberDao getInstance() {
        return instance;
    }

    // 회원가입 메소드
    public boolean signUp(String mid , String mpw , String mname , String mphone){
        boolean result = false;

        int mno = 0;
        if(memberList.size() == 0){
            mno = 1;
        } else {
           mno = memberList.get(memberList.size()-1).getMno() + 1;
        }

        MemberDto member = new MemberDto( mno, mid , mpw , mname , mphone);
        memberList.add(member);
        result = true;
        return result;
    }

    // 로그인 메소드
    public boolean signIn(String mid, String mpw){
        for(int i = 0 ; i < memberList.size() ; i++){
            if ( memberList.get(i).getMid().equals(mid) && memberList.get(i).getMpw().equals(mpw)){
                return true;
            }
        }
        return false;
    }

    //  memberList 조회 메소드
    public ArrayList<MemberDto> getMemberList(){
        return memberList;
    }

}

