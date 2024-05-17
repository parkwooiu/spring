package org.zerock.mapper;

import java.util.List;
import java.util.Map;

import org.zerock.domain.PaymentVO;

public interface PaymentMapper {

    // Create
    public void createPayment(PaymentVO payment);

    // Read
    public PaymentVO getPayment(int paymentID);

    // Update
    public void updatePayment(PaymentVO payment);

    // Delete
    public void deletePayment(int paymentID);

    // Read all payments
    public List<PaymentVO> getAllPayments();
    
    // 결제 처리 메서드
    boolean processPayment(Map<String, Object> paramMap);
    
}