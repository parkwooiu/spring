package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.KakaoPaymentVO;

public interface KakaoPaymentMapper {

    // Create
    public void insertKakaoPayment(KakaoPaymentVO kakaoPayment);

    // Read
    public KakaoPaymentVO selectKakaoPayment(int paymentID);
    
    public List<KakaoPaymentVO> selectAllKakaoPayments();

    // Update
    public void updateKakaoPayment(KakaoPaymentVO kakaoPayment);

    // Delete
    public void deleteKakaoPayment(int paymentID);
    
}