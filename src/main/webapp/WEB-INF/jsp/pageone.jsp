<%-- 
    Document   : pageone
    Created on : 26-Oct-2019, 23:19:06
    Author     : CHILIKWEM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="fragments/requirements.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        <table border="1">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Gender</th>
                    <th>User Role</th>
                    <th>Address</th>
                </tr>
            </thead>
            <tbody>

                <c:forEach items="${users}" var="a">
                    <tr>
                        <td>${a.firstname} ${a.lastname}</td>
                        <td>${a.email}</td>
                        <td>${a.gender}</td>
                        <td>${a.userrole}</td>
                        <td>${a.address}</td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
        <a href="home">Home</a>
    </body>
</html>
