<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Checkout - Gigg-Grab</title>
      <link rel="stylesheet" type="text/css" 
          href="${pageContext.request.contextPath}/css/payment.css">
</head>
<body>
    <header>
        <nav>
            <ul>
                <li><a href="#">Home</a></li>
                <li><a href="#">Event Details</a></li>
                <li><a href="#">Choose Tickets</a></li>
                <li><a href="#">Payment & Checkout</a></li>
                <li><a href="#">My Bookings</a></li>
                <li><a href="#">Login</a></li>
                <li><a href="#">Register</a></li>
            </ul>
        </nav>
    </header>

    <main>
        <h1>Checkout</h1>
        <div class="checkout-container">
            <div class="form-section">
                <h2>Contact Information</h2>
                <form>
                    <label for="first-name">First name:</label>
                    <input type="text" id="first-name" name="first-name">
                    <label for="last-name">Last name:</label>
                    <input type="text" id="last-name" name="last-name">
                    <label for="email">Email:</label>
                    <input type="email" id="email" name="email">
                    <label for="phone">Phone:</label>
                    <input type="tel" id="phone" name="phone">

                    <h2>Ticket 1 Information</h2>
                    <label for="ticket1-first-name">First name:</label>
                    <input type="text" id="ticket1-first-name" name="ticket1-first-name">
                    <label for="ticket1-last-name">Last name:</label>
                    <input type="text" id="ticket1-last-name" name="ticket1-last-name">

                    <h2>Ticket 2 Information</h2>
                    <label for="ticket2-first-name">First name:</label>
                    <input type="text" id="ticket2-first-name" name="ticket2-first-name">
                    <label for="ticket2-last-name">Last name:</label>
                    <input type="text" id="ticket2-last-name" name="ticket2-last-name">
                </form>
            </div>

            <div class="image-section">
                <img src="concert-image.jpg" alt="Concert crowd">
            </div>

            <div class="order-summary">
                <h2>Order summary</h2>
                <p>2 x General Admission <span>$40</span></p>
                <p>Delivery e-ticket <span>$0</span></p>
                <p class="total">Total <span>$40</span></p>
                <button>Pay by card</button>
            </div>
        </div>
    </main>

    <footer>
        <div class="footer-section">
            <div class="logo">Gigg-Grab</div>
        </div>
        <div class="footer-section">
            <h3>Contact Us</h3>
            <p>gigggrab1428@gmail.com</p>
            <p>224, Kathmandu, Nepal</p>
            <p>Ticket Booking: +977 8299727287</p>
        </div>
        <div class="footer-section">
            <h3>Subscribe</h3>
            <p>Enter your email to get notified about our news updates</p>
            <input type="email" placeholder="Email">
            <button>Subscribe</button>
        </div>
        <p class="copyright">2025 TicketBooking, All rights reserved.</p>
    </footer>
</body>
</html>