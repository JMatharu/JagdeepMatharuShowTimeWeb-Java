<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Format and show the current time on the server</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<h1>Current date and time on server in Canada - English</h1>
	<c:forEach items="${sessionScope.timelog}" var="onetime">
${onetime}<br />
	</c:forEach>
	<h2>Use this from to select another format</h2>
	<form action="${pageContext.request.contextPath}/clock" method="post">
		Select format <select name="format">
			<c:choose>
				<c:when test="${(requestScope.format == 'full')}">
					<option value="full" selected>full</option>
					<option value="long">long</option>
					<option value="medium">medium</option>
					<option value="short">short</option>

				</c:when>
				<c:when test="${(requestScope.format == 'long')}">
					<option value="full" selected>full</option>
					<option value="long">long</option>
					<option value="medium">medium</option>
					<option value="short">short</option>

				</c:when>
				<c:when test="${(requestScope.format == 'medium')}">
					<option value="full" selected>full</option>
					<option value="long">long</option>
					<option value="medium">medium</option>
					<option value="short">short</option>

				</c:when>
				<c:when test="${(requestScope.format == 'short')}">
					<option value="full" selected>full</option>
					<option value="long">long</option>
					<option value="medium">medium</option>
					<option value="short">short</option>

				</c:when>
				<c:otherwise>
					<option value="full" selected>full</option>
					<option value="long">long</option>
					<option value="medium">medium</option>
					<option value="short">short</option>

				</c:otherwise>
			</c:choose>
		</select> and click <input type="submit" name="ShowTime" value="Show Time">
	</form>
	<p>Current locale: ${sessionScope.locale}.</p>
	<form action="${pageContext.request.contextPath}/setLocale"
	method="get">
		<p>
			To change locale: <a type="submit" href="" name="getStart">Start
				Over</a>
		</p>
	</form>
</body>
</html>