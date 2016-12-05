
//CopyRight:Alexis Padula and Sean Webber
package edu.elon.model;

import java.io.Serializable;

public class Person implements Serializable {

  private String firstName;
  private String lastName;
  private String email;
  private String title;
  private String dueDate;
  private String overdue;

  public Person() {
    firstName = "";
    lastName= "";
    email = "";
    title = "";
    dueDate = "";
    overdue = "";

  }

  public Person(String firstName,String lastName, String email, String title, String dueDate, String overdue) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.title = title;
    this.dueDate = dueDate;
    this.overdue = overdue;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
   public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
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
