package com.afrikateck.studentsoap.service;

import com.afrikateck.studentsoap.model.StudentEntity;
import com.afrikateck.studentsoap.repository.StudentRepository;
import com.afrikateck.studentsoap.ws.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

  private StudentRepository studentRepository;

  @Autowired
  public StudentServiceImpl(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @Override
  public List<StudentEntity> all() {
    return studentRepository
            .findAll();
  }

  @Override
  public StudentEntity getByID(Long studentID){
    return this.studentRepository.findById(studentID).get();
  }

  @Override
  public StudentEntity add(StudentEntity studentEntity) {
    return studentRepository
            .save(studentEntity);
  }

  @Override
  public boolean update(StudentEntity studentEntity) {
    try {
      this.studentRepository.save(studentEntity);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  @Override
  public boolean delete(Long studentID) {
    try {
      this.studentRepository.deleteById(studentID);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
