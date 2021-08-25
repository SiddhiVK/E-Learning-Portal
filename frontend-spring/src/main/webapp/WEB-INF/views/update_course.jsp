<%@ include file="header.jsp" %>
<%@ include file="admin_login_req.jsp" %>
<html>
<head>
	<title>Update Course</title>
</head>
<body>

<hr>
	    <div class="row justify-content-center">
            <div class="col-md-6">
                    <div class="card">
                        <div class="card-header text-center"><h4>Update Course</h4></div>
                        <div class="card-body">
                            <form name="my-form" action="edit_course" method="Post" >
                                <input type="hidden" id="course_id" name="course_id" value="${course.course_id}">
                                <div class="form-group row">
                                    <label for="c_name" class="col-md-4 col-form-label text-md-right">Course Name</label>
                                    <div class="col-md-6">
                                        <input type="text" id="course_name" class="form-control" name="course_name" value="${course.course_name}">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="c_fees" class="col-md-4 col-form-label text-md-right">Course Fee</label>
                                    <div class="col-md-6">
                                        <input type="number" step="0.01" id="course_fees" class="form-control" name="course_fees" value="${course.course_fees}">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="c_desp" class="col-md-4 col-form-label text-md-right">Description</label>
                                    <div class="col-md-6">
                                        <input type="text" id="c_desp" class="form-control" name="course_desc" value="${course.course_desc}">
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <label for="c_resource" class="col-md-4 col-form-label text-md-right">Resources</label>
                                    <div class="col-md-6">
                                        <input type="text" id="c_resource" class="form-control" name="course_resource" value="${course.course_resource}">
                                    </div>
                                </div>
                                
                                <div class="col-md-4 offset-md-4 text-center">
                                    <button type="submit" class="btn btn-primary">
                                    Update Course
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                 </div>
            </div>

</body>
</html>