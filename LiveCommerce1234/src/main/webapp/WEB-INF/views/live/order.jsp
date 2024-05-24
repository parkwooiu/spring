<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<%@ include file="../includes/header.jsp" %>

<style>
    button#requestPaymentBtn {
        border: none; /* 버튼 테두리 제거 */
        background: none; /* 버튼 배경 제거 */
        padding: 0; /* 내부 여백 제거 */
    }
    
</style>

<body>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
       <title>주문 페이지</title>
      <div style="text-align: center;">
       <h2>주문 페이지</h2>
          <!-- 기존 주문 정보 표시 -->
          <h3>상품 정보</h3>
          <p>상품명: ${product.productName}</p>
          <p>가격: ${product.price}원</p>
          <p>설명: ${product.description}</p>
          <p>수량: ${quantity}</p>
          <p>총 가격: <span id="totalPrice">${product.price * quantity} 원</span></p>
          <p>배송 주소: ${shippingAddress}</p>
          <p>우편번호: ${shippingPostalCode}</p>
          <!-- 카카오페이 결제 폼 -->
          <form id="kakaoPayForm" action="/live/kakaoPay" method="post">
             <input type="hidden" name="orderId" value="${order.orderID}">
             <input type="hidden" name="amount" value="${product.price * quantity}">
             <input type="hidden" name="buyerEmail" value="${user.email}">
             <input type="hidden" name="buyerName" value="${user.username}">
             <input type="hidden" name="productName" value="${product.productName}">
             <!-- 기타 필요한 숨은 입력 필드를 여기에 추가하세요 -->
             <button id="requestPaymentBtn" type="submit"><img src="/resources/images/order.png" alt="결제하기"></button>
         </form>
      </div>
    <script>
        // 페이지 로드 시 실행되는 함수
        $(document).ready(function() {
            // 결제하기 버튼 클릭 시 폼을 서버로 제출
            $('#requestPaymentBtn').click(function() {
                $('#kakaoPayForm').submit();
            });
        });
    </script>
</body>
</html>

<%@ include file="../includes/footer.jsp" %>