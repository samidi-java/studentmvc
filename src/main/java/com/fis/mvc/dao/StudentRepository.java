package com.fis.mvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fis.mvc.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {


}
