package com.afrikateck.studentsoap.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

@Entity
@Table(name = "students")
public class StudentEntity implements Serializable {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long studentID;

  private String firstName;

  private String lastName;

  private String dateOfBirth;

  private String gender;

  private String positionInFamily;

  private Long formID;

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

  public Long getFormID() {
    return formID;
  }

  public void setFormID(Long formID) {
    this.formID = formID;
  }
}
