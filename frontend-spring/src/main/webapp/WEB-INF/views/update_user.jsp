<%@ include file="header.jsp" %>
<%@ include file="login_req.jsp" %>
<html>
<head>
	<title>Update User</title>
</head>
<body>
	 <div class="row justify-content-center">
            <div class="col-md-6">
                    <div class="card">
                        <div class="card-header text-center"><h4>Update User</h4></div>
                        <div class="card-body">
                            <form name="my-form" action="edit_user" method="Post" modelAttribute="user">
                                 <input type="hidden" id="user_id" name="user_id" value="${auth.obj.user_id}">
                                <div class="form-group row">
                                    <label for="username" class="col-md-4 col-form-label text-md-right">Username</label>
                                    <div class="col-md-6">
                                        <input type="text" id="username" class="form-control" name="name" value="${auth.obj.name }">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="phone" class="col-md-4 col-form-label text-md-right">Phone Number</label>
                                    <div class="col-md-6">
                                        <input type="text" id="phone" class="form-control" name="phone" value="${auth.obj.phone }">
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <label for="email" class="col-md-4 col-form-label text-md-right">E-Mail</label>
                                    <div class="col-md-6">
                                        <input type="email" id="email" class="form-control" name="email" value="${auth.obj.email }">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="address" class="col-md-4 col-form-label text-md-right">Address</label>
                                    <div class="col-md-6">
                                        <input type="text" id="address" class="form-control" name="address" value="${auth.obj.address }">
                                    </div>
                                </div>


                                <div class="form-group row">
                                    <label for="upload_photo" class="col-md-4 col-form-label text-md-right">Upload photo</label>
                                    <div class="col-md-6">
                                        <input type="text" id="upload_photo" class="form-control" name="upload_photo" value="${auth.obj.upload_photo }">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="password" class="col-md-4 col-form-label text-md-right">Password</label>
                                    <div class="col-md-6">
                                        <input type="password" id="password" class="form-control" name="password" value="${auth.obj.password }">
                                    </div>
                                </div>

                                <div class="col-md-4 offset-md-4 text-center">
                                    <button type="submit" class="btn btn-info">
                                    Update User
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                 </div>
            </div>
</body>
</html>