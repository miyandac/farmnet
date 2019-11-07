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
        <title>Users</title>
        <%@include file="fragments/css.jsp" %>
    </head>
    <body id="page-top">
        <%@include file="fragments/header.jsp" %>


        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Farms</h6>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <a class="btn btn-success" href="${contextPath}/addfarm">Add Farm</a>
                    
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Breadth</th>
                                <th>Length</th>
                                <th>Location </th>
                                <th>&nbsp; </th>
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach items="${farms}" var="a">
                                <tr>
                                    <td>${a.name}</td>
                                    <td>${a.breadth}</td>
                                    <td>${a.length}</td>
                                    <td>${a.location}</td>
                                    <td><a href="${contextPath}/${a.id}/fields" class="btn btn-success">View Fields</a></td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>


        <a href="home">Home</a>

        <%@include file="fragments/footer.jsp" %>

    </body>
</html>
