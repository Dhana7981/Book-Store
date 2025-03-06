<!DOCTYPE html>
<%@page import="java.util.List"%>
<html>
<head>
<style>
table{
width:90%;
border:1px solid red;
border-collapse:collapse;
}
tr{
height:30px;
}
td{
border:1px solid red;
border-collapse:collapse;
padding:5px;
}
</style>
</head>
<body>
<h2>Welcome to JLC BookStore!!!</h2>
<h2>Your Cart Here</h2>
<table>
<%
Object obj=session.getAttribute("MyCart");
if(obj!=null){
	List<String> cartList=(List<String>)obj;
	if(cartList.isEmpty()){
		%>
		<font color='red' size='4'>No Books in Your Cart, show now</font>
		<%
	}
	int count=1;
	for(String bname:cartList){
		%>
		<tr>
		<td> <%= count++ %></td>
		<td> <%= bname %> </td>
		<td> Rs.250 </td>
		<td> 10% off </td>
		<td>
		<form action="removeFromCart">
		<input type='hidden' name='bname' value="<%= bname %>"/>
		<input type='submit' value="Remove From Cart"/>
		</form>
		</td>
		</tr>
		<%
	}
}
%>
</table>
<div>
<h3>
<a href="showBooks.jsp">Continue Shopping</a>
<a href="placeOrder">Place Order</a>
<a href="index.jsp">Search More</a>
</h3>
</div>
</body>
</html>