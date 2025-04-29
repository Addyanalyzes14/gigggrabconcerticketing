<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign In | Concert Tickets</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/signin.css">
</head>
<body>
<div class="container">
    <main class="login-box">
        <!-- Image Section -->
        <section class="left" aria-label="Concert scene">
            <img src="${pageContext.request.contextPath}/images/concert.jpg" 
                 alt="Live concert audience" 
                 class="login-img">
        </section>

        <!-- Form Section -->
        <section class="right">
            <h2>Welcome Back!</h2>
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
            <form action="${pageContext.request.contextPath}/LoginServlet" method="post">
                <div class="input-group">
                    <label for="email">
                        <span class="icon">📧</span>
                        <span class="label-text">Email Address:</span>
                        <input type="email" 
                               id="email" 
                               name="email" 
                               required
                               autocomplete="email">
                    </label>
                </div>

                <div class="input-group">
                    <label for="password">
                        <span class="icon">🔒</span>
                        <span class="label-text">Password:</span>
                        <input type="password" 
                               id="password" 
                               name="password" 
                               autocomplete="current-password">
                    </label>
                </div>

                <button type="submit" class="btn">Sign In</button>
                <p class="signup-text">Don't have an account? <a href="${pageContext.request.contextPath}/signup.jsp">Sign Up</a></p>
            </form>
        </section>
    </main>
</div>
</body>
</html>
