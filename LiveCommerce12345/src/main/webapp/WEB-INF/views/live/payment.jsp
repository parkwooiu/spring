<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>결제</title>
    <!-- 여기에 필요한 CSS 및 JavaScript 파일을 추가하세요 -->
</head>
<body>
<header>
    <!-- 웹사이트 헤더 정보를 여기에 추가하세요 -->
</header>

<main>
    <h1>결제</h1>
    <!-- 결제 내용을 표시하는 코드를 여기에 추가하세요 -->
    <div class="payment-details">
        <h2>결제 정보</h2>
        <p>상품명: ${product.productName}</p>
        <p>수량: ${quantity}</p>
        <p>총 가격: ${totalPrice}원</p>
        <p>상품 사진: <img src="${product.photo}" alt="${product.productName}" width="300"></p>
        
        <!-- 실제 결제 수단 선택 및 결제 버튼 -->
        <form action="/live/processPayment" method="post">
            <label for="paymentMethod">결제 수단 선택:</label>
            <select id="paymentMethod" name="paymentMethod">
                <option value="카카오페이">카카오페이</option>
                <!-- 다른 결제 수단 옵션을 추가할 수 있음 -->
            </select>
            <input type="submit" value="결제하기">
        </form>
    </div>
</main>

<footer>
    <!-- 웹사이트 푸터 정보를 여기에 추가하세요 -->
</footer>
</body>
</html>