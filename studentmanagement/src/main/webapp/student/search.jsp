<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student Management Application</title>
</head>
<body>

<center>
    <h1>Student Management</h1>
    <h2>
        <a href="students?action=students">List Students</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5" class = "table">
        <caption><h2>List of Students</h2></caption>

        <tr>
            <th>StudentId</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>Email</th>
            <th>Phone</th>
            <th>RoleID</th>
            <th>Function</th>
        </tr>
        <c:forEach var="student" items="${searchStudents}">
            <tr>
                <td><c:out value="${student.getId()}"/></td>
                <td><c:out value="${student.getName()}"/></td>
                <td><c:out value="${student.getDateOfBirth()}"/></td>
                <td><c:out value="${student.getEmail()}"/></td>
                <td><c:out value="${student.getPhoneNumber()}"/></td>
                <td><c:out value="${student.getClassroomId()}"/></td>
                <td>
                    <a href="/students?action=edit&id=${student.getId()}" class="btn btn-info">Edit</a>
                    <a href="/students?action=delete&id=${student.getId()}" type="button" class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>