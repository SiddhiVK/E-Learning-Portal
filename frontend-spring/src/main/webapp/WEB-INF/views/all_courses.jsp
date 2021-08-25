<%@ include file="header.jsp" %>
<%@ include file="login_req.jsp" %>
<head>
<meta charset="ISO-8859-1">
<title>Course List</title>

<style>
	.jumbotron{
		background-color : white;
	}
	
	tr:nth-child(even) {
            background-color: Lightgrey;
     }
	
</style>

</head>
<body>
	<div class="container jumbotron">
		<div class="panel-heading text-center"><span class="lead">Courses</span></div>
	            <table class="table table-hover">
	                <thead>
	                    <tr>
	                        <th>Id</th>
	                        <th>Course Name</th>
	                        <th>Fee</th>
	                        <th>Description</th>
	                        <th>Resources</th>
	                    </tr>
	                </thead>
	                <tbody>
	                <c:forEach items="${courses}" var="course">
	                    <tr>
	                        <td>${course.course_id}</td>
	                        <td>${course.course_name}</td>
	                        <td>${course.course_fees}</td>
	                        <td>${course.course_desc}</td>
	                        <td>${course.course_resource}</td>
	                       <c:if test="${auth.roll == 'USER'}">
	                        <td>
	                        
		                        <form action="enrollProcess" method="Post" id="form${course.course_id}">
									<c:if test="${auth.roll == 'ADMIN'}">
										<input type="hidden" id="user_id" name="user_id">
									</c:if>
									<c:if test="${auth.roll == 'USER'}">
										<input type="hidden" id="user_id" name="user_id" value="${auth.obj.user_id}">
										<input type="hidden" id="name" name="name" value="${auth.obj.name}">
										<input type="hidden" id="course_name" name="course_name" value="${course.course_name}">
									</c:if>
									<input type="hidden" id="course_id" name="course_id" value="${course.course_id}">
								</form>
							</td>
							</c:if>
							<c:if test="${auth.roll == 'USER'}">
	                        <td><button type="submit" form="form${course.course_id}" class="btn btn-outline-primary">Enroll</button></td>
	                     <!--     <td><button type="button" class="btn btn-outline-success">Enrolled</button></td> -->
	                     <!--     <td><button type="button" class="btn btn-outline-danger">Unenroll</button></td> -->
	                    	</c:if>
	                    
	                   <c:if test="${auth.roll == 'ADMIN'}">
	                        <td>
	                        
		                        <form action="update_course" method="Post">
									<input type="hidden" id="course_id" name="course_id" value="${course.course_id}">
									<td><button type="submit" class="btn btn-outline-info">Update</button></td>
								</form>
							</td>
							</c:if>
						
							
						<c:if test="${auth.roll == 'ADMIN'}">
	                        <td>
	                        
		                        <form action="delete_course" method="Post">
									<input type="hidden" id="course_id" name="course_id" value="${course.course_id}">
									<td><button type="submit" class="btn btn-outline-danger">Delete</button></td>
								</form>
							</td>
							</c:if>	
	                    
	         
	                    	<!--   <td><button type="submit" form="form${course.course_id}" class="btn btn-outline-info">Update</button></td> -->
	                    	
	                    </tr>
	                </c:forEach>
	                </tbody>
	            </table>
	   </div>
</body>