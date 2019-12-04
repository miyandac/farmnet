<%-- 
    Document   : addfieldevent
    Created on : 02-Dec-2019, 11:22:14
    Author     : CHILIKWEM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="fragments/requirements.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Field Event</title>
        <%@include file="fragments/css.jsp" %>
    </head>
    <body id="page-top">
        <%@include file="fragments/header.jsp" %>

        <div class="card mb-4">
            <div class="card-header">
                Add Field
            </div>
            <div class="card-body">
                <form method="POST" action="${contextPath}/${field.id}/addfieldevent"> 

                    <input type="hidden" name="farm" value="${farm.id}">
                    <input type="hidden" name="field" value="${field.id}">

                    <div class="form-group">
                        <label for="description">Description</label>
                        <input type="text" class="form-control" id="description" name="description" required="">
                    </div>
                    <div class="form-group">
                        <label for="event">Event</label>
                        <input type="text" class="form-control" id="event" name="eventreport" required="">
                    </div>
                    <div class="form-group">
                        <label for="dateofevent">Date of Event</label>
                        <input type="text" class="form-control" id="dateofevent" name="dateofevent" placeholder="Date Created" required="">
                    </div>


                    <div class="form-group">
                        <input type="submit" class="btn btn-success btn-block" value="Submit" />
                    </div>
                </form>
            </div>
        </div>
        <%@include file="fragments/footer.jsp" %> 
        <script type="text/javascript">
            $("#dateofevent").datepicker({
                format:'yyyy-mm-dd'
            });
                    
        </script>
    </body>
</html>
