<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h1>Contact List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Email</th>
        <th>Country</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="contact" items="${contacts}">
        <tr>
            <td>${contact.id}</td>
            <td>${contact.name}</td>
            <td>${contact.email}</td>
            <td>${contact.country}</td>
            <!-- PUT to update -->

            <td><a href="/update-contact/${contact.id}">Update</a></td>

            <td><form:form method="DELETE" action="/delete-contact/${contact.id}">
                <input type="submit" value="Delete" />
            </form:form></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="/create-contact">Create Contact</a>
