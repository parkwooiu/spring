<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>프로필</title>
</head>
<body>

<%@ include file="../includes/header.jsp" %>

<h2>프로필</h2>

<c:if test="${empty user}">
    <p>사용자 정보를 불러올 수 없습니다.</p>
</c:if>

<c:if test="${not empty user}">
    <p><strong>사용자 아이디:</strong> ${user.username}</p>
    <p><strong>이메일:</strong> ${user.email}</p>
    <p><strong>배송 주소:</strong> ${user.shippingAddress}</p>
    <p><strong>배송 우편번호:</strong> ${user.shippingPostalCode}</p>
    
    <!-- 수정 버튼 클릭 시 모달 표시 -->
    <button onclick="openModal()">프로필 수정</button>

    <!-- 프로필 수정 모달 -->
    <div id="profileModal" class="modal">
        <div class="modal-content">
            <span class="close" onclick="closeModal()">&times;</span>
            <h3>프로필 수정</h3>
            <form action="/user/update" method="post">
                <label for="email">이메일:</label>
                <input type="text" id="email" name="email" value="${user.email}">
                <label for="shippingAddress">배송 주소:</label>
                <input type="text" id="shippingAddress" name="shippingAddress" value="${user.shippingAddress}">
                <label for="shippingPostalCode">배송 우편번호:</label>
                <input type="text" id="shippingPostalCode" name="shippingPostalCode" value="${user.shippingPostalCode}">
                <button type="submit">저장</button>
            </form>
        </div>
    </div>
</c:if>

<script>
    // 모달 표시 함수
    function openModal() {
        document.getElementById('profileModal').style.display = 'block';
    }

    // 모달 닫기 함수
    function closeModal() {
        document.getElementById('profileModal').style.display = 'none';
    }
</script>

</body>
</html>

<%@ include file="../includes/footer.jsp" %>
