<%@ include file="header.jsp" %>
<%@ include file="login_req.jsp" %>
<head>
<meta charset="ISO-8859-1">
<title>Feedback List</title>

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
	<div class="panel-heading text-center"><span class="lead">List of Feedbacks </span></div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Feedback Id</th>
                        <th>User Id</th>
                        <th>Username</th>
                        <th>Email</th>
                        <th>Feedback</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${feedbacks}" var="feedback">
                    <tr>
                        <td>${feedback.feedback_id}</td>
                        <td>${feedback.user_id}</td>
                        <td>${feedback.name}</td>
                        <td>${feedback.email}</td>
                        <td>${feedback.feedback}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
</body>
</html>