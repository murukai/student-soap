package com.afrikateck.studentsoap.endpoint;

import com.afrikateck.studentsoap.model.StudentEntity;
import com.afrikateck.studentsoap.service.StudentService;
import com.afrikateck.studentsoap.ws.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class StudentEndpoint {
  public static final String NAMESPACE_URI = "http://www.afrikateck.com/studentsoap/ws";

  private StudentService service;

  public StudentEndpoint() {

  }

  @Autowired
  public StudentEndpoint(StudentService service) {
    this.service = service;
  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getStudentByIdRequest")
  @ResponsePayload
  public GetStudentByIdResponse getMovieById(@RequestPayload GetStudentByIdRequest request) {
    GetStudentByIdResponse response = new GetStudentByIdResponse();
    StudentEntity movieEntity = service.getByID(request.getStudentID());
    Student student = new Student();
    BeanUtils.copyProperties(movieEntity, student);
    response.setStudent(student);
    return response;

  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllStudentRequest")
  @ResponsePayload
  public GetAllStudentResponse getAllMovies(@RequestPayload GetAllStudentRequest request) {
    GetAllStudentResponse response = new GetAllStudentResponse();

    List<Student> students = new ArrayList<>();

    List<StudentEntity> studentEntities = service.all();

    studentEntities.forEach((student) -> {
      Student studentType = new Student();
      BeanUtils.copyProperties(student, studentType);
      students.add(studentType);
    });
    response.getStudent().addAll(students);

    return response;

  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addStudentRequest")
  @ResponsePayload
  public AddStudentResponse addMovie(@RequestPayload AddStudentRequest request) {
    AddStudentResponse response = new AddStudentResponse();
    Student student = new Student();
    ServiceStatus serviceStatus = new ServiceStatus();

    StudentEntity studentEntity = new StudentEntity();
    // 2. Get updated movie information from the request
    BeanUtils.copyProperties(request.getStudent(), studentEntity);
    // 3. update the movie in database

    StudentEntity savedMovieEntity = service.add(studentEntity);

    if (savedMovieEntity == null) {
      serviceStatus.setStatusCode("CONFLICT");
      serviceStatus.setMessage("Exception while adding Entity");
    } else {

      BeanUtils.copyProperties(savedMovieEntity, student);
      serviceStatus.setStatusCode("SUCCESS");
      serviceStatus.setMessage("Content Added Successfully");
    }

    response.setStudent(student);
    response.setServiceStatus(serviceStatus);
    return response;

  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateStudentRequest")
  @ResponsePayload
  public UpdateStudentResponse updateMovie(@RequestPayload UpdateStudentRequest request) {
    UpdateStudentResponse response = new UpdateStudentResponse();
    ServiceStatus serviceStatus = new ServiceStatus();
    // 1. Find if movie available
    StudentEntity studentFromDB = service.getByID(request.getStudent().getStudentID());

    if(studentFromDB == null) {
      serviceStatus.setStatusCode("NOT FOUND");
      serviceStatus.setMessage("Student with id : " + request.getStudent().getStudentID()+ " not found");
    }else {

      // 2. Get updated movie information from the request
      BeanUtils.copyProperties(request.getStudent(), studentFromDB);
      // 3. update the movie in database

      boolean flag = service.update(studentFromDB);

      if(flag == false) {
        serviceStatus.setStatusCode("CONFLICT");
        serviceStatus.setMessage("Exception while updating Entity = " + request.getStudent().getStudentID());;
      }else {
        serviceStatus.setStatusCode("SUCCESS");
        serviceStatus.setMessage("Content updated Successfully");
      }


    }

    response.setServiceStatus(serviceStatus);
    return response;
  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteStudentRequest")
  @ResponsePayload
  public DeleteStudentResponse deleteMovie(@RequestPayload DeleteStudentRequest request) {
    DeleteStudentResponse response = new DeleteStudentResponse();
    ServiceStatus serviceStatus = new ServiceStatus();

    boolean flag = service.delete(request.getStudentID());

    if (flag == false) {
      serviceStatus.setStatusCode("FAIL");
      serviceStatus.setMessage("Exception while deleting Entity id = " + request.getStudentID());
    } else {
      serviceStatus.setStatusCode("SUCCESS");
      serviceStatus.setMessage("Content Deleted Successfully");
    }

    response.setServiceStatus(serviceStatus);
    return response;
  }
}
