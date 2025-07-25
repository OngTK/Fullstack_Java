package comprehensive.DookDackMarcket_250724.view;


import comprehensive.DookDackMarcket_250724.controller.ProductController;
import comprehensive.DookDackMarcket_250724.controller.QnaController;
import comprehensive.DookDackMarcket_250724.model.dto.ProductDto;
import comprehensive.DookDackMarcket_250724.model.dto.QnaDto;
import comprehensive.DookDackMarcket_250724.model.dto.RankingDto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// View : 게시물 관련 입출력

public class MarketView {
    // 싱글톤 선언 =======================================
    private MarketView() {
    }

    ;
    private static final MarketView instance = new MarketView();

    public static MarketView getInstance() {
        return instance;
    }

    // Controller 싱글톤 호출  =======================================
    private ProductController pController = ProductController.getInstance();
    private QnaController qController = QnaController.getInstance();

    // 0. 여러 메소드에서 사용할 입력 객체를 입력변수로 선언 =================================
    private Scanner scan = new Scanner(System.in);

    // 화면 구성 =================================
    public void index() {
        for (; ; ) {
            System.out.println("============================= 뚝딱마켓 =============================");
            System.out.println("1. 중고 물품 등록 | 2. 물품 목록 조회 | 3. 물품 정보 수정 | 4. 물품 삭제");
            System.out.println("5. 문의 남기기    | 6. 물품 상세 조회 | 7. 등록 랭킹 조회 | 8. 검색");
            System.out.println("====================================================================");
            System.out.print("선택 > ");
            int choice = scan.nextInt();

            try {
                if (choice == 1) {
                    productRegi();      // 1. 물품등록
                } else if (choice == 2) {
                    productPrint();     // 2. 물품 목록 조회
                } else if (choice == 3) {
                    productUpdate();    // 3. 물품 정보 수정
                } else if (choice == 4) {
                    productDelete();    // 4. 물품 삭제
                } else if (choice == 5) {
                    qnaRegi();          // 5. 문의 남기기
                } else if (choice == 6) {
                    productSearch();    // 6. 물품 상세 조회
                } else if (choice == 7) {
                    rankingPrint();     // 7. 등록 랭킹 조회
                } else if (choice == 8) {
                    // TODO 8. 검색
                } else {
                    System.out.println("[경고] 올바르지 못한 기능입니다.");
                }
            } catch (InputMismatchException e) {
                System.out.println("[경고] 입력 타입이 올바르지 못합니다.");
            } catch (Exception e) {
                System.out.println("[경고] 관리자에게 문의하세요.");
            }
        }// infinity loop end
    } // func end

    //[1]물품등록
    public void productRegi() {
        //[1.1] user에게 정보 받기
        scan.nextLine();
        System.out.print("판매자 닉네임 : ");
        String pSeller = scan.nextLine();
        System.out.print("물품명 : ");
        String pName = scan.nextLine();
        System.out.print("설명 : ");
        String pMemo = scan.nextLine();
        System.out.print("가격 : ");
        int pPrice = scan.nextInt();
        System.out.print("비밀번호 : ");
        String pPw = scan.next();

        //[1.2] controller에서 productRegi 실행
        // productRegi(String pSeller, String pName, String pMemo, int pPrice, String pPW)
        boolean result = pController.productRegi(pSeller, pName, pMemo, pPrice, pPw);

        //[1.3] 결과 반환에 따른 출력
        if (result) {
            System.out.println("[안내] 물품이 성공적으로 등록되었습니다.");
        } else {
            System.out.println("[경고] 물품 등록을 실패하였습니다.");
        }

    }

    //[2] 물품 목록 조회
    public void productPrint() {
        //[2.1] pControeller 에서 productPrint() 실행
        ArrayList<ProductDto> productList = pController.productPrint();

        //[2.2] 목록 상단 기본 화면
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("no \t 물품명 \t 가격 \t 닉네임 \t 등록일 \t 판매여부 ");
        System.out.println("------------------------------------------------------------------------------");

        //[2.3]list 반복문으로 출력
        for (ProductDto productDto : productList) {
//            System.out.println(productDto.toString());
            String status = "";
            if (productDto.getsStatus()) {
                status = "판매중";
            } else {
                status = "판매완료";
            }
            System.out.printf("%d \t %s \t %d \t %s \t %s \t %s \n",
                    productDto.getpNo(),
                    productDto.getpName(),
                    productDto.getpPrice(),
                    productDto.getpSeller(),
                    productDto.getpDate(),
                    status);
            System.out.println("------------------------------------------------------------------------------");
        }
    } //func end

