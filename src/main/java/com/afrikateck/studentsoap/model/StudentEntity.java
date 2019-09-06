package com.afrikateck.studentsoap.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "students")
public class StudentEntity {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long studentID;

  @Column(name = "firstName", length = 100)
  @NotNull
  private String firstName;

  @Column(name = "lastName", length = 100)
  @NotNull
  private String lastName;

  @Column(name = "dateOfBirth", length = 50)
  @NotNull
  private String dateOfBirth;

  @Column(name = "gender", length = 6)
  @NotNull
  private String gender;

  @Column(name = "positionInFamily", length = 5)

  private String positionInFamily;

  public long getStudentID() {
    return studentID;
  }

  public void setStudentID(long studentID) {
    this.studentID = studentID;
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

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getPositionInFamily() {
    return positionInFamily;
  }

  public void setPositionInFamily(String positionInFamily) {
    this.positionInFamily = positionInFamily;
  }
}
