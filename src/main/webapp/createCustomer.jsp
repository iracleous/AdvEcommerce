<%--
  Created by IntelliJ IDEA.
  User: dimitris
  Date: 12/8/2021
  Time: 1:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body>

<h1> New Customer</h1>

<form onSubmit="return false">
    <input type="text" name = "fullName" id = "fullName" placeholder="fullName"/> <br />
    <input type="email" name = "email" id = "email" placeholder="email"/> <br />
    <input type="date" name = "dateOfBirth" id = "dateOfBirth" placeholder="dateOfBirth"/> <br />

    <button   onclick="submitToServer()"> submit</button>
</form>


<div id="resultArea"></div>

<script>
    function submitToServer() {
        url = "http://localhost:8080/AdvEcommerce-1.0-SNAPSHOT/api/customer";
        method = "post";
        contentType = 'application/json';
        data = JSON.stringify({
            fullName: $('#fullName').val(),
            email: $('#email').val()
        });
        console.log(url);

        $.ajax({
            url: url,
            method: method,
            contentType: contentType,
            data: data
        })
            .done(result =>

                {

$("#resultArea").html(result.fullName +   '    '+  result.email)


                }


            )
            .fail(failure => alert(JSON.stringify(failure)));

    }

</script>
</body>
</html>
