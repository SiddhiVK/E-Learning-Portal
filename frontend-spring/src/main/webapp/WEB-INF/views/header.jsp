<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    
    <style>
    	a{
    		color : white;
    	}
    </style>
    
   </head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	  <c:if test="${auth.roll == null}">
	    		<a class="navbar-brand" href="index">ELP</a>
	  </c:if> 
	 <c:if test="${auth.roll == 'USER'}">
	    		<a class="navbar-brand" href="home">ELP</a>
	  </c:if> 	
	<c:if test="${auth.roll == 'ADMIN'}">
	    		<a class="navbar-brand" href="admin_home">ELP</a>
	  </c:if> 	
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
	    <div class="navbar-nav justify-content-center">
		<!-- <a class="nav-item nav-link active" href="Home">Home <span class="sr-only">(current)</span></a>  -->
				 
			<c:if test="${auth.roll == 'USER'}">
				<a class="nav-item nav-link" href="home">Home</a>
				<a class="nav-item nav-link" href="courses">Courses</a>
				<a class="nav-item nav-link" href="add_contact">Contact</a>
				<a class="nav-item nav-link" href="add_feedback">Feedback</a>
				<a class="nav-item nav-link" href="profile">User Profile</a>
			</c:if>
				
			<c:if test="${auth.roll == 'ADMIN'}">
				<a class="nav-item nav-link" href="add_course">Add Course</a>
				<a class="nav-item nav-link" href="users">Users</a>
				<a class="nav-item nav-link" href="courses">Courses</a>
				<a class="nav-item nav-link" href="enrolledcourses">Enrolled Courses</a>
				<a class="nav-item nav-link" href="feedbacks">Feedbacks</a>
				<a class="nav-item nav-link" href="contacts">Contacts</a>
				<a class="nav-item nav-link" href="admins">Admins</a>
				<a class="nav-item nav-link" href="admin_registration">New Admin</a>
			</c:if>  
			<c:if test="${auth.roll == 'USER'}">
	    	<!--  <a class="nav-item" >User ${auth.username}</a> -->
	    		<a href="logout" class="nav-item btn btn-danger btn-sm float-end">Log Out</a>
			</c:if>   
			<c:if test="${auth.roll == 'ADMIN'}">
	    	<!--  	<a class="nav-item">Admin ${auth.username}</a> -->
	    		<a href="logout" class="nav-item btn btn-danger btn-sm">Log Out</a>
			</c:if>   
			<c:if test="${auth.roll == null}">
	    		<a class="nav-item nav-link" href="user_login">Log In</a>
	    		<a class="nav-item nav-link" href="user_registration">Sign Up</a>
	    		<a class="nav-item nav-link" href="admin_login">Admin Log In</a>
			</c:if>   
	    </div>
	  </div>
	</nav>
</body>
</html>