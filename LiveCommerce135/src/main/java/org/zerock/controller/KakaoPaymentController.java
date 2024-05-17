package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.KakaoPaymentVO;
import org.zerock.service.KakaoPaymentService;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/live")
public class KakaoPaymentController {

    @Autowired
    private KakaoPaymentService kakaoPaymentService;

    @PostMapping("/kakaoPay")
    public String kakaoPay(@RequestParam("imp_uid") String impUid,
                           @RequestParam("merchant_uid") String merchantUid,
                           @RequestParam("amount") int amount) {
        // 아임포트 서버에서 결제 정보를 조회하여 검증
        Map<String, String> result = kakaoPaymentService.verifyPayment(impUid, merchantUid, amount);
        if ("success".equals(result.get("status"))) {
            // 결제 정보가 유효하면 데이터베이스에 저장
            KakaoPaymentVO kakaoPayment = new KakaoPaymentVO();
            kakaoPayment.setOrderID(Integer.parseInt(merchantUid.split("_")[1])); // 예시로 주문 ID를 파싱
            kakaoPayment.setAmount(amount);
            kakaoPayment.setPaymentMethod("kakaopay");
            kakaoPayment.setKakaoTransactionID(impUid);
            kakaoPayment.setStatus("paid");
            kakaoPaymentService.registerKakaoPayment(kakaoPayment);
            return "redirect:/resultPage"; // 결제 결과 페이지로 리다이렉트
        } else {
            return "redirect:/paymentFailed"; // 결제 실패 페이지로 리다이렉트
        }
    }
}
