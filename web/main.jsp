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
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    <title>Main page</title>
  </head>
  <body>
    <%@include file="includes/header.html"%>
    <div id="mainSection">
      <a href="checkout.jsp" title="Checkout Book" class="main"> Check out a book </a><br>
      <a href="library?action=manage"  title="Manage Books" class="main"> Manage checked out books</a>
    </div>
    <%@include file="includes/footer.html"%>
  </body>
</html>