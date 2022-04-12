<%-- 
    Document   : html
    Created on : Mar 31, 2022, 10:18:09 PM
    Author     : ngova
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form"  uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="<c:url value="/css/style.css" />" rel="stylesheet" />
    </head>
    <body>
        <ul>
        
            <c:forEach var="cat" items="${categories}">
                <li>${cat.id} - ${cat.name}</li>
            </c:forEach>
        </ul>
    </body>
</html>
