
//CopyRight:Alexis Padula and Sean Webber
package edu.elon.model;

import java.io.Serializable;

public class Person implements Serializable {

  private String name;
  private String email;
  private String title;
  private String dueDate;
  private String overdue;

  public Person() {
    name = "";
    email = "";
    title = "";
    dueDate = "";
    overdue = "";

  }

  public Person(String name, String email, String title, String dueDate, String overdue) {
    this.name = name;
    this.email = email;
    this.title = title;
    this.dueDate = dueDate;
    this.overdue = overdue;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDueDate() {
    return dueDate;
  }

  public void setDueDate(String dueDate) {
    this.dueDate = dueDate;
  }

  public String getOverdue() {
    return overdue;
  }

  public void setOverdue(String overdue) {
    this.overdue = overdue;
  }
}
