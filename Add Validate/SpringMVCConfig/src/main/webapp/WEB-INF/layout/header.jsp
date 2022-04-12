<%-- 
    Document   : header
    Created on : Apr 2, 2022, 9:13:23 PM
    Author     : ngova
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <ul class="navbar-nav">
        <li class="nav-item active">
            <a class="nav-link" href="/">Trang chu</a>
        </li>
        <c:forEach var="cat" items="${categories}">
            <li class="nav-item">
                <a class="nav-link" href="#">${cat.name}</a>
            </li>
        </c:forEach>

        <li class="nav-item">
            <a class="nav-link"  href="<c:url value="/cart" />">Gio Hang</a>
        </li>

    </ul>
</nav>

