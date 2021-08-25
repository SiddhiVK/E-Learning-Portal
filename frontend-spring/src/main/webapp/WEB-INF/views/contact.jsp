<%@ include file="header.jsp" %>
<head>
<meta charset="ISO-8859-1">
<title>Contacts</title>

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
	<c:if test="${auth.roll != Null}">
	<div class="panel-heading text-center"><span class="lead">All Contacts</span></div>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>User Id</th>
                        <th>Username</th>
                        <th>Phone No.</th>
                        <th>Email</th>
                        <th>Message</th>
                    </tr>
                </thead>
                <tbody>
				<c:if test="${auth.roll == 'USER'}">
					<c:set var="Cont" scope="session" value="${contacts.stream().filter(c -> c.name == auth.username).toList()}"/>  
				</c:if>
				<c:if test="${auth.roll == 'ADMIN'}">
					<c:set var="Cont" scope="session" value="${contacts}"/>  
				</c:if>
	                <c:forEach items="${Cont}" var="contact">
	                    <tr>
	                        <td>${contact.contact_id}</td>
	                        <td>${auth.username}</td>
	                        <td>${contact.user_id}</td>
	                        <td>${contact.name}</td>
	                        <td>${contact.phone_no}</td>
	                        <td>${contact.email}</td>
	                        <td>${contact.message}</td>
	                    </tr>
	                </c:forEach>
	                
                </tbody>
            </table>
		</c:if>
        </div>
</body>