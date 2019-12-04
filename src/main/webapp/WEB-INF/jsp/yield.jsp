<%-- 
    Document   : yield
    Created on : 04-Nov-2019, 13:39:29
    Author     : CHILIKWEM
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


        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Yield</h6>
            </div>
            <div class="card-body">
                  <div class="table-responsive">
                   <a class="btn btn-success" href="${contextPath}/addyield">Add Yield</a>
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>Yield id</th>
                                <th>Crop</th>
                                <th>Weight</th>                            
                                <th>Date of Yield</th>
                            </tr>
                        </thead>
                        <tbody>

                            <c:forEach items="${yield}" var="a">
                                <tr>
                                    <td>${a.yieldid}</td>
                                    <td>${a.crop}</td>
                                    <td>${a.weight}</td>
                                    <td>${a.dateofyield}</td>
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

