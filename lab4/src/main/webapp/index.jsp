<%@ page import="org.example.lab4.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.LinkedList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <title>JSP - Hello World</title>
    </head>
    <body>
        <h1><%= "Hello World!" %></h1>

        <div id="page">
        <form>
            <table>
                <tbody>
                    <tr>
                        <td><label for="name">Name</label></td>
                        <td><input id="name" type="text" name="name"></td>
                    </tr>
                    <tr>
                        <td><label for="surname">Surname</label></td>
                        <td><input id="surname" type="text" name="surname"></td>
                    </tr>
                    <tr>
                        <td><label for="email">Email</label></td>
                        <td><input id="email" type="text" name="email"></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" name="submit" value="Submit">
        </form>

            <% List<Student> students = (List<Student>)application.getAttribute("students"); %>

            <c:if test="${not empty param.submit}">
                <%
                    if (students == null) {
                        students = new LinkedList<>();
                        application.setAttribute("students", students);
                    }

                    String name = request.getParameter("name");
                    String surname = request.getParameter("surname");

                    if (!name.isEmpty() && !surname.isEmpty()) {
                        Student student = new Student();
                        student.setName(name);
                        student.setSurname(surname);
                        student.setEmail(request.getParameter("email"));
                        students.add(student);
                    }

                    response.sendRedirect("index.jsp");
                %>
            </c:if>

            <%
                if (students != null) {
                    out.println("Students: </br>");
                    for (Student student : students) {
                        out.println(String.format("Student: name=%s, surname=%s, email=%s <br>", student.getName(), student.getSurname(), student.getEmail()));
                    }
                }
            %>

        </div>
    </body>
</html>

