<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gigg-Grab Concerts</title>
      <link rel="stylesheet" type="text/css" 
          href="${pageContext.request.contextPath}/css/choosetickets.css">
</head>
<body>

    <header>
        <div class="navbar">
            <div class="logo">Gigg-Grab</div>
            <nav>
                <ul>
                    <li><a href="#">Home</a></li>
                    <li><a href="#">Event Details</a></li>
                    <li><a href="#">Payment & Checkout</a></li>
                    <li><a href="#">My Bookings</a></li>
                    <li><a href="#">Profile</a></li>
                    <li><button class="login-btn">Login</button></li>
                    <li><button class="register-btn">Register</button></li>
                </ul>
            </nav>
        </div>
        <div class="banner">
            <h1>OUR TOP<br>ARTISTS<br>TICKETS !!</h1>
        </div>
        <div class="menu-tabs">
            <a href="#">CONCERTS</a>
            <a href="#">SETLISTS</a>
            <a href="#">REVIEWS</a>
            <a href="#">FAN ALSO VIEWED</a>
        </div>
    </header>

    <main>
        <div class="concert-section">
            <h2>CONCERTS · 15 RESULTS</h2>
            <div class="concert-card">
                <p><strong>Jul 08, Fri · 6:30 PM</strong><br>
                <span class="venue">Mumbai, MH · Jio World Garden</span><br>
                Kulshrestha Kamal Live in Concert</p>
                <button class="ticket-btn">Find Tickets</button>
            </div>

            <div class="concert-card">
                <p><strong>May 08, Thu · 8:00 PM</strong><br>
                <span class="venue">Delhi, DL · Indira Gandhi Indoor Stadium</span><br>
                Arijit Singh Soulful Melodies Tour</p>
                <button class="ticket-btn">Find Tickets</button>
            </div>

            <div class="concert-card">
                <p><strong>AUG 07, Sat · 7:00 PM</strong><br>
                <span class="venue">Bengaluru, KA · M. Chinnaswamy</span><br>
                Shreya Ghoshal Live – Musical Journey</p>
                <button class="ticket-btn">Find Tickets</button>
            </div>

            <div class="concert-card">
                <p><strong>Sun · 7:30 PM</strong><br>
                <span class="venue">Pune, MH · Balewadi Stadium</span><br>
                Sunidhi Chauhan – Powerhouse</p>
                <button class="ticket-btn">Find Tickets</button>
            </div>
        </div>
    </main>

    <footer>
        <div class="footer-left">
            <h3>Gigg-Grab</h3>
            <p>
                <i class="icon"></i>
                <i class="icon"></i>
                <i class="icon"></i>
                <i class="icon"></i>
                <i class="icon"></i>
            </p>
        </div>

        <div class="footer-center">
            <p><strong>CONTACT US</strong><br>
            giggrab1472@gmail.com<br>
            224, Kathmandu, Nepal, Ticket Booking<br>
            +977 9829277287</p>
        </div>

        <div class="footer-right">
            <strong>SUBSCRIBE</strong><br>
            <input type="email" placeholder="Enter your email" />
            <button>Submit</button>
        </div>
        <div class="copyright">
            © 2025 TicketBooking. All rights reserved.
        </div>
    </footer>

</body>
</html>
    