package com.afrikateck.studentsoap.repository;

import com.afrikateck.studentsoap.model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

}
