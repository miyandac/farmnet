<%-- 
    Document   : field
    Created on : Nov 5, 2019, 6:14:14 PM
    Author     : MUNDIAG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="fragments/requirements.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Yield</title>
    <%@include file="fragments/css.jsp" %>
    </head>
        <body id="page-top">
    <%@include file="fragments/header.jsp" %>
    <body>
       
        <a class="btn btn-success" href="${contextPath}/${farm.id}/addfield">Add Field</a>
        
        <br/>
        ${fields}
    <%@include file="fragments/footer.jsp" %>
    </body>
</html>
