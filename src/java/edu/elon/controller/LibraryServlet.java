/*
 * CopyRight:Alexis Padula and Sean Webber
 */
package edu.elon.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.elon.model.Person;
import edu.elon.data.UserDB;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Alexis
 */
@WebServlet(name = "LibraryServlet", urlPatterns = {"/library"})
public class LibraryServlet extends HttpServlet {

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String url = "/main.jsp";

    String action = request.getParameter("action");

    if (action == null) {
      url = "/main.jsp";
    } else if (action.equals("checkout")) {
      String firstName = request.getParameter("firstName");
      String lastName = request.getParameter("lastName");
      String email = request.getParameter("email");
      String title = request.getParameter("book");
      Person user = new Person(firstName, lastName, email, title, null, null);
      UserDB.insert(user);
      request.setAttribute("title", title);
      Date date = new Date();
      Calendar c = Calendar.getInstance();
      c.setTime(date);
      c.add(Calendar.WEEK_OF_MONTH, 2);
      date = c.getTime();
      SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
      String formatDate = sdf.format(date);
      request.setAttribute("date", formatDate);
      url = "/finalCheckout.jsp";
    } else if (action.equals("manage")) {
      request.setAttribute("users", UserDB.selectUsers());

      url = "/manage.jsp";
    } else if (action.equals("delete")) {
      UserDB.delete(request.getParameter("email"), request.getParameter("title"));
      request.setAttribute("users", UserDB.selectUsers());
      url = "/manage.jsp";
    }
    getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);

  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
