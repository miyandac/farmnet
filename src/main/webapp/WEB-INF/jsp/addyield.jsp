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
        <title> Add Yield</title>
        <%@include file="fragments/css.jsp" %>
    </head>
    
    <body id="page-top">
        <%@include file="fragments/header.jsp" %>
         
          <div class="card mb-4">
            <div class="card-header">
                Add Yield
            </div>
            <div class="card-body"> 
                <form method="POST" action="${contextPath}/addyield">
                    <div class="form-group">
                        <label for="">Crop</label>
                        <input type="text" class="form-control" id ="crop" name ="crop" placeholder="crop">
                    </div>
                    <div class="form-group">
                        <label for="">Weight</label>
                        <input type="number" class="form-control" id ="weight" name ="weight" placeholder="weight">
                    </div>
                    <div class="form-group">
                        <label for="">Date of Yield</label>
                        <input type="date" class="form-control" id ="dateofyield" name ="dateofyield" placeholder="date of yield">
                    </div>
                    <div class="form-group">
                        <label for="">Quantity</label>
                        <input type="number" class="form-control" id ="quantity" name ="quantity" placeholder="Quantity">
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
