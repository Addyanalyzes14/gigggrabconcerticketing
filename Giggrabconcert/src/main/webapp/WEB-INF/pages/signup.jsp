<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign up | Concert Tickets</title>
      <link rel="stylesheet" type="text/css" 
          href="${pageContext.request.contextPath}/css/signup.css">
    
</head>
<body>
    <div class="container">
        <div class="left-panel">
            <img src="concert.jpg" alt="Concert Crowd">
        </div>
        <div class="right-panel">
            <h2>Sign Up</h2>
            <%
    String errorMessage = (String) request.getAttribute("error");
    String successMessage = (String) request.getAttribute("success");

    if (errorMessage != null && !errorMessage.isEmpty()) {
        out.println("<p class=\"error-message\">" + errorMessage + "</p>");
    }

    if (successMessage != null && !successMessage.isEmpty()) {
%>
        <p class="success-message"><%= successMessage %></p>
<%
    }
%>
            <form action="register.jsp" method="post">
                <div class="input-group">
                    <label><i class="fa fa-user"></i> Full Name :</label>
                    <input type="text" name="fullname" required>
                </div>
                <div class="input-group">
                    <label><i class="fa fa-phone"></i> Enter Ph Number :</label>
                    <input type="text" name="phone" required>
                </div>
                <div class="input-group">
                    <label><i class="fa fa-envelope"></i> Enter Email :</label>
                    <input type="email" name="email" required>
                </div>
                <div class="input-group">
                    <label><i class="fa fa-lock"></i> Enter Password :</label>
                    <input type="password" name="password" required>
                </div>
                <button type="submit" class="signup-btn">Sign Up</button>
            </form>
            <p class="login-link">Already have an account? <a href="login.jsp"><strong>Login</strong></a></p>
            <div class="social-login">
                <span>-OR-</span>
                <div class="social-icons">
                    <img src="google.png" alt="Google Login">
                    <img src="facebook.png" alt="Facebook Login">
                </div>
            </div>
        </div>
    </div>
</body>
</html>