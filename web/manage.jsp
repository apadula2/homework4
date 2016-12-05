<%-- 
    Document   : Checkout Form 
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
            <select>
              <c:forEach items="${people}" var="case">
                <tr>
                  <td>${case.name}</td>
                  <td>${case.email}</td>
                  <td>${case.book}</td>
                  <td>${case.dueDate}</td>
                      <td>
                        <form action="library" method="post">
                           <input type="hidden" name="action" value="delete"> 
                          <input type="submit" name="checkIn" value="Check-In">
                        </form>
                      </td>
                </tr>
              </c:forEach>
            </select>
            </tr>
                    
        <section>
        <%@include file="includes/footer.html"%>
    </body>
</html>
