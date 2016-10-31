<%-- 
    Document   : index
    Created on : 28/10/2016, 13:12:39
    Author     : Wylianne
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="basico" uri="https://tags/customTags/crowTable"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        
        
        <script src="//code.jquery.com/jquery-1.12.3.js"></script>
        <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.12/js/dataTables.bootstrap.min.js"></script>
    </head>
    <body>                
            
            
            <basico:simpleTable value="5">
                <basico:simpleContentTable value="5">
                </basico:simpleContentTable>
            </basico:simpleTable>
            
            <hr>
            <hr>
            <basico:simpleTable value="4">
                <basico:simpleContentTable value="4">
                </basico:simpleContentTable>
            </basico:simpleTable>

            
    </body>
</html>
