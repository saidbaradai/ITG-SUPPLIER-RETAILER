<%@page import="Dao.ProductDao"%>
<%@page import="models.User"%>
<%@page import="java.util.List"%>
<%@page import="Dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <% UserDao userDao=new UserDao(); 
    List<User> suppliersList =userDao.GetSuppliersList();
    ProductDao productDao=new ProductDao();
    %>
    
    
    
<div class="card">
	<article class="card-group-item">
		<header class="card-header"><h6 class="title">All suppliers </h6></header>
		<div class="filter-content">
			<div class="list-group list-group-flush">
			<a  class="list-group-item" href="<%=request.getContextPath()%>/retailer/index">LIST ALL PRODUCTS</a>
				
			 	
			 	
			 	<%
		for (int i = 0; i < suppliersList.size(); i++) {
		%>

		 <a href="<%=request.getContextPath()%>/retailer/list-pruducts-by-supplier?supplier_id=<%=suppliersList.get(i).getUser_id()%>" class="list-group-item">${supplier.name} 

			<%
			out.println(suppliersList.get(i).getName());
			%>
			
		<span class="float-right badge badge-light round"> <%=productDao.GetProductNumberBySupplierId(suppliersList.get(i).getUser_id())%></span>  </a>
		<%
		}
		%>
		
		<a  class="list-group-item" href="<%=request.getContextPath()%>/retailer/list-out-of-stock-pruducts">OUT OF STOCKS</a>
			</div>  
		</div>
	</article> 
	<article class="card-group-item">
		<header class="card-header"><h6 class="title">Color check</h6></header>
		<div class="filter-content">
			<div class="card-body">
				<label class="btn btn-danger">
				  <input class="" type="checkbox" name="myradio" value="">
				  <span class="form-check-label">Red</span>
				</label>
				<label class="btn btn-success">
				  <input class="" type="checkbox" name="myradio" value="">
				  <span class="form-check-label">Green</span>
				</label>
				<label class="btn btn-primary">
				  <input class="" type="checkbox" name="myradio" value="">
				  <span class="form-check-label">Blue</span>
				</label>
			</div> <!-- card-body.// -->
		</div>
	</article> <!-- card-group-item.// -->
</div> <!-- card.// -->




<p>Filter  3</p>

<div class="card">
	<article class="card-group-item">
		<header class="card-header">
			<h6 class="title">Range input </h6>
		</header>
		<div class="filter-content">
			<div class="card-body">
			<div class="form-row">
			<div class="form-group col-md-6">
			  <label>Min</label>
			  <input type="number" class="form-control" id="inputEmail4" placeholder="$0">
			</div>
			<div class="form-group col-md-6 text-right">
			  <label>Max</label>
			  <input type="number" class="form-control" placeholder="$1,0000">
			</div>
			</div>
			</div> <!-- card-body.// -->
		</div>
	</article> <!-- card-group-item.// -->
	<article class="card-group-item">
		<header class="card-header">
			<h6 class="title">Selection </h6>
		</header>
		<div class="filter-content">
			<div class="card-body">
				<div class="custom-control custom-checkbox">
					<span class="float-right badge badge-light round">52</span>
				  	<input type="checkbox" class="custom-control-input" id="Check1">
				  	<label class="custom-control-label" for="Check1">Samsung</label>
				</div> <!-- form-check.// -->

				<div class="custom-control custom-checkbox">
					<span class="float-right badge badge-light round">132</span>
				  	<input type="checkbox" class="custom-control-input" id="Check2">
				 	<label class="custom-control-label" for="Check2">Black berry</label>
				</div> <!-- form-check.// -->

				<div class="custom-control custom-checkbox">
					<span class="float-right badge badge-light round">17</span>
				  	<input type="checkbox" class="custom-control-input" id="Check3">
				  	<label class="custom-control-label" for="Check3">Samsung</label>
				</div> <!-- form-check.// -->

				<div class="custom-control custom-checkbox">
					<span class="float-right badge badge-light round">7</span>
				  	<input type="checkbox" class="custom-control-input" id="Check4">
				  	<label class="custom-control-label" for="Check4">Other Brand</label>
				</div> <!-- form-check.// -->
			</div> <!-- card-body.// -->
		</div>
	</article> <!-- card-group-item.// -->
</div> <!-- card.// -->