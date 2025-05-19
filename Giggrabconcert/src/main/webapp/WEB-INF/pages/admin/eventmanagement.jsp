<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title> Event Management</title>
      <link rel="stylesheet" type="text/css" 
          href="${pageContext.request.contextPath}/css/eventmanagement.css">
</head>
<body>
    <header>
        <h1>ADMIN DASHBOARD - EVENT MANAGEMENT</h1>
    </header>

    <main>
        <div class="controls">
            <input type="text" placeholder="Search Events..." class="search-bar">
            <button class="add-btn">Add New Event</button>
        </div>

        <table>
            <thead>
                <tr>
                    <th>EVENT NAME</th>
                    <th>DATE</th>
                    <th>VENUE</th>
                    <th>ARTIST</th>
                    <th>TICKETS SOLD</th>
                    <th>ACTIONS</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Rock Festa 2025</td>
                    <td>May 15, 2025</td>
                    <td>Tundikhel Ground</td>
                    <td>Nepathya</td>
                    <td>3,245</td>
                    <td>
                        <button class="action-btn view-btn">View</button>
                        <button class="action-btn edit-btn">Edit</button>
                        <button class="action-btn delete-btn">Delete</button>
                    </td>
                </tr>
                <tr>
                    <td>EDM Night Kathmandu</td>
                    <td>June 2, 2025</td>
                    <td>Bhrikutimandap</td>
                    <td>DJ Karma</td>
                    <td>1,800</td>
                    <td>
                        <button class="action-btn view-btn">View</button>
                        <button class="action-btn edit-btn">Edit</button>
                        <button class="action-btn delete-btn">Delete</button>
                    </td>
                </tr>
                <tr>
                    <td>Jazz & Soul Evening</td>
                    <td>April 20, 2025</td>
                    <td>Patan Museum Garden</td>
                    <td>Rohit John Chettri</td>
                    <td>925</td>
                    <td>
                        <button class="action-btn view-btn">View</button>
                        <button class="action-btn edit-btn">Edit</button>
                        <button class="action-btn delete-btn">Delete</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </main>
</body>
</html>