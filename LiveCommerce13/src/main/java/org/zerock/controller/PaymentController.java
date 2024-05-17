package org.zerock.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.service.PaymentService;

@Controller
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/live/kakaoPay")
    @ResponseBody
    public Map<String, Object> kakaoPay(@RequestParam Long orderId, @RequestParam Double amount) {
        return paymentService.kakaoPayReady(orderId, amount);
    }

    @GetMapping("/live/kakaoPaySuccess")
    public String kakaoPaySuccess(@RequestParam("pg_token") String pgToken, @RequestParam Long orderId, Model model) {
        boolean paymentSuccess = paymentService.kakaoPayApprove(orderId, pgToken);
        if (paymentSuccess) {
            model.addAttribute("message", "결제가 성공적으로 완료되었습니다.");
        } else {
            model.addAttribute("message", "결제에 실패했습니다. 다시 시도해주세요.");
        }
        return "paymentResult";
    }

    @GetMapping("/live/kakaoPayCancel")
    public String kakaoPayCancel(Model model) {
        model.addAttribute("message", "결제가 취소되었습니다.");
        return "paymentResult";
    }

    @GetMapping("/live/kakaoPayFail")
    public String kakaoPayFail(Model model) {
        model.addAttribute("message", "결제에 실패했습니다.");
        return "paymentResult";
    }
}