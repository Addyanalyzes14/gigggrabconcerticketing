<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gig Grab</title>
     <link rel="stylesheet" type="text/css" 
          href="${pageContext.request.contextPath}/css/homepage.css">
</head>
<body>
    <header class="top-bar">
        <div class="nav-links">
            <a href="#">Event Details</a>
            <a href="#">Choose Tickets</a>
            <a href="#">Payment & Checkout</a>
            <a href="#">My Bookings</a>
            <a href="#">Profile</a>
        </div>
    </header>

    <section class="hero-section">
        <h1>Gig - Grab</h1>
        <p>Your Gateway to Every Gig!</p>
        <div class="hero-image"> <!-- Image Placeholder --> </div>
        <div class="search-box">
            <input type="text" placeholder="City or Gig Name">
            <input type="text" placeholder="All Shows">
            <input type="text" placeholder="Select Date">
            <button>Search</button>
        </div>
        <button class="ticket-sale">Tickets on Sale Now</button>
    </section>

    <section class="discount-banner">
        <p>BOOK !! N GET EARLY DISCOUNT !!</p>
    </section>

    <section class="quick-escape">
        <h2>Ready for a Quick Escape?</h2>
        <div class="escape-images">
            <div class="escape-img"> <!-- Placeholder --> </div>
            <div class="escape-img"> <!-- Placeholder --> </div>
        </div>
    </section>

    <section class="past-shows">
        <h2>OUR PAST SHOWS</h2>
        <div class="show-gallery">
            <div class="show-card"> <!-- Placeholder for main image --> </div>
            <div class="show-description"> <!-- Description and thumbnails --> </div>
        </div>
    </section>

    <section class="features">
        <h2>WE HAVE WHAT YOU WANT !</h2>
        <div class="features-content">
            <div class="feature"> <!-- Icon and text --> </div>
            <div class="feature center-img"> <!-- Main Center Image Placeholder --> </div>
            <div class="feature"> <!-- Icon and text --> </div>
        </div>
    </section>

    <footer>
        <div class="footer-brand">Gig-Grab</div>
        <div class="footer-info">
            <div class="contact">
                <h4>CONTACT US</h4>
                <p>2324 Entertainment Road<br>NYC 10001 USA</p>
            </div>
            <div class="subscribe">
                <h4>SUBSCRIBE</h4>
                <input type="email" placeholder="Enter your email">
                <button>Subscribe</button>
            </div>
        </div>
        <p class="footer-note">2025 BookMyGig. All rights reserved.</p>
    </footer>
</body>
</html>