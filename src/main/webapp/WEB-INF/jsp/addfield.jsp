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
                Add Inventory Item
            </div>
            <div class="card-body">
                <form method="POST" action="${contextPath}/${farm.id}/addfield"> 
                    <div class="form-group">
                        <label for="breadth">Breadth</label>
                        <input type="number" class="form-control" id="breadth" name="breadth" placeholder="Breadth">
                    </div>
                    <div class="form-group">
                        <label for="crop">Crop</label>
                        <input type="text" class="form-control" id="name" name="crop" placeholder="Crop">
                    </div>
                    <div class="form-group">
                        <label for="datecreated">Date Created</label>
                        <input type="date" class="form-control" id="datecreated" name="datecreated" placeholder="Date Created">
                    </div>
                    <div class="form-group">
                        <label for="quantitytype">Length)</label>
                        <input type="number" class="form-control" id="length" name="length" placeholder="length">
                    </div>
                    <div class="form-group">
                        <label for="farm">Farm</label>
                        <select class="form-control" name="farm" id="farm">
                            <option value="1">Yes</option>
                            <option value="2">No</option>
                        </select>

                    </div>
                    <div class="form-group">
                        <label for="itemtype">Item Type (Select)</label>
                        <input type="text" class="form-control" id="itemtype" name="itemtype" placeholder="Item Type">
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

