<%@ include file="common/header.jsp"%>
<%@ include file="common/navigation.jsp"%>
<div class="container">
    <H1>List of Users:</H1>

    <table border="1">
        <thead>
        <tr>
            <th>UserId</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Phone Number</th>
            <th>Email</th>
            <th>Address</th>
            <th>Password</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.userId}</td>
                <td>${user.name}</td>
                <td>${user.surname}</td>
                <td>${user.phoneNumber}</td>
                <td>${user.email}</td>
                <td>${user.address}</td>
                <td>${user.password}</td>
                <td><a type="button" href="/update-user/${user.userId}">UPDATE</a></td>
                <td><a type="button" href="/delete-user/${user.userId}">DELETE</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div>
        <p>
            <a class="button" href="add-user">ADD USER</a>
        </p>
    </div>

</div>