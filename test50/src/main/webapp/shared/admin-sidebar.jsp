
<%@page import="Dao.CategoryDao"%>
<%@page import="models.Category"%>
<%@page import="java.util.List"%>

<style>
.list-group-hover .list-group-item:hover {
    background-color: #f5f5f5;
}
</style>
<div class="list-group">



<%
CategoryDao c=new CategoryDao();

		List<Category> categories2=c.ListAllCategories();%>

<a href="#" class="list-group-item list-group-item-action  ">
			All Products
		</a>

		<%
		for (int i = 0; i < categories2.size(); i++) {
		%>

		<a href="#" class="list-group-item list-group-item-action  ">
			<%
			out.println(categories2.get(i).getName());
			%>
		</a>
		<%
		}
		%>


</div>