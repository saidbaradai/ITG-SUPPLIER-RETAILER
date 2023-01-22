<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.List"%>
<%@page import="models.CardItem"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/card-style.css">


<link  rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<link  rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js">

<link  rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">

<link  rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">

<meta charset="ISO-8859-1">
<title>Insert title here</title>


</head>
<body>
	<jsp:include page="/shared/retailer-header.jsp"></jsp:include>
	
	
	<%

		List<CardItem> cartList=(ArrayList<CardItem>)request.getSession().getAttribute("card_list");

	   
	%>
<div class="container">


<div class="card">

            <div class="row">
                <div class="col-md-8 cart">
                    <div class="title">
                        <div class="row">
                            <div class="col"><h4><b>Shopping Cart</b></h4></div>
                            <div class="col align-self-center text-right text-muted"> items <i class="fas fa-shopping-cart"></i></div>
                        </div>
                    </div>  
                    
                    
                    
				         <% double total_price=0;
						for (int i = 0; i < cartList.size(); i++) {
							total_price+=cartList.get(i).getQuantity()*cartList.get(i).getPrice();
						%>
                    <div class="row border-top border-bottom">
                        <div class="row main align-items-center">
                            <div class="col-2"><img class="img-fluid" style="width:400px;" src="<%=request.getContextPath()+"/"+cartList.get(i).getPhoto_path()%>"></div>
                            <div class="col">
                                <div class="row text-muted">Shirt</div>
                                <div class="row"><%out.println(cartList.get(i).getName());%></div>
                            </div>
                             <div class="col">$ <%out.println(cartList.get(i).getPrice());%> </div>
                            
                            <div class="col">
                                   <div class="col">x <%out.println(cartList.get(i).getQuantity());%> </span></div>
                            </div>
                            
                            <div class="col">
                                   <div class="col">= <%out.println(cartList.get(i).getQuantity()*cartList.get(i).getPrice());%> </span></div>
                            </div>
                        </div>
                    </div>
                    
                    
                    
                     <%} %>
                    
                    
                     
                    <div class="back-to-shop"><a href="#">&leftarrow;</a><span class="text-muted">Back to shop</span></div>
                   
                </div>
                <div class="col-md-4 summary">
                    <div><h5><b>Summary</b></h5></div>
                    <hr>
                    <div class="row">
                        <div class="col" style="padding-left:0;">ITEMS 3</div>
                        <div class="col text-right">$ <%=(int)total_price%></div>
                    </div>
                    <form>
                        <p>SHIPPING</p>
                        <select><option class="text-muted">Standard-Delivery- &euro;0.00</option></select>
                        <p>GIVE CODE</p>
                        <input id="code" placeholder="Enter your code">
                    </form>
                    <div class="row" style="border-top: 1px solid rgba(0,0,0,.1); padding: 2vh 0;">
                        <div class="col">TOTAL PRICE</div>
                        <div class="col text-right">$ <%=(int)total_price%></div>
                    </div>
                    <button class="btn">CHECKOUT</button>
                </div>
            </div>
            
        </div>




</div>








</body>
</html>