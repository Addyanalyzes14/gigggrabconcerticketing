<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>dashboard - Gigg-Grab</title>
      <link rel="stylesheet" type="text/css" 
          href="${pageContext.request.contextPath}/css/dashboard.css">
</head>
<body>

<!-- Navbar -->
<div class="navbar">
    <ul class="nav-links">
        <li><a href="#">dashboard</a></li>
        <li><a href="#">Event Management</a></li>
        <li><a href="#">User Management</a></li>
        <li><a href="#">Admin Profile</a></li>
        <li><button class="login-btn">Login</button></li>
        <li><button class="register-btn">Register</button></li>
    </ul>
</div>

<!-- Dashboard Header -->
<div class="dashboard-header">
    <h3>Primary</h3>
    <div class="dashboard-title">
        <span>Dashboard</span>
        <input type="text" placeholder="Search">
        <img src="admin-profile.jpg" alt="Admin" class="admin-avatar">
    </div>
</div>

<!-- Today's Data Cards -->
<div class="today-data-section">
    <h3>Today's Data</h3>
    <div class="cards">
        <div class="card red-card">
            <p>Payment amount</p>
            <h2>$500.00</h2>
            <span>**** 3486</span>
        </div>
        <div class="card purple-card">
            <p>Payment order</p>
            <h2>$200.00</h2>
            <span>**** 5542</span>
        </div>
        <div class="card green-card">
            <p>Payment customer</p>
            <h2>$350.00</h2>
            <span>**** 6896</span>
        </div>
    </div>
</div>

<!-- Finance Data Table -->
<div class="finance-section">
    <h3>Finance Data</h3>
    <table>
        <tr>
            <th>Date</th>
            <th>Transaction Type</th>
            <th>Description</th>
            <th>Amount</th>
            <th>Category</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
        <tr>
            <td>2023-05-01</td>
            <td>Expenses</td>
            <td>Office Supplies</td>
            <td>$250</td>
            <td>Office Expenses</td>
            <td>Pending</td>
            <td>Edit</td>
        </tr>
        <tr>
            <td>2023-05-02</td>
            <td>Income</td>
            <td>Client Payment</td>
            <td>$500</td>
            <td>Sales</td>
            <td>Completed</td>
            <td>Edit</td>
        </tr>
        <tr>
            <td>2023-05-03</td>
            <td>Expenses</td>
            <td>Travel Expenses</td>
            <td>$250</td>
            <td>Travel</td>
            <td>Pending</td>
            <td>Edit</td>
        </tr>
        <tr>
            <td>2023-05-04</td>
            <td>Expense</td>
            <td>Marketing Campaign</td>
            <td>$300</td>
            <td>Marketing</td>
            <td>Approved</td>
            <td>Edit</td>
        </tr>
        <tr>
            <td colspan="7" class="total">Total: $1,000</td>
        </tr>
    </table>
</div>

<!-- Footer -->
<footer>
    <div class="footer-column">
        <h4>Quick Links</h4>
        <p>Dashboard<br>Events<br>User<br>Reports</p>
    </div>
    <div class="footer-column">
        <h4>Support</h4>
        <p>Documentation<br>API Reference<br>System Update<br>Contact Dev Team</p>
    </div>
    <div class="footer-column">
        <h4>Gigg-Grab Admin</h4>
        <p>Concert Ticket Booking System<br>Version 2.1.4</p>
    </div>
    <div class="footer-bottom">
        <p>© 2025 Gigg-Grab. All rights reserved.<br>Privacy Policy | Terms of Service</p>
    </div>
</footer>

</body>
</html>