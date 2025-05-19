<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
      <link rel="stylesheet" type="text/css" 
          href="${pageContext.request.contextPath}/css/adminprofile.css">
</head>
<body>
    <header>
        <nav>
            <ul>
                <li><a href="#">DASHBOARD</a></li>
                <li><a href="#">EVENT MANAGEMENT</a></li>
                <li><a href="#">USER</a></li>
                <li><a href="#">ADMIN PROFILE</a></li>
                <li><a href="#">LOGOUT</a></li>
            </ul>
        </nav>
    </header>

    <main>
        <section class="user-info">
            <div class="profile-pic">
                <!-- Image will be inserted here later -->
            </div>
            <div class="user-details">
                <h2>USER INFORMATION</h2>
                <p><strong>FULL NAME:</strong> Ravi Acharya</p>
                <p><strong>USERNAME:</strong> @admin_ravi</p>
                <p><strong>EMAIL:</strong> ravi.acharya@concerthub.com</p>
                <p><strong>PHONE:</strong> +977-9812345678</p>
                <p><strong>LOCATION:</strong> Kathmandu, Nepal</p>
                <p><strong>JOINED:</strong> January 5, 2023</p>
                <p><strong>TOTAL EVENTS MANAGED:</strong> 36</p>
            </div>
        </section>

        <section class="admin-stats">
            <h3>ADMIN OVERVIEW STATS</h3>
            <div class="stats-container">
                <div class="stat-item">
                    <span class="icon red"></span>
                    <p>TOTAL EVENTS MANAGED: 36</p>
                </div>
                <div class="stat-item">
                    <span class="icon blue"></span>
                    <p>TOTAL TICKETS REGISTERED: 12,000</p>
                </div>
                <div class="stat-item">
                    <span class="icon purple"></span>
                    <p>TOTAL TICKETS SOLD: 98,245</p>
                </div>
                <div class="stat-item">
                    <span class="icon yellow"></span>
                    <p>REVENUE GENERATED: NPR 1.8 Cr</p>
                </div>
            </div>
        </section>

        <section class="recent-activities">
            <h3>RECENT ACTIVITY</h3>
            <table>
                <tr>
                    <th>ACTIVITY</th>
                    <th>DATE & TIME</th>
                </tr>
                <tr>
                    <td>Created new concert: 'Nepal Rocks'</td>
                    <td>April 25, 2025 - 3:20 PM</td>
                </tr>
                <tr>
                    <td>Updated ticket prices</td>
                    <td>April 24, 2025 - 1:45 PM</td>
                </tr>
                <tr>
                    <td>Removed fake user accounts</td>
                    <td>April 23, 2025 - 10:30 AM</td>
                </tr>
                <tr>
                    <td>Sent bulk email to customers</td>
                    <td>April 20, 2025 - 5:00 PM</td>
                </tr>
            </table>
        </section>
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
                <a href="#">Help Center</a>
                <a href="#">API Reference</a>
                <a href="#">System Update</a>
            </div>
            <div>
                <h4>GIG-GRAB SYSTEM</h4>
                <a href="#">Version 2.1.4</a>
            </div>
        </div>
        <p>&copy; 2025 Gig-Grab, All rights reserved. <a href="#">PRIVACY POLICY</a> | <a href="#">TERMS OF SERVICE</a></p>
    </footer>
</body>
</html>