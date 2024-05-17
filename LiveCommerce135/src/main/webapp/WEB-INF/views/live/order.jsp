<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>주문 페이지</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
</head>
<body>
    <h2>주문 페이지</h2>
    <div>
        <!-- 기존 주문 정보 표시 -->
        <h3>상품 정보</h3>
        <p>상품명: ${product.productName}</p>
        <p>가격: ${product.price}원</p>
        <p>설명: ${product.description}</p>
        <p>상품 ID: ${productId}</p>
        <p>수량: ${quantity}</p>
        <p>총 가격: <span id="totalPrice">${product.price * quantity} 원</span></p>
        <p>배송 주소: ${shippingAddress}</p>
        <p>우편번호: ${shippingPostalCode}</p>
    </div>
    
    <!-- 결제 요청 버튼 -->
    <button id="requestPaymentBtn">결제하기</button>

    <script>
        $(document).ready(function() {
            $('#requestPaymentBtn').click(function() {
                var IMP = window.IMP; // 생략 가능
                IMP.init('imp26828762'); // 아임포트 관리자 페이지에서 확인한 가맹점 식별코드

                IMP.request_pay({
                    pg: 'kakaopay',
                    pay_method: 'card',
                    merchant_uid: 'merchant_' + new Date().getTime(),
                    name: '${product.productName}',
                    amount: ${product.price * quantity},
                    buyer_email: 'buyer@example.com',
                    buyer_name: '구매자이름',
                    buyer_tel: '010-1234-5678',
                    buyer_addr: '${shippingAddress}',
                    buyer_postcode: '${shippingPostalCode}'
                }, function(rsp) {
                    if (rsp.success) {
                        // 결제가 성공하면 서버에 결제 결과를 전달
                        $.ajax({
                            url: "/live/kakaoPay",
                            method: "POST",
                            data: {
                                imp_uid: rsp.imp_uid,
                                merchant_uid: rsp.merchant_uid,
                                amount: rsp.paid_amount
                            },
                            success: function(data) {
                                // 결제 성공 페이지로 리다이렉트
                                window.location.href = "/resultPage";
                            }
                        });
                    } else {
                        alert("결제에 실패하였습니다. 에러 내용: " + rsp.error_msg);
                    }
                });
            });
        });
    </script>
</body>
</html>
