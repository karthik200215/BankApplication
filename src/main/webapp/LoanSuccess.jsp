<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f0f0f0;
	margin: 0;
	padding: 0;
}

.loo {
	width: 100%;
	max-width: 600px;
	margin: 50px auto;
	background-color: #fff;
	padding: 20px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	border-radius: 10px;
	color:#225797;
	font-size:20px;
}
</style>
<meta charset="UTF-8">
<title>LOAN SUCCESS PAGE</title>
</head>
<body>
	<div class="loo">
		<%
	session = request.getSession();
	out.println("Dear ,"+ session.getAttribute(name)+"  " + "thank you showing interest from SBI bank.");
	out.println("<br>");
	out.println("<br>");
	out.println("Our executive will contact soon on your email address as shown Below");
	out.println("<br>");
	out.println("<br>");
	out.println(session.getAttribute("mail"));
	
	%>
	</div>
</body>
</html>