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

        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Fields</h6>
            </div>
            <div class="card-body">
                <a class="btn btn-success" href="${contextPath}/${farm.id}/addfield">Add Field</a>

                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>Length</th>
                                <th>Breadth</th>
                                <th>Crop</th>
                                <th>Date Created</th>
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach items="${fields}" var="a">
                                <tr>
                                    <td>${a.length}</td>
                                    <td>${a.breadth}</td>
                                    <td>${a.crop}</td>
                                    <td>${a.datecreated}</td>
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
