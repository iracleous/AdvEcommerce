<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<img src="/images/arcaic.png">

<br/>

<h1> New Customer</h1>

<form action="http://localhost:8080/AdvEcommerce-1.0-SNAPSHOT/api/customer" method="post">
    <input type="text" name = "fullName" placeholder="fullName"/> <br />
    <input type="email" name = "email" placeholder="email"/> <br />
    <input type="date" name = "dateOfBirth" placeholder="dateOfBirth"/> <br />

    <input type="submit" />
</form>

<hr>
<h1> Customer List</h1>

</body>
</html>