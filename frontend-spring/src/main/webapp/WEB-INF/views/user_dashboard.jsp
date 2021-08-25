<%@ include file="header.jsp" %>
<%@ include file="login_req.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Dashboard</title>
</head>
<body>
	<div class="container jumbotron">
	    <div class="row justify-content-center">
            <div class="col-md-8">
			<h3>Welcome ${user.name}</h3>
			<hr>
		    <table>
		        <tr>
		            <td><h4>Your Profile</h4></td>
		        </tr>
		        <tr>
		        </tr>
		        <tr>
		        	<td>User Id: ${user.user_id}</td>
		        </tr>
		        <tr>
		        	<td>Phone No.: ${user.phone}</td>
		        </tr>
		        <tr>
		        	<td>Email : ${user.email} </td>
		        </tr>
		        <tr>
		        	<td>Address : ${user.address}</td>
		        </tr>
		        <tr>
		        	<td>Reg. Date : ${user.reg_date}</td>
		        </tr>
		        <tr>
		        	<td>Photo : ${user.upload_photo}</td>
		        </tr>
		    </table>
		    </div>
	   </div>
   </div>
</body>
</html>