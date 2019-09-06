package com.afrikateck.studentsoap.service;

import com.afrikateck.studentsoap.model.StudentEntity;
import com.afrikateck.studentsoap.ws.Student;

import java.util.List;

public interface StudentService {
  List<StudentEntity> all();
  StudentEntity getByID(Long studentID);
  StudentEntity add(StudentEntity studentEntity);
  boolean update(StudentEntity studentEntity);
  boolean delete(Long studentID);
}
