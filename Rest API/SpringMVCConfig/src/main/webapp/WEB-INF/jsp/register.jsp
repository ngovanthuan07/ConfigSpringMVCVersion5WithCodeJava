<%-- 
    Document   : register
    Created on : Apr 9, 2022, 10:57:01 PM
    Author     : ngova
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/register" var="action" />
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1 class="text-danger">DANG KY</h1>
<form:form mothod="post" action="${action}" modelAttribute="user">
    <div class="form-group"> 
        <label>First Name</label>
        <form:input type="text" id="firstname" class="form-control" path="firstName"/>
    </div> 
    <div class="form-group"> 
        <label>Last Name</label>
        <form:input type="text" id="lastname" class="form-control" path="lastName"/>
    </div> 
    <div class="form-group"> 
        <label>Email</label>
        <form:input type="text" id="lastname" class="form-control" path="email"/>
    </div> 
    <div class="form-group"> 
        <label>Username</label>
        <form:input type="text" id="username" class="form-control" path="username"/>
    </div> 
    <div class="form-group"> 
        <label>Password</label>
        <form:input type="password" id="password" path="password" class="form-control"/>
    </div> 
    <div class="form-group"> 
        <label>Password</label>
        <form:input type="password" id="confirm-password" path="confirmPassword" class="form-control"/>
    </div> 
    <div class="form-group"> 
        <input type="submit" value="DANG KY" class="btn btn-danger"/>
    </div>
</form:form>
