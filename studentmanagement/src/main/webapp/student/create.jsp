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
        <a href="students?action=students">List All Students</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5" class = "table">
            <caption>
                <h2>Add New Student</h2>
            </caption>
            <tr>
                <th>Student Name:</th>
                <td>
                    <input type="text" name="name" id="name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Student Birthday:</th>
                <td>
                    <input type="date" name="dateOfBirth" id="dateOfBirth"  size="45"/>
                </td>
            </tr>
            <tr>
                <th>Student Address:</th>
                <td>
                    <input type="text" name="address" id="address" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Student PhoneNumber:</th>
                <td>
                    <input type="text" name="phoneNumber" id="phoneNumber" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Student Email:</th>
                <td>
                    <input type="text" name="email" id="email" size="45"/>
                </td>
            </tr>
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
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>