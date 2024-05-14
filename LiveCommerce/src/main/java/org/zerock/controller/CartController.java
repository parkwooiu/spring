package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.CartVO;
import org.zerock.service.CartService;
import org.zerock.service.ProductService;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final ProductService productService;

    @Autowired
    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
		this.productService = productService;
    }

    // 모든 카트 목록을 조회하는 페이지
    @GetMapping("/list")
    public String getAllCarts(Model model) {
        model.addAttribute("carts", cartService.getAllCarts());
        model.addAttribute("product", productService.getAllProducts());
        return "/live/cart"; // 카트 목록을 보여주는 뷰로 이동
    }
    

    // 특정 카트의 상세 정보 조회 페이지
    @GetMapping("/{cartID}")
    public String getCart(@PathVariable("cartID") int cartID, Model model) {
        model.addAttribute("cart", cartService.getCart(cartID));
        return "cartDetail"; // 카트 상세 정보를 보여주는 뷰로 이동
    }

    // 카트에 새로운 상품 추가
    @PostMapping
    public String insertCart(CartVO cart) {
        cartService.insertCart(cart);
        return "redirect:/carts"; // 카트 목록 페이지로 리다이렉트
    }

    // 카트 정보 업데이트
    @PostMapping("/{cartID}")
    public String updateCart(@PathVariable("cartID") int cartID, CartVO cart) {
        cart.setCartID(cartID);
        cartService.updateCart(cart);
        return "redirect:/carts/" + cartID; // 업데이트된 카트 상세 정보 페이지로 리다이렉트
    }

    // 카트 삭제
    @PostMapping("/{cartID}/delete")
    public String deleteCart(@PathVariable("cartID") int cartID) {
        cartService.deleteCart(cartID);
        return "redirect:/carts"; // 카트 목록 페이지로 리다이렉트
    }
}