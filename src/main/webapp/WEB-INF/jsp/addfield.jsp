<%-- 
    Document   : addfield
    Created on : Nov 6, 2019, 5:13:57 PM
    Author     : MUNDIAG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="fragments/requirements.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Field</title>
        <%@include file="fragments/css.jsp" %>
    </head>
    <body id="page-top">
        <%@include file="fragments/header.jsp" %>

        <div class="card mb-4">
            <div class="card-header">
                Add Field
            </div>
            <div class="card-body">
                <form method="POST" action="${contextPath}/${farm.id}/addfield"> 
                     <div class="form-group">
                        <label for="quantitytype">Length</label>
                        <input type="number" class="form-control" id="length" name="length" placeholder="length (in m)" required="">
                    </div>
                    <div class="form-group">
                        <label for="breadth">Breadth</label>
                        <input type="number" class="form-control" id="breadth" name="breadth" placeholder="Breadth (in m)" required="">
                    </div>
                    
                    <div class="form-group">
                        <label for="crop">Crop</label>
                        <input type="text" class="form-control" id="name" name="crop" placeholder="Crop" required="">
                    </div>
                    <div class="form-group">
                        <label for="datecreated">Date Created</label>
                        <input type="date" class="form-control" id="datecreated" name="datecreated" placeholder="Date Created" required="">
                    </div>
                   
                    <div class="form-group">
                        <input type="submit" class="btn btn-success btn-block" value="Submit" />
                    </div>
                </form>
            </div>
        </div>


        <%@include file="fragments/footer.jsp" %>
    </body>
</html>

