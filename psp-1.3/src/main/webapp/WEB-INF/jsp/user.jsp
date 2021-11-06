<%@ include file="common/header.jsp"%>
<%@ include file="common/navigation.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="container">
    <H3>Add new User or Edit existing one:</H3>

    <%--@elvariable id="user" type="com.psp.psp13.model.User"--%>
    <form:form method="post" modelAttribute="user">
        <form:label path="userId">UserId</form:label>
        <br/>
        <form:input path="userId" type="text" required="required" />
        <form:errors path="userId" />
        <br/>
        <form:label path="name">Name</form:label>
        <br/>
        <form:input path="name" type="text" required="required" />
        <form:errors path="name" />
        <br/>
        <form:label path="surname">Surname</form:label>
        <br/>
        <form:input path="surname" type="text" required="required" />
        <form:errors path="surname" />
        <br/>
        <form:label path="phoneNumber">Phone Number</form:label>
        <br/>
        <form:input path="phoneNumber" type="text" required="required" />
        <form:errors path="phoneNumber" />
        <br/>
        <form:label path="email">Email</form:label>
        <br/>
        <form:input path="email" type="text" required="required" />
        <form:errors path="email" />
        <br/>
        <form:label path="address">Address</form:label>
        <br/>
        <form:input path="address" type="text" required="required" />
        <form:errors path="address" />
        <br/>
        <form:label path="password">Password</form:label>
        <br/>
        <form:input path="password" type="text" required="required" />
        <form:errors path="password" />
        <br/>
        <br/>
        <button type="submit">OK</button>
    </form:form>

    <hr style="height:2px;border-width:0;color:gray;background-color:gray">
    <H4>Notes:</H4>
    <p>Requirements for password:</p>
    <ul>
        <li>at least 8 characters long</li>
        <li>contains upper case character</li>
        <li>contains specific character (@,#,$,^,&,!)</li>
    </ul>
    <p>Valid phone number format:</p>
    <ul>
        <li>+3706*******</li>
        <li>86*******</li>
    </ul>
</div>