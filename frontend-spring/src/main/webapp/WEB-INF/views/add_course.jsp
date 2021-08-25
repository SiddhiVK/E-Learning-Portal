<%@ include file="header.jsp" %>
<%@ include file="admin_login_req.jsp" %>
<html>
<head>
	<title>Course Page</title>
</head>
<body>

<hr>
	    <div class="row justify-content-center">
            <div class="col-md-6">
                    <div class="card">
                        <div class="card-header text-center"><h4>Add Course</h4></div>
                        <div class="card-body">
                            <form name="my-form" action="submit_course" method="Post" >
                                
                                <div class="form-group row">
                                    <label for="c_name" class="col-md-4 col-form-label text-md-right">Course Name</label>
                                    <div class="col-md-6">
                                        <input type="text" id="c_name" class="form-control" name="c_name">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="c_fees" class="col-md-4 col-form-label text-md-right">Course Fee</label>
                                    <div class="col-md-6">
                                        <input type="number" step="0.01" id="c_fees" class="form-control" name="c_fees">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="c_desp" class="col-md-4 col-form-label text-md-right">Description</label>
                                    <div class="col-md-6">
                                        <input type="text" id="c_desp" class="form-control" name="c_desp">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="c_resource" class="col-md-4 col-form-label text-md-right">Resources</label>
                                    <div class="col-md-6">
                                        <input type="text" id="c_resource" class="form-control" name="c_resource">
                                    </div>
                                </div>
                                
                                <div class="col-md-4 offset-md-4 text-center">
                                    <button type="submit" class="btn btn-primary">
                                    Add Course
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                 </div>
            </div>

</body>
</html>