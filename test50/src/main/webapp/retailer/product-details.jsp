<%@page import="Dao.UserDao"%>
<%@page import="models.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link  rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
<meta charset="ISO-8859-1">
<title>Product details</title>


</head>
<body>

<jsp:include page="/shared/retailer-header.jsp"></jsp:include>
<% Product p=(Product)request.getAttribute("productFromDb");
UserDao userDao = new UserDao(); 
%>
 <!-- Product section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center">
                    <div class="col-md-6" >
                    <img style="max-width: 300px;" class="card-img-top mb-5 mb-md-0" src="<%=request.getContextPath()+"/"+p.getPhoto_path()%>" alt="..." ></div>
                    <div class="col-md-6">
                        <div class="small mb-1">Supplier: 
                         <a href="<%=request.getContextPath()%>/retailer/list-pruducts-by-supplier?supplier_id=<%=p.getSupplier_id()%>"><%= userDao.getUserNameById(p.getSupplier_id())%></a>
                        
                        </div>
                        <h1 class="display-5 fw-bolder"><%= p.getName()%></h1>
                        <div class="fs-5 mb-5">
                            
                            <span ><%= p.getPrice()%></span>
                        </div>
                        <p class="lead"><%= p.getDescription()%></p>
                        <div class="d-flex">
                        <!-- max value should be depending on stocks (said baradai) -->
                            
                            <% if(p.getStock_number()<=0||p.isIs_in_stock()==false) {%>
                            <button class="btn btn-outline-dark flex-shrink-0" type="button" disabled>
                                <i class="bi-cart-fill me-1"></i>
                                Add to cart
                            </button>
                            <%} else{%>
                            
                            
                            <form action="<%=request.getContextPath()%>/retailer/add-to-card" method="get">
                            <input class="form-control text-center me-3" id="inputQuantity" type="number" name="quantity" value="1" style="max-width: 5rem" min="1" step="1"  max="<%= p.getStock_number()%>" />
                            <input type="hidden" name="product_id" value="<%=p.getProduct_id()%>"></input>
	                            <button class="btn btn-outline-dark flex-shrink-0" type="submit" >
	                                <i class="bi-cart-fill me-1"></i>
	                                Add to cart
	                            </button>
                            </form>
                            
                            <%} %>
                        </div>
                    </div>
                </div>
            </div>
        </section>












</body>
</html>