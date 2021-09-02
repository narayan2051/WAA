<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Registration</title>
</head>
<body>
<div class="container ml-50 mr-50">
    <h1>Registration Form</h1><br/>
    <form:form method="post" modelAttribute="student">
        <form:errors path="*" cssStyle="color:red" element="div"/>
        <div class="form-group">
            <label for="id">Student Id:</label>
            <input path="id" class="form-control" id="id" name="id"/>
            <form:errors path="id" cssStyle="color:red" element="div"/>
        </div>
        <div class="form-group">
            <label>FirstName:</label>
            <input class="form-control" id="firstName" name="firstName"/>
            <form:errors path="firstName" cssStyle="color:red" element="div"/>
        </div>
        <div class="form-group">
            <label for="lastName"> LastName:</label>
            <input type="text" class="form-control" id="lastName" name="lastName">
            <form:errors path="lastName" cssStyle="color:red" element="div"/>
        </div>
        <div class="form-group">
            <label for="gender"> Gender:</label>
            <input type="text" class="form-control" id="gender" name="gender">
            <form:errors path="gender" cssStyle="color:red" element="div"/>
        </div>
        <div class="form-group">
            <label for="gender"> Birth Date:</label>
            <input class="form-control" id="birthday" name="birthday">
            <form:errors path="birthday" cssStyle="color:red" element="div"/>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="text" class="form-control" name="email" id="email">
            <form:errors path="email" cssStyle="color:red" element="div"/>
        </div>
        <div><h3>Phone Details</h3></div>
        <div class="form-group">
            <label for="phone.area">Area:</label>
            <input type="text" class="form-control" id="phone.area" name="phone.area">
            <form:errors path="phone.area" cssStyle="color:red" element="div"/>
        </div>
        <div class="form-group">
            <label for="phone.prefix">Prefix:</label>
            <input type="text" class="form-control" id="phone.prefix" name="phone.prefix">
            <form:errors path="phone.prefix" cssStyle="color:red" element="div"/>
        </div>
        <div class="form-group">
            <label for="phone.number">Number:</label>
            <input type="text" class="form-control" id="phone.number" name="phone.number">
            <form:errors path="phone.number" cssStyle="color:red" element="div"/>
        </div>
        <div class="form-group">
            <input type="submit" class="btn btn-success">
            <input type="reset" class="btn btn-danger">
        </div>
    </form:form>
</div>
</body>
</html>


</body>
</html>