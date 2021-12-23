<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="./css/mycss.css">
    <script src="./js/script.js"></script>

</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<img src="./images/arcaic.png"  width="100px"  height="50px">

<br/>

<ul>
    <li><a href="./createCustomer.jsp">Create customer</a> </li>
    <li><a href="./listCustomers.html">list customers</a></li>
    <li><a href="#">select customer</a></li>
    <li><a href="#">update customer</a></li>
    <li><a href="#">delete customer</a></li>

    <li><a href="./api/test">delete customer</a></li>

</ul>



</body>
</html>