    //[3] 물품 수정 ========================
    public void productUpdate() {
        //[3.1] 물품번호, 비밀번호를 받아 유효성 검사 시행
        //[3.1.1] 물품번호, 비밀번호를 받기
        System.out.print("물품번호 : ");
        int pNo = scan.nextInt();
        System.out.print("비밀번호 : ");
        String pPw = scan.next();

        //[3.1.2] pConsoller의 productCheck 실행
        boolean check = pController.productCheck(pNo, pPw);
        if (check == false) {
            System.out.println("[경고] 물품 정보가 올바르지 않습니다."); //pNo, pPw 불일치
        } else { // pNo, pPw가 참일 경우,
            //[3.2] 수정할 정보 받아오기
            System.out.println("------------------ 물품 정보 수정 ------------------");
            scan.nextLine();
            System.out.print("물품명 : ");
            String pName = scan.nextLine();
            System.out.print("설명 : ");
            String pMemo = scan.nextLine();
            System.out.print("가격 : ");
            int pPrice = scan.nextInt();
            System.out.print("판매여부 : ");
            String stauts = scan.next();

            // [3.3] pController에 productUpdate 실행
            int result = pController.productUpdate(pNo, pName, pMemo, pPrice, stauts);

            // [3.4] 결과 출력
            if (result == 0) {
                System.out.println("[경고] 입력 값이 올바르지 못합니다."); // 입력값 유효성 검사 실패
            } else if (result == 1) {
                System.out.println("[안내] 물품이 성공적으로 등록되었습니다.");
            } else if (result == 2) {
                System.out.println("[경고] 물품 등록을 실패하였습니다.");
            }
        }
    } // func


    //[4] 4. 물품 삭제
    public void productDelete() {
        //[4.1] 화면 구성
        System.out.print("물품번호 : ");
        int pNo = scan.nextInt();
        System.out.print("비밀번호 : ");
        String pPw = scan.next();

        //[4.2] pController에 productDelete 실행
        boolean result = pController.productDelete(pNo, pPw);
        //[4.3] 결과 출력
        if (result) {
            System.out.println("[안내] 물품이 성공적으로 삭제되었습니다.");
        } else {
            System.out.println("[경고] 물품 삭제를 실패하였습니다.");
        }
    }//func end

    //[5] 문의 등록
    public void qnaRegi() {
        //[5.1] user에게 정보 받기
        System.out.print("물품번호 : ");
        int pNo = scan.nextInt();
        scan.nextLine();
        System.out.print("문의자 닉네임 : ");
        String qQuestioner = scan.nextLine();
        System.out.print("문의내용 : ");
        String qContent = scan.nextLine();
        System.out.print("비밀번호 : ");
        String qPw = scan.next();

        //[5.2] qController에 qnaRegi() 실행
        boolean result = qController.qnaRegi(pNo, qQuestioner, qContent, qPw);
        //[5.3] 결과 출력
        if (result) {
            System.out.println("[안내] 문의글을 정상적으로 등록하였습니다.");
        } else {
            System.out.println("[경고] 문의글 등록을 실패하였습니다.");
        }
    } //func end

    //[6] 물품 상세 조회
    public void productSearch() {
        //[6.1] user에게 물품 번호 받기
        System.out.print("물품번호 : ");
        int pNo = scan.nextInt();

        //[6.2] pcon 에서 물품정보 조회
        ProductDto productDto = pController.productSearch(pNo);

        String status = "";
        if (productDto.getsStatus() == true) {
            status = "판매완료";
        } else {
            status = "판매중";
        }

        //[6.3] pno 물품 정보 출력
        System.out.println(" --------------------- 물품 상세 조회 ---------------------");
        System.out.println("물품명 : " + productDto.getpName());
        System.out.println("설명 : " + productDto.getpMemo());
        System.out.println("가격 : " + productDto.getpPrice());
        System.out.println("판매여부 : " + status);

        //[6.4] pNo를 qcon에 보내서 qnaSearch 실행
        ArrayList<QnaDto> qnaList = qController.qnaSearch(pNo);

        //[6.5] 반복문을 돌면서 qna 출력
        System.out.println(" --------------------- 물품 문의글 ---------------------");
        for (QnaDto qnaDto : qnaList) {
            System.out.println("문의번호 : " + qnaDto.getqNO());
            System.out.println("문의자 닉네임 : " + qnaDto.getqQuestioner());
            System.out.println("문의 내용 : " + qnaDto.getqContent());
            System.out.println("------------------------------------------");
        }
    } // func end

    // [7] 랭킹조회
    public void rankingPrint() {
        // [7.1] pcon에서 rankingPrint 실행
        ArrayList<RankingDto> rankList = pController.rankingPrint();
        // [7.2] 반복문을 돌면서 출력
        System.out.println("-------------- 등록 랭킹 조회 --------------");
        System.out.println("랭킹 \t 닉네임 \t 등록수");
        System.out.println("------------------------------------------------");
        for(int i = 0 ; i < rankList.size() ; i++){
            System.out.printf("%d \t %s \t %d \n",i+1,rankList.get(i).getpSeller(),rankList.get(i).getCount());
        }
        // [7.3]
        // [7.4]
    }

} //class end
