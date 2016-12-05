<%-- 
    Document   : Checkout Form 
    Created on : Nov 27, 2016, 1:11:04 PM
    Author     : Alexis Padula and Sean Webber
--%>

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
            <h2>Checkout</h2>
            <form action="library" method="post">
                <input type="hidden" name="action" value="checkout"> 
                <label> First Name: </label>
                <input type="text" name="firstName" required><br>
                <label> Last Name: </label>
                <input type="text" name="lastName" required><br>
                <label> Email Address: </label>
                <input type="email" name="email" required><br>
                <label> Book Title: </label>
                <input type="text" name="book" required><br>
                <input type="submit" name ="action" value="Checkout">
            </form>
                    
        <section>
        <%@include file="includes/footer.html"%>
    </body>
</html>