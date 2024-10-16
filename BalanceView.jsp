<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Balance Information</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 100%;
            max-width: 600px;
            margin: 50px auto;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        .balance-info {
            text-align: center;
            font-size: 24px;
            color: #4CAF50;
            margin-top: 20px;
        }
        .btn {
            display: inline-block;
            padding: 10px 20px;
            background-color: #143C7A;
            color: #fff;
            border: none;
            border-radius: 5px;
            text-decoration: none;
            font-size: 16px;
            text-align: center;
            margin-top: 20px;
        }
        .btn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Your Account Balance</h1>
        <div class="balance-info">
            <% 
                Object balance = session.getAttribute("bal");
                if (balance != null) {
                    out.println("Balance: $" + balance);
                } else {
                    out.println("Balance information is not available.");
                }
            %>
        </div>
        <div style="text-align: center;">
            <a href="Home.html" class="btn">Go to Home</a>
        </div>
    </div>
</body>
</html>
