package comprehensive.DookDackMarcket_250724.controller;

// Controller : 통신

import comprehensive.DookDackMarcket_250724.model.dao.ProductDao;
import comprehensive.DookDackMarcket_250724.model.dto.ProductDto;

import java.util.ArrayList;

public class ProductController {
    // 싱글톤 =======================================
    private ProductController() {
    }

    ;
    private static final ProductController instance = new ProductController();

    public static ProductController getInstance() {
        return instance;
    }

    // Dao 싱글톤 호출  =======================================
    private ProductDao productDao = ProductDao.getInstance();

    // 메소드 =======================================

    //[1] 물품 등록 ========================
    public boolean productRegi(String pSeller, String pName, String pMemo, int pPrice, String pPW) {
        //[1.1] productDto 객체 생성
        //ProductDto(int pNo, String pName, String pSeller, String pMemo, int pPrice, String pPw, String pDate, boolean pStatus) 생성자
        ProductDto productDto = new ProductDto(0, pName, pSeller, pMemo, pPrice, pPW, "", false);
//        System.out.println(productDto.toString());

        //[1.2] Dto의 productRegi 실행
        boolean result = productDao.productRegi(productDto);


        //[1.3] view에 결과 반환
        return result;
    } //func end

    //[2] 물품 조회 ========================
    public ArrayList<ProductDto> productPrint() {
        //[2.1] Dao에 productPrint() 실행
        ArrayList<ProductDto> productList = productDao.productPrint();
        //[2.2] view에 결과 반환
        return productList;
    } // func end

    //[3] 물품 수정 ========================
    public int productUpdate(int pNo, String pName, String pMemo, int pPrice, String status) {
        //[3.1] pNo로 dao에 productSearch(int pNo) 실행
        ProductDto productDto = productDao.productSearch(pNo);
        //[3.2] String status 를 boolean pStatus로 변환
        boolean pStatus = false;
        if (status.equals("판매중")) {
            pStatus = false;
        } else {
            pStatus = true;
        }
        ;

        //[3.3] 입력 매개변수가 null인지 확인
        if (pName.equals("") || pMemo.equals("") || pPrice == 0 || status.equals("") ||
                !(status.equals("판매중") || status.equals("판매완료"))) {
            return 0;
        }

        //[3.4] productDto의 정보를 매개변수로 수정
        productDto.setpName(pName);
        productDto.setpMemo(pMemo);
        productDto.setpPrice(pPrice);
        productDto.setpStatus(pStatus);
//        System.out.println(productDto);

        //[3.5] productDto를 DB 수정을 위해 dao에 전달
        boolean result = productDao.productUpdate(productDto);

        //[3.6] 결과 반환
        if (result) {
            return 1;
        }
        return 2;
    } //func end

    //[4] 물품 삭제 ========================
    public boolean productDelete(int pNo, String pPw) {
        //[4.1] pno, ppw 유효성 검사
        boolean result = productCheck(pNo, pPw);
        if(result == false){
            return false;
        }
        //[4.2] pNo를 매개변수로 dao에 productDelete 실행
        result = productDao.productDelete(pNo);

        //[4.3] 결과 반환
        return result;
    } //func end

    //[6] 물품 상세 조회 ========================
    public ProductDto productSearch(int pNo) {
        //[6.1] pController에 productSearch 실행
        ProductDto productDto = productDao.productSearch(pNo);
        //[6.2] 결과를 반환
        return productDto;
    } // func end

    //[7] 랭킹조회 ========================
    //[7.1]
    //[7.2]
    //[7.3]
    //[7.4]
    //[8] 키워드 검색 조회 ========================
    //[8.1]
    //[8.2]
    //[8.3]
    //[8.4]

    //[10] 물품번호, 비밀번호 유효성 검사 ========================
    public boolean productCheck(int pNo, String pPw) {
        //[10.1] productSearch(pNo)로 해당 상품 정보를 조회
        ProductDto productDto = productDao.productSearch(pNo);
        //[10.2] 비밀번호 일치여부를 확인
        if (productDto.getpPw().equals(pPw)) {
            return true; // 비밀번호 일치
        }
        return false;   // 비밀번호 불일치
    } //func end

} // class end
