<%@ include file="header.jsp" %>
<%@ include file="admin_login_req.jsp" %>
<head>
<meta charset="ISO-8859-1">
<title>Admin List</title>

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
	<div class="panel-heading text-center"><span class="lead">All Admins</span></div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Admin Id</th>
                        <th>Username</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${admins}" var="admin">
                    <tr>
                        <td>${admin.getId()}</td>
                        <td>${admin.name}</td>
                        <td>${admin.password}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
</body>
</html>