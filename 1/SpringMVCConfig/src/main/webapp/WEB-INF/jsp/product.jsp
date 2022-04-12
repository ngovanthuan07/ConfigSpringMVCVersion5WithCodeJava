<%-- 
    Document   : product
    Created on : Apr 3, 2022, 8:59:09 PM
    Author     : ngova
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<h1 class="text-center text-danger">QUAN LY SAN PHAM</h1>

<c:url value="/admin/products" var="action" />


<form:form method="post" action="${action}" modelAttribute="product"
           enctype="multipart/form-data">
    <div class="form-group">
        <label>Anh san pham</label>
        <form:input type="file" id="file" path="file" cssClass="form-control"/>
    </div>
    <div class="form-group">
        <input type="submit" value="Them san pham" class="btn btn-danger"/>
    </div>
</form:form>