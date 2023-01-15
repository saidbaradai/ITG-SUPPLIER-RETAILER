<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



	<jsp:include page="/shared/header.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<jsp:include page="/shared/admin-sidebar.jsp"></jsp:include>
			</div>
			<div class="col-sm-9 ">
				<div class="alert alert-warning" role="alert">
					you have no orders</div>
			</div>

		</div>
	</div>



</body>
</html>