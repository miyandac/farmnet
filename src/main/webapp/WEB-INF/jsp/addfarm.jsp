<%-- 
    Document   : addyield
    Created on : 05-Nov-2019, 20:38:27
    Author     : CHILIKWEM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="fragments/requirements.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Add Farm</title>
        <%@include file="fragments/css.jsp" %>
    </head>
    
    <body id="page-top">
        <%@include file="fragments/header.jsp" %>
         
          <div class="card mb-4">
            <div class="card-header">
                Add Farm
            </div>
            <div class="card-body"> 
                <form method="POST" action="${contextPath}/addfarm">
                    <div class="form-group">
                        <label for="">Farm Name</label>
                        <input type="text" class="form-control" id ="name" name ="name" placeholder="name">
                    </div>
                    <div class="form-group">
                        <label for="">Breadth</label>
                        <input type="number" class="form-control" id ="breadth" name ="breadth" placeholder="breadth">
                    </div>
                    <div class="form-group">
                        <label for="">Length</label>
                        <input type="number" class="form-control" id ="length" name ="length" placeholder="length">
                    </div>
                    <div class="form-group">
                        <label for="">Location</label>
                        <input type="text" class="form-control" id ="location" name ="location" placeholder="location">
                    </div>
                    <div class="form-group">
                        <input type="submit" class="btn btn-success btn-block" value="Submit">
                     </div>
                </form>
            </div>
        </div>


        <%@include file="fragments/footer.jsp" %>       
    </body>
</html>
