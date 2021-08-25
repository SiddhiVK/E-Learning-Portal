<%@ include file="header.jsp" %>
<%@ include file="admin_login_req.jsp" %>
<head>
<meta charset="ISO-8859-1">
<title>Contact List</title>

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
	<div class="panel-heading text-center"><span class="lead">List of Contacts </span></div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Contact Id</th>
                        <th>User Id</th>
                        <th>Username</th>
                        <th>Phone No.</th>
                        <th>Email</th>
                        <th>Message</th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${contacts}" var="contact">
                    <tr>
                        <td>${contact.contact_id}</td>
                        <td>${contact.user_id}</td>
                        <td>${contact.name}</td>
                        <td>${contact.phone}</td>
                        <td>${contact.email}</td>
                        <td>${contact.message}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
</body>