<%-- 
    Document   : Final Checkout
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
            <p>Thank you for your patronage of the Belk Libary. 
                You've successfully checked out the book,${title} . 
                Please note that this book is due back on ${date} . 
                A friendly reminder will be sent to you 
                if your book become overdue</p>
            <a href="library" title="back to main"> Return to front page </a>
        <section>
        <%@include file="includes/footer.html"%>
    </body>
</html>