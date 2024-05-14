<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>장바구니</title>
</head>
<body>
    <h2>장바구니</h2>
    ${products}
    
    <table>
        <thead>
            <tr>
                <th>상품명</th>
                <th>가격</th>
                <th>수량</th>
                <!-- 기타 필요한 컬럼들 -->
            </tr>
        </thead>
        <tbody>
            <!-- 장바구니 목록을 반복해서 표시 -->
            <c:forEach items="${carts}" var="cart">
                <tr>
                 
                    <td>${cart.productID}</td>
                    <td>${cart.userID}</td>
                    
                   
                    
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>