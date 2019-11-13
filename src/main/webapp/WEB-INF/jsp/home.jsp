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
        <h1>Welcome to Farm Management System</h1>
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Field Events</h6>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>Farm</th>
                                <th>Field</th>
                                <th>Date</th>
                                <th>Description</th>
                                <th>Created By</th>
                                <th>Report</th>
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach items="${events}" var="a">
                                <tr>
                                    <td>${a.farm.name}</td>
                                    <td>${a.field.id}</td>
                                    <td>${a.dateofevent}</td>
                                    <td>${a.description}</td>
                                    <td>${a.createdby.firstname}</td>
                                    <td>${a.eventreport}</td>
                                </tr>
                            </c:forEach>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <%@include file="fragments/footer.jsp" %>
    </body>
</html>
