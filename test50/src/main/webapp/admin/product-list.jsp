<%@page import="models.Category"%>
<%@page import="java.util.List"%>
<%@page import="Dao.CategoryDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<jsp:include page="/shared/header.jsp"></jsp:include>
		
	<div class="container">
		
			
			
		<div class="alert alert-info " role="alert">
					All the products for the Supllier (<%=session.getAttribute("userName")%>) </div>
		<a class="btn btn-primary" href="<%=request.getContextPath()%>/admin/add-new-product">Add new product</a>
					
		
	<%CategoryDao c=new CategoryDao();
	String categoryname="";
	%>

	 
					<input type="text" id="myInput" onkeyup="SearchFunction()" placeholder="Search for products..">
					
		<table id="myTable" class="table sortable ">
		
		 <thead>
		  <tr>
			    <th>photo</th>
			    <th>Name<span>&uarr;</span></th>
			    <th>description<span>&uarr;</span></th>
			    <th>price<span>&uarr;</span></th>
			    <th>stock_number<span>&uarr;</span></th>
			    <th>in stock ?<span>&uarr;</span></th>
			    <th>category_id<span>&uarr;</span></th>
			    <th>process</th>
		    
		  </tr>
		  </thead>
		  <c:forEach items="${products }" var="product">
		    <tr>
		      <td>
					<!-- <img src="../images/note9.jpg" width="40px"> -->
					<img src="<%=request.getContextPath()+"/"%>${product.photo_path}"  height="60px" width="50px">
					
				
		      </td>
		      <td>${product.name }</td>
		      <td>${product.description}</td>
		       <td >${product.price} $</td>
		      <td >${product.stock_number }</td>
		      <td>${product.is_in_stock}</td>
		       <td>${product.category_id}</td>
		      <td>
		      	<a href="../admin/update-product?product_id=${product.product_id}" class="btn btn-warning">Update</a>
		      </td>
		      <td>
		      	<a href="../admin/delete-product?product_id=${product.product_id}" class="btn btn-danger">Delete</a>
		      </td>
		    </tr>
		  </c:forEach>
		</table>
					
					
					
					
					
				
			
	</div>

<script src="<%=request.getContextPath()%>/js/myscripts.js"></script>


			 
</body>
</html>