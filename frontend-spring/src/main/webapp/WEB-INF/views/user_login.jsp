<%@ include file="header.jsp" %>
<html>
<head>
	<title>Login Page</title>
</head>
<body>

<hr>
	    <div class="row justify-content-center">
            <div class="col-md-6">
                    <div class="card">
                        <div class="card-header text-center"><h4>Log in</h4></div>
                        <div class="card-body">
                            <form name="my-form" action="loginProcess" method="Post" modelAttribute="user">
                                <div class="form-group row">
                                    <label for="username" class="col-md-4 col-form-label text-md-right">Username</label>
                                    <div class="col-md-6">
                                        <input type="text" id="username" class="form-control" name="username" value="${username}">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="password" class="col-md-4 col-form-label text-md-right">Password</label>
                                    <div class="col-md-6">
                                        <input type="password" id="password" class="form-control" name="password">
                                    </div>
                                </div>
                                <div class="col-md-4 offset-md-4 text-center">
                                    <button type="submit" class="btn btn-success">
                                    Login
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                 </div>
            </div>
</body>
</html>