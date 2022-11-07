<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Employee List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Country</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.userName}</td>
            <td>${employee.email}</td>
            <td>${employee.gender}</td>
            <td>${employee.age}</td>
            <td>${employee.salary}</td>
            <!-- PUT to update -->

            <td><a href="/update-employee/${employee.id}">Update</a></td>

            <td><form:form method="DELETE" action="/delete-employee/${employee.id}">
                <input type="submit" value="Delete" />
            </form:form></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="/create-employee">Create Employee</a>
