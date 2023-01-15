<%@page import="Dao.CategoryDao"%>
<%@page import="java.util.List"%>
<%@page import="models.Category"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page="/shared/header.jsp"></jsp:include>
<div class="container">

				<div class="alert alert-warning" role="alert">
					All categories</div>
					
					<% Category category=(Category)request.getAttribute("existCategory"); %>
					<% if (category==null) {%>
						<form action="../admin/add-category" method="get" class="form-inline" >
					<%}%>
					
					<% if (category!=null) {%>
						<form action="../admin/save-category" method="get" class="form-inline" >
					<%}%>
					
					
					
						 
						  <div class="form-group mx-sm-3 mb-2">
						    <label for="inputPassword2" class="sr-only">Password</label>
						    <% if (category!=null) {%>
							<input type="text" class="form-control" id="categoryName" name="categoryName" placeholder="Enter name" required value="<%=category.getName()%>">
							 <input type="hidden" id="" name="existCategoryId" value="<%= category.getCategory_id()%>">
							<%}%>
							
							 <% if (category==null) {%>
							<input type="text" class="form-control" id="categoryName" name="categoryName" placeholder="Enter name" required >
							<%}%>
							
						  </div>
						  <% if (category==null) {%>
						  <button type="submit" class="btn btn-primary mb-2">Add</button>
						  <%}%>
						  
						  <%if (category!=null){%>
						  <button type="submit" class="btn btn-warning" mb-2">Update</button>
						  <%}%>
					</form>
		
  
  
  
  
  
  

          <div class="row">
  <table class="table table-hover">
    <thead>
      <tr>
        <th class="col-md-8">Category name</th>
        <th></th>
        <th></th>
      </tr>
    </thead>
    <tbody>
    
    
    
    <% 
    CategoryDao c=new CategoryDao();

		List<Category> categories2=c.ListAllCategories();%>

      
		<%
		for (int i = 0; i < categories2.size(); i++) {
		%>
		<tr>
				<td>
					<%
					out.println(categories2.get(i).getName());
					%>
				</td>
				 <td>
		          <a href="../admin/update-category?category_id=<%=categories2.get(i).getCategory_id()%>" >update</a>
		         
		        </td>
		        <td>
		        	<a href="../admin/delete-category?category_id=<%=categories2.get(i).getCategory_id()%>" >Delete</a>

		        </td>
		</tr>
		<%
		}
		%>

       
       

      

    </tbody>
  </table>
  </div>
</div>
  
  
  
  
  
  
  
  
  
  
  
  
  
  
</body>
</html>