package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.OrderVO;
import org.zerock.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/create")
    public String showOrderForm(@RequestParam("productId") int productId,
                                @RequestParam("quantity") int quantity,
                                Model model) {
        // 상품 ID와 수량을 모델에 담아서 주문 페이지로 전달
        model.addAttribute("productId", productId);
        model.addAttribute("quantity", quantity);

        return "order/create"; // 주문 생성 폼으로 이동
    }

    @PostMapping("/create")
    public String createOrder(@RequestParam("productId") int productId,
                              @RequestParam("quantity") int quantity,
                              @RequestParam("shippingAddress") String shippingAddress,
                              @RequestParam("shippingPostalCode") String shippingPostalCode) {
        // 주문 생성 로직 수행
        OrderVO order = new OrderVO(productId, quantity, shippingAddress, shippingPostalCode, null);
        orderService.createOrder(order);

        return "redirect:/order/list"; // 주문 목록 페이지로 이동
    }

    @GetMapping("/list")
    public String showOrderList(Model model) {
        // 주문 목록 조회 로직 수행
        // List<OrderVO> orderList = orderService.getOrderList();
        // model.addAttribute("orderList", orderList);

        return "order/list"; // 주문 목록 페이지로 이동
    }
}
