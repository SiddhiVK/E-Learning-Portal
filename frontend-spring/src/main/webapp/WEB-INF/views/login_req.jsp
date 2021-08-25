<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<html>
<head>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>

	<c:if test="${auth.roll == Null}">
		<c:redirect url="user_login"/>
	</c:if>
</body>
</html>