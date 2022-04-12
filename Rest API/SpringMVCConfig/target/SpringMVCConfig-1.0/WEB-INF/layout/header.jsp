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
            <a class="nav-link" href="<c:url value="/"/>">Trang chu</a>
        </li>
        <c:forEach var="cat" items="${categories}">
            <li class="nav-item">
                <a class="nav-link" href="#">${cat.name}</a>
            </li>
        </c:forEach>

        <li class="nav-item">
            <a class="nav-link"  href="<c:url value="/cart" />">Gio Hang</a>
        </li>
        <c:if test="${pageContext.request.userPrincipal.name == null}">
            <li class="nav-item">
                <a class="nav-link text-danger"  href="<c:url value="/login" />">Dang Nhap</a>
            </li>       
            <li class="nav-item">
                <a class="nav-link text-danger"  href="<c:url value="/register" />">Dang Ky</a>
            </li>  
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <li class="nav-item">
                <a class="nav-link text-danger"  href="<c:url value="/" />">${pageContext.request.userPrincipal.name }</a>
            </li>   
            <li class="nav-item">
                <a class="nav-link text-danger"  href="<c:url value="/logout" />">Log out</a>
            </li>  
        </c:if>


        <li class="nav-item">
            <a class="nav-link text-danger"  href="<c:url value="/cart" />">Gio hang 
                <span class="badge badge-danger" id="cart-counter">${cartCounter}</span>
            </a>
        </li>      
    </ul>
</nav>

