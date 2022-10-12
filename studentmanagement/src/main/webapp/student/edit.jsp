<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Student</title>
</head>
<body>

<center>
    <h1>Student Management</h1>
    <h2>
        <a href="students?action=students">List All Students</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5" class = "table">
            <caption>
                <h2>
                    Edit Student
                </h2>
            </caption>
            <c:if test="${student != null}">
                <input type="hidden" name="id" value="<c:out value='${student.getId()}' />"/>
            </c:if>
            <tr>
                <th>Student ID:</th>
                <td>
                    <input type="text" name="id" size="45"
                           value="<c:out value='${customer.getId()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Student Name:</th>
                <td>
                    <input type="text" name="name" size="45"
                           value="<c:out value='${student.getName()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Student birthday:</th>
                <td>
                    <input type="date" name="dateOfBirth" size="45"
                           value="<c:out value='${customer.getDateOfBirth()}' />"
                    />
                </td>
            </tr>
            <tr>
            <tr>
            <tr>
                <th>Student Email:</th>
                <td>
                    <input type="text" name="email" size="45"
                           value="<c:out value='${student.getEmail()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Student phonenumber:</th>
                <td>
                    <input type="text" name="phoneNumber" size="45"
                           value="<c:out value='${student.getPhoneNumber()}' />"
                    />
                </td>
            </tr>
            <tr>
            <tr>
            <tr>
                <th>Student Classroom:</th>
                <td>
                    <select name="classroomId" id="classroomId">
                        <option value=" "> </option>
                        <c:forEach var="classroom" items="${listClassrooms}">

                            <option value="${classroom.getId()}">${classroom.getName()}</option>

                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
            <tr>

                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>