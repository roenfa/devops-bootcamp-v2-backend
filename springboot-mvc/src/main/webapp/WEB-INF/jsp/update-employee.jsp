<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Create Contact</h1>
<form:form method="post" action="/update-employee">
    <table>
        <tr hidden="true">
            <td>Id:</td>
            <td><form:input path="id" readonly="true" /></td>
        </tr>
        <tr>
            <td>Name: </td>
            <td><form:input path="userName"/></td>
        </tr>
        <tr>
            <td>Email: </td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td>Gender: </td>
            <td><form:input path="gender"/></td>
        </tr>
        <tr>
            <td>Age: </td>
            <td><form:input path="age"/></td>
        </tr>
        <tr>
            <td>Salary: </td>
            <td><form:input path="salary"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Create"/></td>
        </tr>
    </table>
</form:form>
