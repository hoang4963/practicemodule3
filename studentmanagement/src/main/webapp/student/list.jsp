<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>

</head>
<body>

<center>
    <h1>Student Management</h1>
    <h2>
        <a href="/students?action=create"class="btn btn-info">Add New Student</a>
    </h2>

    <h2>List of Students</h2>
</center>

<div align="center">
    <table border="1" cellpadding="5" class = "table">

        <tr>
            <form action="/students" method="get">
                <input name="searchByName"  type="text" placeholder="Type something to search">
                <input type="hidden" name="action" value="searchByName">
                <button type="submit">Seacrh</button>
            </form>
        </tr>
        <tr>
            <th>StudentId</th>
            <th>Name</th>
            <th>Birthday</th>
            <th>Email</th>
            <th>Phone</th>
            <th>ClassRoom</th>
            <th>Function</th>
        </tr>
        <c:forEach var="student" items="${listStudent}">
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
                        <%--                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModal">Delete</button>--%>

                        <%--                    <!-- Modal -->--%>
                        <%--                    <div class="modal fade" id="myModal" role="dialog">--%>
                        <%--                        <div class="modal-dialog">--%>

                        <%--                            <!-- Modal content-->--%>
                        <%--                            <div class="modal-content">--%>
                        <%--                                <div class="modal-header">--%>
                        <%--                                    <h4 class="modal-title">ARE YOU SURE?</h4>--%>
                        <%--                                </div>--%>

                        <%--                                <div class="modal-footer">--%>
                        <%--                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>--%>
                        <%--                                    <a href="/customers?action=delete&id=${customer.getId()}" type="button" class="btn btn-danger">Delete</a>--%>
                        <%--                                </div>--%>
                        <%--                            </div>--%>

                        <%--                        </div>--%>
                        <%--                    </div>--%>

                </td>
            </tr>
        </c:forEach>
    </table>
</div>


</body>
</html>