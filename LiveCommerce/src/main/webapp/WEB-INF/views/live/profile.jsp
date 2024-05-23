<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<%@ include file="../includes/header.jsp" %>

<html>
<head>
    <title>프로필</title>
    <!-- 부트스트랩 링크 추가 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 20px;
        }
        .profile-container {
            max-width: 600px;
            margin: 50px auto;
            padding: 30px;
            background-color: #ffffff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .profile-header {
            text-align: center;
            margin-bottom: 30px;
        }
        .profile-header h2 {
            color: #343a40;
        }
        .profile-info p {
            font-size: 16px;
            color: #495057;
            margin-bottom: 10px;
        }
        .profile-info p strong {
            color: #212529;
        }
        .btn-primary {
            background-color: #007bff;
            border-color: #007bff;
            width: 100%;
            padding: 10px;
            margin-top: 20px;
        }
        .btn-primary:hover {
            background-color: #0056b3;
            border-color: #0056b3;
        }
        .modal-header {
            background-color: #007bff;
            color: #fff;
        }
        .form-group label {
            font-weight: bold;
        }
    </style>
</head>
<body>

<div class="profile-container">
    <div class="profile-header">
        <h2>프로필</h2>
    </div>

    <c:if test="${empty user}">
        <div class="alert alert-danger" role="alert">
            사용자 정보를 불러올 수 없습니다.
        </div>
    </c:if>

    <c:if test="${not empty user}">
        <div class="profile-info">
            <p><strong>사용자 아이디:</strong> ${user.username}</p>
            <p><strong>이메일:</strong> ${user.email}</p>
            <p><strong>배송 주소:</strong> ${user.shippingAddress}</p>
            <p><strong>배송 우편번호:</strong> ${user.shippingPostalCode}</p>
        </div>
        <!-- 개인정보 수정 버튼 추가 -->
        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#profileModal">개인정보 수정</button>
    </c:if>
</div>

<!-- 개인정보 수정 모달 창 -->
<div class="modal fade" id="profileModal" tabindex="-1" role="dialog" aria-labelledby="profileModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="profileModalLabel">개인정보 수정</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <!-- 개인정보 입력 폼 -->
        <form id="profileForm" action="/user/updateProfile" method="post">
          <div class="form-group">
            <label for="email">이메일:</label>
            <input type="email" class="form-control" id="email" name="email" value="${user.email}" required>
          </div>
          <div class="form-group">
            <label for="shippingAddress">배송 주소:</label>
            <input type="text" class="form-control" id="shippingAddress" name="shippingAddress" value="${user.shippingAddress}" required>
          </div>
          <div class="form-group">
            <label for="shippingPostalCode">배송 우편번호:</label>
            <input type="text" class="form-control" id="shippingPostalCode" name="shippingPostalCode" value="${user.shippingPostalCode}" required>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
        <button type="submit" class="btn btn-primary" form="profileForm">저장</button>
      </div>
    </div>
  </div>
</div>

<!-- 부트스트랩 및 jQuery 스크립트 추가 -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>

<%@ include file="../includes/footer.jsp" %>
