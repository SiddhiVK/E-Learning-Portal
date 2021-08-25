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
	    <c:if test="${auth.roll == 'ADMIN'}">
		<div class="panel-heading text-center"><span class="lead">Enrolled Courses</span></div>
	            <table class="table table-hover">
	                <thead>
	                    <tr>
	                        <th>Course Id</th>
	                        <th>User Id</th>
	                        <th>User Name</th>
	                        <th></th>
	                    </tr>
	                </thead>
	                <tbody>
	           
	                <c:forEach items="${ec}" var="ec">
	                    <tr>
	                       <td>${ec.course_id}</td>
	                        <td>${ec.user_id}</td>
	                        <td>${ec.getName()}</td>
	                        <td>
		                        <form action="enrollProcess" method="Post" id="form${ec.course_id}">
									<c:if test="${auth.roll == 'ADMIN'}">
										<input type="hidden" id="course_id" name="course_id" value="${ec.course_id}">
									</c:if>
									<input type="hidden" id="course_id" name="course_id" value="${ec.course_id}">
								</form>
							</td>
	                    </tr>
	                </c:forEach>
	                </tbody>
	            </table>
	            </c:if>
	   </div>
</body>