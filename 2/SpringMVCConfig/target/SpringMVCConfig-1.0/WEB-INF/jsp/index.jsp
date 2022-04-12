<%-- 
    Document   : index
    Created on : Mar 30, 2022, 12:33:37 PM
    Author     : ngova
    <%@taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1 class="test-center text-danger">DANH MUC SAN PHAM</h1>
<form action="">
    <div class="row">
        <div class="col-md-11">
            <input type="form-control" type="text" name="kw" placeholder="Nhap tu khoa de tim" />
        </div>
        <div class="col-md-1">
            <input type="submit" value="Search" class="btn btn-danger"/>
        </div>
    </div>
</form>

<div class="row">
    <c:forEach var="p" items="${products}">
        <div class="card col-md-4">
            <div class="card-body">
                <img class="img-fluid" src="<c:url value="images/images1.jpg"/>" alt="${p.name}"/>
            </div>
            <div class="card-footer bg-info">
                <h3>${p.name}</h3>
                <p>${p.price} VND</p>
            </div>
        </div>
    </c:forEach>
</div>