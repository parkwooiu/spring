package org.zerock.service;

import java.util.List;
import java.util.Map;

import org.zerock.domain.PaymentVO;

public interface PaymentService {
    
    void createPayment(PaymentVO payment); // 결제 정보 추가
    
    PaymentVO getPayment(int paymentID); // 특정 결제 정보 조회
    
    void updatePayment(PaymentVO payment); // 결제 정보 수정
    
    void deletePayment(int paymentID); // 결제 정보 삭제
    
    List<PaymentVO> getAllPayments(); // 모든 결제 정보 조회

    /**
     * 카카오페이 결제 준비
     * @param orderId 주문 ID
     * @param amount 결제 금액
     * @return 결제 준비 응답 데이터
     */
    Map<String, Object> kakaoPayReady(Long orderId, Double amount);

    /**
     * 카카오페이 결제 승인
     * @param orderId 주문 ID
     * @param pgToken 결제 승인 토큰
     * @return 결제 승인 성공 여부
     */
    boolean kakaoPayApprove(Long orderId, String pgToken);
}
