<%@ include file="header.jsp" %>
<%@ include file="login_req.jsp" %>
<html>
<head>
	<title>Contact Page</title>
</head>
<body>

<hr>
	    <div class="row justify-content-center">
            <div class="col-md-6">
                    <div class="card">
                        <div class="card-header text-center"><h4>Add Contact</h4></div>
                        <div class="card-body">
                            <form name="my-form" action="submit_contact" method="Post" >
								<c:if test="${auth.roll == 'USER'}">
                                	<input type="hidden" id="user_id" name="user_id"  value="${auth.obj.user_id }">
                                </c:if>
                                <c:if test="${auth.roll == 'ADMIN'}">
									<div class="form-group row">
									    <label for="user_id" class="col-md-4 col-form-label text-md-right">User ID</label>
									    <div class="col-md-6">
									        <input type="number" id="user_id" class="form-control" name="user_id">
									    </div>
									</div>
                                </c:if>
                                <input type="hidden" id="username" name="username" value="${auth.obj.name }">
                                
                                <div class="form-group row">
                                    <label for="email" class="col-md-4 col-form-label text-md-right">E-Mail</label>
                                    <div class="col-md-6">
                                        <input type="email" id="email" class="form-control" name="email">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="phone" class="col-md-4 col-form-label text-md-right">Phone Number</label>
                                    <div class="col-md-6">
                                        <input type="number" id="phone" class="form-control" name="phone">
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <label for="message" class="col-md-4 col-form-label text-md-right">Message</label>
                                    <div class="col-md-6">
                                        <input type="text" id="message" class="form-control" name="message">
                                    </div>
                                </div>
                                
                                <div class="col-md-4 offset-md-4 text-center">
                                    <button type="submit" class="btn btn-primary text-center">
                                    Add Contact
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                 </div>
            </div>
  
</body>
</html>