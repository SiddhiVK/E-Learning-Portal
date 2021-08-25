<%@ include file="header.jsp" %>
<%@ include file="login_req.jsp" %>
<html>
<head>
	<title>Feedback Page</title>
</head>
<body>

<hr>
	    <div class="row justify-content-center">
            <div class="col-md-6">
                    <div class="card">
                        <div class="card-header text-center"><h4>Add Feedback</h4></div>
                        <div class="card-body">
                            <form name="my-form" action="submit_feedback" method="Post" >
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
                                    <label for="feedback" class="col-md-4 col-form-label text-md-right">Feedback</label>
                                    <div class="col-md-6">
                                        <input type="text" id="feedback" class="form-control" name="feedback">
                                    </div>
                                </div>
                                <div class="col-md-4 offset-md-4 text-center">
                                    <button type="submit" class="btn btn-primary">
                                    Submit
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                 </div>
            </div>
</body>
</html>