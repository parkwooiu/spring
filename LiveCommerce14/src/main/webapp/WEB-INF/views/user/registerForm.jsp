<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ include file="../includes/header.jsp" %>

<html>
<body>
    <title>User Registration</title>
    <h2>User Registration</h2>
    <form action="/user/register" method="post" modelAttribute="user">
        <div>
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
        </div>
        <div>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div>
            <label for="shippingAddress">Shipping Address:</label>
            <input type="text" id="shippingAddress" name="shippingAddress">
        </div>
        <div>
            <label for="shippingPostalCode">Shipping Postal Code:</label>
            <input type="text" id="shippingPostalCode" name="shippingPostalCode">
        </div>
        <button type="submit">Register</button>
    </form>
</body>
</html>

<%@ include file="../includes/footer.jsp" %>