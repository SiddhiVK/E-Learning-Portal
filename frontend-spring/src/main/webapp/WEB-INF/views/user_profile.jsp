<%@ include file="header.jsp" %>
<%@ include file="login_req.jsp" %>
<html>
<head>
	<title>User Profile</title>
</head>

<style>
	.jumbotron{
		background-color : white;
	}
	
	tr:nth-child(even) {
            background-color: Lightgrey;
     }
     
     .center {
  margin-left: auto;
  margin-right: auto;
}
	
</style>

<body>

<hr>
	    <div class="row justify-content-center">
            <div class="col-md-6">
                    <div class="card">
                        <div class="card-header text-center"><h4>My Profile</h4></div>
                        <div class="card-body">
                              	<p>User Id : ${auth.obj.user_id }</p>
                              	<p>Name : ${auth.obj.name }</p>
                              	<p>Email : ${auth.obj.email }</p>
                                <p>Phone : ${auth.obj.phone }</p>
                                <p>Address : ${auth.obj.address }</p>
                        </div>
                        <div class="card-footer text-muted text-center">
                        	<c:if test="${auth.roll == 'USER'}">
                        		<form action="update_user" method="Post">
									<input type="hidden" id="user_id" name="user_id" value="${auth.obj.user_id}">
									<button type="submit" class="btn btn-outline-info">Update</button>
								 </form>
								 <hr>
							</c:if>
							<c:if test="${auth.roll == 'USER'}">
						         <form action="delete_user" method="Post">
									<input type="hidden" id="user_id" name="user_id" value="${auth.obj.user_id}">
									<button type="submit" class="btn btn-outline-danger">Delete</button>
								 </form>
							</c:if>
					    </div>
                    </div>
                 </div>
            </div>
            


<br>
<hr>
	<div class="container">
		<div class="panel-heading text-center"><span class="lead">My Courses</span></div>
			<div class="center">
				 <table class="table center">
	                <thead>
	                    <tr>
	                        <th>Course Id</th>
	                        <th>Course Name</th>
	                    </tr>
	                </thead>
	                <tbody>
	           
	                <c:forEach items="${ec}" var="ec">
	                    <tr>
	                    <c:if test="${ec.user_id == auth.obj.user_id}">
	                       <td>${ec.course_id}</td>
	                        <td>${ec.course_name}</td>
	             		</c:if>
	                       
	                    </tr>
	                </c:forEach>
	                </tbody>
	            </table>
			</div>
	</div>

</body>
</html>