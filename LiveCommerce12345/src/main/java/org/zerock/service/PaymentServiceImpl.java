package org.zerock.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.PaymentVO;
import org.zerock.mapper.PaymentMapper;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public void createPayment(PaymentVO payment) {
        paymentMapper.createPayment(payment);
    }

    @Override
    public PaymentVO getPayment(int paymentID) {
        return paymentMapper.getPayment(paymentID);
    }

    @Override
    public void updatePayment(PaymentVO payment) {
        paymentMapper.updatePayment(payment);
    }

    @Override
    public void deletePayment(int paymentID) {
        paymentMapper.deletePayment(paymentID);
    }

    @Override
    public List<PaymentVO> getAllPayments() {
        return paymentMapper.getAllPayments();
    }
    @Override
    public boolean processPayment(int productId, int quantity) {
        // productId와 quantity를 맵에 담아 매퍼에 전달
        // 결제 처리 후 성공 여부 반환
        // 여기서는 간단히 true로 설정
        return true;
    }
}