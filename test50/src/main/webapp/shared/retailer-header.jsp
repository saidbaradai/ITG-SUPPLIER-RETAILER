
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<style>
.navbar{
background-color: #5bc0de !important;

}

.nav-item,.nav-link , .navbar-brand, .navbar-text{
color:#fff !important;
font-size:20px;
}


</style>
<div class="container" >
<nav class="navbar navbar-expand-lg navbar-light bg-light "style="background-color: coral;" >
  <a class="navbar-brand" href="<%=request.getContextPath()%>/retailer/index">Home<span class="sr-only">(current)</span></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
      
      <li class="nav-item">
        <a class="nav-link" href="#">Orders</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath()%>/admin/categories-list">Categories</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath()%>/admin/list-products">Products</a>
      </li>
    </ul>
    
    <span>
    	<form id="search-form" action="<%=request.getContextPath()%>/retailer/search-for-pruducts-by-name" method="get"> 
		  <input type="text" placeholder="Search..." name="name_for_search">
		  <button type="submit">Search</button>
		</form>
		    
    </span>
    <span class="nav-item active "  style="color:green;" >
     
      Retailer: <%=session.getAttribute("userName")%>
     
   <svg xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
  <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6Zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0Zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4Zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10Z"/>
</svg>
    </span>
    
     <span class="navbar-text font-weight-bold">
    <form action="<%=request.getContextPath()%>/logout" method="post">
		<button class="btn btn-info" type="submit"> Logout</button>
		</form>
    </span>
    
  </div>
</nav>


<div style="padding:30px;">
</div>
</div>

