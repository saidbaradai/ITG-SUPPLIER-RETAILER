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

	 
					
					
		<table class="table">
		  <tr>
		  <th>photo</th>
		    <th>name</th>
		    <th>description</th>
		     <th>price</th>
		    <th>stock_number</th>
		    <th>in stock ?</th>
		     <th>category_id</th>
		    <th>process</th>
		    
		  </tr>
		  <c:forEach items="${products }" var="product">
		    <tr>
		      <td>
					<img src="../images/note9.jpg" width="40px">
		      </td>
		      <td>${product.name }</td>
		      <td>${product.description}</td>
		       <td>${product.price}</td>
		      <td>${product.stock_number }</td>
		      <td>${product.is_in_stock}</td>
		       <td>${product.category_id}</td>
		      <td>
		      	<a href="#" class="btn btn-warning">Update</a>
		      </td>
		      <td>
		      	<a href="#" class="btn btn-danger">Delete</a>
		      </td>
		    </tr>
		  </c:forEach>
		</table>
					
					
					
					
					
				
			
	</div>



			 
</body>
</html>