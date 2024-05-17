package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.zerock.domain.KakaoPaymentVO;
import org.zerock.mapper.KakaoPaymentMapper;

@Service
public class KakaoPaymentServiceImpl implements KakaoPaymentService {

    @Autowired
    private KakaoPaymentMapper kakaoPaymentMapper;

    @Override
    public void registerKakaoPayment(KakaoPaymentVO kakaoPayment) {
        // 카카오페이 결제 정보를 데이터베이스에 등록
        kakaoPaymentMapper.insertKakaoPayment(kakaoPayment);
    }

    @Override
    public KakaoPaymentVO getKakaoPayment(int paymentID) {
        // 주어진 결제 ID에 해당하는 카카오페이 결제 정보를 조회
        return kakaoPaymentMapper.selectKakaoPayment(paymentID);
    }

    @Override
    public List<KakaoPaymentVO> getAllKakaoPayments() {
        // 모든 카카오페이 결제 정보를 조회
        return kakaoPaymentMapper.selectAllKakaoPayments();
    }

    @Override
    public void modifyKakaoPayment(KakaoPaymentVO kakaoPayment) {
        // 카카오페이 결제 정보를 수정
        kakaoPaymentMapper.updateKakaoPayment(kakaoPayment);
    }

    @Override
    public void removeKakaoPayment(int paymentID) {
        // 주어진 결제 ID에 해당하는 카카오페이 결제 정보를 삭제
        kakaoPaymentMapper.deleteKakaoPayment(paymentID);
    }
    @Override
    public String saveAndRequestKakaoPay(KakaoPaymentVO kakaoPayment) {
        // 카카오페이 결제 정보를 데이터베이스에 등록
        kakaoPaymentMapper.insertKakaoPayment(kakaoPayment);
        
        // 여기서 결제 요청을 보내고, 결제 승인 URL을 받아옵니다. (실제로는 카카오페이 API를 호출하여 처리)
        String approvalUrl = "https://mock-kakao-payments.com/approval"; // 가짜 URL
        
        return approvalUrl; // 가짜 URL 반환
    }
 
    @Override
    public boolean verifyPayment(String impUid) {
        // 아임포트 API를 호출하여 결제 검증
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://api.iamport.kr/payments/" + impUid;
        String apiKey = "imp26828762"; // 아임포트 API 키
        String apiSecret = "TwyhG0bJ9GhPenHBi2gNwTBfvLgXypi5nC1ISvh7LR4KV3EHtAIQnc4kYP6PqEHJhHuoPcqUaXY2oqi2"; // 아임포트 API 시크릿

        // 아임포트 API 토큰 발급
        String tokenUrl = "https://api.iamport.kr/users/getToken";
        String tokenResponse = restTemplate.postForObject(tokenUrl, null, String.class);

        // 토큰을 이용하여 결제 검증 요청
        String paymentResponse = restTemplate.getForObject(apiUrl + "?_token=" + tokenResponse, String.class);
        
        // 결제 검증 결과를 파싱하여 반환
        // 여기서는 간단히 성공 여부만 반환하도록 예시를 작성했습니다.
        return paymentResponse.contains("\"status\":\"paid\"");
    }
}

