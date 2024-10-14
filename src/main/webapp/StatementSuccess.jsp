<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Success Page</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 80%;
            max-width: 600px;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            text-align: center;
        }
        h1 {
            color: #4CAF50;
            font-size: 28px;
        }
        .session-data {
            margin-top: 20px;
            font-size: 18px;
            color: #333;
        }
        .session-data span {
            font-weight: bold;
            color: #000;
        }
        .btn {
            display: inline-block;
            margin-top: 30px;
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-size: 16px;
        }
        .btn:hover {
            background-color: #45a049;
        }
        .error {
            color: red;
            font-size: 16px;
        }
        sppp{
         
         align:center;
         
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Success Page</h1>
        <div class="session-data">
            <% 
                session = request.getSession();
                Object sal = session.getAttribute("sal");
                Object ral = session.getAttribute("ral");
                Object Am = session.getAttribute("al");

                if (sal != null && ral != null && Am != null) {
                    out.println("<p><span class='sppp'>Senders Account Number:</span> " + sal + "</p>" + "<p><span class='sppp'>Receivers Account Number:</span> " + ral + "</p>" + "<p><span class='sppp'>Amount:</span> " + Am + "</p>");
                } else {
                    out.println("<p class='error'>SAL information not available</p>");
                }

            %>
        </div>
        <a href="Home.html" class="btn">Return to Home</a>
    </div>
</body>
</html>
