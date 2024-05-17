package org.zerock.service;

import org.zerock.domain.KakaoPaymentVO;

import java.util.List;
import java.util.Map;

public interface KakaoPaymentService {

    // 카카오페이 결제 정보 등록
    void registerKakaoPayment(KakaoPaymentVO kakaoPayment);

    // 주어진 결제 ID에 해당하는 카카오페이 결제 정보 조회
    KakaoPaymentVO getKakaoPayment(int paymentID);

    // 모든 카카오페이 결제 정보 조회
    List<KakaoPaymentVO> getAllKakaoPayments();

    // 카카오페이 결제 정보 수정
    void modifyKakaoPayment(KakaoPaymentVO kakaoPayment);

    // 카카오페이 결제 정보 삭제
    void removeKakaoPayment(int paymentID);



    /**
     * 카카오페이 결제 정보를 저장하고, 결제를 요청하여 결제 승인 URL을 반환합니다.
     * @param kakaoPayment 카카오페이 결제 정보 객체
     * @return 결제 승인 URL
     */
    String saveAndRequestKakaoPay(KakaoPaymentVO kakaoPayment);

    /**
     * 결제 검증 메서드
     * @param impUid 아임포트 거래 고유 번호
     * @return 결제 검증 결과
     */
    boolean verifyPayment(String impUid);
}
