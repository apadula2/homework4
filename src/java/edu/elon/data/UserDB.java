//CopyRight: Alexis Padula and Sean Webber
package edu.elon.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

import edu.elon.model.Person;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class UserDB {

  public static int insert(Person user) {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    if (connection == null) {
      System.out.println("connection is null");
    }
    PreparedStatement ps = null;

    String query
            = "INSERT INTO LibraryUsers (FirstName,LastName, Email, Title, DueDate)"
            + "VALUES (?, ?, ?, ?,?)";
    try {
      ps = connection.prepareStatement(query);
      ps.setString(1, user.getFirstName());
      ps.setString(2, user.getLastName());
      ps.setString(3, user.getEmail());
      ps.setString(4, user.getTitle());
      Date d = new Date();
      Calendar c = Calendar.getInstance();
      c.setTime(d);
      c.add(Calendar.WEEK_OF_MONTH, 2);
      d = c.getTime();
      java.sql.Date date = new java.sql.Date(d.getTime());
      ps.setDate(5, date);
      return ps.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e);
      return 0;
    } finally {
      DBUtil.closePreparedStatement(ps);
      pool.freeConnection(connection);
    }
  }

  public static int delete(String email, String title) {
    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;

    String query = "DELETE FROM LibraryUsers "
            + "WHERE Email = ?"
            + "AND Title = ?";
    try {
      ps = connection.prepareStatement(query);
      ps.setString(1, email);
      ps.setString(2, title);

      return ps.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e);
      return 0;
    } finally {
      DBUtil.closePreparedStatement(ps);
      pool.freeConnection(connection);
    }
  }

  public static ArrayList<Person> selectUsers() {

    ConnectionPool pool = ConnectionPool.getInstance();
    Connection connection = pool.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;

    String query = "SELECT * FROM LibraryUsers";
    try {
      ps = connection.prepareStatement(query);
      rs = ps.executeQuery();

      ArrayList<Person> users = new ArrayList<Person>();

      while (rs.next()) {

        Person user = new Person();
        user.setFirstName(rs.getString("FirstName"));
        user.setLastName(rs.getString("LastName"));
        user.setTitle(rs.getString("Title"));
        user.setEmail(rs.getString("Email"));
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
        Date d = rs.getDate("DueDate");
        String date = sdf.format(d);
        user.setDueDate(date);
        if (rs.getDate("DueDate").before(new Date())) {
          user.setOverdue("overdue");
        } else {
          user.setOverdue("");
        }
        users.add(user);
      }
      return users;
    } catch (SQLException e) {
      System.out.println(e);
      return null;
    } finally {
      DBUtil.closeResultSet(rs);
      DBUtil.closePreparedStatement(ps);
      pool.freeConnection(connection);
    }

  }
}
