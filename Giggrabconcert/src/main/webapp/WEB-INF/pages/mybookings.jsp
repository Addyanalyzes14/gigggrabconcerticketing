<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Bookings - Gigg-Grab</title>
    <link rel="stylesheet" type="text/css" 
          href="${pageContext.request.contextPath}/css/mybookings.css">
    
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

    <!-- Banner -->
    <div class="banner">
        <img src="bookings-banner.jpg" alt="Bookings Banner">
    </div>

    <!-- Booking Details -->
    <div class="booking-section">
        <h2>Your Bookings</h2>
        <div class="booking-card">
            <h3>Arijit Singh Soulful Melodies</h3>
            <p><strong>Date:</strong> May 08, Thursday - 8:00 PM</p>
            <p><strong>Venue:</strong> Indira Gandhi Indoor Stadium, Delhi</p>
            <p><strong>Ticket Type:</strong> General Admission</p>
            <p><strong>Price:</strong> $20</p>
            <button class="view-btn">View Ticket</button>
        </div>

        <div class="booking-card">
            <h3>Shreya Ghoshal Live</h3>
            <p><strong>Date:</strong> August 07, Saturday - 7:00 PM</p>
            <p><strong>Venue:</strong> M. Chinnaswamy Stadium, Bengaluru</p>
            <p><strong>Ticket Type:</strong> Balcony Seating</p>
            <p><strong>Price:</strong> $80</p>
            <button class="view-btn">View Ticket</button>
        </div>
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