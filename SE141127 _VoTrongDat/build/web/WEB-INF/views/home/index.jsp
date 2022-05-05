<%-- 
    Author     : SE141127 Vo Trong Dat
--%>
<h2 class="text-center">Confirm Page (Id: SE141127, Full name: Vo Trong Dat)</h2>
<div class="row text-center">
    <div class="col">
        <img src="images/mickey.gif" alt=""/>
    </div>
</div>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h1>List of Employee</h1>
<hr/>
<a class="btn btn-sm btn-outline-success" href="${pageContext.request.contextPath}/home/create.do"><i class="bi bi-plus-circle"></i> Create New</a> 
<table class="table table-striped">
    <thead>
        <tr>
            <th>#</th>
            <th>Id</th>
            <th>Name</th>
            <th style="text-align: right;">Salary</th>
            <th>DOB</th>
            <th>Operations</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="employee" items="${list}" varStatus="loop">
            <tr>
                <td>${loop.index + 1}</td>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td style="text-align: right;"><fmt:formatNumber value="${employee.salary}" pattern="$ #,##0.00" /></td>
                <td><fmt:formatDate value="${employee.DOB}" pattern="MM-dd-yyyy" /></td>
                <td>
                    <a class="btn btn-sm btn-outline-success" href="${pageContext.request.contextPath}/home/edit.do?id=${employee.id}"><i class="bi bi-pencil-square"></i> Edit</a> 
                    <a class="btn btn-sm btn-outline-danger" href="${pageContext.request.contextPath}/home/confirm.do?id=${employee.id}"><i class="bi bi-x-circle"></i> Delete</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>    
</table>
