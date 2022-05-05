<%-- 
    Author     : SE141127 Vo Trong Dat
--%>
<h2 class="text-center">Confirm Page (Id: SE141127, Full name: Vo Trong Dat)</h2>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1>Edit employee</h1>
<hr/>
<div class="row">
    <div class="col">
        <form action="${pageContext.request.contextPath}/home/update.do">
            <div class="mb-3 mt-3">
                <label for="id" class="form-label">Id:</label>
                <input type="text" class="form-control" value="${employee.id}" id="id" placeholder="Enter id" name="id">
            </div>
            <div class="mb-3">
                <label for="name" class="form-label">Name:</label>
                <input type="text" class="form-control" value="${employee.name}" id="name" placeholder="Enter name" name="name">
            </div>
            <div class="mb-3">
                <label for="salary" class="form-label">Salary:</label>
                <input type="text" class="form-control" value="${employee.salary}" id="salary" placeholder="Enter salary" name="salary">
            </div>
            <div class="mb-3">
                <label for="DOB" class="form-label">DOB:</label>
                <input type="date" class="form-control" value="${employee.DOB}" id="DOB" placeholder="Enter DOB" name="DOB">
            </div>
            <button type="submit" class="btn btn-sm btn-outline-success" name="op" value="update"><i class="bi bi-check-circle"></i> Update</button>
            <button type="submit" class="btn btn-sm btn-outline-danger" name="op" value="cancel"><i class="bi bi-x-circle"></i> Cancel</button>
        </form>
        <div style="font-style: italic" class="mt-3 text-danger">${errorMessage}</div>
    </div>
    <div class="col"></div>
</div>