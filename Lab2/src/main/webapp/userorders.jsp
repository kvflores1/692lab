<%-- 
    Document   : userorders
    Created on : Feb 10, 2022, 12:00:00 PM
    Author     : Wei Ru Dong
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="com.mycompany.lab2.OrderHistory"%>
<!DOCTYPE html>


<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Order</title>
    </head>
    <style>

body {
  background-color: #E6E6FA;

}
</style>
<% 
    ArrayList<OrderHistory> orders= (ArrayList)request.getAttribute("OrderHistoryInfo");
  
%>

<center><h2>Hello <%=session.getAttribute("uname")%></h2></center>
<br>
<center><h3> The following are your orders</h3></center>
<br>
<form action="AddToCart" method="post">
<table border="2" align="center" cellpadding="5" cellspacing="5">

<tr>
   
<th> Name </th>
<th> Brand </th>
<th> Earliest Pickup Date </th>
<th> Available for Pickup </th>

</tr>

    <% for(OrderHistory order: orders){
    %>
<tr>
<td> <%=order.getProductName()%> </td>
<td> <%=order.getProductBrand()%></td>
<td> <%=new SimpleDateFormat("yyyy-MM-dd").format(order.getPickupDate())%></td>
<% if (order.isAvailable()){
%>
<td> <input type="submit" value="Add to Cart for Pickup" ></td>
<%}

else {
%>


<td> "The product is not available for pickup"</td>
<% }}
%>
</tr>
</table>
</form>
</body>
</html>
