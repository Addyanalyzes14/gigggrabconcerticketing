<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> - User Management</title>
      <link rel="stylesheet" type="text/css" 
          href="${pageContext.request.contextPath}/css/usermanagement.css">
</head>
<body>
    <header>
        <nav>
            <ul>
                <li><a href="#">DASHBOARD</a></li>
                <li><a href="#">EVENT MANAGEMENT</a></li>
                <li><a href="#">USER MANAGEMENT</a></li>
                <li><a href="#">ADMIN PROFILE</a></li>
                <li><a href="#">LOGOUT</a></li>
            </ul>
        </nav>
    </header>

    <main>
        <h1>ADMIN DASHBOARD - USER MANAGEMENT</h1>
        <div class="controls">
            <input type="text" placeholder="Search Users..." class="search-bar">
        </div>

        <table>
            <thead>
                <tr>
                    <th>FULL NAME</th>
                    <th>USERNAME</th>
                    <th>EMAIL</th>
                    <th>PHONE</th>
                    <th>JOINED DATE</th>
                    <th>STATUS</th>
                    <th>ACTIONS</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Priya Sharma</td>
                    <td>@priyamusic</td>
                    <td>priya.sharma@gmail.com</td>
                    <td>+977-9801234567</td>
                    <td>March 12, 2023</td>
                    <td>Active</td>
                    <td>
                        <button class="action-btn view-btn">View</button>
                        <button class="action-btn edit-btn">Edit</button>
                        <button class="action-btn block-btn">Block</button>
                        <button class="action-btn delete-btn">Delete</button>
                    </td>
                </tr>
                <tr>
                    <td>Ramesh Khadka</td>
                    <td>@rameshk</td>
                    <td>ramesh.khadka@gmail.com</td>
                    <td>+977-9812345678</td>
                    <td>Jan 5, 2024</td>
                    <td>Blocked</td>
                    <td>
                        <button class="action-btn view-btn">View</button>
                        <button class="action-btn edit-btn">Edit</button>
                        <button class="action-btn unblock-btn">Unblock</button>
                        <button class="action-btn delete-btn">Delete</button>
                    </td>
                </tr>
                <tr>
                    <td>Anjali Thapa</td>
                    <td>@anjalilive</td>
                    <td>anjali.t@gmail.com</td>
                    <td>+977-9847654321</td>
                    <td>Nov 18, 2022</td>
                    <td>Active</td>
                    <td>
                        <button class="action-btn view-btn">View</button>
                        <button class="action-btn edit-btn">Edit</button>
                        <button class="action-btn block-btn">Block</button>
                        <button class="action-btn delete-btn">Delete</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </main>

    <footer>
        <div class="footer-links">
            <div>
                <h4>QUICK LINKS</h4>
                <a href="#">Dashboard</a>
                <a href="#">Events</a>
                <a href="#">Users</a>
                <a href="#">Reports</a>
            </div>
            <div>
                <h4>SUPPORT</h4>
                <a href="#">Documentation</a>
                <a href="#">API Reference</a>
                <a href="#">System Update</a>
                <a href="#">Contact Dev Team</a>
            </div>
            <div>
                <h4>GIG-GRAB ADMIN</h4>
                <a href="#">Concert Ticket Booking System</a>
                <a href="#">Version 2.1.4</a>
            </div>
        </div>
        <p>© 2025 Gig-Grab, All rights reserved. <a href="#">PRIVACY POLICY</a> | <a href="#">TERMS OF SERVICE</a></p>
    </footer>
</body>
</html>