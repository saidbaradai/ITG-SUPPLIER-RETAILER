<%@page import="models.Product"%>
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

<% Product p=(Product)request.getAttribute("productFromDb");%>
			
	<div class="container">
			<div class="row">
			<div class="col-md-6">
				<form action="../admin/save-updated-product" method="post" enctype='multipart/form-data'>
					  <div class="form-group">
					    <label for="exampleInputEmail1">Product name</label>
					    <input type="text" class="form-control"   name="name" required value="<%= p.getName()%>"	>
					  </div>
					  
					  <div class="form-group">
					    <label for="exampleInputEmail1">description</label>
					    <input type="text" class="form-control"   name="description" required value="<%= p.getDescription()%>">
					  </div>
					  
					  <div class="form-group">
					    <label for="exampleInputEmail1">photo path</label>
					    <input type="hidden" class="form-control"   name="photo_path" required value="<%= p.getPhoto_path()%>">
					  </div>
					  
					  <div class="form-group">
					    <label for="exampleInputEmail1">price</label>
					    <input type="number" step="0.01"class="form-control"   name="price" required value="<%= p.getPrice()%>">
					  </div>
					  
					  <div class="form-group">
					    <label for="exampleInputEmail1">stock_number</label>
					    <input type="number" class="form-control"   name="stock_number" required value="<%= p.getStock_number()%>">
					  </div>
					  
					  
					  
					  <div class="form-group">
					    <label for="">Category</label>
					    
					    <% CategoryDao c=new CategoryDao();
		
						List<Category> categories=c.ListAllCategories(Integer.parseInt(request.getSession().getAttribute("UserId").toString()));%>
		
					     <select name="category_id" class="form-control" required  value="<%= p.getCategory_id()%>">
						     <option disabled selected value> -- select a category -- </option>
						     <%
								for (int i = 0; i < categories.size(); i++) {
								%>
									<option value=<%out.println(categories.get(i).getCategory_id());%>  <c:if test="${categories.get(i).getCategory_id() == p.getCategory_id()}">selected</c:if> >
										 <%out.println(categories.get(i).getName());%>
									 </option>
								<%
								}
								%>
						 </select>
					  </div>
					   
					  <div class="form-group">
					    <label for="">Is in stock? </label><br>
					    <% if( p.isIs_in_stock()==true){ %>
						    <input name="is_in_stock" type="radio" value="true" required checked =true  /> Yes<br>
							<input name="is_in_stock" type="radio" value="false" required /> No
					    <%}  else{%>
					    	<input name="is_in_stock" type="radio" value="true" required  /> Yes<br>
							<input name="is_in_stock" type="radio" value="false" required checked /> No
					    <%} %>
					  </div>
					  
					  <div class="form-group">
							    <label for="exampleInputEmail1">image</label>
							     <input type="file" id="file-input" name="image"/>
						  	</div>
					
					  
					  <input name="db_product_id" type="hidden" value="<%= p.getProduct_id()%>"  />
					  <button type="submit" class="btn btn-warning">update</button>
					</form>
					
					
					</div>
					
					<div class="col-md-6">
						<img id="preview" src="<%=request.getContextPath()+"/"+p.getPhoto_path()%>" alt="Image preview" width="400">
					</div>
					
			</div>



	</div>


  <script>
  const fileInput = document.getElementById("file-input");
  const preview = document.getElementById("preview");

  fileInput.addEventListener("change", function (event) {
    const file = event.target.files[0];
    const reader = new FileReader();

    reader.onloadend = function () {
      preview.src = reader.result;
    }

    if (file) {
      reader.readAsDataURL(file);
    } else {
      preview.src = "";
    }
  });
  </script>



</body>
</html>