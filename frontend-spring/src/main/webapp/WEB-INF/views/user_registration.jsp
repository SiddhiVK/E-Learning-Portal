<%@ include file="header.jsp" %>
<html>
<head>
	<title>Registration Page</title>
</head>
<body>

<hr>
	    <div class="row justify-content-center">
            <div class="col-md-6">
                    <div class="card">
                        <div class="card-header text-center"><h4>User Registration</h4></div>
                        <div class="card-body">
                            <form name="my-form" action="registrationProcess" method="Post" modelAttribute="user">
                                
                                <div class="form-group row">
                                    <label for="username" class="col-md-4 col-form-label text-md-right">Username</label>
                                    <div class="col-md-6">
                                        <input type="text" id="username" class="form-control" name="username">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="phone" class="col-md-4 col-form-label text-md-right">Phone Number</label>
                                    <div class="col-md-6">
                                        <input type="text" id="phone" class="form-control" name="phone">
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <label for="email" class="col-md-4 col-form-label text-md-right">E-Mail</label>
                                    <div class="col-md-6">
                                        <input type="email" id="email" class="form-control" name="email">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="address" class="col-md-4 col-form-label text-md-right">Address</label>
                                    <div class="col-md-6">
                                        <input type="text" id="address" class="form-control" name="address">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="reg_date" class="col-md-4 col-form-label text-md-right">Reg. date</label>
                                    <div class="col-md-6">
                                        <input type="text" id="reg_date" class="form-control" name="reg_date">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="upload_photo" class="col-md-4 col-form-label text-md-right">Upload photo</label>
                                    <div class="col-md-6">
                                        <input type="text" id="upload_photo" class="form-control" name="upload_photo">
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
                                    Register
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                 </div>
            </div>

</body>
</html>