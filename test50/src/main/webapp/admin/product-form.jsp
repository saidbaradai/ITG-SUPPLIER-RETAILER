<%@page import="models.Category"%>
<%@page import="java.util.List"%>
<%@page import="Dao.CategoryDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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


	<div class="container ">
	<div class="col-md-6">
		<form action="../admin/save-product" method="get">
			  <div class="form-group">
			    <label for="exampleInputEmail1">Product name</label>
			    <input type="text" class="form-control"   name="name" required	>
			  </div>
			  
			  <div class="form-group">
			    <label for="exampleInputEmail1">description</label>
			    <input type="text" class="form-control"   name="description" required>
			  </div>
			  
			  <div class="form-group">
			    <label for="exampleInputEmail1">photo path</label>
			    <input type="text" class="form-control"   name="photo_path" required>
			  </div>
			  
			  <div class="form-group">
			    <label for="exampleInputEmail1">price</label>
			    <input type="number" step="0.01"class="form-control"   name="price" required>
			  </div>
			  
			  <div class="form-group">
			    <label for="exampleInputEmail1">stock_number</label>
			    <input type="number" class="form-control"   name="stock_number" required>
			  </div>
			  
			  
			  
			  <div class="form-group">
			    <label for="">Category</label>
			    
			    <% CategoryDao c=new CategoryDao();

				List<Category> categories=c.ListAllCategories(Integer.parseInt(request.getSession().getAttribute("UserId").toString()));%>

			     <select name="category_id" class="form-control" required >
				     <option disabled selected value> -- select a category -- </option>
				     <%
						for (int i = 0; i < categories.size(); i++) {
						%>
							<option value=<%out.println(categories.get(i).getCategory_id());%>>
								 <%out.println(categories.get(i).getName());%>
							 </option>
						<%
						}
						%>
				 </select>
			  </div>
			  
			  <div class="form-group">
			    <label for="">Is in stock? </label><br>
			    <input name="is_in_stock" type="radio" value="true" required  /> Yes<br>
				<input name="is_in_stock" type="radio" value="false" required /> No
			    
			  </div>
			
			  
			  
			  <button type="submit" class="btn btn-primary">Submit</button>
			</form>
			
			</div>
	</div>










</body>
</html>