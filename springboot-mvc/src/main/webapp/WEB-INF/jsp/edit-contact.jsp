<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Edit Contact</h1>
<form:form method="put" action="/update-contact">
    <table>
        <tr>
            <td>Id:</td>
            <td><form:input path="id" readonly="true"/></td>
        </tr>
        <tr>
            <td>Name: </td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>Email: </td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td>Country: </td>
            <td><form:input path="country"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Edit"/></td>
        </tr>
    </table>
</form:form>