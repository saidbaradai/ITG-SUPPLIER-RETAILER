<%@page import="Dao.CategoryDao"%>
<%@page import="models.Product"%>
<%@page import="java.util.List"%>
<%@page import="Dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.card img{cursor: pointer;}

</style>
</head>
<body>
	<jsp:include page="/shared/retailer-header.jsp"></jsp:include>




		<% CategoryDao categoryDao=new CategoryDao(); int c_id;%>
				
		<div class="container">
				<div class="row">
						<div class="col-md-3">
							<jsp:include page="/shared/retailer-sidebar.jsp"></jsp:include>
			   </div>
			<div class="col-md-9  " >
				<div class="row">
				<c:forEach items="${products}" var="product">
				
						
							<div class="col-md-4" style="margin-bottom: 2%;">
								<div class="card border border-success rounded " style="border-color:#5bc0de !important;" >
						            <div class="d-flex justify-content-between p-3">
						              <p class="lead mb-0">bir reklam</p>
						              <div class="bg-info rounded-circle d-flex align-items-center justify-content-center shadow-1-strong" style="width: 35px; height: 35px;">
						                <p class="text-white mb-0 small">x2</p>
						              </div>
						            </div>
						            
						            <a href="<%=request.getContextPath()%>/retailer/product-details?product_id=${product.product_id}">
						            	<img src="<%=request.getContextPath()+"/"%>${product.photo_path}" class="card-img-top" alt="Laptop" style="height: 320px" >
						            </a>
						            <div class="card-body">
						              <div class="d-flex justify-content-between">
						                <p class="small"><a href="#!" class="text-muted"> <%= categoryDao.getCategoryById(347).getName()%></a></p>
						                <p class="small text-danger"><s></s> </p>
						              </div>
						
						              <div class="d-flex justify-content-between mb-3">
						                <h5 class="mb-0">${product.name}</h5>
						                <h5 class="text-dark mb-0">${product.price}$</h5>
						              </div>
						
						              <div class="d-flex justify-content-between mb-2">
						                <p class="text-muted mb-0">Available: <span class="fw-bold">${product.stock_number}</span></p>
						                <div class="ms-auto text-warning">
						                  <i class="fas fa-star"></i>
						                  <i class="fas fa-star"></i>
						                  <i class="fas fa-star"></i>
						                  <i class="fas fa-star"></i>
						                  <i class="far fa-star"></i>
						                </div>
						              </div>
						            </div>
						          </div>
							</div>
							
							
					</c:forEach>
				</div>
			</div>
			
			
			
		</div>
	</div>
		


</body>
</html>