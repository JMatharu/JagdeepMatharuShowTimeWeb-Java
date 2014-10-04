<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Show time welcome page</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<h1>Welcome to the time and date service</h1>
	<form method="post"
		action="${pageContext.request.contextPath }/setLocale">
		<p>Use this Web Site to display the current time on the server.
			The time is formatted for your country and language and to the format
			details that you request. However it is not adjusted for the time
			zone.</p>
		<h2>Please Specify your locale.</h2>
		<input type="submit" name="ShowTime" value="Canada - English" /> <input
			type="submit" name="ShowTime" value="Canada - French" /> <input
			type="submit" name="ShowTime" value="United States" />
	</form>
</body>
</html>