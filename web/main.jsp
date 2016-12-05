<%-- 
    Document   : main
    Created on : Nov 27, 2016, 1:11:04 PM
    Author     : Alexis Padula and Sean Webber
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main page</title>
    </head>
    <body>
        <%@include file="includes/header.html"%>
        <section>
            <a href="checkout.jsp" title="Checkout Book"> Check out a book </a><br>
            <a href="library?action=manage"  title="Manage Books"> Manage checked out books</a>
        <section>
        <%@include file="includes/footer.html"%>
    </body>
</html>