/*
 * CopyRight:Alexis Padula and Sean Webber
 */
package edu.elon.data;

import java.sql.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Alexis
 */
public class ConnectionPool {

  private static ConnectionPool pool = null;
  private static DataSource data = null;

  private ConnectionPool() {
    try {
      InitialContext ic = new InitialContext();
      data = (DataSource) ic.lookup("java:/comp/env/jdbc/MySQLDS");
    } catch (NamingException e) {
      System.out.println(e);
    }
  }

  public static synchronized ConnectionPool getInstance() {
    if (pool == null) {
      pool = new ConnectionPool();
    }
    return pool;
  }

  public Connection getConnection() {
    try {
      return data.getConnection();
    } catch (SQLException e) {
      System.out.println(e);
      return null;
    }
  }

  public void freeConnection(Connection c) {
    try {
      c.close();
    } catch (SQLException e) {
      System.out.println(e);
    }
  }

}
