<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>주문하기</title>
    <!-- 여기에 필요한 CSS 및 JavaScript 파일을 추가하세요 -->
</head>
<body>
<header>
    <!-- 웹사이트 헤더 정보를 여기에 추가하세요 -->
</header>

<main>
    <h1>주문하기</h1>
    <!-- 주문 양식 -->
    <div class="order-form">
        <h2>${product.productName}</h2>
        <p>설명: ${product.description}</p>
        <p>가격: ${product.price}원</p>
        <img src="${product.photo}" alt="${product.productName}" width="300">
        
        <!-- 주문 수량 입력 폼 -->
        <form action="/live/processOrder" method="post">
            <!-- 상품 정보를 hidden input으로 전달 -->
            <input type="hidden" name="productId" value="${product.productId}">
            
            <!-- 주문 수량 입력 -->
            <label for="quantity">수량:</label>
            <input type="number" id="quantity" name="quantity" min="1" value="1">
            
            <!-- 결제 수단 선택 -->
            <label for="paymentMethod">결제 수단:</label>
            <select id="paymentMethod" name="paymentMethod">
                <option value="신용카드">신용카드</option>
                <option value="계좌이체">계좌이체</option>
                <option value="페이팔">페이팔</option>
                <!-- 기타 결제 수단 옵션 추가 -->
            </select>
            
            <!-- 주문 버튼 -->
            <input type="submit" value="주문하기">
        </form>
    </div>
</main>

<footer>
    <!-- 웹사이트 푸터 정보를 여기에 추가하세요 -->
</footer>

<script>
    // 페이지 로드시 초기화 및 값 설정
    document.addEventListener("DOMContentLoaded", function() {
        // quantity와 productId 값을 가져와서 변수에 저장합니다.
        var quantity = document.getElementById("quantity").value;
        var productId = document.getElementById("productId").value;

        // 콘솔에 값 출력하여 확인합니다.
        console.log("Quantity: " + quantity);
        console.log("Product ID: " + productId);
    });
</script>
</body>
</html>
