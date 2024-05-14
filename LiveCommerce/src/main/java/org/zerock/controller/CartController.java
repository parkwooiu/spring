package org.zerock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.CartVO;
import org.zerock.domain.ProductVO;
import org.zerock.service.CartService;
import org.zerock.service.ProductService;
import org.zerock.service.UserService;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/cart")
@Log4j
public class CartController {

    private final CartService cartService;
    private final ProductService productService;
    private final UserService userService;

    @Autowired
    public CartController(CartService cartService, ProductService productService, UserService userService) {
        this.cartService = cartService;
        this.productService = productService;
        this.userService = userService;
    }

    // 메인 페이지
    @GetMapping("/list")
    public String home(Model model) {
        // 현재 로그인한 사용자의 정보 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        log.info(username);
        
        // 사용자 정보를 이용하여 userID 가져오기
        int userID = userService.getUserIDByUsername(username);
        log.info(userID);

        // 사용자의 장바구니 정보 가져오기
        List<CartVO> carts = cartService.getCartByUserID(userID);
        model.addAttribute("carts", carts);
        log.info(carts);

        // 상품 정보를 가져와서 모델에 추가
        List<ProductVO> products = productService.getAllProducts();
        model.addAttribute("products", products);

        // 현재 로그인한 사용자 정보 가져와서 모델에 추가 (예시)
        // 사용자 이름이나 다른 정보를 화면에 표시할 수 있음
        model.addAttribute("username", username);

        return "/live/cart";
    }
}