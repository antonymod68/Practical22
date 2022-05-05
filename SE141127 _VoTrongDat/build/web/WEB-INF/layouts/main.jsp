<%-- 
    Document   : main
    Created on : Feb 22, 2022, 12:46:21 PM
    Author     : SE141127 Vo Trong Dat
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.2/font/bootstrap-icons.css">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <!--Header-->
        <h1>SE141127 Vo Trong Dat</h1>
        <div class="container p-5 bg-light text-primary text-center">
        </div>               
        <div class="container">
            <!--Navigation-->
            <nav class="navbar navbar-expand-sm bg-light">
                <div class="container-fluid">
                    <!-- Links -->
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/">Home</a>
                        </li>
                                             
                    </ul>
                </div>
            </nav>
            <!--Contents-->
            <div class="row">
                <div class="col">
                    <!--url:.../controller/action.do-->
                    <jsp:include page="/WEB-INF/views/${controller}/${action}.jsp" />
                </div>    
            </div>
        </div>
        <!--Footer-->
        <div class="container p-1 bg-light text-primary text-center">
            Copyright 2021-2022 by PRJ. All Rights Reserved.
        </div>
    </body>
</html>

