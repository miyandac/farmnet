<%-- 
    Document   : home
    Created on : 26-Oct-2019, 23:06:39
    Author     : CHILIKWEM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="fragments/requirements.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <%@include file="fragments/css.jsp" %>
    </head>
    <body id="page-top">
        <%@include file="fragments/header.jsp" %>
        <h1>Welcome home!</h1>

        <a href="${contextPath}/addinventory">Add Inventory item</a>
        
        <%@include file="fragments/footer.jsp" %>
    </body>
</html>
