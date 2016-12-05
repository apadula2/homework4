<%-- 
    Document   : Manage
    Created on : Nov 27, 2016, 1:11:04 PM
    Author     : Alexis Padula and Sean Webber
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout Form</title>
    </head>
    <body>
        <%@include file="includes/header.html"%>
        <section>
          <table>
            <tr>
              <th>Patron Name</th>
              <th>Email Address</th>
              <th>Book Title</th>
              <th>Due Date</th>
              <th>Overdue</th>
              <c:forEach items="${users}" var="user">
                <tr>
                  <td>${user.name}</td>
                  <td>${user.email}</td>
                  <td>${user.title}</td>
                  <td>${user.dueDate}</td>
                      <td>
                        <form action="library" method="post">
                           <input type="hidden" name="action" value="delete">
                           <input type="hidden" name="email" value="${user.email}">
                            <input type="hidden" name="title" value="${user.title}">
                          <input type="submit" name="checkIn" value="Check-In">
                        </form>
                      </td>
                </tr>
              </c:forEach>
            </tr> 
            <a href="main.jsp" title="return"> Return to front page </a><br>
            </section>
        <%@include file="includes/footer.html"%>
    </body>
</html>
