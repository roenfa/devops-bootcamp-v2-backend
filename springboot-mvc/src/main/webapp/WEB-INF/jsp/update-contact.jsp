<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Update Contact</h1>
<form:form method="post" action="/update-contact">
    <table>
        <tr><form:input path="id" value="${contact.id}" type="hidden"/></tr>
        <tr>
            <td>Name: </td>
            <td><form:input path="name"/></td>
            <td>Email: </td>
            <td><form:input path="email"/></td>
            <td>Country: </td>
            <td><form:input path="country"/></td>
            <td><input type="submit" value="Update"/></td>
    </table>
</form:form>
