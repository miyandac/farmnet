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
                        <select class="form-control" name="crop" id="crop" required="">
                            <c:forEach items="${crops}" var="c">
                                <option value="${c.name}">${c.name}</option>
                            </c:forEach>
                        </select> 
                    </div>
                    <div class="form-group">
                        <label for="">Weight</label>
                        <input type="number" class="form-control" id ="weight" name ="weight" placeholder="weight" required="">
                    </div>
                    <div class="form-group">
                        <label for="">Date of Yield</label>
                        <input type="date" class="form-control" id ="dateofyield" name ="dateofyield" placeholder="date of yield" required="">
                    </div>
                    <div class="form-group">
                        <label for="">Quantity</label>
                        <input type="number" class="form-control" id ="quantity" name ="quantity" placeholder="Quantity" required="">
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
