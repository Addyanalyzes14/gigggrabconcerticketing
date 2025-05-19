<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Profile - Gigg-Grab</title>
      <link rel="stylesheet" type="text/css" 
          href="${pageContext.request.contextPath}/css/userprofile.css">
</head>
<body>

<!-- Navbar -->
<div class="navbar">
    <div class="logo">Gigg-Grab</div>
    <ul class="nav-links">
        <li><a href="#">Home</a></li>
        <li><a href="#">Event Details</a></li>
        <li><a href="#">Choose Tickets</a></li>
        <li><a href="#">Payment & Checkout</a></li>
        <li><a href="#">My Bookings</a></li>
        <li><button class="login-btn">Login</button></li>
        <li><button class="register-btn">Register</button></li>
    </ul>
</div>

<!-- User Info Section -->
<div class="user-info-container">
    <div class="profile-image">
        <img src="user-image.jpg" alt="User Profile">
    </div>
    <div class="user-details">
        <h2>👤 User Information</h2>
        <ul>
            <li><strong>Full Name:</strong> Priya Gold</li>
            <li><strong>Username:</strong> @priyamusic</li>
            <li><strong>Email:</strong> priya.sharma@gmail.com</li>
            <li><strong>Phone:</strong> +977-9801234567</li>
            <li><strong>Location:</strong> Kathmandu, Nepal</li>
            <li><strong>Joined:</strong> March 12, 2023</li>
            <li><strong>Total Bookings:</strong> 18</li>
        </ul>
    </div>
</div>

<!-- Booking History Table -->
<div class="recent-bookings">
    <h3>🎫 Recent Concert Bookings</h3>
    <table>
        <tr>
            <th>Concert Name</th>
            <th>Date</th>
            <th>Venue</th>
            <th>TicketType</th>
            <th>Status</th>
        </tr>
        <tr>
            <td>Arijit Singh Live</td>
            <td>April 25</td>
            <td><strong>Dasharath Stadium</strong></td>
            <td>VIP</td>
            <td>Attended</td>
        </tr>
        <tr>
            <td>Rock Nepal Fest</td>
            <td>March 10</td>
            <td><strong>Tudikhel Ground</strong></td>
            <td>General</td>
            <td>Canceled</td>
        </tr>
        <tr>
            <td>Coke Studio Night</td>
            <td>Feb 14</td>
            <td><strong>Club Deja</strong></td>
            <td>Premium</td>
            <td>Attended</td>
        </tr>
    </table>
</div>

<!-- Footer -->
<footer>
    <div class="footer-left">
        <h3>Gigg-Grab</h3>
        <div class="social-icons">
            <i>🌐</i> <i>📘</i> <i>📸</i> <i>🎶</i> <i>🎵</i>
        </div>
    </div>
    <div class="footer-center">
        <p><strong>CONTACT US</strong><br>
        giggrab1428@gmail.com<br>
        224, Kathmandu, Nepal, Ticket Booking<br>
        +977 9829277287</p>
    </div>
    <div class="footer-right">
        <strong>SUBSCRIBE</strong><br>
        <p>Enter your email to get notified<br>about our new ticketing policy</p>
        <input type="email" placeholder="Email">
        <button>Submit</button>
    </div>
    <div class="copyright">
        © 2025 TicketBooking. All rights reserved.
    </div>
</footer>

</body>
</html>