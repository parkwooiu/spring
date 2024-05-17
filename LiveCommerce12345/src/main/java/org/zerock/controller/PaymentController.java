package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.service.PaymentService;

@Controller
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/live/payment")
    public String processPayment(@RequestParam("productId") int productId,
                                 @RequestParam("quantity") int quantity,
                                 RedirectAttributes redirectAttributes) {
        // 결제 서비스를 호출하여 결제를 처리합니다.
        boolean paymentSuccess = paymentService.processPayment(productId, quantity);

        if (paymentSuccess) {
            // 결제가 성공한 경우
            redirectAttributes.addFlashAttribute("message", "결제가 완료되었습니다.");
            return "redirect:/live/success"; // 결제 성공 페이지로 리다이렉트합니다.
        } else {
            // 결제가 실패한 경우
            redirectAttributes.addFlashAttribute("error", "결제에 실패했습니다. 다시 시도해주세요.");
            return "redirect:/live/failure"; // 결제 실패 페이지로 리다이렉트합니다.
        }
    }
}
